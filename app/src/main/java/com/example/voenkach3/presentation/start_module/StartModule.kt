package com.example.voenkach3.presentation.start_module

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.voenkach3.R

@Preview(showBackground = true)
@Composable
fun StartModulePreview(){
    StartModule()
}

@Composable
fun StartModule(){
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.flag), contentDescription = "", contentScale = ContentScale.Crop, modifier = Modifier.matchParentSize())
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
            TextButton(onClick = {},
                colors = ButtonDefaults.textButtonColors(contentColor = Color.Black, containerColor = Color.White),
                modifier = Modifier.width(250.dp)
            ) {
                Text(text = "Регистрация", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(onClick = {},
                colors = ButtonDefaults.textButtonColors(contentColor = Color.Black, containerColor = Color.White),
                modifier = Modifier.width(250.dp)
            ) {
                Text(text = "Вход", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            //Spacer(modifier = Modifier.height(8.dp))
        }
    }
}