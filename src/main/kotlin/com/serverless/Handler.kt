package com.serverless

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import org.apache.logging.log4j.LogManager
import java.io.File

fun main(args : Array<String>) {
  val input = if (!args.isEmpty() && args.size>0) args[0] else {System.out.println("Usage: java -jar isPalindrome-dev-all.jar palindrome-candidate");return};
  val map: Map<String, Any> = hashMapOf("1" to input)
  val response = IsPalindromeResponse(input=map)
  println(response.isPalindrome())
}
class Handler:RequestHandler<Map<String, Any>, ApiGatewayResponse> {
  override fun handleRequest(input:Map<String, Any>, context:Context):ApiGatewayResponse {
    LOG.info("received: " + input.keys.toString())
    val result:String = IsPalindromeResponse("",input).isPalindrome()

    return ApiGatewayResponse.build {
      statusCode = 200
      objectBody = IsPalindromeResponse(result, input)
      headers = mapOf("X-Powered-By" to "AWS Lambda & serverless")
    }
  }

  companion object {
    private val LOG = LogManager.getLogger(Handler::class.java)
  }
}
