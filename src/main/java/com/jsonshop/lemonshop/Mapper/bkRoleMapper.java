package com.jsonshop.lemonshop.Mapper;

import com.jsonshop.lemonshop.entity.bkRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value = "bkRoleMapper")
public interface bkRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(bkRole record);

    bkRole selectByPrimaryKey(Integer roleId);

    List<bkRole> selectAll();

    int updateByPrimaryKey(bkRole record);
}