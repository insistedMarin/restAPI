package com.example.test_back_end.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Inventaire {
    private int inventaireId;
    private int materielId;
    private int magasinId;
    private int quantite;
    private Timestamp updateAt;

    public Inventaire(int inventaireId, int materielId, int magasinId, int quantite, Timestamp updateAt) {
        this.inventaireId = inventaireId;
        this.materielId = materielId;
        this.magasinId = magasinId;
        this.quantite = quantite;
        this.updateAt = updateAt;
    }

    public Inventaire() {

    }


    @Id
    @Column(name = "inventaire_id")
    public int getInventaireId() {
        return inventaireId;
    }

    public void setInventaireId(int inventaireId) {
        this.inventaireId = inventaireId;
    }

    @Basic
    @Column(name = "materiel_id")
    public int getMaterielId() {
        return materielId;
    }

    public void setMaterielId(int materielId) {
        this.materielId = materielId;
    }

    @Basic
    @Column(name = "magasin_id")
    public int getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(int magasinId) {
        this.magasinId = magasinId;
    }

    @Basic
    @Column(name = "quantite")
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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
        Inventaire that = (Inventaire) o;
        return inventaireId == that.inventaireId && materielId == that.materielId && magasinId == that.magasinId && quantite == that.quantite && Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventaireId, materielId, magasinId, quantite, updateAt);
    }
}
