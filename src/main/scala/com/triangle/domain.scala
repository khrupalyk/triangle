package com.triangle

import cats.Show

object domain {
  //TODO value classes ot newtypes
  type TriangleItem = Int
  type Triangle = Array[Array[TriangleItem]]
  type MinimalPath = List[TriangleItem]
  type NodeSumAcc = Array[Int]
  type Row = Int
  type Col = Int


  implicit val minimalPathShow: Show[MinimalPath] = (t: MinimalPath) => s"${t.mkString(" + ")} = ${t.sum}"
}
