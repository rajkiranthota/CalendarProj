/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rajk.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rajkiran_Macys
 */
@Entity
@Table(name = "CALENDAR_EVENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalendarEvents.findAll", query = "SELECT c FROM CalendarEvents c")
    , @NamedQuery(name = "CalendarEvents.findByCeventId", query = "SELECT c FROM CalendarEvents c WHERE c.ceventId = :ceventId")
    , @NamedQuery(name = "CalendarEvents.findByCtitle", query = "SELECT c FROM CalendarEvents c WHERE c.ctitle = :ctitle")
    , @NamedQuery(name = "CalendarEvents.findByCdate", query = "SELECT c FROM CalendarEvents c WHERE c.cdate = :cdate")
    , @NamedQuery(name = "CalendarEvents.findByCtime", query = "SELECT c FROM CalendarEvents c WHERE c.ctime = :ctime")
    , @NamedQuery(name = "CalendarEvents.findByClocation", query = "SELECT c FROM CalendarEvents c WHERE c.clocation = :clocation")
    , @NamedQuery(name = "CalendarEvents.findByCattendant", query = "SELECT c FROM CalendarEvents c WHERE c.cattendant = :cattendant")
    , @NamedQuery(name = "CalendarEvents.findByCcalendarFk", query = "SELECT c FROM CalendarEvents c WHERE c.ccalendarFk = :ccalendarFk")
    , @NamedQuery(name = "CalendarEvents.findByCreminderFlag", query = "SELECT c FROM CalendarEvents c WHERE c.creminderFlag = :creminderFlag")
    , @NamedQuery(name = "CalendarEvents.findByCreminderTime", query = "SELECT c FROM CalendarEvents c WHERE c.creminderTime = :creminderTime")})
public class CalendarEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEVENT_ID")
    private Integer ceventId;
    @Size(max = 48)
    @Column(name = "CTITLE")
    private String ctitle;
    @Column(name = "CDATE")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    @Column(name = "CTIME")
    @Temporal(TemporalType.TIME)
    private Date ctime;
    @Size(max = 48)
    @Column(name = "CLOCATION")
    private String clocation;
    @Size(max = 24)
    @Column(name = "CATTENDANT")
    private String cattendant;
    @Column(name = "CCALENDAR_FK")
    private Integer ccalendarFk;
    @Column(name = "CREMINDER_FLAG")
    private Character creminderFlag;
    @Column(name = "CREMINDER_TIME")
    @Temporal(TemporalType.TIME)
    private Date creminderTime;

    public CalendarEvents() {
    }

    public CalendarEvents(Integer ceventId) {
        this.ceventId = ceventId;
    }

    public Integer getCeventId() {
        return ceventId;
    }

    public void setCeventId(Integer ceventId) {
        this.ceventId = ceventId;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getClocation() {
        return clocation;
    }

    public void setClocation(String clocation) {
        this.clocation = clocation;
    }

    public String getCattendant() {
        return cattendant;
    }

    public void setCattendant(String cattendant) {
        this.cattendant = cattendant;
    }

    public Integer getCcalendarFk() {
        return ccalendarFk;
    }

    public void setCcalendarFk(Integer ccalendarFk) {
        this.ccalendarFk = ccalendarFk;
    }

    public Character getCreminderFlag() {
        return creminderFlag;
    }

    public void setCreminderFlag(Character creminderFlag) {
        this.creminderFlag = creminderFlag;
    }

    public Date getCreminderTime() {
        return creminderTime;
    }

    public void setCreminderTime(Date creminderTime) {
        this.creminderTime = creminderTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ceventId != null ? ceventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarEvents)) {
            return false;
        }
        CalendarEvents other = (CalendarEvents) object;
        if ((this.ceventId == null && other.ceventId != null) || (this.ceventId != null && !this.ceventId.equals(other.ceventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rajk.model.CalendarEvents[ ceventId=" + ceventId + " ]";
    }
    
}
