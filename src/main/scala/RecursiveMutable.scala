import java.util.concurrent.{ForkJoinPool, RecursiveAction}

class RecursiveMutable(array : Array[Int], pool : ForkJoinPool, start : Int, end : Int) extends RecursiveAction {
  override def compute(): Unit = {
    if(start == end) {
      array(start) *= 2
    } else {
      val mid = start + (end - start) / 2
      pool.invoke(new RecursiveMutable(array, pool, start, mid))
      pool.invoke(new RecursiveMutable(array, pool, mid + 1, end))
    }
  }
}
