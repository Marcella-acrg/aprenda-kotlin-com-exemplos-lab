// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val matricula: String) {
    override fun toString(): String {
        return "Usuario: $nome | matricula: $matricula"
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int) {
    override fun toString(): String {
        return "Conteudo: $nome | duracao: $duracao"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel)  {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    override fun toString(): String {
        return """
        Formacao: $nome
        Conteudos: $conteudos
        Nivel: $nivel
        Alunos Matriculados: $inscritos
            """.trimIndent()
    }
}

fun geradorMat() : String {
    return (100..1000).random().toString()
}

fun main() {
    val marcella = Usuario("Marcella Araújo", geradorMat())
    val igor = Usuario("Igor Júnior", geradorMat())
    val gilma = Usuario("Gilma Coelho", geradorMat())
    val ana = Usuario("Ana Luísa", geradorMat())

    val conteudoJava = ConteudoEducacional("Java Web crie aplicações usando Spring Boot, Java com Spring, Boas Práticas em Java", 720)
    val conteudoCyberSecurity = ConteudoEducacional("Explorando vulnerabilidades em aplicações web, Investigando vulnerabilidades em um servidor de aplicações web", 240)
    val conteudoCloud = ConteudoEducacional("Amazon S3 - Manipule e armazene objetos na nuvem, Amazon EC2 - Alta disponibilidade e escalabilidade em uma aplicação, Amazon ECS - Gerencie Docker na nuvem da AWS", 180)
    val conteudoBasicoBackEnd = ConteudoEducacional("Logica de programacao, Algoritmo, POO", 60)

    val formacaoJava = Formacao("Java", listOf(conteudoBasicoBackEnd, conteudoJava), Nivel.AVANCADO)
    val formacaoCyberSecurity = Formacao("Cyber Secutity", listOf(conteudoCyberSecurity), Nivel.INTERMEDIARIO)
    val formacaoCloud = Formacao("Cloud AWS", listOf(conteudoCloud), Nivel.AVANCADO)
    val formacaoBasicoBackEnd = Formacao("Desenvolvedor Back-End", listOf(conteudoBasicoBackEnd), Nivel.BASICO)

    formacaoJava.matricular(marcella)
    formacaoBasicoBackEnd.matricular(marcella, igor)
    formacaoCloud.matricular(gilma)
    formacaoCyberSecurity.matricular(ana)

    println("\n**********************************************************************************************************************************************************************************************************\n")
    println(formacaoJava)
    println("\n**********************************************************************************************************************************************************************************************************\n")
    println(formacaoBasicoBackEnd)
    println("\n**********************************************************************************************************************************************************************************************************\n")
    println(formacaoCloud)
    println("\n**********************************************************************************************************************************************************************************************************\n")
    println(formacaoCyberSecurity)

}