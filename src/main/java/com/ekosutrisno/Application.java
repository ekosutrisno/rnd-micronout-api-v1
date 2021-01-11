package com.ekosutrisno;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
        info = @Info(
                title = "API V2",
                version = "0.0",
                description = "My API RnD",
                license = @License(name = "Apache 2.0", url = "https://foo.bar"),
                contact = @Contact(url = "", name = "Eko Sutrisno", email = "ekosutrisno801@gmail.com")
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
