package categorical.category

trait Category {
  def id[A]: IdentityMorphism[A]
  def morphism[A, B]: Morphism[A, B]
}
