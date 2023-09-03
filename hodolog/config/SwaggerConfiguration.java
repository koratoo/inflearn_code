자바 스웨거 환경설정
package com.hodolog.api.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfiguration {

    private final String version = "v1";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Example API")
                .description("Swagger 소개를 위한 example")
                .build();
    }

    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(version)
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hodolog.api"))
                .paths(PathSelectors.any())
                .build();
    }
}



---------------------------------------------------------------------------
그레이들 의존설 설정
	// Swagger2 gradle
	implementation (group: 'io.springfox', name: 'springfox-swagger2', version: '2.9.2'){
		exclude module: 'swagger-annotations' exclude module: 'swagger-models'
	}
	implementation "io.swagger:swagger-annotations:1.5.21"
	implementation "io.swagger:swagger-models:1.5.21"
	implementation group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.9.2'

---------------------------------------------------------------------------
컴파일 설정
[compileJava, compileTestJava]*.options*.encoding = "UTF-8"
---------------------------------------------------------------------------
application.yaml 설정
    
 spring:
    mvc:
      pathmatch:
        matching-strategy: ant_path_matcher
  
