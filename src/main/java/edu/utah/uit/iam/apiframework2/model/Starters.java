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
@Table(name = "starters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Starters.findAll", query = "SELECT s FROM Starters s")
    , @NamedQuery(name = "Starters.findById", query = "SELECT s FROM Starters s WHERE s.startersPK.id = :id")
    , @NamedQuery(name = "Starters.findByName", query = "SELECT s FROM Starters s WHERE s.name = :name")
    , @NamedQuery(name = "Starters.findByNumber", query = "SELECT s FROM Starters s WHERE s.number = :number")
    , @NamedQuery(name = "Starters.findByPosition", query = "SELECT s FROM Starters s WHERE s.position = :position")
    , @NamedQuery(name = "Starters.findByTeamsId", query = "SELECT s FROM Starters s WHERE s.startersPK.teamsId = :teamsId")})
public class Starters implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StartersPK startersPK;
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

    public Starters() {
    }

    public Starters(StartersPK startersPK) {
        this.startersPK = startersPK;
    }

    public Starters(StartersPK startersPK, String name, String number, String position) {
        this.startersPK = startersPK;
        this.name = name;
        this.number = number;
        this.position = position;
    }

    public Starters(int id, int teamsId) {
        this.startersPK = new StartersPK(id, teamsId);
    }

    public StartersPK getStartersPK() {
        return startersPK;
    }

    public void setStartersPK(StartersPK startersPK) {
        this.startersPK = startersPK;
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
        hash += (startersPK != null ? startersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Starters)) {
            return false;
        }
        Starters other = (Starters) object;
        if ((this.startersPK == null && other.startersPK != null) || (this.startersPK != null && !this.startersPK.equals(other.startersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utah.uit.iam.apiframework2.Starters[ startersPK=" + startersPK + " ]";
    }
    
}
