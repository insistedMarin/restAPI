package com.example.test_back_end.Controller;

import com.example.test_back_end.Model.Materiel;
import com.example.test_back_end.Service.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/materiel")
public class MaterielController {

    private MaterielService materielService;
    @Autowired
    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }
    /*body
    *
    {
    "nom":"table",
    "categorieId":2
    }*/
    @PostMapping()
    public ResponseEntity<Materiel> createMateriel(@RequestBody Materiel materiel){
        return new ResponseEntity<Materiel>(materielService.saveMateriel(materiel), HttpStatus.CREATED);
    }
    /*
    * body
    * {
    "materielId": 9,
    "nom": "table",
    "discription": null,
    "marque": "test",
    "imageUrl": "path",
    "taille": "petit",
    "dureeLocation": 10,
    "coutLocation": 34.500,
    "coutRemplacement": 34.500,
    "categorieId": 2
}
    * */
    @PutMapping()
    public ResponseEntity<Materiel> updateMateril(@RequestBody Materiel materiel){
        return new ResponseEntity<Materiel>(materielService.updateMateriel(materiel),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean result=materielService.deleteMateriel(id);
        return new ResponseEntity<String>(result?"success":"not success,this id is not exist",result?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }
}
