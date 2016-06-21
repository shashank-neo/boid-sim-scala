

import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Rectangle}

/**
  * Created by shwet.s under project LearnScala. <br/>
  * Created on  17/03/16. <br/>
  * Updated on 17/03/16.  <br/>
  * Updated by shwet.s. <br/>
  *
  *
  */
object BoidSim extends JFXApp {
  val scene = new Scene {
    fill = Color.Aqua
  }
  stage = new PrimaryStage {
    title = "Boids Simulator"
    width = 1200
    height = 800
  }
  val flock = new Flock
  flock.randomInit
  var content = new Array[Circle](flock.boids.length)
  for(index <- flock.boids.indices) {
    content(index) = new Circle {
      centerX = flock.boids(index).currentPos.posX
      centerY = flock.boids(index).currentPos.posY
      radius = 5
      fill =  Color.Coral
    }
  }
  scene.content = content
  stage.scene = scene
  stage.show()
  var lastTime = 0L
  val timer = AnimationTimer ( t => {
    if(t - lastTime >= 100000000) {
      flock.moveToNewPosition
      for(index <- flock.boids.indices) {
        content(index).centerX = flock.boids(index).currentPos.posX
        content(index).centerY = flock.boids(index).currentPos.posY
      }
      lastTime = t
    }
  })
  timer.start()
}

