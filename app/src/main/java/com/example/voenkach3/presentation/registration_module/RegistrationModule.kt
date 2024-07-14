package com.example.voenkach3.presentation.registration_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.voenkach3.R
import com.example.voenkach3.navigation.Screen
import com.example.voenkach3.presentation.universal.CustomTextField

@Preview(showBackground = true)
@Composable
fun RegistrationModulePreview(){
    //RegistrationModule()
}

@Composable
fun RegistrationModule(navController: NavHostController){
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.flag), contentDescription = "", contentScale = ContentScale.Crop, modifier = Modifier.matchParentSize())
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
            CustomTextField(title = "Имя", imageId = R.drawable.namelogo)
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(title = "Фамилия", imageId = R.drawable.namelogo)
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(title = "Должность", imageId = R.drawable.joblogo)
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(title = "Логин", imageId = R.drawable.regloginlogo)
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(title = "Пароль", imageId = R.drawable.passwordlogo)
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = { navController.navigate(Screen.Main.route) },
                colors = ButtonDefaults.textButtonColors(contentColor = Color.Black, containerColor = Color.White)
            ) {
                Text(text = "Продолжить")
            }
        }
    }
}