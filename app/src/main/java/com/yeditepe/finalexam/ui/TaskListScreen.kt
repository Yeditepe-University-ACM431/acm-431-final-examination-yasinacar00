package com.yeditepe.finalexam.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.yeditepe.finalexam.model.Task
import com.yeditepe.finalexam.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(viewModel: TaskViewModel = viewModel()) {
    // TODO 3: Read task list from ViewModel
    val taskList = viewModel.tasks

    Column(modifier = Modifier.padding(16.dp)) {
        Text("My Tasks", modifier = Modifier.padding(bottom = 8.dp))

        LazyColumn {
        // TODO 4: Display task titles and completion status
        // Use a simple Column or LazyColumn
            items(taskList) { task ->
                TaskRow(
                    task = task,
                    onToggle = { viewModel.toggleTask(task.id) }
                )
            }
        }
    }
}

@Composable
fun TaskRow(task: Task, onToggle: () -> Unit) {
    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = "${task.title} - ${if (task.isCompleted) "Done" else "Pending"}",
            modifier = Modifier.weight(1f).padding(top = 12.dp)
        )
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = { onToggle() }
        )
    }
}
