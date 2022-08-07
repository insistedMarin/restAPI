package com.example.test_back_end.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Materiel {
    private int materielId;
    private String nom;
    private String discription;
    private String marque;
    private String imageUrl;
    private String taille;
    private int dureeLocation;
    private BigDecimal coutLocation;
    private BigDecimal coutRemplacement;
    private int categorieId;
    private Timestamp updateAt;

    public Materiel(int materielId, String nom, String discription, String marque, String imageUrl, String taille, int dureeLocation, BigDecimal coutLocation, BigDecimal coutRemplacement, int categorieId, Timestamp updateAt) {
        this.materielId = materielId;
        this.nom = nom;
        this.discription = discription;
        this.marque = marque;
        this.imageUrl = imageUrl;
        this.taille = taille;
        this.dureeLocation = dureeLocation;
        this.coutLocation = coutLocation;
        this.coutRemplacement = coutRemplacement;
        this.categorieId = categorieId;
        this.updateAt = updateAt;
    }

    public Materiel() {

    }

    @Id
    @Column(name = "materiel_id")
    public int getMaterielId() {
        return materielId;
    }

    public void setMaterielId(int materielId) {
        this.materielId = materielId;
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
    @Column(name = "discription")
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Basic
    @Column(name = "marque")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "taille")
    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    @Basic
    @Column(name = "duree_location")
    public int getDureeLocation() {
        return dureeLocation;
    }

    public void setDureeLocation(int dureeLocation) {
        this.dureeLocation = dureeLocation;
    }

    @Basic
    @Column(name = "cout_location")
    public BigDecimal getCoutLocation() {
        return coutLocation;
    }

    public void setCoutLocation(BigDecimal coutLocation) {
        this.coutLocation = coutLocation;
    }

    @Basic
    @Column(name = "cout_remplacement")
    public BigDecimal getCoutRemplacement() {
        return coutRemplacement;
    }

    public void setCoutRemplacement(BigDecimal coutRemplacement) {
        this.coutRemplacement = coutRemplacement;
    }

    @Basic
    @Column(name = "categorie_id")
    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
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
        Materiel materiel = (Materiel) o;
        return materielId == materiel.materielId && dureeLocation == materiel.dureeLocation && categorieId == materiel.categorieId && Objects.equals(nom, materiel.nom) && Objects.equals(discription, materiel.discription) && Objects.equals(marque, materiel.marque) && Objects.equals(imageUrl, materiel.imageUrl) && Objects.equals(taille, materiel.taille) && Objects.equals(coutLocation, materiel.coutLocation) && Objects.equals(coutRemplacement, materiel.coutRemplacement) && Objects.equals(updateAt, materiel.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materielId, nom, discription, marque, imageUrl, taille, dureeLocation, coutLocation, coutRemplacement, categorieId, updateAt);
    }
}
