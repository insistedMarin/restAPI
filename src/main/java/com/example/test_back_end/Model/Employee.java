package com.example.test_back_end.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Employee {
    private int employeeId;
    private String nom;
    private String prenom;
    private String imageUrl;
    private String email;
    private String login;
    private String mdp;
    private byte actif;
    private int magasinId;
    private Timestamp updateAt;

    public Employee(String nom, String prenom, int magasinId) {
        this.nom = nom;
        this.prenom = prenom;
        this.magasinId = magasinId;
    }

    public Employee() {

    }

    @Id
    @Column(name = "employee_id")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "mdp")
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Basic
    @Column(name = "actif")
    public byte getActif() {
        return actif;
    }

    public void setActif(byte actif) {
        this.actif = actif;
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
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && actif == employee.actif && magasinId == employee.magasinId && Objects.equals(nom, employee.nom) && Objects.equals(prenom, employee.prenom) && Objects.equals(imageUrl, employee.imageUrl) && Objects.equals(email, employee.email) && Objects.equals(login, employee.login) && Objects.equals(mdp, employee.mdp) && Objects.equals(updateAt, employee.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, nom, prenom, imageUrl, email, login, mdp, actif, magasinId, updateAt);
    }
}
