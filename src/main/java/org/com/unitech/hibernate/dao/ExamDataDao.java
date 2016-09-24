package org.com.unitech.hibernate.dao;

import org.com.unitech.hibernate.model.ExamData;

import java.util.List;

/**
 * Created by MohanDivya on 9/24/2016.
 */
public interface ExamDataDao {
    List<ExamData> getInformation(int id) throws Exception;
}
