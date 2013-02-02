package com.milo.server.intents

import unfiltered.request._
import unfiltered.response._

object MainIntent {

  val hello = unfiltered.netty.async.Intent {
    case req@GET(Path(Seg("aa" :: p :: Nil))) =>
      req.respond(HtmlContent ~> ResponseString(p))
  }

  val wi = unfiltered.netty.async.Intent {
    case req@GET(Path(Seg("ab" :: p :: Nil))) =>
      req.respond(HtmlContent ~> ResponseString(p))
  }
}
