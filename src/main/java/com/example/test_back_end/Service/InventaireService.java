package com.example.test_back_end.Service;

import com.example.test_back_end.DAO.InventaireDAO;
import com.example.test_back_end.Model.Inventaire;
import com.example.test_back_end.Model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventaireService {

    @Autowired
    private InventaireDAO inventaireDAO;
    public Inventaire saveInventaire(Inventaire inventaire){

        if(inventaireDAO.addInventaire(inventaire))
            inventaire= inventaireDAO.searchInventaire(inventaire).get(0);

        return inventaire;
    }
    public Inventaire updateInventaire(Inventaire inventaire){
        if(inventaireDAO.updateInventaire(inventaire))
            inventaire= inventaireDAO.searchInventaireById(inventaire.getInventaireId()).get(0);

        return inventaire;
    }
    public boolean deleteInventaire(int id){
        if(inventaireDAO.searchInventaireById(id).size()==0)
            return false;
        return inventaireDAO.deleteInventaire(id);
    }

    public List<Result> checkQuantite(){
        return inventaireDAO.CheckQuantite();
    }

    
}
