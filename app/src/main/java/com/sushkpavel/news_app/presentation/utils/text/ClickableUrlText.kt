package com.sushkpavel.news_app.presentation.utils.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.sushkpavel.news_app.R

@Composable
fun ClickableUrlText(url: String, modifier: Modifier = Modifier, textStyle: TextStyle) {
    val annotatedString = buildAnnotatedString {
        pushStringAnnotation(tag = "URL", annotation = url)
        withStyle(style = SpanStyle(color = Color.Blue, fontSize = textStyle.fontSize )) {
            append("\n ${stringResource(R.string.visit)}: $url")
        }
        pop()
    }

    val uriHandler = LocalUriHandler.current

    BasicText(
        text = annotatedString,
        style = textStyle,
        modifier = modifier.clickable {
            annotatedString.getStringAnnotations(tag = "URL", start = 0, end = annotatedString.length)
                .firstOrNull()?.let { annotation ->
                    uriHandler.openUri(annotation.item)
                }
        }
    )
}


