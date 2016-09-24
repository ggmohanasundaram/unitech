package org.com.unitech.rest.service;

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
    ExamDataService examDataService;

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ExamData>> getStatusInformation(@PathVariable("id") int id) throws Exception {

        ExamData examData = null;
        List<ExamData> information = examDataService.getInformation(id);

        if(information == null || information.isEmpty() )
        {
            return new ResponseEntity<List<ExamData>>( HttpStatus.NOT_FOUND);
        }
        else {

            return new ResponseEntity<List<ExamData>>(information, HttpStatus.OK);
        }

    }
}
