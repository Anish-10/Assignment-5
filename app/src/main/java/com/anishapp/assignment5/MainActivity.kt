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
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var etDoj:EditText
    private lateinit var etDob:EditText
    private lateinit var btnSubmit:Button
    private lateinit var tvDoj:TextView
    private lateinit var tvDob:TextView

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etDoj=findViewById(R.id.etDoj)
        etDob=findViewById(R.id.etDob)
        btnSubmit=findViewById(R.id.btnSubmit)
        tvDoj=findViewById(R.id.tvDoj)
        tvDob=findViewById(R.id.tvDob)

        etDoj.setOnClickListener {
            workingYears()
        }

        etDob.setOnClickListener {
            age()
        }

        btnSubmit.setOnClickListener {
            calcAge()
            calcWorkingYears()
        }
    }

    private fun age()
    {
        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog=DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    etDob.setText("$dayOfMonth-${month+1}-$year")
                },
                year,
                month,
                day
        )
        datePickerDialog.show()
    }

    private fun workingYears()
    {
        val c=Calendar.getInstance()
        val year=c.get(Calendar.YEAR)
        val month=c.get(Calendar.MONTH)
        val day=c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog=DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    etDoj.setText("$dayOfMonth-${month+1}-$year")
                },
                year,
                month,
                day
        )
        datePickerDialog.show()
    }

    private fun calcAge()
    {
        val today=Date()
        val dobs=etDob.text.toString()
        val sdf=SimpleDateFormat("dd-mm-yyyy")
        val dob=sdf.parse(dobs)

        val years=(today.time-dob.time)/31540000000
        val months=(today.time-dob.time)/2628000000
        val days=(today.time-dob.time)/86400000

        tvDob.text="Your Age is: $years years "

    }

    private fun calcWorkingYears()
    {
        val today=Date()
        val dojs=etDoj.text.toString()
        val sdf=SimpleDateFormat("dd-mm-yyyy")
        val doj=sdf.parse(dojs)

        val years=(today.time-doj.time)/31540000000
        val months=(today.time-doj.time)/2628000000
        val days=(today.time-doj.time)/86400000

        tvDoj.text="No. of worked years: $years years "

    }
}