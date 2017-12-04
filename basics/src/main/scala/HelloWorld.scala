package org.indyscala.scalatags.basics

import scalatags.Text.all._

object HelloWorld extends App with DemoSupport {

  def buildHtml(): Tag = p("Hello World!")

  val htmlFragment = buildHtml
  println(htmlFragment)

  // easier to see in the browser...
  val file = write(htmlFragment.toString)
  browse(file)
}
