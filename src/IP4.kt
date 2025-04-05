fun main(){
    val valid :String="1.1.2.3"
    check(
        name =" THIS IS VALID IPV4",
        result = ipvChecker(valid),
        second = true
    )

    val invalidIncreaseDots :String="0..1.2.3"
    check(
        name =" THIS IS invalidIncreaseDots IPV4",
        result = ipvChecker(invalidIncreaseDots),
        second = false
    )

    val invalidDecreaseDots :String="01.2.3"
    check(
        name =" THIS IS invalidDecreaseDots IPV4",
        result = ipvChecker(invalidDecreaseDots),
        second = false
    )

    val invalidAboveRange :String="0.1000.2.3"
    check(
        name =" THIS IS invalidAboveRange IPV4",
        result = ipvChecker(invalidAboveRange),
        second = false
    )

    val invalidLowerThanRange :String="0.-1000.2.3"
    check(
        name =" THIS IS invalidLowerThanRange IPV4",
        result = ipvChecker(invalidLowerThanRange),
        second = false
    )

    val invalidNumberOfZeros :String="0.0010.2.3"
    check(
        name =" THIS IS invalidNumberOfZeros IPV4",
        result = ipvChecker(invalidNumberOfZeros),
        second = false
    )

    val invalidCharacters :String="0.b.2.3"
    check(
        name =" THIS IS invalidCharacters IPV4",
        result = ipvChecker(invalidCharacters),
        second = false
    )

    val invalidSpecialCharacters :String="0._.2.3"
    check(
        name =" THIS IS invalidSpecialCharacters IPV4",
        result = ipvChecker(invalidSpecialCharacters),
        second = false
    )
}

/**
 * After completing the instructional videos,
 * implement an IPv4 address checker function that determines whether a given string is a valid IPv4 address.
 * An IPv4 address is valid if it consists of four numeric segments, separated by dots (.), where:
 * - Each segment must be a number between 0 and 255, inclusive.
 * - Leading zeros in any segment (e.g., "01" or "001") are not allowed, except for the digit "0" itself.
 * - The address must contain exactly three dots and no extra characters.
 * - The function should return a Boolean value only—true if the input is a valid IPv4 address, and false otherwise.
 *
 * You must follow a Test-Driven Development (TDD) approach while building this function:
 *
 * - Create a check function, follow the tutorial structure, and write comprehensive test cases first without implementing any logic in the checker function. Initially, the function should always return false.
 * - Share your written test cases with your mentor during the daily meeting for review and feedback.
 * Once approved, begin implementing the logic of the IPv4 checker function step by step, ensuring that each test passes.
 * - Upon successful implementation, design a complete flowchart to represent the decision-making logic of the function using draw.io.
 */
fun check(name:String, result: Boolean, second:Boolean){
    if (result==second)
        println("Success $name")
    else
        println("Failed $name")
}
fun ipvChecker(result: String):Boolean {
    val parts: List<String> = result.split(".")

    if (parts.size != 4) return false

    for (i in parts) {
        // i cant pass empty string as ipv4
        if (i.isEmpty()) return false

        if (i.any { !it.isDigit() }) return false

      //Check not to start with 00 or 01
        if (i.length > 1 && i.startsWith("0")) return false

        //check if it in range
        val num = i.toIntOrNull() ?: return false
        if (num !in 0..255) return false

    }

    return true
}
