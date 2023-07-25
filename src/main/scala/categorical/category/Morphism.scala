package categorical.category

sealed trait Morphism[A, B]
object Morphism {
  case class FunctionMorphism[A, B](f: A => B) extends Morphism[A, B]
  case class RelationMorphism[A](r: (A, A) => Boolean) extends Morphism[A, Boolean]
  trait SubTypeMorphism[A, B <: A] extends Morphism[A, B]

}
