package com.jsonshop.lemonshop.Mapper;

import com.jsonshop.lemonshop.entity.bkUserRole;
import java.util.List;

public interface bkUserRoleMapper {
    int deleteByPrimaryKey(Integer adminRoleId);

    int insert(bkUserRole record);

    bkUserRole selectByPrimaryKey(Integer adminRoleId);

    List<bkUserRole> selectAll();

    int updateByPrimaryKey(bkUserRole record);
}