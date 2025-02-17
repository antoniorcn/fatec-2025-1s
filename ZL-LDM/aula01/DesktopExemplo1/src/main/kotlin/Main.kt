package org.example

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane

class Principal() : Application() {

    override fun start(stage : Stage) {

        val bp = BorderPane()
        val text = Label("Ola Mundo react Native")
        bp.setCenter(text)

        val scn = Scene( bp, 600.0, 400.0)
        stage.scene = scn
        stage.title = "Meu primeiro App Desktop"
        stage.show()
    }
}

fun main() {
    Application.launch(Principal::class.java)
}