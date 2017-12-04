package org.indyscala.scalatags.site

import java.io.File
import ba.sake.hepek.core.Renderable

object Index extends Renderable {

  override def render: String = {
    import scalatags.Text.all._
    import scalatags.Text.tags2.title

    val titleText = "Static Site with ScalaTags"

    html(
      head(
        title(titleText),
        link(rel := "stylesheet", href := "assets/bootstrap/bootstrap.min.css"),
      ),
      body(
        div(cls := "container",
          h1(id := "title", titleText),
          p("Pretty lame demo so far."),
        )
      )
    )
  }.toString()

  override def relPath: File = new File("index.html")
}

