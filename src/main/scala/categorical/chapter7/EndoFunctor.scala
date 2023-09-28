package categorical
package chapter7
import category.Category

trait EndoFunctor[A] extends Functor[A, A] {
  override def mapCategory(category: Category[A]): Category[A]
  override def compose(f: EndoFunctor[A]): EndoFunctor[A]
  
}
