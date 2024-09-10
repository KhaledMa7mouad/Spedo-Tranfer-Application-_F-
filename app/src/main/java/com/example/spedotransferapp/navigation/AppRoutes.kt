package com.example.spedotransferapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spedotransferapp.ui.theme.screens.EditPasswordScreen
import com.example.spedotransferapp.ui.theme.screens.EditProfileScreen
import com.example.spedotransferapp.ui.theme.screens.OnBoardingScreen1
import com.example.spedotransferapp.ui.theme.screens.OnBoardingScreen2
import com.example.spedotransferapp.ui.theme.screens.OnBoardingScreen3
import com.example.spedotransferapp.ui.theme.screens.SecondScreen
import com.example.spedotransferapp.ui.theme.screens.SettingsScreen
import com.example.spedotransferapp.ui.theme.screens.SignIn
import com.example.spedotransferapp.ui.theme.screens.Timeout
import androidx.navigation.navArgument
import com.example.spedotransferapp.ui.theme.screens.NotificationScreen
import com.example.spedotransferapp.ui.theme.screens.SignUpSecondScreen
import com.example.spedotransferapp.ui.theme.screens.SuccessTransactionScreen

import com.example.spedotransferapp.ui.theme.screens.TransfareAmountScreen
import com.example.spedotransferapp.ui.theme.screens.TransferConfirmationScreen

object Routes {
    const val FIRSTSIGNUP = "firstsignup"
    const val SIGNIN = "signin"
    const val ONBOARDINGONE = "onboardingone"
    const val ONBOARDINGTWO = "onboardingtwo"
    const val ONBOARDINGTHREE = "onboardingthree"
    const val TIMEOUT = "timeout"
    const val SETTINGS = "settings"
    const val EDITPROFILE = "editprofile"
    const val EDITPASSWORD = "editpassword"
    const val TRANSFERAMOUNT = "transferamount"
    const val TRANSFERCONFIRMATION = "transferconfirmation"
    const val SUCCESSFULTRANSACTION = "successfultransaction"
    const val NOTIFICATION = "notification"
    const val SIGNUPSECONDSCREEN="signupsecondscreen"

}

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.FIRSTSIGNUP
    )
    {

        composable(route = Routes.FIRSTSIGNUP) {
            SecondScreen(navController)
        }
        composable(route = Routes.SIGNIN) {
            SignIn(navController)
        }

        composable(route = Routes.TIMEOUT) {
            Timeout(navController)
        }
        composable(route = Routes.SETTINGS) {
            SettingsScreen(navController)
        }
        composable(route = Routes.EDITPROFILE) {
            EditProfileScreen(navController)
        }
        composable(route = Routes.EDITPASSWORD) {
            EditPasswordScreen(navController)
        }
        composable(route = Routes.TRANSFERAMOUNT) {
            TransfareAmountScreen(navController)
        }
        composable(
            route = "${Routes.TRANSFERCONFIRMATION}/{amount}/{recipientName}/{recipientAccount}",
            arguments = listOf(
                navArgument("amount") { type = NavType.StringType },
                navArgument("recipientName") { type = NavType.StringType },
                navArgument("recipientAccount") { type = NavType.StringType }
            )
        ) {
            val amount = it.arguments?.getString("amount")!!
            val recipientName = it.arguments?.getString("recipientName")!!
            val recipientAccount = it.arguments?.getString("recipientAccount")!!

            TransferConfirmationScreen(
                amount = amount,
                recipientName = recipientName,
                recipientAccount = recipientAccount,
                navController = navController
            )
        }
        composable(
            route = "${Routes.SIGNUPSECONDSCREEN}/{name}/{email}/{password}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) {
            val name = it.arguments?.getString("name")!!
            val email = it.arguments?.getString("email")!!
            val password = it.arguments?.getString("password")!!

            SignUpSecondScreen(
                name = name,
                email = email,
                password = password,
                navController = navController
            )
        }

        composable(route = Routes.SUCCESSFULTRANSACTION) {
            SuccessTransactionScreen(navController)
        }

        composable(route = Routes.NOTIFICATION) {
            NotificationScreen()
        }


    }

}