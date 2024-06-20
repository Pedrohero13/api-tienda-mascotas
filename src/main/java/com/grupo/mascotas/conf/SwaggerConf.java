/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo.mascotas.conf;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author SI-PEDRO-HERNANDEZ
 */
public class SwaggerConf {
    private String prodUrl="https://pruebados-xnykyxl5ca-uc.a.run.app/";
    @Bean
    public OpenAPI myOpenAPI() {

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Info info = new Info()
                .title("Integration Qualitas API")
                .version("1.0")
                .description("This API exposes endpoints to Integration of qualitas.");

        List<Server> servidores = new ArrayList<>();
        servidores.add(prodServer);
        return new OpenAPI().info(info).servers(servidores);
    }

}
