package com.daniil.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniil.uikit.theme.Colors
import com.daniil.uikit.theme.Font

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean = true,
    isLoading: Boolean = false
) {
    val interactionSource = remember { MutableInteractionSource() }
    Button(
        modifier = modifier,
        onClick = {
            if (!isLoading) {
                onClick()
            }
        },
        shape = RoundedCornerShape(16.dp),
        enabled = isEnabled,
        interactionSource = interactionSource,
        elevation = null,
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            disabledBackgroundColor = Colors.primaryPale,
            backgroundColor = Colors.primary,
            disabledContentColor = Colors.primaryPale
        )
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = Colors.onPrimary,
                strokeWidth = 1.dp,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            )
        } else {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                style = Font.button(Colors.onPrimary),
            )
        }
    }
}

@Composable
@Preview
private fun PrimaryButtonPreview() {
    Column(modifier = Modifier.background(Color.White)) {
        PrimaryButton(
            text = "Default text",
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.height(16.dp))
        PrimaryButton(
            text = "Default text",
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            isEnabled = false
        )
    }
}