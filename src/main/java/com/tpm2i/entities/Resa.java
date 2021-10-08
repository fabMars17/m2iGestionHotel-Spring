package com.tpm2i.entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
public class Resa {
    private int id;
    private Client client;
    private Hotel hotel;
    private Date datestart;
    private Date dateend;
    private int chambre;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "client", referencedColumnName = "id", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client c) {
        this.client = c;
    }

    @OneToOne
    @JoinColumn(name = "hotel", referencedColumnName = "id", nullable = false)
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel h) {
        this.hotel = h;
    }

    @Basic
    @Column(name = "datestart")
    public Date getDateStart() {
        return datestart;
    }

    public void setDateStart(Date date) {
        this.datestart = date;
    }

    @Basic
    @Column(name = "dateend")
    public Date getDateEnd() {
        return dateend;
    }

    public void setDateEnd(Date date) {
        this.dateend = date;
    }

    @Basic
    @Column(name = "no_chambre")
    public int getChambre() {
        return chambre;
    }

    public void setChambre(int nc) {
        this.chambre = nc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resa resa = (Resa) o;

        if (id != resa.id) return false;
        if (datestart != null ? !datestart.equals(resa.datestart) : resa.datestart != null) return false;
        if (dateend != null ? !dateend.equals(resa.dateend) : resa.dateend != null) return false;
        if (chambre != resa.chambre) return false;

        return true;
    }
}
