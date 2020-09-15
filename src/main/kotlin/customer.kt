import kotlin.math.E
import kotlin.system.exitProcess

data class customer(var ccode: String?, var name: String)

data class cusomer_purchase(
    var ccode: String,
    var scode: String?,
    var sname: String?,
    var spurity: Float,
    var sweight: Float,
    var squantity: Int,
    var sprice: Float
)

var customers = arrayListOf<customer>()
var customerlist = arrayListOf<cusomer_purchase>()

fun main() {
    customer()
}

fun customer() {
    println("Rate of 1 Gram 24k Gold")
    var goldrate = readLine()!!.toFloat()
    do {
        println("1.Add customer\n2.View customer\n3.Sell gold\n4.Remove customer\n5.Main menu\n6.Exit")
        var cust = readLine()!!.toInt()
        when (cust) {
            1 -> addcustomer()
            2 -> viewcustomer()
            3 -> sellgold(goldrate)
            4 -> removecust()
            5 -> home()
            6 -> {
                println("****Exit****")
                exitProcess(0)
            }
            else -> {
                println("Invalid Option")
            }
        }
    } while (cust != 6)
}

//remove customer
fun removecust() {
    var temp = ""
    if (customers.isEmpty()) {
        println("Add minimum customer")
        return
    }
    println("     Customers    ")
    viewcustomer()
    println("Enter Customer CODE")
    var tcode = readLine()
    println(tcode)
    var i = 0
    for (cust in customers) {
        if (cust.ccode == tcode) {
            temp = cust.name
            customers.removeAt(i)
            break
        }
        i++
    }
    println("$temp was removed from list")

}

//purchase list
fun sellgold(rate: Float) {
    if (customers.isEmpty()) {
        println("Add minimum customer")
        return
    }
    if (mainstocks.isEmpty()) {
        println("Nothing In The Stock")
        return
    }
    println("     Customers    ")
    viewcustomer()
    println("Enter Customer CODE")
    var tcode = readLine()!!.toInt()

    view_item_stock()

}

//customer view
fun viewcustomer() {
    if (customers.isEmpty())
        return
    for (customer in customers) {
        println("Code=${customer.ccode} Name=${customer.name}")
    }

}

//add customer
fun addcustomer() {
    println("Enter The Details")
    println("Code")
    var cucode = readLine()
    println("Name")
    var cusname = readLine()!!.toString()
    customers.add(customer(cucode, cusname))

}

//stock view function
fun view_item_stock() {
    for (element in mainstocks) {
        println("Code=${element.scode} Purity=${element.spurity} Quantity=${element.squantity} Weight=${element.sweight}")
    }
}