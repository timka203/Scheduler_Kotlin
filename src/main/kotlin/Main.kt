class Module(val name: String,
             val time: Int,
             val numOfQuestions: Int) {
    val coef :Double = (numOfQuestions / time).toDouble()
}

class Scheduler(private var timeLeft: Int,
                private var modules : MutableList<Module>) {
    private var questionChecked : Int = 0
    private var usedModules = mutableListOf<Module>()

    fun schedule(): Int{
        var usedModule: Module?
        modules.sortBy { m -> m.coef }
        modules.reverse()
        usedModule = modules.firstOrNull { module -> module.time <= timeLeft }
        while  (usedModule != null ) {
            modules.remove(usedModule)
            usedModules.add(usedModule)
            questionChecked += usedModule.numOfQuestions
            timeLeft -= usedModule.time
            usedModule = modules.firstOrNull { module -> module.time <= timeLeft }
        }
        printSchedule()
        return questionChecked
    }

    private fun printSchedule() {
        println("Modules to learn : ${usedModules.size}")
        usedModules.forEach{module -> println("${module.name} Number of questions : ${module.numOfQuestions}")}
        println("Total number of questions : $questionChecked")
        println("Free hours after studying : $timeLeft")
        if (timeLeft > 0 && modules.size > 0) {
            println("Module that could be covered partially: ${modules.first().name}")
        }
    }


}


fun main() {
    println("Hello World!")
    val module1 = Module("test1", 2, 8)
    val module2 = Module("test2", 5, 12)
    val module3 = Module("test3", 5, 13)
    val module4 = Module("test4", 5, 14)
    val module5 = Module("test5", 5, 15)
    val modules = mutableListOf(module2,module1,module3,module5,module4)
    val scheduler = Scheduler(20,modules)
    scheduler.schedule()
}