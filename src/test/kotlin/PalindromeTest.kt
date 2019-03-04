import com.serverless.IsPalindromeResponse
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class PalindromeTest {

    @Test
    fun testGoodPal() {
        val input = "able was i ere i saw elba"
        val response = IsPalindromeResponse(input=hashMapOf("1" to input))
        val expectedResponse = "${input} is a Palindrome"
        val actualResponse = response.isPalindrome()
        assertEquals(expectedResponse, actualResponse)
    }

    @Test
    fun testGoodPalWithCaps() {
        val input = "Able was i ere i saw elba"
        val response = IsPalindromeResponse(input=hashMapOf("1" to input))
        val expectedResponse = "${input}".toLowerCase()+" is a Palindrome"
        val actualResponse = response.isPalindrome()
        assertEquals(expectedResponse, actualResponse)
    }

    @Test
    fun testBadPal() {
        val input = "Now is the time"
        val response = IsPalindromeResponse(input=hashMapOf("1" to input))
        val expectedResponse = "${input} is a Palindrome"
        val actualResponse = response.isPalindrome()
        assertNotEquals(expectedResponse, actualResponse)
    }

}
