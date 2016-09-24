package org.com.unitech.hibernate.model;


import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by MohanDivya on 9/24/2016.
 */
@Entity
@Table(name = "ExamData")
public class ExamData {

    @Id
    @Column(name = "idsession")
    private int idsession;

    @Column(name = "idcompany")
    private int idcompany;

    @Column(name = "idservice")
    private String idservice;

    @Column(name = "status")
    private String status;

    @Column(name = "part1id")
    private int part1id;

    @Column(name = "part2id")
    private int part2id;

    @Column(name = "time1")
    private String time1;

    @Column(name = "time1b")
    private String time1b;

    @Column(name = "time2")
    private String time2;

    @Column(name = "time2b")
    private String time2b;

    @Column(name = "type1id")
    private String type1id;

    @Column(name = "type2name")
    private String type2name;

    @Column(name = "type2id")
    private String type2id;

    @Column(name = "address1")
    private String address1;

    @Column(name = "location1")
    private String location1;

    @Column(name = "notes")
    private String notes;

    @Column(name = "data1")
    private String data1;

    public int getIdsession() {
        return idsession;
    }

    public void setIdsession(int idsession) {
        this.idsession = idsession;
    }

    public int getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(int idcompany) {
        this.idcompany = idcompany;
    }

    public String getIdservice() {
        return idservice;
    }

    public void setIdservice(String idservice) {
        this.idservice = idservice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPart1id() {
        return part1id;
    }

    public void setPart1id(int part1id) {
        this.part1id = part1id;
    }

    public int getPart2id() {
        return part2id;
    }

    public void setPart2id(int part2id) {
        this.part2id = part2id;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime1b() {
        return time1b;
    }

    public void setTime1b(String time1b) {
        this.time1b = time1b;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime2b() {
        return time2b;
    }

    public void setTime2b(String time2b) {
        this.time2b = time2b;
    }

    public String getType1id() {
        return type1id;
    }

    public void setType1id(String type1id) {
        this.type1id = type1id;
    }

    public String getType2name() {
        return type2name;
    }

    public void setType2name(String type2name) {
        this.type2name = type2name;
    }

    public String getType2id() {
        return type2id;
    }

    public void setType2id(String type2id) {
        this.type2id = type2id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getLocation1() {
        return location1;
    }

    public void setLocation1(String location1) {
        this.location1 = location1;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }
    @Override
    public String toString() {
        return "User [part2id=" + part2id + ", idsession=" + idsession + ", idcompany=" + idcompany
                + ", idservice=" + idservice + ", status=" + status +
                ", part1id=" + part1id +
                ", time1=" + time1 +
                ", time1b=" + time1b +
                ", time2=" + time2 +
                ", time2b=" + time2b +
                ", type1id=" + type1id +
                ", type2name=" + type2name +
                ", type2id=" + type2id +
                ", location1=" + location1 +
                ", notes=" + notes +
                ", data1=" + data1 +"]";
    }
}
