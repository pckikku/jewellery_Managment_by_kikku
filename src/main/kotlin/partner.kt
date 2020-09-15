import kotlin.system.exitProcess

data class dpartner(var pcode: String?, var pname: String?, var pmoney: Int)


var total_investment = +0.0
var partners = arrayListOf<dpartner>()


fun main() {
    partner()
}

fun partner() {
    do {
        println("1.Add Partner\n2.Edit Partner\n3.View Partners\n4.Total Investment\n5.Main Menu\n6.Exit\nEnter Your Choise")
        var p = readLine()!!.toInt()

        when (p) {
            1 -> addpartner()
            2 -> {
                println("Enter The Code Of Partner")
                var pdcode = readLine()
                editpartner(pdcode)
            }
            3 -> viewpartners()
            4 -> println("Total Investment = $total_investment")
            5 -> home()
            6 -> {
                println("****Exit****")
                exitProcess(0)
            }
            else -> {
                println("INVALID OPTION")
                home()
            }

        }
    } while (p != 5)

}


//add partners
fun addpartner() {
    println("Enter The Details")
    println("Code")
    var pcode = readLine()
    println("Name")
    var pname = readLine()
    println("Investment")
    var pmoney = readLine()!!.toInt()
    total_investment = total_investment + pmoney
    partners.add(dpartner(pcode, pname, pmoney))
    println("Added $pname as a PARTNER")

}

//display partners
fun viewpartners() {
    for (element in partners) {
        print("${element.pcode} ${element.pname} ${element.pmoney}\n")
    }

}


//edit partner

fun editpartner(pdcode: String?) {


    do {
        println(" 1.Alter Investment\n 2.Delete Partner\n 3.Go Back\n 4.Main menu\n 5.Exit\n Enter Your Choise")
        var delp = readLine()!!.toInt()

        when (delp) {
            1 -> altermoney(pdcode)
            2 -> delpartner(pdcode)
            3 -> partner()
            4 -> home()
            5 -> {
                println("****Exit****")
                exitProcess(0)

            }
        }

    } while (pdcode != null)
}

fun delpartner(pdcode: String?) {
    for (element in partners) {
        if (element.pcode == pdcode) {
            var love = partners.removeAt(partners.indexOf(element))
            return
        }
    }
}

fun altermoney(pdcode: String?) {
    println("Enter The Amount")
    var amount = readLine()!!.toInt()
    println("1.Increment\n2.Decriment\n Enter your choice")
    var choice = readLine()!!.toInt()
    if (choice == 1) {
        for (element in partners) {
            if (element.pcode == pdcode) {
                element.pmoney = element.pmoney + amount
                return
            }
        }
    } else if (choice == 2) {
        for (element in partners) {
            if (element.pcode == pdcode) {
                element.pmoney = element.pmoney - amount
                return
            }
        }
    } else {
        print("Invalid Option")
        altermoney(pdcode)
    }


}
