package org.com.unitech.hibernate.dao;

import org.com.unitech.exceptions.DaoException;
import org.com.unitech.hibernate.model.ExamData;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MohanDivya on 9/24/2016.
 */
@Repository("examDataDao")
public class ExamDataImpl extends AbstractDao implements ExamDataDao {
    public List<ExamData> getInformation(int id) throws DaoException {

        try {
            Criteria criteria = getSession().createCriteria(ExamData.class);
            criteria.add(Restrictions.eq("part2id", id));
            return (List<ExamData>) criteria.list();
        } catch (Exception e) {
            throw new DaoException("Problem in DAO Layer " + e);
        }
    }

    public List<String> getSpecificInformation(int id, String field) throws DaoException {
        try {
            Criteria criteria = getSession().createCriteria(ExamData.class);
            criteria.add(Restrictions.eq("part2id", id));
            criteria.setProjection(Projections.projectionList()
                    .add(Projections.property(field), field));
            List<String> list = criteria.list();
            return list;
        } catch (Exception e) {
            throw new DaoException("Problem in DAO Layer " + e);
        }
    }
}
