package com.seohyuni.returneverytimeserver.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  private static final String INFO_TITLE = "Return Everytime";
  private static final String INFO_VERSION = "0.0.1";
  private static final String INFO_DESCRIPTION = "Return Everytime API Docs";

  @Bean
  public Docket restApi() {

    Docket docket = new Docket(DocumentationType.SWAGGER_2);

    docket.apiInfo(getApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.seohyuni.returneverytimeserver.controller"))
        .paths(PathSelectors.ant("/api/**"))
        .build();

    int tagOrd = 0;
    docket.tags(
        new Tag("Test", "테스트 API", ++tagOrd),
        new Tag("User", "사용자 API", ++tagOrd)

    );

    return docket;
  }

  private ApiInfo getApiInfo(){
    return new ApiInfoBuilder()
        .title(INFO_TITLE)
        .version(INFO_VERSION)
        .description(INFO_DESCRIPTION)
        .build();
  }

  @Bean
  public UiConfiguration uiConfiguration(){
    return UiConfigurationBuilder.builder()
        .defaultModelRendering(ModelRendering.MODEL)
        .docExpansion(DocExpansion.LIST)// 펼쳐보기
        .build();
  }

}
