package categorical.chapter5

import categorical.category.Morphism.IdentityMorphism
import categorical.category.{Category, Morphism}

// Here the type params represent categories
trait Product[+A, +B, C] extends Category[C] { self =>
  def projectA: Morphism[C, A]
  def projectB: Morphism[C, B]
  override def id: IdentityMorphism[C] = ???
  override def morphism: Morphism[C, C] = ???

  def combine[A1 >: A, B1 >: B, C1 <: C](a: A1, b: B1): C1
  def compose[A1 >: A, B1 >: B, C1 <: C, D]: Product[A1, B1, D] => C1 =
    productD => combine(productD.projectA, productD.projectB)
  def factorizer[C1 <: C, A1 >: A, B1 >: B](
      f: C1 => A1,
      g: C1 => B1
  ): C1 => (A1, B1) = c => (f(c), g(c))
}
