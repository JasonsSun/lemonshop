package com.jsonshop.lemonshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class bkuserMessage implements Serializable {
    @Id
    @GeneratedValue
    private Integer adminMes;

    private String adminRealname;//名称（昵称或者真实姓名，不同系统不同定义）

    private String adminSex;

    private String adminAge;

    private String adminAddress;

    private String adminIdcard;

    private String adminPhone;

    private String adminMobile;

    private String adminEmail;

    private Integer adminLoginid;

    private static final long serialVersionUID = 1L;

    public bkuserMessage(Integer adminMes, String adminRealname, String adminSex, String adminAge, String adminAddress, String adminIdcard, String adminPhone, String adminMobile, String adminEmail, Integer adminLoginid) {
        this.adminMes = adminMes;
        this.adminRealname = adminRealname;
        this.adminSex = adminSex;
        this.adminAge = adminAge;
        this.adminAddress = adminAddress;
        this.adminIdcard = adminIdcard;
        this.adminPhone = adminPhone;
        this.adminMobile = adminMobile;
        this.adminEmail = adminEmail;
        this.adminLoginid = adminLoginid;
    }

    public bkuserMessage() {
        super();
    }

    public Integer getAdminMes() {
        return adminMes;
    }

    public void setAdminMes(Integer adminMes) {
        this.adminMes = adminMes;
    }

    public String getAdminRealname() {
        return adminRealname;
    }

    public void setAdminRealname(String adminRealname) {
        this.adminRealname = adminRealname == null ? null : adminRealname.trim();
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex == null ? null : adminSex.trim();
    }

    public String getAdminAge() {
        return adminAge;
    }

    public void setAdminAge(String adminAge) {
        this.adminAge = adminAge == null ? null : adminAge.trim();
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress == null ? null : adminAddress.trim();
    }

    public String getAdminIdcard() {
        return adminIdcard;
    }

    public void setAdminIdcard(String adminIdcard) {
        this.adminIdcard = adminIdcard == null ? null : adminIdcard.trim();
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    public String getAdminMobile() {
        return adminMobile;
    }

    public void setAdminMobile(String adminMobile) {
        this.adminMobile = adminMobile == null ? null : adminMobile.trim();
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail == null ? null : adminEmail.trim();
    }

    public Integer getAdminLoginid() {
        return adminLoginid;
    }

    public void setAdminLoginid(Integer adminLoginid) {
        this.adminLoginid = adminLoginid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminMes=").append(adminMes);
        sb.append(", adminRealname=").append(adminRealname);
        sb.append(", adminSex=").append(adminSex);
        sb.append(", adminAge=").append(adminAge);
        sb.append(", adminAddress=").append(adminAddress);
        sb.append(", adminIdcard=").append(adminIdcard);
        sb.append(", adminPhone=").append(adminPhone);
        sb.append(", adminMobile=").append(adminMobile);
        sb.append(", adminEmail=").append(adminEmail);
        sb.append(", adminLoginid=").append(adminLoginid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}