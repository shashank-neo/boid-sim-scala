import scala.util.Random

/**
  * Created by shwet.s under project LearnScala. <br/>
  * Created on  15/03/16. <br/>
  * Updated on 15/03/16.  <br/>
  * Updated by shwet.s. <br/>
  *
  *
  */
class Flock {
  val distanceFactor = 5
  val divisionFactor = 8
  val normalFactor = 100
  val left = 50
  val right = 1150
  val top = 50
  val bottom = 650
  val totalBoids = 50
  val boids: Array[Boid] = new Array[Boid](totalBoids)

  def randomInit : Unit  = {
    for(i <- 0 until totalBoids) {
      val pos = new Position(Random.nextInt(600), Random.nextInt(600))
      val vel = new Velocity(Random.nextInt(10),Random.nextInt(10))
      boids(i) = new Boid(pos,vel)
    }
  }

  def simulate : Unit = {
    while (true) {
      //printOnScreen
      moveToNewPosition
    }
  }

  def moveToNewPosition: Unit = {
    for(boid <- boids) {
      val v1 = rule1(boid)
      val v2 = rule2(boid)
      val v3 = rule3(boid)
      val v4 = boundingRule(boid)
      boid.currentVel.addVec(v1).addVec(v2).addVec(v3)
      boid.currentPos.addVec(new BoidVector(boid.currentVel.XVel, boid.currentVel.YVel))
      if(boid.currentPos.posX < left || boid.currentPos.posX > right) {
        boid.currentVel.XVel = boid.currentVel.XVel * -1.0
      }
      if(boid.currentPos.posY < top || boid.currentPos.posY > bottom) {
        boid.currentVel.YVel = boid.currentVel.YVel * -1.0
      }
    }
  }

  def rule1 (boidJ: Boid): BoidVector = {
    val position = new Position(0.0,0.0)
    for(boid <- boids) {
      if(!boid.equal(boidJ)) {
        position.add(boid.currentPos)
      }
    }
    position.scalarDiv(boids.length - 1)
    val difPos = position.difference(boidJ.currentPos)
    difPos.scalarDiv(normalFactor)
    new BoidVector(difPos.posX, difPos.posY)
  }

  def rule2(boidJ: Boid): BoidVector = {
    val position = new Position(0.0,0.0)
    for(boid <- boids) {
      if (!boidJ.equal(boid)) {
        if (boidJ.currentPos.distance(boid.currentPos) < distanceFactor) {
          position.subtract(boid.currentPos.difference(boidJ.currentPos))
        }
      }
    }
    new BoidVector(position.posX, position.posY)
  }

  def rule3(boidJ: Boid): BoidVector = {
    val vel = new Velocity(0.0, 0.0)
    for(boid <- boids) {
      if(!boidJ.equal(boid)) {
        vel.add(boid.currentVel)
      }
    }
    vel.scalarDivide(boids.length - 1)
    val difVel = vel.difference(boidJ.currentVel)
    difVel.scalarDivide(divisionFactor)
    new BoidVector(difVel.XVel, difVel.YVel)
  }

  def boundingRule(boidJ: Boid): BoidVector = {
    val vec = new BoidVector(0,0)
    if(boidJ.currentPos.posX < left) {
      vec.valX = 1.0
    } else if(boidJ.currentPos.posX > right) {
      vec.valX = -1.0
    }
    if(boidJ.currentPos.posY < top) {
      vec.valY = 1.0
    } else if(boidJ.currentPos.posY > bottom) {
      vec.valY = -1.0
    }
    vec
  }
}
