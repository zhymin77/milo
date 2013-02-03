package com.milo.server

import com.typesafe.config._

object ServerSetting {
  val config = ConfigFactory.load("config/server")

  val serverPort = config.getString("server.port")
}
