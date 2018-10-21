package Game

import Behaviors.*

class StanLee():Narrator{
    override var eventType: String = ""
    override fun narrate(eventType: String):String{
        var answer: String = ""
        when (eventType) {
            "welcome" -> {
                answer = """Sean bienvenidos todos a una partida que promete ser de lo mas interesante!
                    Traigan sus palomitas, figuras de accion, bebidas, mascota o a quien sea, pero esta
                    batalla ESTA POR EMPEZAAAR!
                """.trimIndent()
            }
            "startGame" -> {
                answer = """La partida empieza YAAAAA! Elige sabiamente tus heroes, recuerda
                    "Un gran poder conlleva una gran responsabilidad"
                    Con partidas como estas quisiera nunca retirarme!!!!!
                """.trimMargin()
            }
            "singleKill" -> {
                answer = """EXCLESIOR!!! Una muerte ha ocurrido!!!
                """.trimMargin()
            }
            "twoOrMoreKills" -> {
                answer = """EXCELSIORR!! Muerte múltiple! este equipo no se anda con rodeos eh!
                """.trimMargin()
            }
            "pentaKill" -> {
                answer = """PEEENTA KILLLL! EXCELSIORR!! NO PUEDO CREER LO QUE ESTOY VIENDO!!
                    """.trimMargin()
            }
            "killTower" -> {
                answer = """Cae una torre! tengan mas cuidado, recuerden que para una buena defensa
                    |se necesita de torres! cuidaslas mas
                """.trimMargin()
            }
            "direWins" -> {
                answer = """Increible partida para el equipo Dire! Totalmente merecida la victoria
                    |Se van contentos a casa sin duda alguna
                """.trimMargin()
            }
            "radiantWins" -> {
                answer = """SE ACABO LA BATALLA, RADIAN GANA Y ES CAMPEÓN DE LA TEMPORADA!
                    |""".trimMargin()
            }
        }
        return answer
    }
}