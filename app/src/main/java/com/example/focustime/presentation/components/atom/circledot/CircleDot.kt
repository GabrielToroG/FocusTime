package com.example.focustime.presentation.components.atom.circledot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.focustime.presentation.theme.FocusTimeTheme

@Composable
fun CircleDot(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Box(
        modifier = modifier
            .size(FocusTimeTheme.dimensions.iconSizeSmall)
            .clip(shape = CircleShape) //Forma que va a tener
            .background(color)
    )
}