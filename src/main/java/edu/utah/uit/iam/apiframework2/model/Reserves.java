/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utah.uit.iam.apiframework2.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andrewschneider
 */
@Entity
@Table(name = "reserves")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserves.findAll", query = "SELECT r FROM Reserves r")
    , @NamedQuery(name = "Reserves.findById", query = "SELECT r FROM Reserves r WHERE r.reservesPK.id = :id")
    , @NamedQuery(name = "Reserves.findByName", query = "SELECT r FROM Reserves r WHERE r.name = :name")
    , @NamedQuery(name = "Reserves.findByNumber", query = "SELECT r FROM Reserves r WHERE r.number = :number")
    , @NamedQuery(name = "Reserves.findByPosition", query = "SELECT r FROM Reserves r WHERE r.position = :position")
    , @NamedQuery(name = "Reserves.findByTeamsId", query = "SELECT r FROM Reserves r WHERE r.reservesPK.teamsId = :teamsId")})
public class Reserves implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservesPK reservesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "position")
    private String position;
    @JoinColumn(name = "teams_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Teams teams;

    public Reserves() {
    }

    public Reserves(ReservesPK reservesPK) {
        this.reservesPK = reservesPK;
    }

    public Reserves(ReservesPK reservesPK, String name, String number, String position) {
        this.reservesPK = reservesPK;
        this.name = name;
        this.number = number;
        this.position = position;
    }

    public Reserves(int id, int teamsId) {
        this.reservesPK = new ReservesPK(id, teamsId);
    }

    public ReservesPK getReservesPK() {
        return reservesPK;
    }

    public void setReservesPK(ReservesPK reservesPK) {
        this.reservesPK = reservesPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservesPK != null ? reservesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserves)) {
            return false;
        }
        Reserves other = (Reserves) object;
        if ((this.reservesPK == null && other.reservesPK != null) || (this.reservesPK != null && !this.reservesPK.equals(other.reservesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utah.uit.iam.apiframework2.Reserves[ reservesPK=" + reservesPK + " ]";
    }
    
}
