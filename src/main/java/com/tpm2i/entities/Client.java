package com.tpm2i.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    private int id;
    private String nomcomplet;
    private String telephone;
    private String email;
    private String adresse;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom_complet")
    public String getNom() {
        return nomcomplet;
    }

    public void setNom(String nom) {
        this.nomcomplet = nom;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
    @Column(name = "adresse")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (nomcomplet != null ? !nomcomplet.equals(client.nomcomplet) : client.nomcomplet != null) return false;
        if (telephone != null ? !telephone.equals(client.telephone) : client.telephone != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (adresse != null ? !adresse.equals(client.adresse) : client.adresse != null) return false;

        return true;
    }
}
