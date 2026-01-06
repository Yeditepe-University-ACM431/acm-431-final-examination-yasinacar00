package com.yeditepe.finalexam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "tasks"
    ) {
        // TODO 1: Add composable for "tasks"
        composable("tasks") {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Task List", style = MaterialTheme.typography.headlineMedium)
                TaskRow(
                    task = Task(1, "Final Project", false), 
                    navController = navController
                )
            }
        }

        // TODO 2: Add composable for "taskDetail/{title}"
        composable(
            route = "taskDetail/{title}",
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) { backStackEntry ->
            val taskTitle = backStackEntry.arguments?.getString("title") ?: "Unknown"
            TaskDetailScreen(title = taskTitle)
        }
    }
}
