package com.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration //配置类
@EnableSwagger2 // 开启Swagger2的自动配置
public class SwaggerConfig {

    //配置了 Swagger 的 Docket 的 Bean 实例 配置多个分组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }

    @Bean
    public Docket docket(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(of);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("小豪")
                .enable(b) //配置是否启用Swagger，如果是false，在浏览器将无法访问
                .select()
//                basePackage(final String basePackage) // 根据包路径扫描接口
//                any() // 扫描所有，项目中的所有接口都会被扫描到
//                none() // 不扫描接口
//                      // 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
//                withMethodAnnotation(final Class<? extends Annotation> annotation)
//                      // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
//                withClassAnnotation(final Class<? extends Annotation> annotation)
                .apis(RequestHandlerSelectors.basePackage("com.it.controller"))
                //paths()过滤路径
//                .paths(PathSelectors.ant("/xx/xx"))
                .build();
    }

    //配置Swagger信息=apiInFo
    private ApiInfo apiInfo() {

        //作者信息
        Contact contact = new Contact("admin", "https://localhost:8080", "55555555@qq.com");

        return new ApiInfo("Api Documentation",
                "Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}
