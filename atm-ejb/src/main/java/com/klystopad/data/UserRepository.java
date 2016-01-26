package com.klystopad.data;

import com.klystopad.model.Member;
import com.klystopad.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Kirill Listopad on 1/7/16.
 */
@ApplicationScoped
public class UserRepository {

    @Inject
    private EntityManager em;

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public User findByName(String name){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        criteria.select(user).where(cb.equal(user.get("name"), name));
        return em.createQuery(criteria).getSingleResult();
    }

    public void persist(User user){
        em.persist(user);
    }

}
