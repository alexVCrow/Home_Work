package ua.crow.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import ua.crow.home.util.XMLConverter;

@SpringBootApplication
public class HomeApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HomeApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeApplication.class, args);
    }

}
