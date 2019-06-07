package com.jsonshop.lemonshop.Mapper;

import com.jsonshop.lemonshop.entity.bkPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value = "bkPermissionMapper")
public interface bkPermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(bkPermission record);

    bkPermission selectByPrimaryKey(Integer permissionId);

    List<bkPermission> selectAll();

    int updateByPrimaryKey(bkPermission record);
}