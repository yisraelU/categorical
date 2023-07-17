package categorical.chapter5

trait CoProduct[-A, -B, +C] {
  def injectA(a: A): C
  def injectB(b: B): C
}
