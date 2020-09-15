import kotlin.system.exitProcess

data class dsmith(var scode: Int, var sname: String?)
data class dsmithitems(var scode: Int, var spurity: Float, var sgoldstock: Float)

var smithitems = arrayListOf<dsmithitems>()
var smiths = arrayListOf<dsmith>()


fun main() {
    smith()
}


fun smith() {
    do {
        println("1.Add smith\n2.View smith\n3.Remove smith\n4.Transactions\n5.Main menu\n6.Exit")
        var sm = readLine()!!.toInt()
        when (sm) {
            1 -> addsmith()
            2 -> dealsmith()
            3 -> removesmith()
            4 -> transactions()
            5 -> home()
            6 -> {
                println("****Exit****")
                exitProcess(0)
            }
            else -> println("INVALID Option")

        }

    } while (sm != 6)
}


//add smith
fun addsmith() {

    println("Enter The Details")
    println("Code")
    var scode = readLine()!!.toInt()
    println("Name")
    var sname = readLine()
    smiths.add(dsmith(scode, sname))
    println("${sname} added as a smith")

}

//smith view controll
fun dealsmith() {
    do {
        println("1.View Smith\n2.View Smith Stock\n3.Back\n4.Main menu\n5.Exit")
        var desm = readLine()!!.toInt()
        when (desm) {
            1 -> viewsmith()
            2 -> viewsmithstock()
            3 -> smith()
            4 -> home()
            5 -> {
                println("****Exit****")
                exitProcess(0)
            }
            else -> {
                print("INVALID OPTION")
            }
        }
    } while (desm != 5)
}

//smith stock view
fun viewsmithstock() {
    var vflag = 1
    if (smithitems.isEmpty()) {
        println("No Records")
        return
    }
    println("Enter The SCODE")
    var tscode = readLine()!!.toInt()
    for (item in smithitems) {
        if (item.scode == tscode) {
            println("Purity=${item.spurity}k Quantity=${item.sgoldstock}")
            vflag = 0
        }

    }
    if (vflag == 1) {
        println("No Records")
    }

}

//view smith
fun viewsmith() {
    if (smiths.isEmpty()) {
        println("Empty. Add atleast one smith")
    }
    for (smith in smiths) {
        println("Code=${smith.scode} Name=${smith.sname}")

    }
}

//remove smith
fun removesmith() {
    if (smiths.isEmpty()) {
        println("No Records")
        return
    }
    println("Enter the smith code")
    var stcode = readLine()!!.toInt()
    var i = 0
    for (smith in smiths) {
        if (smith.scode == stcode) {
            smiths.removeAt(i)
            println("${smith.sname} removed successfully")
            break
        }
        i++
    }
}


//Transaction Area
fun transactions() {
    if (smiths.isEmpty()) {
        println("First Add Smith")
        return
    }
    do {

        println("1.Give gold\n2.Return gold\n3.Back\n4.Main menu\n5.Exit")
        var smt = readLine()!!.toInt()

        when (smt) {
            1 -> smithto()
            2 -> smithfrom()
            3 -> smith()
            4 -> home()
            5 -> {
                println("****Exit****")
                exitProcess(0)
            }
        }

    } while (smt != 5)
}

//give gold to the smith
fun smithto() {
    var sflag = 1
    println("Enter The SCODE")
    var stcode = readLine()!!.toInt()
    for (smith in smiths) {
        if (smith.scode == stcode) {
            println("Enter the weight of gold in GRAM")
            var smgw = readLine()!!.toFloat()
            println("Purity of gold in KARAT")
            var smpu = readLine()!!.toFloat()
            for (smithitem in smithitems) {
                if (smithitem.scode == stcode && smithitem.spurity == smpu) {
                    smithitem.sgoldstock += smgw
                    sflag = 0
                    break
                }

            }
            if (sflag == 1) {
                smithitems.add(dsmithitems(stcode, smpu, smgw))

            }
            if (goldstocks.isNotEmpty()) {
                for (golditems in goldstocks) {
                    if (golditems.gpurity == smpu) {
                        golditems.gquantity -= smgw
                    }
                }
            }


        } else {
            println("Invalid SCODE")
        }
    }

}


//receive gold from smith
fun smithfrom() {
    var outflag = 1
    println("Enter The SCODE")
    var stcode = readLine()!!.toInt()
    for (smith in smiths) {
        if (smith.scode == stcode) {
            outflag = 0
        }
    }
    if (outflag == 1) {
        return
    }
    addsmstock()

}

//from smith to stock
fun addsmstock() {
    var smpflag = 1
    println("Product code")
    var smpcode = readLine()
    for (fresh in mainstocks) {
        if (fresh.scode == smpcode) {
            println("Wholesale rate of 1 Gram 24k Gold ")
            var hsrate = readLine()!!.toFloat()
            println("The Quantity In Nos")
            var hsquantity = readLine()!!.toInt()
            var hsamount = hsrate * (fresh.spurity / 24) * hsquantity * fresh.sweight
            fresh.squantity += hsquantity
            fresh.sprice += hsrate
            println("Updated the ${fresh.sname} stock")
            smpflag = 0
            break
        }
    }
    if (smpflag == 1) {
        println("Product name")
        var smpname = readLine()

        println("Wholesale rate of 1 Gram 24k Gold ")
        var smprate = readLine()!!.toFloat()

        println("Purity in KARATS ")
        var smppurity = readLine()!!.toFloat()

        if (smppurity > 24.00) {
            throw PurityException("Enter The Correct Value")
        }

        println("The wight in gram")
        var smpweight = readLine()!!.toFloat()

        println("The Quantity In Nos")
        var smpquantity = readLine()!!.toInt()

        var hsamount = smprate * (smppurity / 24) * smpweight * smpquantity


        mainstocks.add(dstock(smpcode, smpname, smppurity, smpweight, smpquantity, hsamount))
        println("Added $smpname into stock")
    }

}
