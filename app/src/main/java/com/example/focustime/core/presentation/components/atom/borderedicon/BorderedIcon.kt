package com.example.focustime.core.presentation.components.atom.borderedicon

import androidx.compose.material3.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.focustime.core.presentation.theme.FocusTimeTheme

@Composable
fun BorderedIcon(
    @DrawableRes iconId: Int,
    modifier: Modifier = Modifier,
    onTap: () -> Unit = {}
) {
    Icon(
        modifier = modifier
            .size(FocusTimeTheme.dimensions.iconSizeNormal)
            .border(
                width = FocusTimeTheme.dimensions.borderNormal,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
            .padding(FocusTimeTheme.dimensions.paddingSmall)
            .clickable { onTap() },
        imageVector = ImageVector.vectorResource(id = iconId),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary
    )
}