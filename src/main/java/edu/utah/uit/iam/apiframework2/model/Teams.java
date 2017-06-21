/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utah.uit.iam.apiframework2.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andrewschneider
 */
@Entity
@Table(name = "teams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teams.findAll", query = "SELECT t FROM Teams t")
    , @NamedQuery(name = "Teams.findById", query = "SELECT t FROM Teams t WHERE t.id = :id")
    , @NamedQuery(name = "Teams.findByName", query = "SELECT t FROM Teams t WHERE t.name = :name")
    , @NamedQuery(name = "Teams.findByLeague", query = "SELECT t FROM Teams t WHERE t.league = :league")
    , @NamedQuery(name = "Teams.findByCity", query = "SELECT t FROM Teams t WHERE t.city = :city")})
public class Teams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "league")
    private String league;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teams")
    private Collection<Subs> subsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teams")
    private Collection<Starters> startersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teams")
    private Collection<Reserves> reservesCollection;

    public Teams() {
    }

    public Teams(Integer id) {
        this.id = id;
    }

    public Teams(Integer id, String name, String league, String city) {
        this.id = id;
        this.name = name;
        this.league = league;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<Subs> getSubsCollection() {
        return subsCollection;
    }

    public void setSubsCollection(Collection<Subs> subsCollection) {
        this.subsCollection = subsCollection;
    }

    @XmlTransient
    public Collection<Starters> getStartersCollection() {
        return startersCollection;
    }

    public void setStartersCollection(Collection<Starters> startersCollection) {
        this.startersCollection = startersCollection;
    }

    @XmlTransient
    public Collection<Reserves> getReservesCollection() {
        return reservesCollection;
    }

    public void setReservesCollection(Collection<Reserves> reservesCollection) {
        this.reservesCollection = reservesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teams)) {
            return false;
        }
        Teams other = (Teams) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utah.uit.iam.apiframework2.Teams[ id=" + id + " ]";
    }
    
}
