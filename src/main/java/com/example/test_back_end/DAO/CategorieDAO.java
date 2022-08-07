package com.example.test_back_end.DAO;

import com.example.test_back_end.Model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategorieDAO {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private EntityTransaction transaction;
    public boolean addCategorie(Categorie categorie) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("INSERT INTO categorie(nom,update_at) values ('"+categorie.getNom()+"',CURRENT_TIME)");
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.printf("add WRONG!!!");
            return false;
        }
    }
    public List<Categorie> searchCategorie(Categorie categorie) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("select * from categorie where nom = '" +categorie.getNom()+"'",Categorie.class);
            List<Categorie> data = query.getResultList();
            transaction.commit();
            return data;
        } catch (Exception e) {
            System.out.println("search WRONG!");
            return null;
        }
    }
}
