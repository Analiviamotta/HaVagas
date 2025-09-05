package br.edu.ifsp.scl.ads.prdm.sc3033945.havagas

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.prdm.sc3033945.havagas.databinding.ActivityMainBinding

// o AppCompatActivity é o que faz o main activity ser uma tela
class MainActivity : AppCompatActivity() {

    // val é uma variavel de leitura apenas
    // o by lazy significa que o que está dentro da chaves só será criado uma vez,
    // depois fica em cache

    private val amb : ActivityMainBinding by lazy {
        // pega o layout correspondente a ActivityMainBinding
        // como saber se um layout corresponde a class? Existe um padrao de nomenclatura, o nome da
        // class corresponse ao nome do xml de seu layout em PascalCase acompanhado da palavra
        // Binding
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // define qual layout será exibido na activity
        setContentView(amb.root)

        amb.addCellphoneCb.setOnCheckedChangeListener{ _, isChecked ->
            onAddCellPhone(isChecked)
        }

        amb.clearBtn.setOnClickListener{
            clearForm()
        }

        amb.saveBtn.setOnClickListener {
            showSummary()
        }

        amb.degreeSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val degreeView = (view as TextView).text.toString()

                if (degreeView.equals("Fundamental") || degreeView.equals("Médio")) {
                   showYearDegreeField()
                } else {
                  hideYearDegreeField()
                }

                if(degreeView.equals("Graduação") || degreeView.equals("Especialização")){
                    showConclusionYearAndInstitutionFields()
                }else {
                    hideConclusionYearAndInstitutionFields()
                }

                if(degreeView.equals("Mestrado") || degreeView.equals("Doutorado")){
                    showYearOfCompletionAndInstitutionAndThesisTitleAndAdvisor()
                }else{
                    hideYearOfCompletionAndInstitutionAndThesisTitleAndAdvisor()
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun showYearDegreeField(){
        amb.degreeYearLl.visibility = View.VISIBLE
    }

    private fun hideYearDegreeField(){
        amb.degreeYearLl.visibility = View.GONE
        amb.degreeYearEt.setText("")
    }

    private fun showYearOfCompletionAndInstitutionAndThesisTitleAndAdvisor(){
        amb.yearOfCompletionAndInstitutionAndThesisTitleAndAdvisorLl.visibility = View.VISIBLE
    }

    private fun hideYearOfCompletionAndInstitutionAndThesisTitleAndAdvisor(){
        amb.yearOfCompletionAndInstitutionAndThesisTitleAndAdvisorLl.visibility = View.GONE
        amb.yearOfCompletionEt.setText("")
        amb.institutionNameEt.setText("")
        amb.thesisTitleEt.setText("")
        amb.advisorEt.setText("")
    }

    private fun showConclusionYearAndInstitutionFields(){
        amb.yearOfGraduationAndInstitution.visibility = View.VISIBLE
    }

    private fun hideConclusionYearAndInstitutionFields(){
        amb.yearOfGraduationAndInstitution.visibility = View.GONE
        amb.yearOfGraduationEt.setText("")
        amb.institutionEt.setText("")
    }

    private fun onAddCellPhone(show: Boolean) {
        amb.cellPhoneNumberLl.visibility =
            if (show) android.view.View.VISIBLE else android.view.View.GONE
    }

    private fun clearForm(){
        amb.nameEt.setText("")
        amb.emailEt.setText("")
        amb.phoneEt.setText("")
        amb.cellphoneEt.setText("")
        amb.birthdayEt.setText("")
        amb.yearOfCompletionEt.setText("")
        amb.yearOfGraduationEt.setText("")
        amb.degreeYearEt.setText("")
        amb.advisorEt.setText("")
        amb.thesisTitleEt.setText("")
        amb.institutionEt.setText("")
        amb.institutionNameEt.setText("")
        amb.thesisTitleEt.setText("")
        amb.jobOfInterestEt.setText("")
    }

    private fun showSummary() {
        val builder = StringBuilder()

        fun appendEditText(label: String, et: EditText) {
            val value = et.text.toString().ifBlank { "Não informado" }
            builder.append("$label: $value\n")
        }

        fun appendCheckBox(label: String, cb: CheckBox) {
            val value = if (cb.isChecked) "Sim" else "Não"
            builder.append("$label: $value\n")
        }

        fun appendRadioGroup(label: String, rg: RadioGroup) {
            val selectedId = rg.checkedRadioButtonId
            val selectedText = if (selectedId != -1) findViewById<RadioButton>(selectedId).text else "Não informado"
            builder.append("$label: $selectedText\n")
        }

        fun appendSpinner(label: String, spinner: Spinner) {
            val selected = spinner.selectedItem?.toString() ?: "Não informado"
            builder.append("$label: $selected\n")
        }


        appendEditText("Nome", amb.nameEt)
        appendEditText("Email", amb.emailEt)
        appendCheckBox("Receber notificações por email", amb.emailNotificationsCb)
        appendEditText("Telefone", amb.phoneEt)
        appendRadioGroup("Tipo de telefone", amb.phoneTypeRg)
        appendCheckBox("Adicionar celular", amb.addCellphoneCb)
        appendEditText("Celular", amb.cellphoneEt)
        appendRadioGroup("Gênero", amb.genderRg)
        appendEditText("Data de nascimento", amb.birthdayEt)
        appendSpinner("Grau de escolaridade", amb.degreeSp)
        appendEditText("Ano do grau", amb.degreeYearEt)
        appendEditText("Ano de graduação", amb.yearOfGraduationEt)
        appendEditText("Instituição", amb.institutionEt)
        appendEditText("Ano de conclusão", amb.yearOfCompletionEt)
        appendEditText("Título da tese", amb.thesisTitleEt)
        appendEditText("Nome da instituição", amb.institutionNameEt)
        appendEditText("Orientador", amb.advisorEt)
        appendEditText("Vaga de interesse", amb.jobOfInterestEt)

        AlertDialog.Builder(this)
            .setTitle("Informacoes")
            .setMessage(builder.toString())
            .setPositiveButton("OK", null)
            .show()
    }




}