package org.indyscala.scalatags.basics

object RunAll extends App {

  runOne(HelloWorld)
  runOne(Attributes)
  runOne(TypedCss)
  runOne(EscapedInputs)
  runOne(Templates)

  def runOne(app: App): Unit = {
    waitForAck(app)
    app.main(Array())
  }

  def waitForAck(app: App): Unit = {
    val name = app.getClass.getSimpleName.replaceAll("\\$", "")
    System.out.println(s"\n\nPress a key to run $name demo.")
    System.in.read()
  }
}
