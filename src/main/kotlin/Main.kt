import kotlin.reflect.typeOf
import kotlin.system.exitProcess


fun main() {
    home()
}

fun home() {
    do {
        println("1.Partners\n2.Wholsale\n3.Smith\n4.Stock\n5.Customer\n6.Exit\nEnter Your Choise")
        var x = readLine()?.toInt()

        when (x) {
            1 -> partner()
            2 -> wholsale()
            3 -> smith()
            5 -> customer()
            6 -> {
                println("****Exit****")
                exitProcess(0)
            }
            else -> {
                println("INVALID OPTION")
                home()
            }

        }

    } while (x != 6)


}


