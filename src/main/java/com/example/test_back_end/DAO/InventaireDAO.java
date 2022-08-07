package com.example.test_back_end.DAO;

import com.example.test_back_end.Model.Inventaire;
import com.example.test_back_end.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.tools.Diagnostic;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class InventaireDAO {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private EntityTransaction transaction;

    public boolean addInventaire(Inventaire inventaire) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("INSERT INTO inventaire(materiel_id,magasin_id,quantite,update_at) values ("
            +inventaire.getMaterielId()+","
            +inventaire.getMagasinId()+","
            +inventaire.getQuantite()+",CURRENT_TIME)");
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.printf("add WRONG!!!");
            return false;
        }
    }
    public List<Inventaire> searchInventaire(Inventaire inventaire) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("select * from inventaire where materiel_id ="
            +inventaire.getMaterielId()+" and magasin_id="+inventaire.getMagasinId(),Inventaire.class);
            List<Inventaire> data = query.getResultList();
            transaction.commit();
            return data;
        } catch (Exception e) {
            System.out.println("search WRONG!");
            return null;
        }
    }
    public List<Inventaire> searchInventaireById(int id) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("select * from inventaire where inventaire_id="+id,Inventaire.class);
            List<Inventaire> data = query.getResultList();
            transaction.commit();
            return data;
        } catch (Exception e) {
            System.out.println("search WRONG!");
            return null;
        }
    }
    public Boolean updateInventaire(Inventaire inventaire) {//
        try {
            transaction.begin();
//
            Query query = entityManager.createNativeQuery("update inventaire set materiel_id="
            +inventaire.getMaterielId()+", magasin_id="+inventaire.getMagasinId()
            +", quantite="+inventaire.getQuantite()+" where inventaire_id="+inventaire.getInventaireId());
            query.executeUpdate();
            transaction.commit();

            return true;

        } catch (Exception e) {
            System.out.printf(" update WRONG!!!");
            return false;
        }
    }

    public boolean deleteInventaire(int id) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("delete from inventaire where inventaire_id="+id);
            entityManager.createNativeQuery("");
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.printf("delete WRONG!!!");
            return false;
        }
    }
    public List<Result> CheckQuantite(){
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("select  s.materiel_id as id,s.nom,sum(c.quantite) as quantite from inventaire c inner join materiel s on c.materiel_id = s.materiel_id group by s.materiel_id",Result.class);
            List<Result> data=query.getResultList();
            System.out.println(data.size());
            transaction.commit();
            return data;
        } catch (Exception e) {
            System.out.printf("check WRONG!!!");
            return null;
        }
    }
    
}
