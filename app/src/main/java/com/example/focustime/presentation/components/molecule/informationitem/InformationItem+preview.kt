package com.example.focustime.presentation.components.molecule.informationitem

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustime.presentation.components.atom.autoresizedtext.AutoResizedText
import com.example.focustime.presentation.theme.FocusTimeTheme

@Preview(
    name = "InformationItemPreview",
    showBackground = true
)

@Composable
fun InformationItemPreview() {
    FocusTimeTheme {
        InformationItem(text = "text", label = "label")
    }
}