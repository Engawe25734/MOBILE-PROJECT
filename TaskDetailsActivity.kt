```kotlin
package com.example.taskmanager

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TaskDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val txtTaskTitle = findViewById<TextView>(R.id.txtTaskTitle)
        val txtTaskDescription =
            findViewById<TextView>(R.id.txtTaskDescription)

        val txtTaskPriority =
            findViewById<TextView>(R.id.txtTaskPriority)

        val txtTaskDate =
            findViewById<TextView>(R.id.txtTaskDate)

        val btnBack =
            findViewById<Button>(R.id.btnBack)

        val title =
            intent.getStringExtra("title") ?: ""

        val description =
            intent.getStringExtra("description") ?: ""

        val priority =
            intent.getStringExtra("priority") ?: ""

        val date =
            intent.getStringExtra("date") ?: ""

        txtTaskTitle.text = title
        txtTaskDescription.text = description
        txtTaskPriority.text = "Priority: $priority"
        txtTaskDate.text = "Due Date: $date"

        btnBack.setOnClickListener {
            finish()
        }
    }
}
```
