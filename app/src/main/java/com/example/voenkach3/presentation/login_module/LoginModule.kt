package com.example.voenkach3.presentation.login_module

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.voenkach3.R

@Preview(showBackground = true)
@Composable
fun LoginModulePreview(){
    LoginModule()
}

@Composable
fun LoginModule() {

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.flag), contentDescription = "", contentScale = ContentScale.Crop, modifier = Modifier.matchParentSize())
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
//            OutlinedTextField(
//                value = login,
//                onValueChange = { login = it },
//                label = { Text(text = "Логин") },
//                leadingIcon = { Image(painter = painterResource(id = R.drawable.loginlogo), contentDescription = "")},
//                colors = TextFieldDefaults.
//            )
            CustomTextField(title = "Логин", imageId = R.drawable.loginlogo)
            Spacer(modifier = Modifier.height(16.dp))
//            OutlinedTextField(
//                value = password,
//                onValueChange = { password = it },
//                label = { Text(text = "Пароль") },
//                leadingIcon = { Image(painter = painterResource(id = R.drawable.passwordlogo), contentDescription = "")})
            CustomTextField(title = "Пароль", imageId = R.drawable.passwordlogo)
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = {},
                colors = ButtonDefaults.textButtonColors(contentColor = Color.Black, containerColor = Color.White)
            ) {
                Text(text = "Продолжить")
            }
        }
    }
}

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

