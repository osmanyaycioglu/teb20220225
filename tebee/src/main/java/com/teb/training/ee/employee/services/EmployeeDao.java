package com.teb.training.ee.employee.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.teb.training.ee.employee.models.Employee;

@LocalBean
@Stateless
// @TransactionManagement(TransactionManagementType.BEAN)
public class EmployeeDao {

    @PersistenceContext(unitName = "tebee")
    private EntityManager em;

    //    @Transactional
    //    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void insert(final Employee employeeParam) {
        this.em.persist(employeeParam); // managed
    }

    public void update(final Employee employeeParam) {
        Employee mergeLoc = this.em.merge(employeeParam);
    }

    public List<Employee> getByName(final String name) {
        TypedQuery<Employee> createQueryLoc = this.em.createQuery("select e from Employee e where e.name=?1",
                                                                  Employee.class);
        createQueryLoc.setParameter(1,
                                    name);
        List<Employee> resultListLoc = createQueryLoc.getResultList();
        return resultListLoc;
    }

    public List<Employee> getByNameNative(final String name) {
        Query createNativeQueryLoc = this.em.createNativeQuery("select * from employee e where e.name=?1",
                                                               Object.class);
        createNativeQueryLoc.setParameter(1,
                                          name);
        List<Employee> resultListLoc = createNativeQueryLoc.getResultList();
        return resultListLoc;
    }

}
