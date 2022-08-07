package com.example.test_back_end.Controller;

import com.example.test_back_end.Model.Inventaire;
import com.example.test_back_end.Model.Result;
import com.example.test_back_end.Service.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/inventaire")
public class InventaireController {

    private InventaireService inventaireService;
    @Autowired
    public InventaireController(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }
    @GetMapping
    public ResponseEntity<List<Result>> checkQuantite(){
        return new ResponseEntity<List<Result>>(inventaireService.checkQuantite(),HttpStatus.OK);
    }
    /*body
    {
    "magasinId":2,
    "materielId":4,
    "quantite":6
}
    * */
    @PostMapping()
    public ResponseEntity<Inventaire> createInventaire(@RequestBody Inventaire inventaire){
        return new ResponseEntity<Inventaire>(inventaireService.saveInventaire(inventaire), HttpStatus.CREATED);
    }
    /*body
    * {
    "inventaireId": 19,
    "materielId": 4,
    "magasinId": 1,
    "quantite": 8
    }
    * */
    @PutMapping()
    public ResponseEntity<Inventaire> updateMateril(@RequestBody Inventaire inventaire){
        return new ResponseEntity<Inventaire>(inventaireService.updateInventaire(inventaire),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        boolean result=inventaireService.deleteInventaire(id);
        return new ResponseEntity<String>(result?"success":"not success,this id is not exist",result?HttpStatus.OK:HttpStatus.BAD_REQUEST);
    }
}
