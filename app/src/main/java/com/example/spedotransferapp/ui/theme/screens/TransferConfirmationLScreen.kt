package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
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
import com.example.gittest.ui.theme.NewGray2
import com.example.gittest.ui.theme.NewGray3
import com.example.gittest.ui.theme.offred
import com.example.spedotransferapp.R
import com.example.spedotransferapp.navigation.Routes

@Composable
fun TransferConfirmationLastScreen(amount:String="24",recipientName:String="mo",recipientAccount:String="xxxx2244",navController: NavController,modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(colors = listOf(DarkWhite, LightDarkRed))
            )
            .padding(top = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 12.dp, top = 12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_arrow_back_ios_new_24),
                contentDescription = "Back",
                tint = NewGray2,
                modifier = Modifier
                    .size(22.dp)
                    .clickable {
                        navController.navigate(Routes.SETTINGS)
                    }

            )
            Text(
                text = "Transfare",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(0.93f),
                color = NewGray2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500
            )
        }
        Image(
            painter = painterResource(id = R.drawable.transferconfirmationlast),
            contentDescription = "Transfer Amount Screen",
            modifier = Modifier
                .fillMaxWidth(1f)
                .align(Alignment.CenterHorizontally)
                .height(37.dp)

        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            ) {
            Text(
                text = "Amount",
                fontSize = 14.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp),

                )
            Text(
                text = "Confirmation",
                fontSize = 14.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Payment",
                fontSize = 14.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(painter = painterResource(
                id = R.drawable.transferconfirmationlasttt),
                contentDescription ="",
                Modifier.size(80.dp)
                )

        }
        Text(
            text ="Your transfer was successful",
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center

        )


        TransferDetails(fromName = "Mohamed Atef", fromAccount = "xxxx2424", toName = recipientName, toAccount =recipientAccount ,R.drawable.baseline_done_24)

        Row (
            modifier=Modifier.fillMaxWidth()
        ){
            Text(
                text ="Total amount",
                modifier = Modifier
                    .padding(top = 4.dp)
                    .weight(1f),
                fontSize = 16.sp,
                color = NewGray3,


                )
            Text(
                text ="${amount} EGB",
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp)
                    .weight(1f),
                fontSize = 16.sp,
                textAlign = TextAlign.End,
                color = NewGray3

            )

        }
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp)
        )




        Button(
            onClick = {
                navController.navigate(Routes.SCAFFOLDSCREEN)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = offred
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Back to Home",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
        OutlinedButton(
            onClick = {navController.navigate(Routes.TRANSFERAMOUNT)  },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = offred,
            ),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, offred)
        ) {
            Text(
                text = "Add to Favourite",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 10.dp),

                )
        }




    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TransferConfiramtionLastPrev() {
    TransferConfirmationLastScreen(
        amount = "1000",
        recipientName = "Asmaa Desoky",
        recipientAccount = "xxxx2004",
        navController = rememberNavController()
    )
}
