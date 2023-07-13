package chapter3.poset

import chapter3.PartialOrder

trait Poset[-A] extends PartialOrder[A] {
  def contains(a: A): Boolean
}
