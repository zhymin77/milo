package com.milo.server

import com.milo.server.intents._

import unfiltered.request._
import unfiltered.response._

object Server {
  def main(args: Array[String]) = {
    unfiltered.netty.Http(ServerSetting.serverPort.toInt).plan(asyncPlanify(
      MainIntent.hello,
      MainIntent.wi
    )).run()
    println("listening port: " + ServerSetting.serverPort)
  }

  import unfiltered.netty.async.Plan.Intent
  def asyncPlanify(head: Intent, tail: Intent*) = unfiltered.netty.async.Planify{
    tail.fold(head) { _ onPass _ }
  }
}
