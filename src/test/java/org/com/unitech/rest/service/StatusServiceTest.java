package org.com.unitech.rest.service;

import org.com.unitech.exceptions.DaoException;
import org.com.unitech.hibernate.model.ExamData;
import org.com.unitech.hibernate.service.ExamDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by MohanDivya on 9/24/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class StatusServiceTest {

    @Mock
    private ExamDataService examDataService;
    @InjectMocks
    private StatusService statusService = new StatusService();

    @Test
    public void getAllStatusInformationShouldReturnNotFound() throws Exception {
        when(examDataService.getAllInformation(1)).thenReturn(new ArrayList<ExamData>());
        ResponseEntity<List<ExamData>> allStatusInformation = statusService.getAllStatusInformation(1);
        assertThat(allStatusInformation.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }
    @Test
    public void getAllStatusInformationShouldThrow404() throws Exception {
        when(examDataService.getAllInformation(1)).thenReturn(new ArrayList<ExamData>());
        ResponseEntity<List<ExamData>> allStatusInformation = statusService.getAllStatusInformation(1);
        assertThat(allStatusInformation.getStatusCode(), is(HttpStatus.NOT_FOUND));

    }
    @Test
    public void getAllStatusInformationShouldThrow500() throws Exception {
        when(examDataService.getAllInformation(1)).thenThrow(new Exception(""));
        ResponseEntity<List<ExamData>> allStatusInformation = statusService.getAllStatusInformation(1);
        assertThat(allStatusInformation.getStatusCode(), is(HttpStatus.FORBIDDEN));

    }
    @Test
    public void getAllStatusInformationShouldReturnProperMessage() throws Exception {
        ArrayList<ExamData> list = new ArrayList<>();
        list.add(new ExamData());
        when(examDataService.getAllInformation(1)).thenReturn(list);
        ResponseEntity<List<ExamData>> allStatusInformation = statusService.getAllStatusInformation(1);
        assertThat(allStatusInformation.getStatusCode(), is(HttpStatus.OK));

    }
    @Test
    public void getRequiredStatusInformationShouldThrow404() throws Exception {
        when(examDataService.getSpecificInformation(1,"")).thenReturn(new ArrayList<String>());
        ResponseEntity<List<String>> allStatusInformation = statusService.getRequiredStatusInformation(1,"");
        assertThat(allStatusInformation.getStatusCode(), is(HttpStatus.NOT_FOUND));

    }
    @Test
    public void getRequiredStatusInformationShouldThrow500() throws Exception {
        when(examDataService.getSpecificInformation(1,"")).thenThrow(new Exception(""));
        ResponseEntity<List<String>> allStatusInformation = statusService.getRequiredStatusInformation(1,"");
        assertThat(allStatusInformation.getStatusCode(), is(HttpStatus.FORBIDDEN));

    }
    @Test
    public void getRequiredStatusInformationShouldReturnProperMessage() throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("");
        when(examDataService.getSpecificInformation(1,"")).thenReturn(list);
        ResponseEntity<List<String>> allStatusInformation = statusService.getRequiredStatusInformation(1,"");
        assertThat(allStatusInformation.getStatusCode(), is(HttpStatus.OK));

    }
}
