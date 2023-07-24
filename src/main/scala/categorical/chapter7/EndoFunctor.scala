package categorical.chapter7


trait EndoFunctor[A] extends Functor[A,A]{
  def fmap[B](f: A => B): EndoFunctor[B]

}
