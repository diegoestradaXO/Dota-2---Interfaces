package Game

import Behaviors.Narrator

class Game<T>(val narrator: T,
              var radiantTeam: Team?,
              var direTeam: Team?,
              var winIndicator: Int)where T: Narrator {
    private fun narratePhrase(narrator: Narrator, type: String):String{
        return narrator.narrate(type)
    }
    fun welcome(): String{
        val answer = narratePhrase(narrator, "welcome")
        return answer
    }
    fun startGame():String{
        val answer = narratePhrase(narrator, "startGame")
        return answer
    }
    fun singleKill(direKill: Boolean):String{
        if(direKill == true){
            radiantTeam!!.heroes.removeAt(0)
        }else{
            direTeam!!.heroes.removeAt(0)
        }
        val answer = narratePhrase(narrator, "singleKill")
        return answer
    }
    fun twoOrMoreKills(direKill: Boolean, numKills: Int):String{
        if(direKill == true){
            for(i in 1 until numKills){
                radiantTeam!!.heroes.removeAt(0)
            }
        }else{
            for(i in 1 until numKills){
                direTeam!!.heroes.removeAt(0)
            }
        }
        val answer = narratePhrase(narrator, "twoOrMoreKills")
        return answer
    }
    fun pentaKill(direKill: Boolean):String{
        if(direKill == true){
            for(i in 1 until 6){
                radiantTeam!!.heroes.removeAt(0)
            }
        }else{
            for(i in 1 until 6){
                direTeam!!.heroes.removeAt(0)
            }
        }
        val answer = narratePhrase(narrator, "pentaKill")
        return answer
    }
    fun killTower(direKill: Boolean):String{
        if(direKill){
            radiantTeam!!.towers.removeAt(0)
        }else{
            direTeam!!.towers.removeAt(0)
        }
        val answer = narratePhrase(narrator, "killTower")
        return answer
    }
    fun ancientKilled(direKill: Boolean): String{
        if (direKill){
            radiantTeam!!.ancient.isDead = true
            winIndicator = 0
            return narratePhrase(narrator,"direWins")
        }else {
            direTeam!!.ancient.isDead = true
            winIndicator = 1
            return narratePhrase(narrator, "radiantWins")
        }

    }

}