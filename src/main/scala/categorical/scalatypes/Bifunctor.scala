package categorical.scalatypes

trait Bifunctor[F[_]] {

  def map[A, B, C, D](f: (A, B) => (C, D)): F[(A, B)] => F[(C, D)]
  def bimap[A, B, C, D](f: A => C, g: B => D): F[(A, B)] => F[(C, D)]
}

object Bifunctor {
  trait BiComp[F[_, _], G[_], H[_], A, B] {
    def bimap[C, D](f: A => C, g: B => D): F[G[C], H[D]]
  }

class Impl[F[_,_],G[_],H[_],A,B](f: F[G[A], H[B]]) extends BiComp[F,G,H,A,B] {
  override def bimap[C, D](f: A => C, g: B => D): F[G[C], H[D]] = ???
}

  def bifunctor[F[_, _], G[_], H[_]](implicit F: Bifunctor[F], G: Functor[G], H: Functor[H]): Bifunctor[BiComp[F, G, H, ?, ?]] =
    new Bifunctor[BiComp[F, G, H, ?, ?]] {
      def map[A, B, C, D](f: (A, B) => (C, D)): BiComp[F, G, H, (A, B), (C, D)] => BiComp[F, G, H, (C, D), (C, D)] =
        bc => compose(F.map(f)(bc.compose))

      def bimap[A, B, C, D](f: A => C, g: B => D): BiComp[F, G, H, (A, B), (C, D)] => BiComp[F, G, H, (C, D), (C, D)] =
        bc => compose(F.bimap(f, g)(bc.compose))
    }  
}


  trait BiFunctor[F[_,_]]{
    def bimap[A,B,C,D](fab:F[A,B])(f:A=>C,g:B=>D):F[C,D]
  }
  object BiFunctor{
    def apply[F[_,_]](implicit bf:BiFunctor[F]):BiFunctor[F]=bf
  }

  trait Functor[F[_]]{
    def map[A,B](fa:F[A])(f:A=>B):F[B]
    type IntEither[A] = Either[Int,A]
    def compose[G[_]](implicit G:Functor[G]):Functor[({type l[A]=F[G[A]]})#l]=new Functor[({type l[A]=F[G[A]]})#l]{
      def map[A,B](fa:F[G[A]])(f:A=>B):F[G[B]]= Functor.this.map(fa)(ga=>G.map(ga)(f))
    }
  }


  case class BiCom[BiF[_,_]:BiFunctor,F[_]:Functor,G[_]:Functor,A,C](run: BiF[F[A],G[C]]){
    def bimap[B,D](f:A=> B,g:C=>D):BiF[F[B],G[D]]= BiFunctor[BiF].bimap(run)(fa=>Functor[F].map(fa)(f),ga=>Functor[G].map(ga)(g))
  }

  trait Kleisli[Embellishment[_],A,B]{ self=>
    
    def id[A](a:A):Embellishment[A]

    def fish[A,B](f:A=>Embellishment[B]):Embellishment[B]

    def fmap[C](f:B=>C):Embellishment[C]=fish(f andThen id)
  }

  object A {
  var listOfObjects:List[Object]=List(new Object,new Object,new Object)
  val listOfStrings:List[String]=List("a","b","c")

  listOfObjects=listOfStrings

  def takesStrings(list:List[String]) = ???

  }
  trait Monad[M[_]] {
    def pure[A](a:A):M[A]
    def flatMap[A,B](ma:M[A])(f:A=>M[B]):M[B]
    def map[A,B](ma:M[A])(f:A=>B):M[B]=flatMap(ma)(a=>pure(f(a)))
  }

  
  object Monad{
    def apply[M[_]](implicit M:Monad[M]):Monad[M]=M
    implicit class MonadOps[M[_]](monad:Monad[M]){
      def fmap[A,B](f:A=>B):M[A]=>M[B]= monad.flatMap(_)(a=>monad.pure(f(a)))
    }
  }




  