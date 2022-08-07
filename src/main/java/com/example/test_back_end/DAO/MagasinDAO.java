package com.example.test_back_end.DAO;

import com.example.test_back_end.Model.Magasin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MagasinDAO {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private EntityTransaction transaction;
    public boolean addMagasin(Magasin magasin) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("INSERT INTO magasin(ville,directeur_personnel_id,update_at) values ('"+magasin.getVille()+"',"+magasin.getDirecteurPersonnelId()+",CURRENT_TIME)");
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.printf("add WRONG!!!");
            return false;
        }
    }
    public List<Magasin> searchMagasin(Magasin magasin) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("select * from magasin where ville = '" + magasin.getVille() + "' and directeur_personnel_id = '"+magasin.getDirecteurPersonnelId()+"'",Magasin.class);
            List<Magasin> data = query.getResultList();
            transaction.commit();
            return data;
        } catch (Exception e) {
            System.out.println("search WRONG!");
            return null;
        }
    }
}
