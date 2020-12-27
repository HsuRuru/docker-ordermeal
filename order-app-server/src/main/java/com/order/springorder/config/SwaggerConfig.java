package com.order.springorder.config;

import com.google.common.base.Predicate;

import io.swagger.models.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 提供 API 相關的資訊，不想設定可以跳過這個 apiInfo call
                .select()
                // 設定 base package，只有在這個 package 底下的 REST API 才會加入 Swagger 中
                // 如果不想指定，也可以用 RequestHandlerSelectors.any() 代表所有的 REST API
                .apis(RequestHandlerSelectors.basePackage("com.order.springorder.controller"))
                .paths(PathSelectors.any())
                .build();
    }


}