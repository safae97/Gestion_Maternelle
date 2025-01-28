//package ma.fstt.lab4.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // Allow all endpoints
//                .allowedOrigins("http://localhost:4200") // Angular app origin
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed methods
//                .allowedHeaders("*") // Allow all headers
//                .allowCredentials(true) // Allow cookies (if needed)
//                .exposedHeaders("Authorization"); // Expose the Authorization header
//    }
//}
