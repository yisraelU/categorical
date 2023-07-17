package categorical.chapter3.poset

import categorical.chapter3.PartialOrder

trait Poset[A] extends PartialOrder[A] {
  def contains(a: A): Boolean
}
