package chapter5

trait Product[+A, +B, +C] { self =>
  def projectA: A
  def projectB: B
  def combine[A1 >: A, B1 >: B](a: A1, b: B1): C
  def compose[A1 >: A, B1 >: B, D]: Product[A1, B1, D] => C = productD =>
    combine(productD.projectA, productD.projectB)
  def factorizer[C1 >: C, A1 >: A, B1 >: B](
      f: C1 => A1,
      g: C1 => B1
  ): C1 => (A1, B1) = c => (f(c), g(c))
}
