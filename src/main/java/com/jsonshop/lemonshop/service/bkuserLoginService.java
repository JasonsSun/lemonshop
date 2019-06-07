package com.jsonshop.lemonshop.service;

import com.jsonshop.lemonshop.entity.bkuserLogin;

/**
 * @author 16591
 * @title: bkuserLoginService
 * @projectName lemonshop
 * @description: TODO
 * @date 2019/6/8   3:32
 */

public interface bkuserLoginService {

    bkuserLogin findByUsername(String username);

    bkuserLogin getUserByUsername(String username);


}
