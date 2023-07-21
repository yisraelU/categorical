package categorical.chapter5.challenges

sealed trait Either[+A, +B]
object Either {
  case class Left[+A](value: A) extends Either[A, Nothing]
  case class Right[+B](value: B) extends Either[Nothing, B]

}

class IntOrBool {
  def i(int: Int) = int
  def i(bool: Boolean) = if (bool) 1 else 0
}

object Test {
  def m(either: Either[Int, Boolean]): Int = either match {
    case Either.Left(int)   => int
    case Either.Right(bool) => if (bool) 1 else 0
  }
}
