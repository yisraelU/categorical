package categorical.category

sealed trait Morphism[A, B]{
  def id: Morphism[A,A]
}
object Morphism{
  case class FunctionMorphism[A, B](f: A => B) extends Morphism[A, B]{
    def id: FunctionMorphism[A,A] = FunctionMorphism(a => a)
  }
  case class RelationMorphism[A](r: (A,A) => Boolean) extends Morphism[A, Boolean]{
    def id: RelationMorphism[A] = RelationMorphism((a1, a2) => a1 == a2)
  }
}
