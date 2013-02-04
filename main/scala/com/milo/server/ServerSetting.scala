package com.milo.server

import com.typesafe.config._

object ServerSetting {
  val config = ConfigFactory.load("config/server")

  val port = config.getInt("server.port")
  val mode = config.getString("server.mode")
  val isDevMode = mode.toLowerCase.equals("dev")
  val isProdMode = mode.toLowerCase.equals("prod")
}
