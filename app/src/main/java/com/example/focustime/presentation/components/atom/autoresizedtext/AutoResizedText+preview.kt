package com.example.focustime.presentation.components.atom.autoresizedtext

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustime.presentation.theme.FocusTimeTheme

@Preview(
    name = "AutoResizedTextPreview",
    showBackground = true
)

@Composable
fun AutoResizedTextPreview() {
    FocusTimeTheme {
        AutoResizedText("Focus Timer")
    }
}