package by.eapp.testingapp_current.trainingList

import androidx.lifecycle.ViewModel

class TrainingViewModel: ViewModel() {

    private val _tasks = getTrainingTasks().toMutableList()
    val tasks: List<TrainingClass>
        get() = _tasks
    fun remove(item: TrainingClass) {
        _tasks.remove(item)
    }
    fun changeTaskChecked(item: TrainingClass, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
}
private fun getTrainingTasks() = List(30) {i -> TrainingClass(i, "First training") }