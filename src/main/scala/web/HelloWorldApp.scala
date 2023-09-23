package cn.egg
package web

import org.scalatra.ScalatraFilter

class HelloWorldApp extends ScalatraFilter{
  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        <p>
          Say <a href="hello-scalate">hello to Scalate</a>.
        </p>
      </body>
    </html>
  }

}
