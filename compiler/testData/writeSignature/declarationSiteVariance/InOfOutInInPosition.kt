class In<in T>
class Out<out T>
class X

fun f(p: In<Out<X>>) {}

// method: namespace::f
// jvm signature:     (LIn;)V
// generic signature: (LIn<-LOut<+LX;>;>;)V
// kotlin signature:  (LIn<LOut<LX;>;>;)V
