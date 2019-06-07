package com.jsonshop.lemonshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
public class bkPermission implements Serializable {


    @Id
    @GeneratedValue
    private Integer permissionId;

    private String permissionName;
    @Column(columnDefinition = "enum('menu','button')")
    private String permissionResourcetype;//资源类型，[menu|button]

    private String permissionUrl;//资源路径.

    private String resourcePermission;//权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    private String permissionParentid;

    private String permissionParentids;

    private Integer permissionIsvalid;

    private Date permissionCreattime;

    private Date permissionUpdatetime;

    private Date permissionDeletetime;

    @ManyToMany
    @JoinTable(name = "bkPermission", joinColumns = {@JoinColumn(name = "permissionId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<bkRole> roles;

    public List<bkRole> getRoles() {
        return roles;
    }

    public void setRoles(List<bkRole> roles) {
        this.roles = roles;
    }
    private static final long serialVersionUID = 1L;

    public bkPermission(Integer permissionId, String permissionName, String permissionResourcetype, String permissionUrl, String resourcePermission, String permissionParentid, String permissionParentids, Integer permissionIsvalid, Date permissionCreattime, Date permissionUpdatetime, Date permissionDeletetime) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.permissionResourcetype = permissionResourcetype;
        this.permissionUrl = permissionUrl;
        this.resourcePermission = resourcePermission;
        this.permissionParentid = permissionParentid;
        this.permissionParentids = permissionParentids;
        this.permissionIsvalid = permissionIsvalid;
        this.permissionCreattime = permissionCreattime;
        this.permissionUpdatetime = permissionUpdatetime;
        this.permissionDeletetime = permissionDeletetime;
    }

    public bkPermission() {
        super();
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionResourcetype() {
        return permissionResourcetype;
    }

    public void setPermissionResourcetype(String permissionResourcetype) {
        this.permissionResourcetype = permissionResourcetype == null ? null : permissionResourcetype.trim();
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
    }

    public String getResourcePermission() {
        return resourcePermission;
    }

    public void setResourcePermission(String resourcePermission) {
        this.resourcePermission = resourcePermission == null ? null : resourcePermission.trim();
    }

    public String getPermissionParentid() {
        return permissionParentid;
    }

    public void setPermissionParentid(String permissionParentid) {
        this.permissionParentid = permissionParentid == null ? null : permissionParentid.trim();
    }

    public String getPermissionParentids() {
        return permissionParentids;
    }

    public void setPermissionParentids(String permissionParentids) {
        this.permissionParentids = permissionParentids == null ? null : permissionParentids.trim();
    }

    public Integer getPermissionIsvalid() {
        return permissionIsvalid;
    }

    public void setPermissionIsvalid(Integer permissionIsvalid) {
        this.permissionIsvalid = permissionIsvalid;
    }

    public Date getPermissionCreattime() {
        return permissionCreattime;
    }

    public void setPermissionCreattime(Date permissionCreattime) {
        this.permissionCreattime = permissionCreattime;
    }

    public Date getPermissionUpdatetime() {
        return permissionUpdatetime;
    }

    public void setPermissionUpdatetime(Date permissionUpdatetime) {
        this.permissionUpdatetime = permissionUpdatetime;
    }

    public Date getPermissionDeletetime() {
        return permissionDeletetime;
    }

    public void setPermissionDeletetime(Date permissionDeletetime) {
        this.permissionDeletetime = permissionDeletetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", permissionId=").append(permissionId);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", permissionResourcetype=").append(permissionResourcetype);
        sb.append(", permissionUrl=").append(permissionUrl);
        sb.append(", resourcePermission=").append(resourcePermission);
        sb.append(", permissionParentid=").append(permissionParentid);
        sb.append(", permissionParentids=").append(permissionParentids);
        sb.append(", permissionIsvalid=").append(permissionIsvalid);
        sb.append(", permissionCreattime=").append(permissionCreattime);
        sb.append(", permissionUpdatetime=").append(permissionUpdatetime);
        sb.append(", permissionDeletetime=").append(permissionDeletetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}