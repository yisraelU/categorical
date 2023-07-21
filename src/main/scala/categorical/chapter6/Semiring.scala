package categorical.chapter6

trait Semiring[A] {
  def add(a1: A, a2: A): A
  def mul(a1: A, a2: A): A
  def zero: A
  def one: A

  // laws for Semiring

  // only addition is commutative
  def commutative(a1: A, a2: A): Boolean = add(a1, a2) == add(a2, a1)
  def distributive(a1: A, a2: A, a3: A): Boolean = {
    mul(a1, add(a2, a3)) == add(mul(a1, a2), mul(a1, a3)) &&
    mul(add(a1, a2), a3) == add(mul(a1, a3), mul(a2, a3))
  }
  def additiveIdentity(a: A): Boolean = add(a, zero) == a && add(zero, a) == a
  def multiplicativeIdentity(a: A): Boolean =
    mul(a, one) == a && mul(one, a) == a

}
