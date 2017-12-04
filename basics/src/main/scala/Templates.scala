package org.indyscala.scalatags.basics

import scalatags.Text.all._

object Templates extends App with DemoSupport {


  def buildHtml(): Tag =
  page(
    Seq(
      script("alert('HTML templates are just function calls...')")
    ),
    Seq(
      p("This is the first ", b("image"), " displayed on the ", a("site")),
      // courtesy http://www.publicdomainpictures.net/view-image.php?image=167326&picture=cat-on-the-white
      img(src:="http://www.publicdomainpictures.net/pictures/170000/velka/cat-on-the-white-1462965930mn5.jpg"),
      p("blah blah blah i am text")
    )
  )

  def page(scripts: Seq[Modifier], content: Seq[Modifier]) =
  html(
    head(scripts),
    body(
      h1("Page From Template"),
      div(cls := "content")(content)
    )
  )


  val htmlFragment = buildHtml
  println(htmlFragment)

  // easier to see in the browser...
  val file = write(htmlFragment.toString)
  browse(file)
}
