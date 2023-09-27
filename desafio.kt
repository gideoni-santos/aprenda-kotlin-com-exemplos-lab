// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
// [Template deste codigo no Playground]https://pl.kotl.in/Ao184-4xO

enum class Nivel { INICIANTE, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome:String, val id:Long)

data class ConteudoEducacional(val nome: String, val stack:String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel:Nivel ) {
    val inscritos = mutableListOf<Usuario>()

    infix fun matricular(usuario: Usuario) { inscritos.add(usuario) }

    fun matricular(vararg usuarios: Usuario){
        for(usuario in usuarios)
            inscritos.add(usuario)
    }

    fun mostrarConteudos(){
        for(conteudo in conteudos)
            println(conteudo.nome)
    }

    fun mostrarInscritos(){
        for(inscrito in inscritos)
            println(inscrito.nome)
    }
}

fun main() {
    //criando os usuarios
    val gideoni = Usuario("Gideoni",1L)
    val falvo = Usuario("Falvo",2L)
    val ana = Usuario("Ana",3L)

    //criando a lista de conteudos da formacao de Kotlin
    val listaConteudosKotlin:List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Introdução ao Desenvolvimento Moderno de Software","Kotlin"),
        ConteudoEducacional("Conhecendo o Kotlin e Sua Documentação Oficial","Kotlin"),
        ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin","kotlin"))

    //criando a formacao para Kotlin
    val kotlinExperience = Formacao("Kotlin Experience", listaConteudosKotlin, Nivel.INICIANTE)
    
    //verificando se a variavel de Formacao nao é nula, e se não matricular alunos 
    kotlinExperience?.let{
        kotlinExperience matricular  gideoni
        kotlinExperience.matricular(falvo, ana)
    }

    println("--- Formacao: ${kotlinExperience.nome} ---\n\t\tConteudos:")
    kotlinExperience.mostrarConteudos()
    println("\t\tInscritos:")
    kotlinExperience.mostrarInscritos()
    println("---             ---            ---")
}
