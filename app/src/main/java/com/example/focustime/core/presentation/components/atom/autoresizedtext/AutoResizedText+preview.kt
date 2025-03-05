package com.example.focustime.core.presentation.components.atom.autoresizedtext

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustime.core.presentation.theme.FocusTimeTheme

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