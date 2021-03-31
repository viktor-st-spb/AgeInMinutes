package com.example.ageinminutes

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //OnClickListener gets a view and then executes a code after an arrow ->
        //(we use a view to call clickDatePicker() method)
        btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(view : View){

        //myCalendar object of Calendar Class
        val myCalendar = Calendar.getInstance()

        //Current year, month and day
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener {
                    view, SelectedYear, SelectedMonth, SelectedDayOfMonth ->

                    //TODO - this code will be executed after the date will be selected
                    Toast.makeText(this,
                            "The year is $SelectedYear, the month is  " +
                                    "and the date is $SelectedDayOfMonth" ,
                            Toast.LENGTH_LONG).show()

                    val selectedDate = "$SelectedDayOfMonth/${SelectedMonth+1}/$SelectedYear"

                    tvSelectedDate.setText(selectedDate)

                }, year, month, day)
                .show()
    }
}