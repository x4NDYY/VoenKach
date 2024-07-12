package com.example.voenkach3.presentation.universal

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(title: String, @DrawableRes imageId: Int) {
    var text by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .background(Color.White, RoundedCornerShape(8.dp))
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "Search",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                singleLine = true,
                value = text,
                onValueChange = {text = it},
                modifier = Modifier.weight(1f)
            )
            if (text.isEmpty()) {
                Text(
                    text = title,
                    color = Color.Gray
                )
            }
        }
    }
}