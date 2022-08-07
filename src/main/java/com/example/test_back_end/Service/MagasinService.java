package com.example.test_back_end.Service;

import com.example.test_back_end.DAO.MagasinDAO;
import com.example.test_back_end.Model.Magasin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MagasinService {

    @Autowired private MagasinDAO magasinDAO;
    public Magasin saveMagasin(Magasin magasin){

        if(magasinDAO.addMagasin(magasin))
            magasin= magasinDAO.searchMagasin(magasin).get(0);

        return magasin;
    }

}
