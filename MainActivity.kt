```kotlin
package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var taskContainer: LinearLayout
    private val tasks = ArrayList<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskContainer = findViewById(R.id.taskContainer)

        val btnAddTask = findViewById<Button>(R.id.btnAddTask)

        btnAddTask.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivityForResult(intent, 100)
        }

        displayTasks()
    }

    private fun displayTasks() {

        taskContainer.removeAllViews()

        if (tasks.isEmpty()) {

            val emptyMessage = TextView(this)

            emptyMessage.text = "No tasks available.\nTap \"Add Task\" to create a task."
            emptyMessage.textSize = 18f
            emptyMessage.setPadding(20, 40, 20, 40)

            taskContainer.addView(emptyMessage)

            return
        }

        for (task in tasks) {

            val taskButton = Button(this)

            taskButton.text = "${task.title}\nPriority: ${task.priority}"
            taskButton.textSize = 16f

            taskButton.setOnClickListener {

                val intent =
                    Intent(this, TaskDetailsActivity::class.java)

                intent.putExtra("title", task.title)
                intent.putExtra("description", task.description)
                intent.putExtra("priority", task.priority)
                intent.putExtra("date", task.date)

                startActivity(intent)
            }

            taskContainer.addView(taskButton)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {

            val title = data?.getStringExtra("title") ?: ""
            val description = data?.getStringExtra("description") ?: ""
            val priority = data?.getStringExtra("priority") ?: ""
            val date = data?.getStringExtra("date") ?: ""

            val newTask = Task(
                title,
                description,
                priority,
                date
            )

            tasks.add(newTask)

            displayTasks()
        }
    }
}

data class Task(
    val title: String,
    val description: String,
    val priority: String,
    val date: String
)
```
