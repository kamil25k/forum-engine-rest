package pl.kamil25k.forum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kamil25k.forum.post.PostApi;
import pl.kamil25k.forum.post.PostRepository;
import pl.kamil25k.forum.post.PostService;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){

        Class[] ignoreClasses = {PostService.class, PostRepository.class, PostApi.class};
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .ignoredParameterTypes()
                .tags(new Tag("comments", "All comments operations"),
                new Tag("posts", "All posts operations"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("pl.kamil25k.forum"))
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Forum API")
                .version("1.0.0")
                .description("Simple forum app")
                .contact(new Contact("Kamil", "https://github.com/kamil25k", "kamil.kurdej25@gmail.com"))
                .build();
    }

}
