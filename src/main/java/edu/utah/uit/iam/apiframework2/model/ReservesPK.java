/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utah.uit.iam.apiframework2.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author andrewschneider
 */
@Embeddable
public class ReservesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teams_id")
    private int teamsId;

    public ReservesPK() {
    }

    public ReservesPK(int id, int teamsId) {
        this.id = id;
        this.teamsId = teamsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamsId() {
        return teamsId;
    }

    public void setTeamsId(int teamsId) {
        this.teamsId = teamsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) teamsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservesPK)) {
            return false;
        }
        ReservesPK other = (ReservesPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.teamsId != other.teamsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.utah.uit.iam.apiframework2.ReservesPK[ id=" + id + ", teamsId=" + teamsId + " ]";
    }
    
}
