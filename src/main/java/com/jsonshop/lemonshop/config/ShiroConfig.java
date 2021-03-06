package com.jsonshop.lemonshop.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 16591
 * @title: ShiroConfig
 * @projectName lemonshop
 * @description: 做权限框架配置
 * @date 2019/6/8 1:38
 */

@Configuration
public class ShiroConfig {

    private static final Logger log = LoggerFactory.getLogger(ShiroConfig.class);



    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securitytyManager) {


//        =========================================
//        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//        shiroFilter.setSecurityManager(securityManager);
//
//        Map<String, String> chainDefinition = new LinkedHashMap<>();
//        // 静态资源与登录请求不拦截
//        chainDefinition.put("/js/**", "anon");
//        chainDefinition.put("/css/**", "anon");
//        chainDefinition.put("/img/**", "anon");
//        chainDefinition.put("/layui/**", "anon");
//        chainDefinition.put("/login", "anon");
//        chainDefinition.put("/login.html", "anon");
//        // 用户为授权通过认证 && 包含'admin'角色
//        chainDefinition.put("/admin/**", "authc, roles[super_admin]");
//        // 用户为授权通过认证或者RememberMe && 包含'document:read'权限
//        chainDefinition.put("/docs/**", "user, perms[document:read]");
//        // 用户访问所有请求 授权通过 || RememberMe
//        chainDefinition.put("/**", "user");
//
//        shiroFilter.setFilterChainDefinitionMap(chainDefinition);
//        // 当 用户身份失效时重定向到 loginUrl
//        shiroFilter.setLoginUrl("/login.html");
//        // 用户登录后默认重定向请求
//        shiroFilter.setSuccessUrl("/index.html");
//        return shiroFilter;
//        =================================


        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securitytyManager);
        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

//    @Bean
//    public Realm realm() {
//        ShiroRealm realm = new ShiroRealm();
//        realm.setCredentialsMatcher(credentialsMatcher());
//        realm.setCacheManager(ehCacheManager());
//        return realm;
//    }

    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

//    @Bean
//    public CacheManager ehCacheManager() {
//        EhCacheManager cacheManager = new EhCacheManager();
//        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
//        return cacheManager;
//    }

//    @Bean
//    public CredentialsMatcher credentialsMatcher() {
//        AuthCredentialsMatcher credentialsMatcher = new AuthCredentialsMatcher(ehCacheManager());
//        credentialsMatcher.setHashAlgorithmName(AuthCredentialsMatcher.HASH_ALGORITHM_NAME);
//        credentialsMatcher.setHashIterations(AuthCredentialsMatcher.HASH_ITERATIONS);
//        credentialsMatcher.setStoredCredentialsHexEncoded(true);
//        return credentialsMatcher;
//    }

//    @Bean
//    public DefaultWebSecurityManager securityManager() {
//        log.debug("--------------shiro已经加载----------------");
//        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//        manager.setCacheManager(ehCacheManager());
//        manager.setRealm(realm());
//        manager.setRememberMeManager(rememberMeManager());
//        return manager;
//    }

//    @Bean
//    public RememberMeManager rememberMeManager() {
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
//        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
//        cookieRememberMeManager.setCookie(rememberMeCookie());
//        return cookieRememberMeManager;
//    }

//    @Bean
//    public SimpleCookie rememberMeCookie(){
//        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
//        simpleCookie.setMaxAge(259200);
//        return simpleCookie;
//    }

    /**
     * Shiro生命周期处理器:
     * 用于在实现了Initializable接口的Shiro bean初始化时调用Initializable接口回调(例如:UserRealm)
     * 在实现了Destroyable接口的Shiro bean销毁时调用 Destroyable接口回调(例如:DefaultSecurityManager)
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 启用shrio授权注解拦截方式，AOP式方法级权限检查
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
                new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * thymeleaf的shiro扩展
     *
     * @return
     */
//    @Bean
//    public ShiroDialect shiroDialect() {
//        return new ShiroDialect();
//    }

//}
}
