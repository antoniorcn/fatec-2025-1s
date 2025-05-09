package edu.curso.agendacontato.security

import edu.curso.agendacontato.service.UsuarioService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig() {

    @Bean
    fun encoder () : PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity) : SecurityFilterChain {
        http
            .csrf { crsf ->
                crsf.disable()
            }
            .authorizeHttpRequests{ authorize ->
                authorize.requestMatchers("/").permitAll()
                authorize.requestMatchers("/usuario/**").permitAll()
                authorize.requestMatchers("/swagger-ui/*").permitAll()
                authorize.requestMatchers("/swagger-ui/**").permitAll()
                authorize.anyRequest().authenticated()
            }
            .httpBasic {}
        return http.build()
    }

//    @Bean
//    fun authenticationProvider() : AuthenticationProvider {
//        val authProvider = DaoAuthenticationProvider()
//        // authProvider.setUserDetailsService(usuarioService)
//        authProvider.setPasswordEncoder( encoder() )
//        return authProvider
//    }
}