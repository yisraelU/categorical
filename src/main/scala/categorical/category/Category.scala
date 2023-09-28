package categorical.category

import categorical.category.Morphism.IdentityMorphism

trait Category[A] {
  def id: IdentityMorphism[A]
  def morphism: Morphism[A, A]
}
