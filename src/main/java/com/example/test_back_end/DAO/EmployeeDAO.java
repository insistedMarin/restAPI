package com.example.test_back_end.DAO;

import com.example.test_back_end.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeDAO {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private EntityTransaction transaction;
    public boolean addEmployee(Employee employee) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("INSERT INTO employee(nom,prenom,magasin_id,update_at) values ('"+employee.getNom()
                    +"','"
                    +employee.getPrenom()
                    +"',"
                    +employee.getMagasinId()
                    +",CURRENT_TIME)");
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.printf("add WRONG!");
            return false;
        }
    }
    public List<Employee> searchEmployee(Employee employee) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("select * from employee where nom = '" +employee.getNom()+"' and prenom ='"+employee.getPrenom()+"'",Employee.class);
            List<Employee> data = query.getResultList();
            transaction.commit();
            return data;
        } catch (Exception e) {
            System.out.println("search  WRONG!");
            return null;
        }
    }
}
