package org.com.unitech.hibernate.service;

import org.com.unitech.hibernate.dao.ExamDataDao;
import org.com.unitech.hibernate.model.ExamData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MohanDivya on 9/24/2016.
 */
@Service("examDataService")
@Transactional
public class ExamDataServiceImpl implements ExamDataService {

    @Autowired
    private ExamDataDao dao;

    public List<ExamData> getInformation(int id) throws Exception {
        return dao.getInformation(id);
    }
}
