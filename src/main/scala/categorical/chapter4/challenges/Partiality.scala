package categorical.chapter4.challenges

import categorical.chapter4.Kleisli

// a Kleisli arrow from A to B is a function that takes an A and returns an F[B]
// a Partiality is a Kleisli arrow from A to B where F is Option

case class Partiality[-A, +B](pf: PartialFunction[A, B])
    extends Kleisli[Option, A, B] { self =>
  def apply(a: A): Option[B] = pf.lift(a)

}
