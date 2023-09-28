package categorical
package chapter7


trait Reader[R,A] extends Functor[R,A] {
  def read(r:R): A
  def map[Q](f: Q => R): Reader[Q,A] = new Reader[Q,A] {
    def read(q:Q): A = Reader.this.read(f(q))
  }
}
