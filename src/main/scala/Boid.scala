/**
  * Created by shwet.s under project LearnScala. <br/>
  * Created on  14/03/16. <br/>
  * Updated on 14/03/16.  <br/>
  * Updated by shwet.s. <br/>
  *
  *
  */
class Boid(pos: Position, vel: Velocity) {
  var currentPos = pos
  var currentVel = vel

  def equal(boid: Boid): Boolean = {
    boid.currentPos.posX == this.currentPos.posX && boid.currentPos.posY == this.currentPos.posY
  }
}
