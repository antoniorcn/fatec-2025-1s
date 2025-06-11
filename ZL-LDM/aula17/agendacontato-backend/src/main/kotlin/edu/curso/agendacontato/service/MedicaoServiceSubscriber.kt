package edu.curso.agendacontato.service

import edu.curso.agendacontato.model.Medicao
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import edu.curso.agendacontato.repository.MedicaoRepository
import jakarta.annotation.PostConstruct
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MedicaoServiceSubscriber (
    private val repository : MedicaoRepository
) {
    private val client = MqttClient("tcp://localhost:1894",
    //    "Backend-Client"
        MqttClient.generateClientId(),
        MemoryPersistence()
    )

    @PostConstruct
    fun init() {
        client.connect()

        client.subscribe("sensor/dht11") {
            _: String?, mensagem: MqttMessage? ->
                logger.info("Mensagem recebida pelo MQTT: $mensagem")
                if (mensagem != null) {
                    val carga: String = String(mensagem.payload)
                    // carga = {"temp": 13.5, "umd": 40.3}
                    val json = Json.decodeFromString<JsonObject>(carga)
                    val temperatura = json.get("temp")?.toString()?.toDoubleOrNull()
                    val umidade = json.get("umd")?.toString()?.toDoubleOrNull()
                    if (temperatura != null && umidade != null) {
                        val medicao = Medicao(id = null,
                            temperatura = temperatura,
                            umidade = umidade)
                        logger.info("Medicao lida: $medicao")
                        repository.save(medicao)
                    }
                }
        }
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(MedicaoServiceSubscriber::class.java)
    }
}