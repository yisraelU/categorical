package categorical.chapter3.poset.impl

import categorical.chapter3.poset.Poset
object IntegerPoset extends Poset[Int] {
  override def contains(a: Int): Boolean = true
  override def leq(a1: Int, a2: Int): Boolean = a1 <= a2

}
