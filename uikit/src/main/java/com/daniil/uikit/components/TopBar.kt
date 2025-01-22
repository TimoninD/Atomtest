package com.daniil.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniil.uikit.R
import com.daniil.uikit.theme.Colors
import com.daniil.uikit.theme.Font

@Composable
fun TopBar(text: String, onBackClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Colors.onPrimary)
            .padding(horizontal = 16.dp, vertical = 14.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_arrow_back),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart)
                .clickable(
                    onClick = onBackClicked,
                    indication = ripple(bounded = false),
                    interactionSource = remember { MutableInteractionSource() })
        )
        Text(
            text = text,
            style = Font.subtitle1(Colors.onSurface),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
@Preview
private fun TopBarPreview() {
    TopBar(text = "Title") { }
}