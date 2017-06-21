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
@Table(name = "subs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subs.findAll", query = "SELECT s FROM Subs s")
    , @NamedQuery(name = "Subs.findById", query = "SELECT s FROM Subs s WHERE s.subsPK.id = :id")
    , @NamedQuery(name = "Subs.findByName", query = "SELECT s FROM Subs s WHERE s.name = :name")
    , @NamedQuery(name = "Subs.findByNumber", query = "SELECT s FROM Subs s WHERE s.number = :number")
    , @NamedQuery(name = "Subs.findByPosition", query = "SELECT s FROM Subs s WHERE s.position = :position")
    , @NamedQuery(name = "Subs.findByTeamsId", query = "SELECT s FROM Subs s WHERE s.subsPK.teamsId = :teamsId")})
public class Subs implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubsPK subsPK;
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

    public Subs() {
    }

    public Subs(SubsPK subsPK) {
        this.subsPK = subsPK;
    }

    public Subs(SubsPK subsPK, String name, String number, String position) {
        this.subsPK = subsPK;
        this.name = name;
        this.number = number;
        this.position = position;
    }

    public Subs(int id, int teamsId) {
        this.subsPK = new SubsPK(id, teamsId);
    }

    public SubsPK getSubsPK() {
        return subsPK;
    }

    public void setSubsPK(SubsPK subsPK) {
        this.subsPK = subsPK;
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
        hash += (subsPK != null ? subsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subs)) {
            return false;
        }
        Subs other = (Subs) object;
        if ((this.subsPK == null && other.subsPK != null) || (this.subsPK != null && !this.subsPK.equals(other.subsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utah.uit.iam.apiframework2.Subs[ subsPK=" + subsPK + " ]";
    }
    
}
