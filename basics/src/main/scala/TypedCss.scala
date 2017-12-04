package org.indyscala.scalatags.basics

import scalatags.Text.all._

object TypedCss extends App with DemoSupport {

  def buildHtml(): Tag =
  html(
    head(
      script("alert('Look, ma, no more CSS typos!')")
    ),
    body(
      h1(backgroundColor:="blue", color:="red")("This is my title"),
      div(backgroundColor:="blue", color:="red")(
        p(cls := "contentpara first")(
          "This is my first paragraph"
        ),
        a(opacity:=0.9)(
          p(cls := "contentpara")("Goooogle")
        )
      ),
      // or, if you must...
      div(style:="background-color: yellow; color: green")(
        p("More old-school with `style` attribute.")
      )
    )
  )


  val htmlFragment = buildHtml
  println(htmlFragment)

  // easier to see in the browser...
  val file = write(htmlFragment.toString)
  browse(file)
}
