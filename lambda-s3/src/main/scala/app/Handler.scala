package app

import awscala._, s3._
import awscala.s3._
import awscala.Region

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import org.apache.logging.log4j.{LogManager, Logger}

import scala.jdk.CollectionConverters._



class Handler extends RequestHandler[Request, Response] {

  val logger: Logger = LogManager.getLogger(getClass)

  def handleRequest(input: Request, context: Context): Response = {


    implicit val region = Region.US_EAST_1
    implicit val s3 = S3()
    val buckets: Seq[Bucket] = s3.buckets
    logger.info(s"\n1 buckets: $buckets \n")
    buckets.foreach( elem => println(s"elem=>$elem") )

    val bucket: Bucket = s3.createBucket("prueba2fromlambdafunction")
    logger.info(s"\n2 bucket: $bucket \n")

    // Upload operation of the file example1-file.txt with name example1-uploaded-file.txt
    bucket.put("example1-uploaded-file.txt", new java.io.File("example1-file.txt"))

    val s3obj: Option[S3Object] = bucket.getObject("example1-uploaded-file.txt")
    logger.info(s"\n3 Uploaded: ${s3obj.getOrElse("Empty")} \n")


    logger.info(s"Received a request: $input")
    Response("Go Serverless v1.0!!!!! Your function executed successfully!!", input)
  }
}

class ApiGatewayHandler extends RequestHandler[Request, ApiGatewayResponse] {

  def handleRequest(input: Request, context: Context): ApiGatewayResponse = {
    val headers = Map("x-custom-response-header" -> "my custom response header value")
    ApiGatewayResponse(200, "Go Serverless v1.0! Your function executed successfully!",
      headers.asJava,
      true)
  }
}
