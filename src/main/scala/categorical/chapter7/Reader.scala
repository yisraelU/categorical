package categorical.chapter7

trait Reader[A] extends EndoFunctor[A]{
  def read: A
  def map[B](f: A => B): Reader[B]

}
