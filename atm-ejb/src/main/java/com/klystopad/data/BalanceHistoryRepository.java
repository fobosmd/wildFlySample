package com.klystopad.data;

import com.klystopad.model.BalanceHistory;
import com.klystopad.model.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Kirill Listopad on 1/9/16.
 */
public class BalanceHistoryRepository {

    @Inject
    private EntityManager em;

    public List<BalanceHistory> findByUserName(String userName){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BalanceHistory> criteria = cb.createQuery(BalanceHistory.class);
        Root<BalanceHistory> balanceHistory = criteria.from(BalanceHistory.class);
        criteria.select(balanceHistory).where(cb.equal(balanceHistory.get("userName"), userName));
        return em.createQuery(criteria).getResultList();
    }

    public void persist(BalanceHistory balanceHistory){
        em.persist(balanceHistory);
    }
}
