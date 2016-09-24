package org.com.unitech.hibernate.dao;

import org.com.unitech.exceptions.DaoException;
import org.com.unitech.exceptions.DataSourceException;
import org.com.unitech.hibernate.model.ExamData;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.when;

/**
 * Created by MohanDivya on 9/24/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ExamDataImplTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Criteria criteria;

    @Mock
    private Session session;

    @InjectMocks
    ExamDataImpl examData = new ExamDataImpl();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createCriteria(ExamData.class)).thenReturn(criteria);
    }

    @Test
    public void getInformationShouldReturnExamData() throws DaoException {
        ArrayList<ExamData> examDataArrayList = new ArrayList();
        examDataArrayList.add(new ExamData());
        when(criteria.list()).thenReturn(examDataArrayList);
        List<ExamData> information = examData.getInformation(2);
        assertThat(information.size(), is(1));
    }

    @Test
    public void getInformationShouldThrowException() throws DaoException {
        when(sessionFactory.getCurrentSession()).thenReturn(null);
        exception.expect(DaoException.class);
        exception.expectMessage(contains("Problem in DAO Layer"));
        List<ExamData> information = examData.getInformation(2);
    }

    @Test
    public void getSpecificInformationShouldReturnExamData() throws DaoException {
                ArrayList<String> examDataArrayList = new ArrayList();
        examDataArrayList.add("");
        when(criteria.list()).thenReturn(examDataArrayList);
        List<String> information = examData.getSpecificInformation(2, "someFiled");
        assertThat(information.size(), is(1));
    }

    @Test
    public void getSpecificInformationShouldThrowException() throws DaoException {
        when(sessionFactory.getCurrentSession()).thenReturn(null);
        exception.expect(DaoException.class);
        exception.expectMessage(contains("Problem in DAO Layer"));
        List<String> information = examData.getSpecificInformation(2, "someFiled");
    }
}
