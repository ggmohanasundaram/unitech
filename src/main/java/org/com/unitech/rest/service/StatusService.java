package org.com.unitech.rest.service;

import org.com.unitech.exceptions.DaoException;
import org.com.unitech.exceptions.DataSourceException;
import org.com.unitech.exceptions.SessionFactoryLoadingException;
import org.com.unitech.hibernate.model.ExamData;
import org.com.unitech.hibernate.service.ExamDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MohanDivya on 9/24/2016.
 */
@RestController
@RequestMapping("/Unitech/StatusService")
public class StatusService {

    @Autowired
    private ExamDataService examDataService;

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ExamData>> getAllStatusInformation(@PathVariable("id") int id) throws Exception {

        try {
            List<ExamData> information = examDataService.getAllInformation(id);

            if (information == null || information.isEmpty()) {
                return new ResponseEntity<List<ExamData>>(HttpStatus.NOT_FOUND);
            } else {

                return new ResponseEntity<List<ExamData>>(information, HttpStatus.OK);
            }
        } catch (DaoException | DataSourceException | SessionFactoryLoadingException e) {
            System.err.println(e);
            return new ResponseEntity<List<ExamData>>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<List<ExamData>>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "user/{id}/{field}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getRequiredStatusInformation(@PathVariable("id") int id, @PathVariable("field") String field) throws Exception {

        ExamData examData = null;
        try {
            List<String> information = examDataService.getSpecificInformation(id, field);

            if (information == null || information.isEmpty()) {
                return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<List<String>>(information, HttpStatus.OK);
            }
        } catch (DaoException | DataSourceException | SessionFactoryLoadingException e) {
            System.err.println(e);
            return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<List<String>>(HttpStatus.FORBIDDEN);
        }
    }
}
