package com.jsonshop.lemonshop.Mapper;

import com.jsonshop.lemonshop.entity.bKPermissionRole;
import java.util.List;

public interface bKPermissionRoleMapper {
    int deleteByPrimaryKey(Integer permissionRoleId);

    int insert(bKPermissionRole record);

    bKPermissionRole selectByPrimaryKey(Integer permissionRoleId);

    List<bKPermissionRole> selectAll();

    int updateByPrimaryKey(bKPermissionRole record);
}