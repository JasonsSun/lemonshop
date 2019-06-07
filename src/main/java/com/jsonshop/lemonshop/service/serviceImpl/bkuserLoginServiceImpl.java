package com.jsonshop.lemonshop.service.serviceImpl;

import com.jsonshop.lemonshop.Mapper.bkuserLoginMapper;
import com.jsonshop.lemonshop.entity.bkuserLogin;
import com.jsonshop.lemonshop.service.bkuserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 16591
 * @title: bkuserLoginServiceImpl
 * @projectName lemonshop
 * @description: TODO
 * @date 2019/6/8   3:36
 */
@Service("userService")
public class bkuserLoginServiceImpl implements bkuserLoginService {

    @Autowired
    private bkuserLoginMapper bkuserLoginMapper;

    @Override
    public bkuserLogin findByUsername(String username) {
        return bkuserLoginMapper.findByUsername(username);
    }
    @Override
    public bkuserLogin getUserByUsername(String username) {
        return bkuserLoginMapper.getUserByUsername(username);
    }
}
