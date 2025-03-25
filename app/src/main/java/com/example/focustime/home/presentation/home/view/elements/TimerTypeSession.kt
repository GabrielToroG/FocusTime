package com.example.focustime.home.presentation.home.view.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.focustime.core.presentation.components.atom.timertypeitem.TimerTypeItem
import com.example.focustime.core.presentation.theme.FocusTimeTheme

@Composable
fun TimerTypeSession(
    modifier: Modifier = Modifier,
    onTap: () -> Unit = {}
) {
    val gridCount = 3
    val itemSpacing = Arrangement.spacedBy(FocusTimeTheme.dimensions.paddingNormal)
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .height(FocusTimeTheme.dimensions.spacerLarge),
        columns = GridCells.Fixed(gridCount),
        horizontalArrangement = itemSpacing,
        verticalArrangement = itemSpacing
    ) {
        item(key = "FT") {
            TimerTypeItem(
                text = "Focus Timer",
                textColor = MaterialTheme.colorScheme.primary
            )
        }

        item(key = "SB") {
            TimerTypeItem(
                text = "Short Break",
                textColor = MaterialTheme.colorScheme.secondary
            )
        }

        item(key = "LB") {
            TimerTypeItem(
                text = "Long Break",
                textColor = MaterialTheme.colorScheme.secondary
            )
        }
    }
}