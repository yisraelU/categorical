package categorical.category

trait Category[C] {
  def id[A]: [A]
  def morphism[A, B]: Morphism[A, B]
}
