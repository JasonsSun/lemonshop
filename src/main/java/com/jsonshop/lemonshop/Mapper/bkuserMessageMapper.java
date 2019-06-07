package com.jsonshop.lemonshop.Mapper;

import com.jsonshop.lemonshop.entity.bkuserMessage;
import java.util.List;

public interface bkuserMessageMapper {
    int deleteByPrimaryKey(Integer adminMes);

    int insert(bkuserMessage record);

    bkuserMessage selectByPrimaryKey(Integer adminMes);

    List<bkuserMessage> selectAll();

    int updateByPrimaryKey(bkuserMessage record);
}