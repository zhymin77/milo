package com.milo.server.intents

import com.milo.server.utils.ScalateSupport

import unfiltered.request._
import unfiltered.response._

object MainIntent extends ScalateSupport{

  val hello = unfiltered.netty.async.Intent {
    case req@GET(Path(Seg("aa" :: p :: Nil))) =>
      req.respond(HtmlContent ~> render("main/index.ssp", Map()))
  }

  val wi = unfiltered.netty.async.Intent {
    case req@GET(Path(Seg("ab" :: p :: Nil))) =>
      req.respond(HtmlContent ~> ResponseString(p))
  }
}
