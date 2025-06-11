package edu.curso.agendacontato

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    @GetMapping()
    @ResponseBody
    fun hello() : String {
        return """
            <html><body>
                <h1>Agenda contato</h1>
                <h2>Laboratório de Desenvolvimento Multiplataforma</h2>
                <h3>Esta aplicação deve ser acessada no recurso /contato como API Rest</h3>
            </body></html>
        """.trimMargin()
    }
}