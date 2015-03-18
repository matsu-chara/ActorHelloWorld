import akka.actor._

object Silly extends App {
  val system = ActorSystem("system")
  val ref = system.actorOf(Props[SillyActor])

  ref! "HelloWorld"
}

class SillyActor extends Actor {
  def receive: Receive = {
    case _ =>
      for (i <- 1 to 5) {
        println("I'm acting!")
        Thread.sleep(1000)
      }
  }
}