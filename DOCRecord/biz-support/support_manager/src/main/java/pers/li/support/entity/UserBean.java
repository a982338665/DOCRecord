package pers.li.support.entity;

import java.util.Date;

public class UserBean {
    private Integer id;

    private String loginName;

    private String loginPass;

    private String fullName;

    private Byte sex;

    private String creater;

    private Date createTime;

    private String updator;

    private Date updatetIme;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getUpdatetIme() {
        return updatetIme;
    }

    public void setUpdatetIme(Date updatetIme) {
        this.updatetIme = updatetIme;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", loginPass='" + loginPass + '\'' +
                ", fullName='" + fullName + '\'' +
                ", sex=" + sex +
                ", creater='" + creater + '\'' +
                ", createTime=" + createTime +
                ", updator='" + updator + '\'' +
                ", updatetIme=" + updatetIme +
                '}';
    }
}