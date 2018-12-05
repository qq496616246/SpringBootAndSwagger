package com.scw.springboot.swagger.config;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @ Author     ：scw
 * @ Date       ：Created in 上午 11:44 2018/12/5 0005
 * @ Description：对于swagger的配置类，@Configuration表示是一个配置类，@EnableSwagger2表示是swagger的配置
 *                ConditionalOnProperty注解是对于是否开启了swagger的灵活配置（这个适合在开发环境中开启，而正式的时候应该关闭）
 * @ Modified By：
 * @Version: 1
 */

@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger", name = "button-open", havingValue = "true")
public class SwaggerConfig {
    /**
     * 创建获取api应用
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //这里采用包含注解的方式来确定要显示的接口(建议使用这种)
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //.apis(RequestHandlerSelectors.basePackage("com.scw.springboot.swagger.controller"))    //这里采用包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置swagger文档显示的相关内容标识(信息会显示到swagger页面)
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger使用")
                .description("本人博客地址如下：")
                .termsOfServiceUrl("https://blog.csdn.net/Cs_hnu_scw")
                .contact("hnuscw")
                .version("1.0")
                .build();
    }
}
