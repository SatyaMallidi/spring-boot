 package Security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
    
//     @Bean
//     public InMemoryUserDetailsManager configureInMemoryUsers(){

//         UserDetails user1 =User.builder().username("User1").password("User1").roles("ADMIN").build();
//         UserDetails user2 =User.builder().username("User2").password("User2").roles("MANAGER").build();
//         UserDetails user3 =User.builder().username("User3").password("User3").roles("EMPLOYEE").build();


//         InMemoryUserDetailsManager inMemoryUserDetails = new InMemoryUserDetailsManager(user1,user2,user3);

//         return inMemoryUserDetails;
//     }
    
// }


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()).httpBasic();
           // Correctly apply default settings without explicitly calling withDefaults()
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        User.UserBuilder users = User.builder().passwordEncoder(passwordEncoder::encode);
        UserDetails user = users
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = users
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override
    public String toString() {
        return "SecurityConfig []";
    }
}

