package br.gov.pr.toledo.api.application.configs

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfigs {

    @Bean
    fun openApi() = OpenAPI().info(
        Info()
            .title("Banco-Licenças - API")
            .description("API para controle de licenças de software")
            .version("1.0.0")
    ).externalDocs(
        ExternalDocumentation()
            .description("Projeto Github")
            .url("https://github.com/jaderha/banco-licenca")
    )
}