package Game

class Team(
        val heroes: ArrayList<Hero>){
    val towers = ArrayList<Tower>()
    val ancient = Ancient()

    init {
        val tower = Tower()
        for(i in 1 until 6){
            towers.add(tower)
        }
    }
}