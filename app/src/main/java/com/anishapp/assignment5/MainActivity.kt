package com.anishapp.assignment5

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.Month
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var etDoj:EditText
    private lateinit var etDob:EditText
    private lateinit var tvDoj:TextView
    private lateinit var tvDob:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etDoj=findViewById(R.id.etDoj)
        etDob=findViewById(R.id.etDob)
        tvDob=findViewById(R.id.tvDob)

        val currentDate=SimpleDateFormat("dd").format(System.currentTimeMillis()).toInt()
        val currentMonth=SimpleDateFormat("MM").format(System.currentTimeMillis()).toInt()
        val currentYear=SimpleDateFormat("yyyy").format(System.currentTimeMillis()).toInt()

        fun workingYears(year:Int, month:Int, dayOfMonth:Int):String {
            var modCurrentDate=currentDate
            var modCurrentMonth=currentMonth
            var modCurrentYear=currentYear
            val ageDay:Int
            val ageMonth:Int
            val ageYear:Int

            if (dayOfMonth > modCurrentDate)
            {
                modCurrentDate +=31
                modCurrentMonth -=1
                ageDay = modCurrentDate - dayOfMonth
            }
            else
            {
                ageDay = modCurrentDate - dayOfMonth
            }

            if (month > modCurrentMonth)
            {
                modCurrentMonth +=12
                modCurrentYear -=1
                ageMonth = modCurrentMonth - month
            }
            else
            {
                ageMonth = modCurrentMonth - month
            }
            ageYear = modCurrentYear - year

            return "No. of years worked: " + ageYear.toString() + " years " + ageMonth.toString() + " months " + ageDay.toString() + " days"
        }

        tvDoj=findViewById(R.id.tvDoj)
        val datePickerDialog=DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            etDoj.setText("$dayOfMonth-${month + 1}-$year")
            tvDoj.text=workingYears(year, month+1, dayOfMonth)
        },
        currentYear,
        currentMonth-1,
        currentDate
        )

        etDoj.setOnClickListener {
            datePickerDialog.show()
        }

        fun age(year:Int, month:Int, dayOfMonth:Int):String {
            var modCurrentDate=currentDate
            var modCurrentMonth=currentMonth
            var modCurrentYear=currentYear
            val ageDay:Int
            val ageMonth:Int
            val ageYear:Int

            if (dayOfMonth > modCurrentDate)
            {
                modCurrentDate +=31
                modCurrentMonth -=1
                ageDay = modCurrentDate - dayOfMonth
            }
            else
            {
                ageDay = modCurrentDate - dayOfMonth
            }

            if (month > modCurrentMonth)
            {
                modCurrentMonth +=12
                modCurrentYear -=1
                ageMonth = modCurrentMonth - month
            }
            else
            {
                ageMonth = modCurrentMonth - month
            }
            ageYear = modCurrentYear - year

            return "Your Age is: " + ageYear.toString() + " years " + ageMonth.toString() + " months " + ageDay.toString() + " days"
        }

        tvDob=findViewById(R.id.tvDob)
        val datePickerDialog1=DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    etDob.setText("$dayOfMonth-${month + 1}-$year")
                    tvDob.text = age(year, month + 1, dayOfMonth)
                },
                currentYear,
                currentMonth - 1,
                currentDate
        )

        etDob.setOnClickListener {
            datePickerDialog1.show()
        }
    }


}
