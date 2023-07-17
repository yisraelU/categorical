package categorical.chapter4

trait Kleisli[F[+_], -A, +B] {
  def apply(a: A): F[B]
}
