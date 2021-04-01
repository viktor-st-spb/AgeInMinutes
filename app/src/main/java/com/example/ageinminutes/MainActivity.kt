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
import java.text.SimpleDateFormat
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
                    view, selectedYear, selectedMonth, selectedDayOfMonth ->

                    //TODO - this code will be executed after the date will be selected
                    Toast.makeText(this,
                            "The year is $selectedYear, the month is  " +
                                    "and the date is $selectedDayOfMonth" ,
                            Toast.LENGTH_LONG).show()

                    val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                    tvSelectedDate.setText(selectedDate)

                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                    val theDate = sdf.parse(selectedDate)

                    val selectedDateInMinutes = theDate!!.time / 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    val currentDateInMinutes = currentDate!!.time / 60000

                    val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                    tvSelectedDateInMinutes.text = differenceInMinutes.toString()





                }, year, month, day)
                .show()
    }
}