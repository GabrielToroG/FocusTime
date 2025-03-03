package com.example.focustime.presentation.components.atom.autoresizedtext

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AutoResizedText(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.displayLarge
) {
    var timeTextStyle by remember { mutableStateOf(textStyle) }
    val fontSizeFactor = 0.95
    Text(
        text,
        modifier = modifier.fillMaxWidth(),
        softWrap = false,
        style = timeTextStyle,
        onTextLayout = { result ->
            if (result.didOverflowWidth) {
                // Copia lo anterior y le cambia sola una propiedad
                timeTextStyle = timeTextStyle.copy(
                    fontSize = timeTextStyle.fontSize * fontSizeFactor
                )
            }
        } // funcion cuando se calcula el tamaño del texto
    )
}