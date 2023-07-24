package categorical.chapter6

trait Cardinality[A] {
  def size: BigInt
}

object Cardinality {
  def apply[A](implicit ca: Cardinality[A]): Cardinality[A] = ca

  implicit val intCardinality: Cardinality[Int] = new Cardinality[Int] {
    def size: BigInt = Int.MaxValue
  }
  implicit val shortCardinality: Cardinality[Short] = new Cardinality[Short] {
    def size: BigInt = Short.MaxValue
  }
  implicit val byteCardinality: Cardinality[Byte] = new Cardinality[Byte] {
    def size: BigInt = Byte.MaxValue
  }
  implicit val longCardinality: Cardinality[Long] = new Cardinality[Long] {
    def size: BigInt = Long.MaxValue
  }

}
