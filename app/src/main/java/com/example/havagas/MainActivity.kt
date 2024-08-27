package com.example.havagas

import Form
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
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
                    "fundamental", "médio" -> {
                        amb.schoolTrainingLt.isVisible = true
                        amb.graduationYear.isVisible = true
                        amb.institutionYear.isVisible = false
                        amb.thesisTitle.isVisible = false
                        amb.advisorTitle.isVisible = false
                    }
                    "graduação", "especialização" -> {
                        amb.schoolTrainingLt.isVisible = true
                        amb.graduationYear.isVisible = true
                        amb.institutionYear.isVisible = true
                        amb.thesisTitle.isVisible = false
                        amb.advisorTitle.isVisible = false
                    }
                    "mestrado", "doutorado" -> {
                        amb.schoolTrainingLt.isVisible = true
                        amb.graduationYear.isVisible = true
                        amb.institutionYear.isVisible = true
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


        amb.btSave.setOnClickListener {

            val name = amb.nameEt.text.toString()
            val email = amb.emailEt.text.toString()
            val wantsAtt = amb.emailCb.isChecked
            val phoneType = when (amb.typeTelRg.checkedRadioButtonId) {
                R.id.typeTelBusinessRb -> "Business"
                R.id.typeTelHomeRb -> "Home"
                else -> ""
            }
            val phone = amb.telEt.text.toString()
            val celPhone = amb.celEd.text.toString()
            val gender = when (amb.genderRg.checkedRadioButtonId) {
                R.id.femaleRb -> "Female"
                R.id.masculineRb -> "Masculine"
                else -> ""
            }
            val birthDate = amb.dateOfBirthEt.text.toString()
            val education = amb.schoolTrainingSp.selectedItem.toString()
            val graduationYear = amb.graduationYear.text.toString()
            val completionYear = amb.institutionYear.text.toString()
            val institution = amb.institutionYear.text.toString()
            val thesisTitle = amb.thesisTitle.text.toString()
            val advisorTitle = amb.advisorTitle.text.toString()
            val vacanciesOfInterests = amb.vacanciesOfInterestEt.text.toString()


            val form = Form(
                name = name,
                email = email,
                wantsAtt = wantsAtt,
                phoneType = phoneType,
                phone = phone,
                celPhone = celPhone,
                gender = gender,
                birthDate = birthDate,
                education = education,
                graduationYear = graduationYear,
                completionYear = completionYear,
                institution = institution,
                thesisTitle = thesisTitle,
                advisorTitle = advisorTitle,
                vacanciesOfInterests = vacanciesOfInterests
            )

            Toast.makeText(
                this@MainActivity,
                form.toString(),
                Toast.LENGTH_SHORT
            ).show()


        }

    }}