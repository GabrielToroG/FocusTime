package com.example.focustime.home.presentation.home.view

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
import com.example.focustime.core.presentation.components.atom.circledot.CircleDot
import com.example.focustime.core.presentation.components.atom.custombutton.CustomButton
import com.example.focustime.core.presentation.theme.FocusTimeTheme
import com.example.focustime.home.presentation.home.view.elements.InformationElement
import com.example.focustime.home.presentation.home.view.elements.TimerSession
import com.example.focustime.home.presentation.home.view.elements.TimerTypeSession

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
            timer = "05:00",
            onIncreasedTap = { /* TODO */ },
            onDecreasedTap = { /* TODO */ }
        )

        Spacer(modifier = Modifier.height(FocusTimeTheme.dimensions.spacerMedium))

        TimerTypeSession(onTap = { /* TODO */ })

        Spacer(modifier = Modifier.height(FocusTimeTheme.dimensions.spacerMedium))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomButton(
                text = "Start",
                textColor = MaterialTheme.colorScheme.surface,
                buttonColor = MaterialTheme.colorScheme.primary,
                onTap =  { /* TODO */ }
            )

            CustomButton(
                text = "Reset",
                textColor = MaterialTheme.colorScheme.primary,
                buttonColor = MaterialTheme.colorScheme.surface,
                onTap =  { /* TODO */ }
            )
        }

        InformationElement(
            modifier = Modifier.weight(1f),
            round = "10",
            time = "45:00"
        )
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