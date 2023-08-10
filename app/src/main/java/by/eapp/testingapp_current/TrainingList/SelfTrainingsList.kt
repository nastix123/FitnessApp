
package by.eapp.testingapp_current.TrainingList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TrainingTasksList(
    list: List<TrainingClass>,
    onCheckedTask: (TrainingClass, Boolean) -> Unit,
    onCloseTask: (TrainingClass) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,

            key = { task -> task.id }
        ) { task ->
            TrainingTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }
}