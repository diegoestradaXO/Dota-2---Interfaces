import Behaviors.Narrator
import Game.*

fun getMenu(hasTowersAlive: Boolean):String{
    var menu = ""
    if(hasTowersAlive){
        menu = "MENU:\n" +
                "1.Ocurrieron muertes\n" +
                "2.Matan torres\n"
    }else{
        menu = "MENU:\n" +
                "1.Ocurrieron muertes\n" +
                "2.Matan torres\n" +
                "3.Matan Ancient"
    }
    return menu
}

fun main(args: Array<String>) {
    //Creando heroes
    val availableHeroes = ArrayList<Hero>(arrayListOf(
    Hero("Abaddon", "Strength"),
    Hero("Beastmaster", "Strength"),
    Hero("Doom", "Strength"),
    Hero("Huskar", "Strength"),
    Hero("Lycan", "Strength"),
    Hero("Spectre", "Strength"),
    Hero("Abaddon", "Strength"),
    Hero("Bane", "Intelligence"),
    Hero("Invoker", "Intelligence"),
    Hero("Necrophos", "Intelligence"),
    Hero("Lich", "Intelligence"),
    Hero("Disruptor", "Intelligence"),
    Hero("Enchantress", "Intelligence"),
    Hero("Oracle", "Intelligence"),
    Hero("Brood  Mother", "Agility"),
    Hero("Blood Seeker", "Agility"),
    Hero("Clinkz", "Agility"),
    Hero("Luna", "Agility"),
    Hero("Medusa", "Agility"),
    Hero("Meepo", "Agility")
    ))
    //Creando elementos basicos del juego
    val radiantHeroes = ArrayList<Hero>()
    val direHeroes = ArrayList<Hero>()
    //Proceso de seleccion
    var direSelecting = false
    do {
        if (direSelecting){
            println("Seleccion de heroes Dire------")
            availableHeroes.forEachIndexed { index, heroe -> println("${index + 1}. ${heroe.name}, Tipo: ${heroe.type}") }
            println("Selecciona un heroe de la lista...")
            val indexOfHeroSelected = readLine()!!.toInt() - 1
            direHeroes.add(availableHeroes[indexOfHeroSelected])
            availableHeroes.removeAt(indexOfHeroSelected)
        }
        if (!direSelecting){
            println("Seleccion de Heroes Radiant--------")
            availableHeroes.forEachIndexed { index, heroe -> println("${index + 1}. ${heroe.name}, Tipo: ${heroe.type}") }
            println("Selecciona un heroe de la lista...")
            val indexOfHeroSelected = readLine()!!.toInt() - 1
            radiantHeroes.add(availableHeroes[indexOfHeroSelected])
            availableHeroes.removeAt(indexOfHeroSelected)
        }

    }while(availableHeroes.size > 10)
    //Creacion de los equipos y agregacion al juego
    val myNarrator = StanLee()
    val direTeam = Team(direHeroes)
    val radiantTeam = Team(radiantHeroes)
    val myGame = Game<Narrator>(myNarrator, radiantTeam,direTeam,2)
    //Empezar el ciclo principal del juego
    var hasTowersAlive = true
    do {
        //imprimir menu
        println(getMenu(hasTowersAlive))
        val option = readLine()!!.toInt()
        when(option){
            1->{//Matan a un heroe
                println("Fue Radiant quien mato? si/no:")
                val answer = readLine()!!.toString()
                //Si fue una kill del equipo Radiant, pregunta cuantas e imprime las frases correspondientes
                if (answer == "si"){
                    println("Cuantas muertes? (0-5)")
                    val numKills = readLine()!!.toInt()
                    when(numKills){
                        1->{
                            println(myGame.singleKill(false))
                        }
                        in 2..4->{
                            println(myGame.twoOrMoreKills(false,numKills))
                        }
                        5->{
                            println(myGame.pentaKill(false))
                        }
                    }
                }
                else if (answer == "no"){
                    //Si fue una kill del equipo Dire, pregunta cuantas e imprime las frases correspondientes
                    println("Cuantas muertes? (0-5)")
                    val numKills = readLine()!!.toInt()
                    when(numKills){
                        1->{
                            println(myGame.singleKill(true))
                        }
                        in 2..4->{
                            println(myGame.twoOrMoreKills(true,numKills))
                        }
                        5->{
                            println(myGame.pentaKill(true))
                        }
                    }
                }
            }
            2->{
                //Matan Torres
                println("Fue Radiant quien mato? si/no:")
                val answer = readLine()!!.toString()
                if(answer == "si"){
                    //Verificar que aun existan torres en el arraylist
                    if(myGame.direTeam!!.towers.isEmpty() == false){
                        println(myGame.killTower(false))
                    }else{
                        println("Ya no quedan torres en este equipo!")
                    }
                }
                else if (answer == "no"){
                    //Verificar que aun existan torres en el arraylist
                    if(myGame.direTeam!!.towers.isEmpty() == false){
                        println(myGame.killTower(true))
                    }else{
                        println("Ya no quedan torres en este equipo!")
                    }
                }
                //En caso de no haber torres para cualquiera de los dos equipos, se mostrara el otro menu
             if (myGame.direTeam!!.towers.size == 0 ||  myGame.radiantTeam!!.towers.size == 0){
                hasTowersAlive = !hasTowersAlive
             }
            }
            3->{
                //Matar al ancient
                println("Fue Radiant quien mato? si/no:")
                val answer = readLine()!!.toString()
                if (answer == "si"){
                    //verificar que ya no existan torres para poder matar al ancient
                    if(myGame.direTeam!!.towers.isEmpty() == true){
                        println(myGame.ancientKilled(false))
                    }else{
                        println("Alto ahi! el equipo aun tiene torres vivas")
                    }
                }
                else if (answer == "no"){
                    if(myGame.radiantTeam!!.towers.isEmpty() == true){
                        println(myGame.ancientKilled(true))
                    }else{
                        println("Alto ahi! el equipo aun tiene torres vivas")
                    }
                }
            }
        }

    }while (myGame.winIndicator == 2)
}