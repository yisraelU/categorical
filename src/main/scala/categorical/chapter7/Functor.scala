package categorical.chapter7

import categorical.category.Category

// maps category to category via mapping all objects and morphisms from one category to another
trait Functor[A,B] {
  def mapCategory(category: Category[A]): Category[B]
  def compose[C](f: Functor[B,C]): Functor[A,C]
}

object FunctorLaws{

  // for all category A thats mapped to category B via functor F

}
