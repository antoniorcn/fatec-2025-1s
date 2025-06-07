package edu.curso.agendacontato.service

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.util.JSONPObject
import edu.curso.agendacontato.repository.MedicaoRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import org.eclipse.paho.client.mqttv3.*
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import edu.curso.agendacontato.model.Medicao

@Component
class MqttAssinante(
    private val repository : MedicaoRepository
) {
    private val mqtt : MqttClient = MqttClient(
        "tcp://192.168.68.101:1894",
        MqttClient.generateClientId(),
        MemoryPersistence()
    )

    @PostConstruct
    fun init(){
        mqtt.connect()
        mqtt.subscribe("sensor/temp") { _ : String, message : MqttMessage ->
            val carga = String(message.payload)
            val mapper = jacksonObjectMapper()

            val jsonNode: JsonNode = mapper.readTree(carga)

            val temp = jsonNode.get("temp").asDouble()
            val umd = jsonNode.get("umd").asDouble()
            val medicao = Medicao(temperatura = temp, umidade = umd)
            repository.save( medicao )
        }
    }
}