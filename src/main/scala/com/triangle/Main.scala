package com.triangle

import cats.implicits.toShow
import com.triangle.domain._

object Main extends App {

  if(args.isEmpty) {
    println("Please, specify file with the data first")
    System.exit(1)
  }

  val filePath = args.head

  //TODO Move to another service
  TriangleLoader.loadFromFile(filePath) match {
    case Right(triangle) =>
      val minimalPath: MinimalPath = TriangleService.live.getMinimalPath(triangle)
      //TODO logging instead of println
      println(s"Minimal path is: ${minimalPath.show}")
    case Left(value) =>
      println(s"Can't load data from file($filePath): $value")
      System.exit(1)
  }
}
