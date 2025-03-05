package com.example.focustime.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustime.R
import com.example.focustime.core.presentation.components.atom.autoresizedtext.AutoResizedText
import com.example.focustime.core.presentation.components.atom.borderedicon.BorderedIcon
import com.example.focustime.core.presentation.components.atom.circledot.CircleDot
import com.example.focustime.core.presentation.theme.FocusTimeTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(FocusTimeTheme.dimensions.paddingMedium)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Icon(
                modifier = Modifier.size(FocusTimeTheme.dimensions.iconSizeNormal),
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "Menu",
                tint = MaterialTheme.colorScheme.primary
            )
        }
        AutoResizedText(
            "Focus Time",
            textStyle = MaterialTheme.typography.displayMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(FocusTimeTheme.dimensions.spacerMedium))

        Row {
            CircleDot()
            Spacer(modifier = Modifier.width(FocusTimeTheme.dimensions.spacerNormal))
            CircleDot()
            Spacer(modifier = Modifier.width(FocusTimeTheme.dimensions.spacerNormal))
            CircleDot(color = MaterialTheme.colorScheme.tertiary)
            Spacer(modifier = Modifier.width(FocusTimeTheme.dimensions.spacerNormal))
            CircleDot(color = MaterialTheme.colorScheme.tertiary)
            Spacer(modifier = Modifier.width(FocusTimeTheme.dimensions.spacerNormal))
        }

        Spacer(modifier = Modifier.height(FocusTimeTheme.dimensions.spacerMedium))
        TimerSession(
            timer = "05:00"
        )
    }
}

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


@Preview(
    name = "HomeScreenPreview",
    showBackground = true
)
@Composable
 fun HomeScreenPreview() {
     FocusTimeTheme {
         HomeScreen()
     }
 }