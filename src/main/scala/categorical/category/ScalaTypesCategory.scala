package categorical.category

import categorical.category.Morphism.{FunctionMorphism, IdentityMorphism}

trait ScalaTypesCategory[A] extends Category[A] {
  def id: IdentityMorphism[A]
  def morphism: FunctionMorphism[A, B]
}
