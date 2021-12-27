package com.increff.employee.dao;

import com.increff.employee.pojo.EmployeePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class EmployeeDao {
    private static String delete_id = "delete from EmployeePojo p where id=:id";
    private static String select_id = "select p from EmployeePojo p where id=:id";
    private static String select_all = "select p from EmployeePojo p";


    @PersistenceContext
    EntityManager em;

    public void insert(EmployeePojo p) {
        em.persist(p);
    }

    public int delete(int id) {
        Query query = em.createQuery(delete_id);
        query.setParameter("id",id);
        int result = query.executeUpdate();
        return result;
    }

    public EmployeePojo select(int id) {
        TypedQuery<EmployeePojo> query = em.createQuery(select_id,EmployeePojo.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    public List<EmployeePojo> selectAll() {
        TypedQuery<EmployeePojo> query = em.createQuery(select_all,EmployeePojo.class);
        return query.getResultList();
    }

    public void update(int id, EmployeePojo p) {
        p.setId(id);
    }

}
