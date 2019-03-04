package com.serverless

data class IsPalindromeResponse(val message: String = "", val input: Map<String, Any>) : Response() {
    public fun isPalindrome (): String {
        var string: String = ""
        input.forEach{ string += it.value.toString().toLowerCase() }
        val reverse = string.split("").asReversed().joinToString("")
        if (string == reverse) return "${string} is a Palindrome" else return "${string} is not a Palindrome"
    }
}
