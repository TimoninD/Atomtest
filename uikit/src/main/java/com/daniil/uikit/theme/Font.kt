package com.daniil.uikit.theme

import android.graphics.Typeface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Font {

    fun button(color: Color) = TextStyle.Default.copy(
        fontSize = 16.sp,
        color = color,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Medium
    )

    fun headline1(color: Color) = TextStyle.Default.copy(
        fontSize = 32.sp,
        color = color,
        lineHeight = 36.sp,
        fontWeight = FontWeight.SemiBold
    )

    fun body1(color: Color) = TextStyle.Default.copy(
        fontSize = 16.sp,
        color = color,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Normal
    )

    fun subtitle2(color: Color) = TextStyle.Default.copy(
        fontSize = 16.sp,
        color = color,
        lineHeight = 18.sp,
        fontWeight = FontWeight.SemiBold
    )

    fun subtitle1(color: Color) = TextStyle.Default.copy(
        fontSize = 18.sp,
        color = color,
        lineHeight = 20.sp,
        fontWeight = FontWeight.SemiBold
    )

    fun body2(color: Color) = TextStyle.Default.copy(
        fontSize = 14.sp,
        color = color,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Normal
    )
}