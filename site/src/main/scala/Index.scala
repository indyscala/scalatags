package org.indyscala.scalatags.site

import java.io.File
import ba.sake.hepek.core.Renderable

object Index extends Renderable {
  import scalatags.Text.all._

  case class CdnAsset(href: String, checksum: String)

  val BootstrapVersion = "4.0.0-beta.2"

  val BootstrapCss = CdnAsset(
    s"https://maxcdn.bootstrapcdn.com/bootstrap/$BootstrapVersion/css/bootstrap.min.css",
    "sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb")
  val JQuery = CdnAsset(
    "https://code.jquery.com/jquery-3.2.1.slim.min.js",
    "sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN")
  val Popper = CdnAsset(
    "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js",
    "sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" )
  val BootstrapJs = CdnAsset(
    s"https://maxcdn.bootstrapcdn.com/bootstrap/$BootstrapVersion/js/bootstrap.min.js",
    "sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ")


  /**
   * Contents of `index.html` written via sbt-hepek `Renderable`.
   */
  override def render: String = {
    import scalatags.Text.tags2.title

    val titleText = "Static Site with ScalaTags"

    html(
      head(
        title(titleText),
        cssRef(BootstrapCss),
      ),
      body(
        div(cls := "container",
          h1(id := "title", titleText),
          p("Slightly less lame demo."),
        ),
        scriptRef(JQuery),
        scriptRef(Popper),
        scriptRef(BootstrapJs),
      )
    )
  }.toString()

  override def relPath: File = new File("index.html")

  private val crossorigin = attr("crossorigin")
  private val integrity = attr("integrity")

  def cssRef(asset: CdnAsset): ConcreteHtmlTag[String] = link(rel := "stylesheet", href := asset.href, integrity := asset.checksum, crossorigin := "anonymous")
  def scriptRef(asset: CdnAsset): ConcreteHtmlTag[String] = scalatags.Text.tags.script(`type` := "javascript", src := asset.href, integrity := asset.checksum, crossorigin := "anonymous")

}
