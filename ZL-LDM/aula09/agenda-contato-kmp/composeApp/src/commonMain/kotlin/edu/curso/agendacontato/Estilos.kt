package edu.curso.agendacontato

import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background

val estiloPrincipal = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Cyan)

val estiloFormulario = Modifier.fillMaxHeight(0.4f)
            .fillMaxWidth()