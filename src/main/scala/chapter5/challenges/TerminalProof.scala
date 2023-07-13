package chapter5.challenges

import chapter5.Terminal

object TerminalProof {

  // prove that all terminal objects are isomorphic to one another
  def iso[A, B](ta: Terminal[A]): Terminal[B] = _ => ()
  def eq[A, B](ta: Terminal[A], tb: Terminal[B])(a: A, b: B): Boolean =
    ta(a) == tb(b)

}
