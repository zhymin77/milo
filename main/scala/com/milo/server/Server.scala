package com.milo.server

import unfiltered.request._
import unfiltered.response._

object Server {
  def main(args: Array[String]) = {
    val http = unfiltered.netty.Http(8080)
    try {
      http.plan(asyncPlanify(
        hello, wi
      )).run()
    } catch {
      http.close
    }
  }

  import unfiltered.netty.async.Plan.Intent
  def asyncPlanify(head: Intent, tail: Intent*) = unfiltered.netty.async.Planify{
    tail.fold(head) { _ onPass _ }
  }
  val hello = unfiltered.netty.async.Intent {
      case req@GET(Path(Seg("aa" :: p :: Nil))) =>
        req.respond(HtmlContent ~> ResponseString(p))
    }
  val wi = unfiltered.netty.async.Intent {
      case req@GET(Path(Seg("ab" :: p :: Nil))) =>
        req.respond(HtmlContent ~> ResponseString(p))
    }
}
