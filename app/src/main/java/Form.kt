class Form (
    val name: String,
    val email: String,
    val wantsAtt: Boolean,
    val phoneType: String,
    val phone: String,
    val celPhone: String,
    val gender: String,
    val birthDate: String,
    val education: String,
    val graduationYear: String,
    val completionYear: String,
    val institution: String,
    val thesisTitle: String,
    val advisorTitle: String,
    val vacanciesOfInterests: String
){
    override fun toString(): String {
        return """
            Nome: $name
            Email: $email
            Deseja atualizações?: $wantsAtt
            Tipo de telefone: $phoneType
            Número de telefone: $phone
            Celular: $celPhone
            Genero: $gender
            Data de nascimento: $birthDate
            Nível de Educação: $education
            Ano da Formação: $graduationYear
            Ano de conclusao: $completionYear
            Instituicao: $institution
            título de monografia: $thesisTitle
            título de orientador: $advisorTitle
            Job Interests: $vacanciesOfInterests
        """.trimIndent()
    }
}