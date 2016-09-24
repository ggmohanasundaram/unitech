package org.com.unitech.hibernate.service;

import junit.framework.Assert;
import org.com.unitech.exceptions.DaoException;
import org.com.unitech.hibernate.dao.ExamDataDao;
import org.com.unitech.hibernate.model.ExamData;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by MohanDivya on 9/24/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExamDataServiceImplTest {

    @Mock
    private ExamDataDao dao;
    @InjectMocks
    private ExamDataServiceImpl examDataService = new ExamDataServiceImpl();

    @Before
    public void setUp() throws DaoException {
        when(dao.getInformation(1)).thenReturn(new ArrayList<ExamData>());
        when(dao.getSpecificInformation(1,"someFiled")).thenReturn(new ArrayList<String>());
    }

    @Test
    public void getAllInformationShouldReturnExamData() throws Exception {
        List<ExamData> allInformation = examDataService.getAllInformation(1);
        Assert.assertNotNull(allInformation);
    }
    @Test
    public void getSpecificInformationShouldReturnExamData() throws Exception {
        List<String> allInformation = examDataService.getSpecificInformation(1,"someFiled");
        Assert.assertNotNull(allInformation);
    }
}
