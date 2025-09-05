package br.edu.ifsp.scl.ads.prdm.sc3033945.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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


}