package com.example.test_back_end.DAO;

import com.example.test_back_end.Model.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MaterielDAO {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private EntityTransaction transaction;

    public boolean addMateriel(Materiel materiel) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("INSERT INTO materiel(nom,categorie_id,update_at) values ('"+materiel.getNom()
                    +"',"
                    +materiel.getCategorieId()
                    +",CURRENT_TIME)");
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.printf("add WRONG!!!");
            return false;
        }
    }
    public List<Materiel> searchMateriel(Materiel materiel) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("select * from Materiel where nom = '" +materiel.getNom()+"'",Materiel.class);
            List<Materiel> data = query.getResultList();
            transaction.commit();
            return data;
        } catch (Exception e) {
            System.out.println("search WRONG!");
            return null;
        }
    }
    public List<Materiel> searchMaterielById(int id) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("select * from Materiel where materiel_id = '" +id+"'",Materiel.class);
            List<Materiel> data = query.getResultList();
            transaction.commit();
            return data;
        } catch (Exception e) {
            System.out.println("search WRONG!");
            return null;
        }
    }
    public Boolean updateMateriel(Materiel materiel) {//
        try {
            transaction.begin();
//
            Query query = entityManager.createNativeQuery("update Materiel set nom='"+materiel.getNom()
            +"',discription='"+materiel.getDiscription()
            +"',marque='"+materiel.getMarque()
            +"',image_url='"+materiel.getImageUrl()
            +"',taille='"+materiel.getTaille()
            +"',duree_location="+materiel.getDureeLocation()
            +", cout_location="+materiel.getCoutLocation()
            +", cout_remplacement="+materiel.getCoutRemplacement()
            +", categorie_id="+materiel.getCategorieId()
            +", update_at= CURRENT_TIME"
            +" where materiel_id="+materiel.getMaterielId());
            query.executeUpdate();
            transaction.commit();

            return true;

        } catch (Exception e) {
            System.out.printf(" update WRONG!!!");
            return false;
        }
    }

    public boolean deleteMateriel(int id) {
        try {
            transaction.begin();
            Query query = entityManager.createNativeQuery("delete from materiel where materiel_id=" + id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.printf("delete WRONG!!!");
            return false;
        }
    }
}
