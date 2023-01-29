package com.triangle

import org.scalatest.funspec.AnyFunSpec

class TriangleServiceTest extends AnyFunSpec {

  private val service = TriangleService.live

  //TODO move to other service
  private def loadData(fileName: String): Array[Array[Int]] = {
    io.Source.fromResource(fileName)
      .getLines()
      .map(_.split(" ").map(_.toInt))
      .toArray
  }

  //TODO Add more tests for edge cases, like Array(Array(), Array(), Array())
  describe("TriangleService should calculate a minimal path for") {
    describe("small triangles") {
      val data1 = Array(
        Array(7),
        Array(6, 3),
        Array(3, 8, 5),
        Array(11, 2, 10, 9)
      )

      assert(service.getMinimalPath(data1) == List(7, 6, 3, 2))

      val data2 = Array(
        Array(7),
        Array(6, 3),
        Array(3, 8, 5),
        Array(11, 12, 10, 9)
      )
      assert(service.getMinimalPath(data2) == List(7, 3, 5, 9))

      val data3 = loadData("tests/data_small.txt")
      assert(service.getMinimalPath(data3) == (1 to data3.length).map(_ => 1).toList)
    }

    describe("big triangles") {
      val data = loadData("tests/data_big.txt")
      assert(service.getMinimalPath(data) == (1 to data.length).map(_ => 1).toList)
    }

  }
}
