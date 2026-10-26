package id.my.tudemaha.lobos.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import id.my.tudemaha.lobos.ui.screens.LoginScreen
import id.my.tudemaha.lobos.ui.screens.RegisterScreen
import id.my.tudemaha.lobos.ui.screens.ResendVerificationScreen

@Composable
fun LobosNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = LoginRoute,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(250)
            ) + fadeIn(animationSpec = tween(250))
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(250)
            ) + fadeOut(animationSpec = tween(250))
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(250)
            ) + fadeIn(animationSpec = tween(250))
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(250)
            ) + fadeOut(animationSpec = tween(250))
        }
    ) {
        composable<LoginRoute> {
            LoginScreen(
                onNavigateToRegister = {
                    navController.navigate(RegisterRoute) {
                        launchSingleTop = true
                    }
                },
                onNavigateToResendVerification = { email ->
                    navController.navigate(ResendVerificationRoute(email)) {
                        launchSingleTop = true
                    }
                },
                onLoginSuccess = {}
            )
        }

        composable<RegisterRoute> {
            RegisterScreen(
                onNavigateToLogin = {
                    navController.popBackStack()
                },
                onRegisterSuccess = { email ->
                    navController.navigate(ResendVerificationRoute(email)) {
                        popUpTo<RegisterRoute> { inclusive = true }
                    }
                }
            )
        }

        composable<ResendVerificationRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<ResendVerificationRoute>()
            ResendVerificationScreen(
                email = route.email,
                onNavigateToLogin = { navController.popBackStack(LoginRoute, false) },
            )
        }
    }
}