package com.example.test_back_end.Controller;

import com.example.test_back_end.Model.Magasin;
import com.example.test_back_end.Service.MagasinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/api/magasin")
public class MagasinController {
    private MagasinService magasinService;
    @Autowired
    public MagasinController(MagasinService magasinService) {
        this.magasinService = magasinService;
    }
    /*
    path
    http://localhost:8080/test_back_end/api/magasin
    body
    {
    "ville": "shenzhen",
    "directeurPersonnelId":"1"
    }
    * */
    @PostMapping()
    public ResponseEntity<Magasin> saveMagasin(@RequestBody Magasin magasin){
        return new ResponseEntity<Magasin>(magasinService.saveMagasin(magasin), HttpStatus.CREATED);
    }

}
