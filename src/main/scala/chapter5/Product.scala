package chapter5

trait Product[+A,+B,+C] {
  def projectA:A
  def projectB:B
  def combine[A1>:A,B1>:B](a:A1,b:B1):C
}
