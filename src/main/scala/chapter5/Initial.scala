package chapter5

trait Initial[A] {
  def absurd(nothing: Nothing): A
}

object Initial {
  def apply[A](implicit initial: Initial[A]): Initial[A] = initial
  def singleton[A]: Initial[A] = new Initial[A] {
    def absurd(nothing: Nothing): A = nothing
  }
}
