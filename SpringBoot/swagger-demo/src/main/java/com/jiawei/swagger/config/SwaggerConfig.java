package com.jiawei.swagger.config;

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


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Swagger",
                "Swagger Document",
                "v1.0",
                "https://www.google.com/",
                "jiawei",
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");

    }
    /*配置了swagger的bean实例*/
    @Bean
    public Docket docket(Environment environment){
        Profiles profiles = Profiles.of("dev","test");

        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jiawei.swagger.controller"))
                .build();
    }

}
