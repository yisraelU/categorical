# Bifunctor

- a Bifunctor is isomorphic to a Functor where the category is a Product of 2 categories
    - This means using Product to define a new Category 
    - Until now we just described Product as a property , now we can construct a new Category Using Product
- A Functor must provide that all morphisms in the original category are mapped to work in the new Category
- What are the Morphisms of the Category 'Product A B' ?
    - A morphism from a pair in A to a pair in B
- Using the Scala type category this would translate to :
    - ```def morphism[A,B,C,D](a:A,b:B):(C,D)```
