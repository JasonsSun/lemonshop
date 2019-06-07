package com.jsonshop.lemonshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class bkuserLogin implements Serializable {
    @Id
    @GeneratedValue
    private Integer adminId;
    @Column(unique =true)
    private String adminName;//帐号

    private String adminPassword;

    private String adminSalt;//加密密码的盐

    private String adminType;

    private Integer adminIsvalid;

    private Date adminCreatetime;

    private Date adminUpdatetime;

    private Date adminDeletetime;

    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "bkUserRole", joinColumns = { @JoinColumn(name = "adminId") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<bkRole> roleList;// 一个用户具有多个角色

    public List<bkRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<bkRole> roleList) {
        this.roleList = roleList;
    }

    private static final long serialVersionUID = 1L;

    public bkuserLogin(Integer adminId, String adminName, String adminPassword, String adminSalt, String adminType, Integer adminIsvalid, Date adminCreatetime, Date adminUpdatetime, Date adminDeletetime) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminSalt = adminSalt;
        this.adminType = adminType;
        this.adminIsvalid = adminIsvalid;
        this.adminCreatetime = adminCreatetime;
        this.adminUpdatetime = adminUpdatetime;
        this.adminDeletetime = adminDeletetime;
    }

    public bkuserLogin() {
        super();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminSalt() {
        return adminSalt;
    }

    public void setAdminSalt(String adminSalt) {
        this.adminSalt = adminSalt == null ? null : adminSalt.trim();
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType == null ? null : adminType.trim();
    }

    public Integer getAdminIsvalid() {
        return adminIsvalid;
    }

    public void setAdminIsvalid(Integer adminIsvalid) {
        this.adminIsvalid = adminIsvalid;
    }

    public Date getAdminCreatetime() {
        return adminCreatetime;
    }

    public void setAdminCreatetime(Date adminCreatetime) {
        this.adminCreatetime = adminCreatetime;
    }

    public Date getAdminUpdatetime() {
        return adminUpdatetime;
    }

    public void setAdminUpdatetime(Date adminUpdatetime) {
        this.adminUpdatetime = adminUpdatetime;
    }

    public Date getAdminDeletetime() {
        return adminDeletetime;
    }

    public void setAdminDeletetime(Date adminDeletetime) {
        this.adminDeletetime = adminDeletetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", adminName=").append(adminName);
        sb.append(", adminPassword=").append(adminPassword);
        sb.append(", adminSalt=").append(adminSalt);
        sb.append(", adminType=").append(adminType);
        sb.append(", adminIsvalid=").append(adminIsvalid);
        sb.append(", adminCreatetime=").append(adminCreatetime);
        sb.append(", adminUpdatetime=").append(adminUpdatetime);
        sb.append(", adminDeletetime=").append(adminDeletetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}