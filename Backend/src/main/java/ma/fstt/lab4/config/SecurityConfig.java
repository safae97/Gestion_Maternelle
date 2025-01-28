//package ma.fstt.lab4.config;
//
//import ma.fstt.lab4.metier.EnseignantMetier;
//import ma.fstt.lab4.security.EnseignantUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private EnseignantMetier teacherService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors()  // Enable CORS support
//                .and()
//                .authorizeHttpRequests()  // Use the new method to authorize HTTP requests
//                .requestMatchers("/api/teachers/login", "/api/teachers/register").permitAll()  // Allow login and register without authentication
//                .anyRequest().authenticated()  // Require authentication for other requests
//                .and()
//                .formLogin().permitAll()  // Allow form login
//                .and()
//                .httpBasic();  // Enable basic HTTP authentication
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> teacherService.findByUsername(username)
//                .map(EnseignantUserDetails::new) // Wrap Enseignant into UserDetails
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
