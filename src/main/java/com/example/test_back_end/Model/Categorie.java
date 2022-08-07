package com.example.test_back_end.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Categorie {
    private int categorieId;
    private String nom;
    private Timestamp updateAt;

    public Categorie(int categorieId, String nom, Timestamp updateAt) {
        this.categorieId = categorieId;
        this.nom = nom;
        this.updateAt = updateAt;
    }

    public Categorie() {

    }

    @Id
    @Column(name = "Categorie_id")
    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "update_at")
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return categorieId == categorie.categorieId && Objects.equals(nom, categorie.nom) && Objects.equals(updateAt, categorie.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categorieId, nom, updateAt);
    }
}
