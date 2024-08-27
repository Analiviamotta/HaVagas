package com.example.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        amb.addCelBt.setOnClickListener {
            amb.celLt.isVisible = true
        }

        amb.schoolTrainingSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedTraining = parent?.getItemAtPosition(position).toString()


                when (selectedTraining) {
                    "Fundamental", "Médio" -> {
                        amb.schoolTrainingLt.isVisible = true
                        amb.graduationYear.isVisible = true
                    }
                    "Graduação", "Especialização" -> {
                        amb.schoolTrainingLt.isVisible = true
                        amb.institutionYear.isVisible = true
                        amb.graduationYear.isVisible = true
                    }
                    "Mestrado", "Doutorado" -> {
                        amb.schoolTrainingLt.isVisible = true
                        amb.institutionYear.isVisible = true
                        amb.graduationYear.isVisible = true
                        amb.thesisTitle.isVisible = true
                        amb.advisorTitle.isVisible = true
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }



        }

        amb.clearBt.setOnClickListener {

            amb.nameEt.text.clear()
            amb.emailEt.text.clear()
            amb.telEt.text.clear()
            amb.celEd.text.clear()
            amb.dateOfBirthEt.text.clear()
            amb.graduationYear.text.clear()
            amb.institutionYear.text.clear()
            amb.thesisTitle.text.clear()
            amb.advisorTitle.text.clear()
            amb.vacanciesOfInterestEt.text.clear()


            amb.typeTelRg.clearCheck()
            amb.genderRg.clearCheck()


            amb.emailCb.isChecked = false


            amb.schoolTrainingSp.setSelection(0)


            amb.schoolTrainingLt.isVisible = false
            amb.celLt.isVisible = false
        }

    }}