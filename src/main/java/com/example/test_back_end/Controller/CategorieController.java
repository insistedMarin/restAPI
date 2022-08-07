package com.example.test_back_end.Controller;

import com.example.test_back_end.Model.Categorie;

import com.example.test_back_end.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categorie")
public class CategorieController {

    private CategorieService categorieService;
    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    /*
path
http://localhost:8080/test_back_end/api/categorie
body
{
"nom": "electronic"
}
* */
    @PostMapping()
    public ResponseEntity<Categorie> saveCategorie(@RequestBody Categorie categorie){
        return new ResponseEntity<Categorie>(categorieService.saveCategorie(categorie), HttpStatus.CREATED);
    }

}
