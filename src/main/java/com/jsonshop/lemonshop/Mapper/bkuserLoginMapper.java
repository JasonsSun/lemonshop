package com.jsonshop.lemonshop.Mapper;

import com.jsonshop.lemonshop.entity.bkuserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value = "bkuserLoginMapper")
public interface bkuserLoginMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(bkuserLogin record);

    bkuserLogin selectByPrimaryKey(Integer adminId);

    bkuserLogin findByUsername(String username);

    bkuserLogin getUserByUsername(String username);

    List<bkuserLogin> selectAll();

    int updateByPrimaryKey(bkuserLogin record);
}