package com.triangle

import org.scalatest.funsuite.AnyFunSuite

class MinimumTriangleTest extends AnyFunSuite {

  def loadData(fileName: String): Array[Array[Int]] = {
    io.Source.fromResource(fileName).getLines().map(_.split(" ").map(_.toInt)).toArray
  }

  def minTriangle(data: Array[Array[Int]]): List[Int] = {

    if(data.length <= 1)
      return data.headOption.map(_.toList).getOrElse(Nil)

    val sums = new Array[Int](data.length)
    val values = new Array[Int](data.length)

    for(i <- sums.indices) {
      sums(i) = data(sums.length - 1)(i)
    }

    var i = data.length - 2

    while (i >= 0) {

      var j = 0
      var prevMinNodeSum = data(i)(j) + sums(j) + sums(j + 1)
      var foundMinValue = 0
      while(j < data(i).length) {
        val nodeSum = data(i)(j) + sums(j) + sums(j + 1)
        if (prevMinNodeSum >= nodeSum) {
          if (sums(j) >= sums(j + 1)) {
            foundMinValue = data(i + 1)(j + 1)
          } else {
            foundMinValue = data(i + 1)(j)
          }
          prevMinNodeSum = nodeSum
        }

        sums(j) = data(i)(j) + Math.min(sums(j), sums(j+1))
        j = j + 1
      }
      values(i+1) = foundMinValue
      i = i - 1
    }

    values(0) = data.head.head
    values.toList
  }


  test("small triangles") {

    val data1 = Array(
      Array(7),
      Array(6, 3),
      Array(3, 8, 5),
      Array(11, 2, 10, 9)
    )

    assert(minTriangle(data1) == List(7, 6, 3, 2))

    val data2 = Array(
      Array(7),
      Array(6, 3),
      Array(3, 8, 5),
      Array(11, 12, 10, 9)
    )

    assert(minTriangle(data2) == List(7, 3, 5, 9))

    val data3 = loadData("tests/data_small.txt")
    assert(minTriangle(data3) == (1 to data3.length).map(_ => 1).toList)
  }

  test("big triangle") {
    val data = loadData("tests/data_big.txt")
    assert(minTriangle(data) == (1 to data.length).map(_ => 1).toList)
  }
}
