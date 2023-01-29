package com.triangle

import com.triangle.domain.{Col, MinimalPath, NodeSumAcc, Row, Triangle}

trait TriangleService {

  def getMinimalPath(tree: Triangle): MinimalPath

}

object TriangleService {
  val live: TriangleService = new TriangleService {

    private val getNodeSum = (tree: Triangle, sums: NodeSumAcc, row: Row, col: Col) => {
      tree(row)(col) + sums(col) + sums(col + 1)
    }

    //TODO add more validation, like Array(Array(), Array(), Array()), it's incorrect data
    override def getMinimalPath(triangle: Triangle): MinimalPath = {

      if (triangle.length <= 1)
        return triangle.headOption.map(_.toList).getOrElse(Nil)

      val sums = new Array[Int](triangle.length)
      val values = new Array[Int](triangle.length)

      for (i <- sums.indices) {
        sums(i) = triangle(sums.length - 1)(i)
      }

      var i = triangle.length - 2

      while (i >= 0) {
        var j = 0

        var prevMinNodeSum = getNodeSum(triangle, sums, i, j)
        var foundMinValue = 0
        while (j < triangle(i).length) {
          val nodeSum = getNodeSum(triangle, sums, i, j)
          if (prevMinNodeSum >= nodeSum) {
            if (sums(j) >= sums(j + 1)) {
              foundMinValue = triangle(i + 1)(j + 1)
            } else {
              foundMinValue = triangle(i + 1)(j)
            }
            prevMinNodeSum = nodeSum
          }
          sums(j) = triangle(i)(j) + Math.min(sums(j), sums(j + 1))
          j = j + 1
        }
        values(i + 1) = foundMinValue
        i = i - 1
      }

      values(0) = triangle.head.head
      values.toList
    }
  }
}
