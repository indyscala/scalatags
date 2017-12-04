package org.indyscala.scalatags.basics

import scalatags.Text.all._

object Attributes extends App with DemoSupport {

  def buildHtml(): Tag =
  html(
    head(
      script("alert('A little more complex, this time with tag attributes...')")
    ),
    body(
      h1("This is my title"),
      div(
        p(onclick:="... do some js")(
          "This is my first paragraph"
        ),
        a(href:="www.google.com")(
          p("Goooogle")
        ),
        p(hidden)("I am hidden")
      )
    )
  )


  val htmlFragment = buildHtml
  println(htmlFragment)

  // easier to see in the browser...
  val file = write(htmlFragment.toString)
  browse(file)
}
