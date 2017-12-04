package org.indyscala.scalatags.site

import java.io.File
import ba.sake.hepek.core.Renderable

object Index extends Renderable {

  override def render: String = {
    import scalatags.Text.all._
    import scalatags.Text.tags2.title

    html(
      head(
        title("Static Site with ScalaTags"),
      ),
      body(
        div(
          h1(id := "title", "Static Site with ScalaTags"),
          p("Pretty lame demo so far."),
        )
      )
    )
  }.toString()

  override def relPath: File = new File("index.html")
}

