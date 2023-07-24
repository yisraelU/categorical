package categorical.category

import categorical.category.Morphism.FunctionMorphism

trait ScalaTypesCategory[A] extends Category[A]{
  def id: FunctionMorphism[A,A]
  def morphism[A, B]: FunctionMorphism[A,B]
}
