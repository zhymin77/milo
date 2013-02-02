package com.milo.server

import com.milo.server.intents._

import unfiltered.request._
import unfiltered.response._

object Server {
  def main(args: Array[String]) = {
    println(ServerSetting.serverPort)
    val http = unfiltered.netty.Http(8080)
    http.plan(asyncPlanify(
      MainIntent.hello,
      MainIntent.wi
    )).run()
  }

  import unfiltered.netty.async.Plan.Intent
  def asyncPlanify(head: Intent, tail: Intent*) = unfiltered.netty.async.Planify{
    tail.fold(head) { _ onPass _ }
  }
}
