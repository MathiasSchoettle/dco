import java.util.concurrent.{ForkJoinPool, RecursiveTask}

class RecursiveImmutable(list : List[Int], pool : ForkJoinPool) extends RecursiveTask[List[Int]] {
  override def compute(): List[Int] = {
    if(list.size == 1) {
      list.map( e => e * 2)
    } else {
      val mid = list.length / 2
      pool.invoke(new RecursiveImmutable(list.slice(0, mid), pool)) ++ pool.invoke(new RecursiveImmutable(list.slice(mid, list.length), pool))
    }
  }
}
