package com.tpm2i.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {
	private int id;
    private String nom;
    private int etoiles;
    private String adresse;
    private String telephone;
    private String email;
    private String ville;
    
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "etoiles")
    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int e) {
        this.etoiles = e;
    }
    
    @Basic
    @Column(name = "adresse")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
    @Column(name = "ville")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (id != hotel.id) return false;
        if (nom != null ? !nom.equals(hotel.nom) : hotel.nom != null) return false;
        if (etoiles != hotel.etoiles) return false;
        if (adresse != null ? !adresse.equals(hotel.adresse) : hotel.adresse != null) return false;
        if (telephone != null ? !telephone.equals(hotel.telephone) : hotel.telephone != null) return false;
        if (email != null ? !email.equals(hotel.email) : hotel.email != null) return false;
        if (ville != null ? !ville.equals(hotel.ville) : hotel.ville != null) return false;

        return true;
    }
}
