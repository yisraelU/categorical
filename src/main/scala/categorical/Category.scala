package categorical

trait Category[A] {
  def id: Morphism[A, A]
  def morphism: Morphism[A, A]
}
