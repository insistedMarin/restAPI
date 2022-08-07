package com.example.test_back_end.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Magasin {
    private int magasinId;
    private String ville;
    private int directeurPersonnelId;
    private Timestamp updateAt;

    public Magasin(int magasinId, String ville, int directeurPersonnelId, Timestamp updateAt) {
        this.magasinId = magasinId;
        this.ville = ville;
        this.directeurPersonnelId = directeurPersonnelId;
        this.updateAt = updateAt;
    }

    public Magasin() {

    }




    @Id
    @Column(name = "magasin_id")
    public int getMagasinId() {
        return magasinId;
    }

    public void setMagasinId(int magasinId) {
        this.magasinId = magasinId;
    }

    @Basic
    @Column(name = "ville")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "directeur_personnel_id")
    public int getDirecteurPersonnelId() {
        return directeurPersonnelId;
    }

    public void setDirecteurPersonnelId(int directeurPersonnelId) {
        this.directeurPersonnelId = directeurPersonnelId;
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
        Magasin magasin = (Magasin) o;
        return magasinId == magasin.magasinId && directeurPersonnelId == magasin.directeurPersonnelId && Objects.equals(ville, magasin.ville) && Objects.equals(updateAt, magasin.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(magasinId, ville, directeurPersonnelId, updateAt);
    }
}
