package org.indyscala.scalatags.basics

import java.net.URI
import java.nio.charset.StandardCharsets

trait DemoSupport {
  def write(str: String): String = {
    import java.io._
    val fileName = s"/tmp/${getClass().getSimpleName}.html".replaceAll("\\$", "")
    val pw = new PrintWriter(new File(fileName), StandardCharsets.UTF_8.toString)
    pw.write(str)
    pw.close()
    fileName
  }

  def browse(fileName: String): Unit = java.awt.Desktop.getDesktop.browse(
    new URI(s"file://$fileName"))
}
