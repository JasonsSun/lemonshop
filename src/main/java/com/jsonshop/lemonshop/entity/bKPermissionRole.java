package com.jsonshop.lemonshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class bKPermissionRole implements Serializable {
    @Id
    @GeneratedValue
    private Integer permissionRoleId;

    private Integer permissionId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public bKPermissionRole(Integer permissionRoleId, Integer permissionId, Integer roleId) {
        this.permissionRoleId = permissionRoleId;
        this.permissionId = permissionId;
        this.roleId = roleId;
    }

    public bKPermissionRole() {
        super();
    }

    public Integer getPermissionRoleId() {
        return permissionRoleId;
    }

    public void setPermissionRoleId(Integer permissionRoleId) {
        this.permissionRoleId = permissionRoleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", permissionRoleId=").append(permissionRoleId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}