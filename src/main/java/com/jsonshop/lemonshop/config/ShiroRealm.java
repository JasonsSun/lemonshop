//package com.jsonshop.lemonshop.config;
//
//import com.jsonshop.lemonshop.entity.bkuserLogin;
//import com.jsonshop.lemonshop.service.bkuserLoginService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.util.ByteSource;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//
///**
// * @author 16591
// * @title: ShiroRealm
// * @projectName lemonshop
// * @description: TODO
// * @date 2019/6/8   1:45
// */
//public class ShiroRealm extends AuthorizingRealm {
//
//    private static final Logger log = LoggerFactory.getLogger(AuthorizingRealm.class);
//
//    @Autowired
//    @Lazy // 这里lazy 是有必要的, shiro组件会预先加载，导致依赖的bean 没有生成代理对象（AOP失效）
//    private bkuserLoginService bkuserLoginService;
//
//    /**
//     * 认证
//     *
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        String username = (String) authenticationToken.getPrincipal();
//
//        if (log.isDebugEnabled()) {
//            log.debug(String.format("user:%s executing doGetAuthenticationInfo", username));
//        }
//
//        bkuserLogin user = bkuserLoginService.getUserByUsername(username);
//
//        if (user == null) {
//            throw new UnknownAccountException();
//        }
//
//        if (Constant.IS_LOCK.equals(user.getIsLock())) {
//            throw new LockedAccountException();
//        }
//
//        // ShiroUser 作为实际的 principal
//        ShiroUser shiroUser = new ShiroUser();
//        BeanUtils.copyProperties(user, shiroUser);
//
//        // SimpleAuthenticationInfo(Object principal, Object credentials, String realmName)
//        // principal 会被封装到 subject 中
//        // shiro 默认会把我们的 credentials (也就是password) 和 token 中的作对比，所以我们可以不用做密码校验
//
//
////        ByteSource salt = ByteSource.Util.bytes(user.getAdminName());
//        ByteSource salt = ByteSource.Util.bytes("管理员");
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(shiroUser, user.getAdminPassword(), salt, getName());
//
//        if (log.isDebugEnabled()) {
//            log.debug(String.format("user:%s executed doGetAuthenticationInfo", username));
//        }
//
//        return info;
//    }
//
//    /**
//     * 授权
//     *
//     * @param principalCollection
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        ShiroUser shiroUser = (ShiroUser) principalCollection.getPrimaryPrincipal();
//
//        if (log.isDebugEnabled()) {
//            log.debug(String.format("user:%s executing doGetAuthorizationInfo", shiroUser.getUsername()));
//        }
//
//        AuthorizationDTO authorizationDTO = userService.getRolesAndPermissions(shiroUser.getId());
//
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addRoles(authorizationDTO.getRoleCodeSet());
//        info.addStringPermissions(authorizationDTO.getPermissionCodeSet());
//
//        if (log.isDebugEnabled()) {
//            log.debug(String.format("user:%s executed doGetAuthorizationInfo", shiroUser.getUsername()));
//        }
//
//        return info;
//    }
//
//}