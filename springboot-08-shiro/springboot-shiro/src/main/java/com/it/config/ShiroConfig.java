package com.it.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean :3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器
        /*
                - anon： 无需认证就可以访问
                - authc： 必须认证了才能访问
                - user： 必须拥有记住我功能才能用
                - perms： 拥有对某个资源的权限才能访问
                - role： 拥有某个角色权限
         */
        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();

        /*filterChainDefinitionMap.put("/user/add", "authc");
        filterChainDefinitionMap.put("/user/update", "authc");*/

        //授权,正常情况下，没有授权会跳到未授权页面
        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/update", "perms[user:update]");

        //设置进入此页面必须认证（登录）了才能访问
        filterMap.put("/user/*", "authc");

        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    //DefaultWebSecurityManager :2
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建 realm  对象，需要自定义类 :1
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    ////    配置ShiroDialect:用于thymeleaf和shiro标签配合使用
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
