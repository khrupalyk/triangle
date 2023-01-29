package com.triangle

import org.scalatest.funsuite.AnyFunSuite

class MinimumTriangleTest extends AnyFunSuite {

  def minTriangle(data: Array[Array[Int]]): Int = {

    def process(tree: Array[Array[Int]], i: Int, j: Int): Int = {

      if(tree.length == i) return 0

      val node = tree(i)(j) + Math.min(process(tree, i + 1, j), process(tree, i + 1, j + 1))

      node

    }

    process(data, 0, 0)
  }


  test("first test") {
    val data = Array(
         Array(7),
        Array(6,3),
       Array(3,8,5),
      Array(11,2,10,9)
    )

    assert(minTriangle(data) == 18)


    val data2 = Array(
         Array(7),
        Array(6, 3),
       Array(3, 8, 5),
      Array(11, 12, 10, 9)
    )

    assert(minTriangle(data2) == 24)
  }

}
