package com.example.test_back_end.Service;

import com.example.test_back_end.DAO.MaterielDAO;
import com.example.test_back_end.Model.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterielService {

    @Autowired
    private MaterielDAO materielDAO;
    public Materiel saveMateriel(Materiel materiel){

        if(materielDAO.addMateriel(materiel))
            materiel= materielDAO.searchMateriel(materiel).get(0);

        return materiel;
    }
    public Materiel updateMateriel(Materiel materiel){
        if(materielDAO.updateMateriel(materiel))

            materiel= materielDAO.searchMaterielById(materiel.getMaterielId()).get(0);

        return materiel;
    }
    public boolean deleteMateriel(int id){
        if(materielDAO.searchMaterielById(id).size()==0)
            return false;
        return materielDAO.deleteMateriel(id);
    }
}
