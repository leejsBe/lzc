package kr.co.lzc.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI APIConfig() {

    Contact contact = new Contact();

    Info info = new Info()
      .title("ㅋㄷㄹㅅㅌㄷㅇ")
      .version("1.0")
      .contact(contact)
      .description("")
      .license(new License().name("Terms of service").url(""));

    return new OpenAPI()
      .info(info);
  }


  @Bean
  public GroupedOpenApi allApi() {
    return GroupedOpenApi.builder()
      .group("All")
      .pathsToExclude("/test/**")
      .build();
  }


  @Bean
  public GroupedOpenApi backOfficeApi() {
    return GroupedOpenApi.builder()
      .group("back-office")
      .pathsToMatch("/kidari/back-office/**")
      .build();
  }

  @Bean
  public GroupedOpenApi frontApi() {
    return GroupedOpenApi.builder()
      .group("front")
      .pathsToExclude("/kidari/back-office/**")
      .build();
  }

}
