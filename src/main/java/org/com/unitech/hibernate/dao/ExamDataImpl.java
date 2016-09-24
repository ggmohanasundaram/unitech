package org.com.unitech.hibernate.dao;

import org.com.unitech.hibernate.model.ExamData;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MohanDivya on 9/24/2016.
 */
@Repository("examDataDao")
public class ExamDataImpl extends AbstractDao implements ExamDataDao {
    public List<ExamData> getInformation(int id) throws Exception {

        try {
            Criteria criteria = getSession().createCriteria(ExamData.class);
            criteria.add(Restrictions.eq("part2id", id));
            return (List<ExamData>) criteria.list();
        } catch (Exception e) {
            throw e;
        }
    }
}
