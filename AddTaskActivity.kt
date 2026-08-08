```kotlin
package com.example.taskmanager

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class AddTaskActivity : AppCompatActivity() {

    private lateinit var edtTaskTitle: EditText
    private lateinit var edtTaskDescription: EditText
    private lateinit var radioGroupPriority: RadioGroup
    private lateinit var edtTaskDate: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        edtTaskTitle = findViewById(R.id.edtTaskTitle)
        edtTaskDescription = findViewById(R.id.edtTaskDescription)
        radioGroupPriority = findViewById(R.id.radioGroupPriority)
        edtTaskDate = findViewById(R.id.edtTaskDate)

        val btnSelectDate = findViewById<Button>(R.id.btnSelectDate)
        val btnSaveTask = findViewById<Button>(R.id.btnSaveTask)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        btnSelectDate.setOnClickListener {
            showDatePicker()
        }

        btnSaveTask.setOnClickListener {
            saveTask()
        }

        btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun showDatePicker() {

        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->

                val date =
                    "${selectedMonth + 1}/$selectedDay/$selectedYear"

                edtTaskDate.setText(date)

            },
            year,
            month,
            day
        )

        datePicker.show()
    }

    private fun saveTask() {

        val title = edtTaskTitle.text.toString().trim()
        val description = edtTaskDescription.text.toString().trim()
        val date = edtTaskDate.text.toString().trim()

        if (title.isEmpty()) {

            Toast.makeText(
                this,
                "Please enter a task title.",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        if (description.isEmpty()) {

            Toast.makeText(
                this,
                "Please enter a task description.",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        if (date.isEmpty()) {

            Toast.makeText(
                this,
                "Please select a date.",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val selectedRadioButtonId =
            radioGroupPriority.checkedRadioButtonId

        if (selectedRadioButtonId == -1) {

            Toast.makeText(
                this,
                "Please select a priority.",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val selectedRadioButton =
            findViewById<RadioButton>(selectedRadioButtonId)

        val priority =
            selectedRadioButton.text.toString()

        val resultIntent = Intent()

        resultIntent.putExtra("title", title)
        resultIntent.putExtra("description", description)
        resultIntent.putExtra("priority", priority)
        resultIntent.putExtra("date", date)

        setResult(RESULT_OK, resultIntent)

        finish()
    }
}
```
