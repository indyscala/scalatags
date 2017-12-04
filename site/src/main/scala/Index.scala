package org.indyscala.scalatags.site

import java.io.File
import ba.sake.hepek.core.Renderable

object Index extends Renderable {
  import scalatags.Text.all._

  private val crossorigin = attr("crossorigin")

  override def render: String = {
    import scalatags.Text.tags2.title

    val titleText = "Static Site with ScalaTags"

    html(
      head(
        title(titleText),
        link(rel := "stylesheet", href := "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css", crossorigin := "anonymous"),
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

