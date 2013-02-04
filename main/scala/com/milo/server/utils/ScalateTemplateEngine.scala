package com.milo.server.utils

import java.io.{ File, PrintWriter }

import com.milo.server.ServerSetting

import org.fusesource.scalate.Binding
import org.fusesource.scalate.TemplateEngine
import org.fusesource.scalate.layout.DefaultLayoutStrategy

class ScalateTemplateEngine(defaultLayoutUri: String, defaultTemplateDirs: File*)
  extends TemplateEngine(defaultTemplateDirs) {
  this.mode = ServerSetting.mode
  this.allowReload = ServerSetting.isDevMode
  this.allowCaching = !this.allowReload
  this.layoutStrategy = new DefaultLayoutStrategy(this, defaultLayoutUri)

  def render(uri: String, attributes: Map[String, Any] = Map(),
    extraBindings: Traversable[Binding] = Nil): String = {
    layout(uri, attributes, extraBindings)
  }

  def renderWithWriter(uri: String, out: PrintWriter, attributes: Map[String, Any] = Map(),
    extraBindings: Traversable[Binding] = Nil) {
    layout(uri, attributes, extraBindings)
    val template = load(uri, extraBindings)
    layout(uri, template, out, attributes)
  }
}
