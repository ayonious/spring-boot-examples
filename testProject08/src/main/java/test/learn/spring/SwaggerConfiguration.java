package test.learn.spring;

import com.google.common.collect.ImmutableList;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@PropertySource({"classpath:swagger.properties"})
@ConditionalOnResource(resources = {"classpath:swagger.properties"})
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .apiInfo(new ApiInfo(
                        "NK API",
                        "NK test project, trying to test swagger for the first time",
                        "/v1",
                        null,
                        new Contact("Ayon", "https://github.com/ayonious", "jaissatai6@gmail.com"),
                        null,
                        null));
    }
}
