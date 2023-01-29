package com.triangle

import org.scalatest.funsuite.AnyFunSuite

class MinimumTriangleTest extends AnyFunSuite {

  type Index = Int

  def minTriangle(data: Array[Array[Int]]): List[Index] = {

    type Sum = Int

    def process(tree: Array[Array[Int]], i: Int, j: Int): (Sum, List[Index]) = {

      if(tree.length == i) return (0, Nil)

      val x1 = process(tree, i + 1, j)
      val x2 = process(tree, i + 1, j + 1)

      val totalSum: Sum = tree(i)(j) + Math.min(x1._1, x2._1)
      val indexes: List[Index] = j :: (if(x1._1 <= x2._1) x1._2 else x2._2)

      (totalSum, indexes)
    }

    val result = process(data, 0, 0)

    result._2.zipWithIndex map { case (j, i) =>
      data(i)(j)
    }
  }


  test("first test") {
    val data = Array(
         Array(7),
        Array(6,3),
       Array(3,8,5),
      Array(11,2,10,9)
    )

    println(minTriangle(data))
    assert(minTriangle(data) == List(7, 6, 3, 2))


    val data2 = Array(
         Array(7),
        Array(6, 3),
       Array(3, 8, 5),
      Array(11, 12, 10, 9)
    )

    assert(minTriangle(data2) == List(7,3,5,9))
  }

}
