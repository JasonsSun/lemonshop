package com.jsonshop.lemonshop.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class bkRole implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer roleId;// 编号

    private String roleName;// 角色标识程序中判断使用,如"admin",这个是唯一的:

//    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户

    private Integer roleStatus;

    private String roleDescription;// 角色描述,UI界面显示使用

    private Integer roleType;

    private Date roleCreattime;

    private Date roleUpdatetime;

    private Date roleDeletetime;

    //角色 -- 权限关系：多对多关系;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bkPermission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<bkPermission> permissions;

    // 用户 - 角色关系定义;
    @ManyToMany
    @JoinTable(name = "bkUserRole", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "adminId")})
    private List<bkUserRole> userInfos;// 一个角色对应多个用户


    private static final long serialVersionUID = 1L;

    public List<bkPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<bkPermission> permissions) {
        this.permissions = permissions;
    }

    public List<bkUserRole> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<bkUserRole> userInfos) {
        this.userInfos = userInfos;
    }

    public bkRole(Integer roleId, String roleName, Integer roleStatus, String roleDescription, Integer roleType, Date roleCreattime, Date roleUpdatetime, Date roleDeletetime) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleStatus = roleStatus;
        this.roleDescription = roleDescription;
        this.roleType = roleType;
        this.roleCreattime = roleCreattime;
        this.roleUpdatetime = roleUpdatetime;
        this.roleDeletetime = roleDeletetime;
    }

    public bkRole() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription == null ? null : roleDescription.trim();
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Date getRoleCreattime() {
        return roleCreattime;
    }

    public void setRoleCreattime(Date roleCreattime) {
        this.roleCreattime = roleCreattime;
    }

    public Date getRoleUpdatetime() {
        return roleUpdatetime;
    }

    public void setRoleUpdatetime(Date roleUpdatetime) {
        this.roleUpdatetime = roleUpdatetime;
    }

    public Date getRoleDeletetime() {
        return roleDeletetime;
    }

    public void setRoleDeletetime(Date roleDeletetime) {
        this.roleDeletetime = roleDeletetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleStatus=").append(roleStatus);
        sb.append(", roleDescription=").append(roleDescription);
        sb.append(", roleType=").append(roleType);
        sb.append(", roleCreattime=").append(roleCreattime);
        sb.append(", roleUpdatetime=").append(roleUpdatetime);
        sb.append(", roleDeletetime=").append(roleDeletetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}