package chapter3.poset.impl

import chapter3.poset.Poset

object NaturalNumberPoset extends Poset[Int] {
  def leq(a1: Int, a2: Int): Boolean = a1 <= a2
  def contains(a: Int): Boolean = a >= 0
}
