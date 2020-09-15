import kotlin.system.exitProcess

data class dstock(
    var scode: String?,
    var sname: String?,
    var spurity: Float,
    var sweight: Float,
    var squantity: Int,
    var sprice: Float
)

data class dgoldstock(var gcode: Int, var gpurity: Float, var gquantity: Float, var gprice: Float)

var goldstocks = arrayListOf<dgoldstock>()
var mainstocks = arrayListOf<dstock>()
var gcode = 100
var pflag = 1


class PurityException(message: String) : Exception(message)

fun main() {
    wholsale()
}

fun wholsale() {
    do {
        println("1.Gold\n2.Products\n3.Main Menu\n4.Exit\nEnter Your Choise")
        var wh = readLine()!!.toInt()
        when (wh) {
            1 -> tgold()
            2 -> tpstock()
            3 -> home()
            4 -> {
                println("****Exit****")
                exitProcess(0)
            }
            else -> {
                println("INVALID OPTION")
            }
        }
    } while (wh != 4)
}


fun tgold() {
    do {
        println("1.Gold purchase\n2.Gold stock\n3.Back\n4.Main menu\n5.Exit\nEnter your choice")
        var tg = readLine()!!.toInt()
        when (tg) {
            1 -> fgpurchase()
            2 -> tgoldstock()
            3 -> wholsale()
            4 -> home()
            5 -> {
                println("****Exit****")
                exitProcess(0)
            }
            else -> {
                println("INVALID OPTION")
            }

        }

    } while (tg != 5)
}

fun fgpurchase() {
    var gflag = 1
    println("Wholesale rate of 1 Gram 24k Gold ")
    var whrate = readLine()!!.toFloat()
    println("Purity in KARATS ")
    var whpurity = readLine()!!.toFloat()
    for (element in goldstocks) {
        if (element.gpurity == whpurity) {

            println("The wight in gram")
            var whweight = readLine()!!.toFloat()
            var whamount = whrate * (whpurity / 24) * whweight
            total_investment -= whamount
            println("The amount payed = $whamount")
            element.gquantity += whweight
            element.gprice += whamount
            println("${element.gpurity} Karat Stock updated")
            gflag = 0
            break
        }
    }

    if (gflag == 1) {

        if (whpurity > 24.00) {
            throw PurityException("Enter The Correct Value")
        }

        println("The wight in gram")
        var whweight = readLine()!!.toFloat()

        var whamount = whrate * (whpurity / 24) * whweight
        total_investment = total_investment - whamount
        println("The amount payed = $whamount")

        goldstocks.add(dgoldstock(gcode, whpurity, whweight, whamount))
        println("Added $whweight gram gold")
        gcode++
    }


}

fun tgoldstock() {
    if (goldstocks.isEmpty()) {
        println("There is nothing in the stock")
    } else {
        for (element in goldstocks) {
            print("Code=${element.gcode} Purity=${element.gpurity} Quantity=${element.gquantity} Price=${element.gprice}\n")
        }
    }
}

fun tpstock() {
    do {
        println("1.Add stock\n2.Total stock\n3.Back\n4.Main Menu\n5.Exit\nEnter your choice")
        var tg = readLine()!!.toInt()
        when (tg) {
            1 -> addpstock()
            2 -> viewpstock()
            3 -> wholsale()
            4 -> home()
            5 -> {
                println("****Exit****")
                exitProcess(0)
            }
            else -> {
                println("INVALID OPTION")
            }

        }

    } while (tg != 5)


}

fun addpstock() {
    println("Product code")
    var hscode = readLine()
    for (fresh in mainstocks) {
        if (fresh.scode == hscode) {
            pflag = 0
            break
        }
    }
    if (pflag == 1) {
        println("Product name")
        var hsname = readLine()

        println("Wholesale rate of 1 Gram 24k Gold ")
        var hsrate = readLine()!!.toFloat()

        println("Purity in KARATS ")
        var hspurity = readLine()!!.toFloat()

        if (hspurity > 24.00) {
            throw PurityException("Enter The Correct Value")
        }

        println("The wight in gram")
        var hsweight = readLine()!!.toFloat()

        println("The Quantity In Nos")
        var hsquantity = readLine()!!.toInt()

        var hsamount = hsrate * (hspurity / 24) * hsweight * hsquantity
        total_investment = total_investment - hsamount
        println("The amount payed = $hsamount")

        mainstocks.add(dstock(hscode, hsname, hspurity, hsweight, hsquantity, hsamount))
        println("Added $hsname into stock")
    } else {
        println("Wholesale rate of 1 Gram 24k Gold ")
        var hsrate = readLine()!!.toFloat()
        println("The Quantity In Nos")
        var hsquantity = readLine()!!.toInt()
        for (element in mainstocks) {
            if (element.scode == hscode) {
                var hsamount = hsrate * (element.spurity / 24) * hsquantity * element.sweight
                total_investment = total_investment - hsamount
                println("The amount payed = $hsamount")
                element.squantity += hsquantity
                element.sprice += hsrate
                println("Updated the ${element.sname} stock")
                break
            }
        }

    }


}

//view wholesale stock
fun viewpstock() {
    if (mainstocks.isEmpty()) {
        println("There is nothing in the stock")
    } else {
        for (element in mainstocks) {
            print(
                "Code=${element.scode} " +
                        "Name=${element.sname} " +
                        "Purity=${element.spurity} " +
                        "Quantity=${element.squantity} " +
                        "Weight=${element.sweight} " +
                        "Price=${element.sprice}" +
                        "\n"
            )
        }
    }
}

