package com.triangle

import com.triangle.domain.Triangle

import scala.util.Try

//TODO add abstraction, trait, etc.
object TriangleLoader {
  //TODO better error handling and data validation
  def loadFromFile(fileName: String): Either[String, Triangle] = Try {
    io.Source.fromFile(fileName)
      .getLines()
      .map(_.split(" ").map(_.toInt))
      .toArray
  }.toEither.left.map(_.getMessage)

}
