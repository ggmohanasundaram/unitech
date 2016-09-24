package org.com.unitech.hibernate.service;

import org.com.unitech.hibernate.model.ExamData;

import java.util.List;

/**
 * Created by MohanDivya on 9/24/2016.
 */
public interface ExamDataService {
    List<ExamData> getAllInformation(int id) throws Exception;
    List<String> getSpecificInformation(int id, String field) throws Exception;
}
