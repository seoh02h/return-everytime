package com.seohyuni.returneverytimeserver.config.swagger;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
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

    RequestParameterBuilder parameterBuilder = new RequestParameterBuilder();
    parameterBuilder.name("Authorization")
        .query(q -> q.model(
            modelSpecificationBuilder -> modelSpecificationBuilder.scalarModel(ScalarType.STRING)))
        .in(ParameterType.HEADER);

    List<RequestParameter> parameters = new ArrayList<>();
    parameters.add(parameterBuilder.build());

    Docket docket = new Docket(DocumentationType.SWAGGER_2);

    docket.apiInfo(getApiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.seohyuni.returneverytimeserver.controller"))
        .paths(PathSelectors.ant("/api/**"))
        .build()
        .globalRequestParameters(parameters);

    int tagOrd = 0;
    docket.tags(
        new Tag("User", "사용자 API", ++tagOrd),
        new Tag("Log", "시스템로그 API", ++tagOrd),
        new Tag("Board", "게시판 API", ++tagOrd)


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
  public UiConfiguration uiConfiguration() {
    return UiConfigurationBuilder.builder()
        .defaultModelRendering(ModelRendering.MODEL)
        .docExpansion(DocExpansion.LIST)// 펼쳐보기
        .build();
  }

  @Bean
  public DefaultTypeNameProviderFixer defaultTypeNameProviderFixer() {
    return new DefaultTypeNameProviderFixer();
  }

}
