# first-service
This program is a simple palindrome service.
It is also an example of a lambda function in AWS.

It follows the following How-tos:

Creating a Serverless Framework project
https://serverless.com/framework/docs/providers/aws/guide/services/

Using Kotlin in a Serverless Architecture with AWS Lambda
https://medium.com/tech-travelstart/using-kotlin-in-a-serverless-architecture-with-aws-lambda-part-1-setting-up-the-project-87033790e2f4

Installing the AWS SAM CLI on macOS
https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install-mac.html

AWS Command Line Interface
https://docs.aws.amazon.com/cli/latest/userguide/cli-usage-output.html

Controlling Command Output from the AWS CLI
https://docs.aws.amazon.com/cli/latest/userguide/cli-usage-output.html

Creating a Deployment Package
https://docs.aws.amazon.com/lambda/latest/dg/deployment-package-v2.html

Using AWS Lambda with the AWS Command Line Interface
https://docs.aws.amazon.com/lambda/latest/dg/with-userapp.html

To Configure to AWS CLI: aws configure
    Use this to:
    1) set the region
    2) AWS Access and Private keys
    3) set the output format (json, text, or table - all in lowercase)

To Build and run from command line:
  kotlinc src/main -include-runtime -cp /Users/jameswalbersheim/.gradle/caches/modules-2/files-2.1/com.amazonaws/aws-lambda-java-core/1.1.0/b25d4345c6e9e8be78b2803dd43d812f15178a81/aws-lambda-java-core-1.1.0.jar:/Users/jameswalbersheim/.gradle/caches/modules-2/files-2.1/com.amazonaws/aws-lambda-java-events/2.0.1/e659377879a4a7317398b11df269d974f2ed9710/aws-lambda-java-events-2.0.1.jar:/Users/jameswalbersheim/.gradle/caches/modules-2/files-2.1/com.amazonaws/aws-lambda-java-log4j2/1.0.0/3e0b193d254c89acafd6885aa8ba32262a96edb8/aws-lambda-java-log4j2-1.0.0.jar:/Users/jameswalbersheim/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-annotations/2.8.5/9d82ff47bc2c2d3b5b6a6618fe636782bbcd5b07/jackson-annotations-2.8.5.jar:/Users/jameswalbersheim/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-core/2.8.5/60d059f5d2930ccd1ef03535b713fd9f933d1ba7/jackson-core-2.8.5.jar:/Users/jameswalbersheim/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-databind/2.8.5/b3035f37e674c04dafe36a660c3815cc59f764e2/jackson-databind-2.8.5.jar:/Users/jameswalbersheim/.gradle/caches/modules-2/files-2.1/joda-time/joda-time/2.6/5015880733b0bc0ce813a3ed5601064c1d413671/joda-time-2.6.jar:/Users/jameswalbersheim/.gradle/caches/modules-2/files-2.1/junit/junit/4.12/2973d150c0dc1fefe998f834810d68f278ea58ec/junit-4.12.jar:/Users/jameswalbersheim/.gradle/caches/modules-2/files-2.1/org.apache.logging.log4j/log4j-api/2.8.2/e590eeb783348ce8ddef205b82127f9084d82bf3/log4j-api-2.8.2.jar:/Users/jameswalbersheim/.gradle/caches/modules-2/files-2.1/org.apache.logging.log4j/log4j-core/2.8.2/979fc0cf8460302e4ffbfe38c1b66a99450b0bb7/log4j-core-2.8.2.jar:build/libs/isPalindrome-dev.jar -d first.jar
  java -jar first.jar "able was i ere i saw elba"

To Build and Deploy to AWS: ./gradlew clean deploy

To Invoke (example): aws lambda invoke --function-name first-service-dev-isPalindrome --log-type Tail
     --payload '{"input1":"Able was i ere i saw elba"}' output.txt

To see result from AWS: more output.txt

To Test in AWS, go to Services->Lambda->Functions, and click first-service-dev-isPalindrome
Click 1stPalindromeTest->Configure test events, Select 'Edit saved test events' or 'Create new test event'
Enter the following:
{
    "1":"Able was I ere I saw Elba"
}
Click Save, then click Test
Click log details to see result