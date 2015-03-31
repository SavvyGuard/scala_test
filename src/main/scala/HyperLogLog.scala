import scala.util.hashing.MurmurHash3
import scala.math
import scala.collection.mutable

object HyperLogLog{
    var ValueQueue = mutable.Queue(
        "James Wu",
        "Michael Allman",
        "Walter Mazza",
        "Dave Gullo",
        "Deb Ray",
        "Kenny Rogers",
        "Corey",
        "Stan",
        "Bill",
        "Jenny Luke",
        "Dylan",
        "Leo",
        "Ken",
        "Michelle"
    )

    var maxZeros = 0
    def getLeadingZeros(number: Int): Int = {
        var newNumber = 0
        if (number < 0) {
            newNumber = math.abs(number)
        }
        else {
            newNumber = number
        }
        var zeros = Integer.numberOfLeadingZeros(newNumber)
        return zeros
    }
    def count(leadingZeros: Int): Int = {
        return math.pow(2.0, leadingZeros.toDouble).toInt
    }

    def getCount(term: String): Unit = {
        val leadingZeros = getLeadingZeros(MurmurHash3.stringHash(term))
        if (maxZeros < leadingZeros) {
            maxZeros = leadingZeros
        }
    }

    def main(args: Array[String]) = {
        ValueQueue.foreach(
            println
        )
        ValueQueue.foreach(
            getCount
        )
        println(count(maxZeros))
    }
}

