package categorical.chapter10

object Challenges {

  trait NaturalTransformation[F[_],G[_]]{
    def transform[A](fa:F[A]):G[A]
  }

  object NaturalTransformation{
    implicit val listNt: NaturalTransformation[Option, List] = new NaturalTransformation[Option,List] {
      override def transform[A](fa: Option[A]): List[A] = fa.toList
    }

    trait Reader[E,A]{
      def apply(e:E):A
    }

    private type UnitR[A] = Reader[Unit,A]

    val nt1 = new NaturalTransformation[UnitR, List] {
      override def transform[A](fa: UnitR[A]): List[A] = {
        val sol1 = List.empty[A]
        val sol2 = List(fa(()))
        sol1
      }
    }

    private type BoolR[A] = Reader[Boolean,A]

    val nt2 = new NaturalTransformation[BoolR,List] {
      override def transform[A](fa: BoolR[A]): List[A] = {
        val sol1 = List(fa(true))
        val sol2 = List(fa(false))
        val sol3 = List.empty
        sol1
      }
    }
  }

}
