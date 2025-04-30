import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig {

    @Bean
    fun getPasswordEncoder() : PasswordEncoder { 
        return BCryptPasswordEncoder()
    }


    @Bean
    fun userDetailsService() : UserDetailsService { 
        val joao : UserDetails = User
            .builder()
            .username("joao")
            .password(getPasswordEncoder().encode("1234"))
            .roles("USER","STUDENT")
            .build()

        val maria : UserDetails = User
            .builder()
            .username("maria")
            .password(getPasswordEncoder().encode("123456"))
            .roles("TEACHER", "MANAGER")
            .build()

        return InMemoryUserDetailsManager( joao, maria )
    }

    @Bean
    fun securityFilterChain(http : HttpSecurity) : SecurityFilterChain { 
        http
        .authorizeHttpRequests { authorize ->
            authorize
            .anyRequest()
            .authenticated()
        }
        .httpBasic {}
        return http.build()
    }

}