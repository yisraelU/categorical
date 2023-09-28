package categorical.chapter5.challenges

import categorical.chapter3.poset.Poset
import categorical.chapter5.Product

// Question : What is the Product of 2 objects in a Poset
// Step 1 : Define the category of Posets
// Step 2 : Define the Product of 2 objects in a Poset

case class PosetProduct[A: Poset]() extends Product[A, A, (A, A)] {
  override def projectA: A = poset.bottom
  override def projectB: A = poset.bottom
  override def combine[A1 >: A, B1 >: A](a: A1, b: B1): A =
    poset.leastUpperBound(a, b)
}
