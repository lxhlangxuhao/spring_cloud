package com.lang.xu.hao.eurekaserver.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: LangXuhao
 * @Date: 2020/1/7 17:26
 * @Description: swagger 分组显示接口
 */
@Configuration
@EnableSwagger2
//@EnableSwaggerBootstrapUI
//@ComponentScan(basePackages = {"cn.pop.controller"})
public class SwaggerConfig {

//    @Value("${swagger.enable}")
//    private String enableSwagger;

    @Bean
    public Docket h5Docket() {

        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
//                .enable("true".equals(enableSwagger))
//                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .forCodeGeneration(true).select()
                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("cn.steam.controller.h5"))  // 根据包名分组
                .paths(PathSelectors.ant("/hi/**"))  // 根据请求路径分组
                .build().groupName("H5").pathMapping("/");
    }

    @Bean
    public Docket apiDocket() {

        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
//                .enable("true".equals(enableSwagger))
//                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .forCodeGeneration(true).select()
//                .apis(RequestHandlerSelectors.basePackage("cn.steam.controller"))  // 根据包名分组
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/hi/**"))  // 根据请求路径分组
                .build().groupName("API").pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("eureka服务端")
                .description("lang")
                .termsOfServiceUrl("http://www.lang.cn")
                .version("1.0")
                .build();
    }

}
