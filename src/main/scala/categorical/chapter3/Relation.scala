package categorical.chapter3

import categorical.category.{Category, Morphism}

trait Relation[A] extends Category {
  def contains(a: A): Boolean
  def morphism[A, B]: Morphism[A, B]
}
