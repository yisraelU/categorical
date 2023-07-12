package chapter5

trait Terminal[-A] {
  def morphism(a: A): Unit
}

object Terminal {
  def apply[A](implicit terminal: Terminal[A]): Terminal[A] = terminal
  def singleton[A]: Terminal[A] = new Terminal[A] {
    def morphism(a: A): Unit = ()
  }
}
