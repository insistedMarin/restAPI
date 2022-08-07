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
    private int quantite;
    private Timestamp updateAt;

    @Id
    @Column(name = "inventaire_id")
    public int getInventaireId() {
        return inventaireId;
    }

    public void setInventaireId(int inventaireId) {
        this.inventaireId = inventaireId;
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
        return inventaireId == that.inventaireId && quantite == that.quantite && Objects.equals(updateAt, that.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventaireId, quantite, updateAt);
    }
}
