package categorical.chapter3

trait PartialOrder[A] extends Relation[A] {
  def leq(a1: A, a2: A): Boolean

  // laws for PartialOrder
  // false indicates lack of proof
  def reflexive(a: A): Boolean = leq(a, a)
  def antiSymmetric(a1: A, a2: A): Boolean = leq(a1, a2) && leq(a2, a1)
  def transitive(a1: A, a2: A, a3: A): Boolean =
    leq(a1, a2) && leq(a2, a3) && leq(a1, a3)

}
