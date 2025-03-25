package com.example.focustime.home.presentation.home.view.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.focustime.R
import com.example.focustime.core.presentation.components.atom.autoresizedtext.AutoResizedText
import com.example.focustime.core.presentation.components.atom.borderedicon.BorderedIcon
import com.example.focustime.core.presentation.theme.FocusTimeTheme

@Composable
fun TimerSession(
    modifier: Modifier = Modifier,
    timer: String,
    onIncreasedTap: () -> Unit = {},
    onDecreasedTap: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderedIcon(iconId = R.drawable.ic_minus, onTap = onDecreasedTap)
            Spacer(modifier = Modifier.height(FocusTimeTheme.dimensions.spacerMedium))
        }
        AutoResizedText(
            timer,
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .align(Alignment.CenterVertically),
            textStyle = MaterialTheme.typography.displayLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        )
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderedIcon(iconId = R.drawable.ic_plus, onTap = onIncreasedTap)
            Spacer(modifier = Modifier.height(FocusTimeTheme.dimensions.spacerMedium))
        }
    }
}