package com.sushkpavel.news_app.presentation.utils.tab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import java.util.Locale

@Composable
fun TabText(
    text: String?,
    fontSize: TextUnit,
    style: TextStyle,
    alignment: Alignment,
    modifier: Modifier = Modifier
) {
    if (text != null) {
        Box(modifier = modifier) {
            Text(
                text = text.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                },
                fontSize = fontSize,
                style = style,
                modifier = Modifier.align(alignment)
            )
        }
    } else {
        Spacer(modifier = modifier)
    }
}