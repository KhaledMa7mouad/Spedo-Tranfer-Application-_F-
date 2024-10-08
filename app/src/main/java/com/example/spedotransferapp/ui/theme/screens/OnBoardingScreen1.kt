package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gittest.ui.theme.DarkWhite
import com.example.gittest.ui.theme.LightDarkRed
import com.example.gittest.ui.theme.NewGray
import com.example.gittest.ui.theme.NewGray2
import com.example.gittest.ui.theme.offred
import com.example.spedotransferapp.R
import com.example.spedotransferapp.navigation.Routes

@Composable
fun OnBoardingScreen1(navController: NavController,onOnboardingComplete: () -> Unit,modifier: Modifier = Modifier) {
    Column (
        modifier= Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(colors = listOf(DarkWhite, LightDarkRed))
            )
            .padding(top = 24.dp)
    ){
        Column (
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End,
            modifier = Modifier.fillMaxWidth()
        ){
            TextButton(onClick = { onOnboardingComplete() }) {
                Text(
                    text = "Skip",
                    fontSize = 16.sp,
                    color = NewGray2,
                    modifier = Modifier.padding(end = 12.dp,top=16.dp)
                )
            }

        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
                .padding(top = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.onbordingpageoneone),
                contentDescription ="",
                modifier=Modifier.fillMaxSize()
                )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.11f)
                .padding(top = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.frameonboardingone),
                contentDescription ="",
                modifier=Modifier.fillMaxSize()
                )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)

        ) {
            Text(
                text = "Amont",
                fontSize = 24.sp,
                fontWeight = FontWeight.W500,
                color = NewGray2,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top=4.dp)

            )
            Text(
                text = "Send money fast with simple steps. Create account, Confirmation, Payment. Simple.",
                color = NewGray,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier.padding(top=24.dp)
                )
            Button(
                onClick = { navController.navigate("onboarding2") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 24.dp),
                shape = RoundedCornerShape(8.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = offred
                )
                ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    )
            }

        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun OnBoardingScreen1Preview() {
    OnBoardingScreen1(rememberNavController(),{})
}