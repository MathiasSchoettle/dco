import java.util.concurrent.ForkJoinPool

object App extends App {

  var array1 = (1 to 100).toArray
  val pool1 = new ForkJoinPool(Runtime.getRuntime.availableProcessors())

  println(array1.mkString("mutable start ( ", ", ", " )"))
  pool1.invoke(new RecursiveMutable(array1, pool1, 0, array1.length -1))
  println(array1.mkString("mutable end   ( ", ", ", " )"))

  var list1 = (1 to 100).toList
  val pool2 = new ForkJoinPool(Runtime.getRuntime.availableProcessors())

  println(list1.mkString("immutable start ( ", ", ", " )"))
  val list2 = pool2.invoke(new RecursiveImmutable(list1, pool2))
  println(list2.mkString("immutable start ( ", ", ", " )"))

}
