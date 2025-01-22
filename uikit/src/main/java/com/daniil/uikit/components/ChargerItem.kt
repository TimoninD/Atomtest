package com.daniil.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniil.uikit.theme.Colors
import com.daniil.uikit.theme.Font

@Composable
fun ChargerItem(name: String, address: String, isBusy: Boolean) {
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Colors.onPrimary)
                .padding(horizontal = 12.dp, vertical = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = name, style = Font.subtitle2(Colors.onSurface))
                Spacer(Modifier.width(8.dp))
                Spacer(
                    modifier = Modifier
                        .size(12.dp)
                        .background(if (isBusy) Colors.error else Colors.success, CircleShape)
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(text = address, style = Font.body2(Colors.onSurface))

        }
        Divider()
    }
}

@Composable
@Preview
private fun ChargerItemPreview() {
    ChargerItem(name = "Name", address = "Address", isBusy = true)
}