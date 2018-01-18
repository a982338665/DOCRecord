package com.cr.entity;

import java.util.Date;

public class LoginUserBean {
    private Integer sid;

    private String cLoginname;

    private String cLoginpass;

    private String cName;

    private Byte cAge;

    private Byte cSex;

    private Byte cIsuse;

    private String cCreater;

    private Date cCreatetime;

    private String cDesc;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getcLoginname() {
        return cLoginname;
    }

    public void setcLoginname(String cLoginname) {
        this.cLoginname = cLoginname;
    }

    public String getcLoginpass() {
        return cLoginpass;
    }

    public void setcLoginpass(String cLoginpass) {
        this.cLoginpass = cLoginpass;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Byte getcAge() {
        return cAge;
    }

    public void setcAge(Byte cAge) {
        this.cAge = cAge;
    }

    public Byte getcSex() {
        return cSex;
    }

    public void setcSex(Byte cSex) {
        this.cSex = cSex;
    }

    public Byte getcIsuse() {
        return cIsuse;
    }

    public void setcIsuse(Byte cIsuse) {
        this.cIsuse = cIsuse;
    }

    public String getcCreater() {
        return cCreater;
    }

    public void setcCreater(String cCreater) {
        this.cCreater = cCreater;
    }

    public Date getcCreatetime() {
        return cCreatetime;
    }

    public void setcCreatetime(Date cCreatetime) {
        this.cCreatetime = cCreatetime;
    }

    public String getcDesc() {
        return cDesc;
    }

    public void setcDesc(String cDesc) {
        this.cDesc = cDesc;
    }
}