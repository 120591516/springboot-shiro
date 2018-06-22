package com.wangwt.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by admin on 2018/6/20.
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     *
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro的内置过滤器
        /**
         * shiro 内置过滤器，可以实现权限相关的拦截器
         *  常用的过滤器
         *      anon：无需登录（认证）可以访问
         *      authc：必须认证才可以访问
         *      user：如果使用了rememberMe的功能可以直接访问
         *      perms：必须授权才可以访问
         *      role：该资源必须得到角色权限才可以
         */
        Map<String,String> filter = new LinkedHashMap<>();
        //设置不需要验证的页面
        filter.put("/login","anon");
        filter.put("/login","anon");
        filter.put("/thymeleaf","anon");
        //设置需要验证的页面
        filter.put("/user/**","authc");
        //设置登录页
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filter);
        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public  DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return  new UserRealm();
    }
}
