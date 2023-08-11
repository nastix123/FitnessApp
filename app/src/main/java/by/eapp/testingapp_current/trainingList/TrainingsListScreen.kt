package by.eapp.testingapp_current.trainingList

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TrainingListScreen(
    modifier: Modifier = Modifier,
    trainingViewModel: TrainingViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        TrainingTasksList(
            list = trainingViewModel.tasks,
            onCheckedTask = { task, checked ->
                trainingViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                trainingViewModel.remove(task)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Test() {
    TrainingListScreen()
}