package org.indyscala.scalatags.basics

import scalatags.Text.all._

object EscapedInputs extends App with DemoSupport {

  private val evilInput1 = "\"><script>alert('hello!')</script>"
  private val evilInput2 = "<script>alert('hello!')</script>"


  def buildHtml(): Tag =
  html(
    head(
      script("alert('Template text escaped by default...')")
    ),
    body(
      h1(
        title:=evilInput1,
        "This is my title"
      ),
      evilInput2
    )
  )


  val htmlFragment = buildHtml
  println(htmlFragment)

  // easier to see in the browser...
  val file = write(htmlFragment.toString)
  browse(file)
}
