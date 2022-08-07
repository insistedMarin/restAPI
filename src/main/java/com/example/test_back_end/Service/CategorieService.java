package com.example.test_back_end.Service;

import com.example.test_back_end.DAO.CategorieDAO;
import com.example.test_back_end.Model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {

    @Autowired
    private CategorieDAO categorieDAO;
    public Categorie saveCategorie(Categorie categorie){

        if(categorieDAO.addCategorie(categorie))
            categorie= categorieDAO.searchCategorie(categorie).get(0);

        return categorie;
    }
}
