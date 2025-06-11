package edu.curso.agendacontato.security
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class ConfiguracaoSeguranca {

    @Bean
    fun getPasswordEncoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        logger.info("###### SecurityConfig carregada corretamente ######")
        http.authorizeHttpRequests {  auth ->
            auth.requestMatchers("/usuario/**").permitAll()
            auth.anyRequest().authenticated()
        }
        http.httpBasic { }
        http.csrf { it.disable() }
        http.sessionManagement { it.disable() }
        http.logout { it.disable() }
        return http.build()
    }
    companion object {
        private val logger: Logger = LoggerFactory.getLogger(ConfiguracaoSeguranca::class.java)
    }
}