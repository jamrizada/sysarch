package com.rizada.sysarch.config;

import com.rizada.sysarch.model.Bangka;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new io.swagger.v3.oas.models.Components()
                        .addSchemas("Bangka", new Schema<Bangka>()
                                .addProperty("bangkaName", new Schema<String>().example("Example Bangka"))
                                .addProperty("totalPrices", new Schema<Double>().example(123.45)))
                        .addRequestBodies("BangkaRequest", new RequestBody()
                                .content(new Content().addMediaType("application/json",
                                        new MediaType().schema(new Schema<Bangka>()
                                                .addProperty("bangkaName", new Schema<String>().example("Example Bangka"))
                                                .addProperty("totalPrices", new Schema<Double>().example(123.45)))))))
                .info(new Info()
                        .title("Sysarch API")
                        .version("1.0")
                        .description("Demo project for Spring Boot"));
    }
}
