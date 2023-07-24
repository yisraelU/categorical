package categorical.chapter6.challenges

object iso {

  def optToEither[A, B](
      option: Option[A],
      either: Either[B, Unit]
  ): (Either[A, Unit], Option[B]) = {
    val rhs = either match {
      case Left(value) => Some(value)
      case Right(_)    => None
    }
    val lhs = option match {
      case Some(value) => Left(value)
      case None        => Right(())
    }
    (lhs, rhs)
  }

}
