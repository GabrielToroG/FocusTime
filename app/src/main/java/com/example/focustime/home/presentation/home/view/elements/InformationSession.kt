package com.example.focustime.home.presentation.home.view.elements

import android.net.wifi.ScanResult.InformationElement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.focustime.core.presentation.components.molecule.informationitem.InformationItem

@Composable
fun InformationElement(
    modifier: Modifier = Modifier,
    round: String,
    time: String
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            InformationItem(
                modifier = modifier.fillMaxWidth().weight(1f),
                text = round,
                label = "rounds"
            )
            Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
            InformationItem(
                modifier = modifier.fillMaxWidth().weight(1f),
                text = time,
                label = "time"
            )
        }
    }
}