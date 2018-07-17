/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajk.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rajkiran_Macys
 */
@Entity
@Table(name = "CALENDAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendar.findAll", query = "SELECT c FROM Calendar c")
    , @NamedQuery(name = "Calendar.findByCid", query = "SELECT c FROM Calendar c WHERE c.cid = :cid")
    , @NamedQuery(name = "Calendar.findByCname", query = "SELECT c FROM Calendar c WHERE c.cname = :cname")
    , @NamedQuery(name = "Calendar.findByCuser", query = "SELECT c FROM Calendar c WHERE c.cuser = :cuser")})
public class Calendar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CID")
    private Integer cid;
    @Size(max = 24)
    @Column(name = "CNAME")
    private String cname;
    @Size(max = 24)
    @Column(name = "CUSER")
    private String cuser;

    public Calendar() {
    }

    public Calendar(Integer cid) {
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCuser() {
        return cuser;
    }

    public void setCuser(String cuser) {
        this.cuser = cuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendar)) {
            return false;
        }
        Calendar other = (Calendar) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rajk.model.Calendar[ cid=" + cid + " ]";
    }
    
}
