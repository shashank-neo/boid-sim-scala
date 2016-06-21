/**
  * Created by shwet.s under project LearnScala. <br/>
  * Created on  19/03/16. <br/>
  * Updated on 19/03/16.  <br/>
  * Updated by shwet.s. <br/>
  *
  *
  */
class Velocity(velX: Double, velY: Double) {
  var XVel = velX
  var YVel = velY

  def add(vel: Velocity) : Unit = {
    this.XVel = this.XVel + vel.XVel
    this.YVel = this.YVel + vel.YVel
  }

  def scalarDivide(factor: Double) : Unit = {
    this.XVel = this.XVel / factor
    this.YVel = this.YVel / factor
  }

  def difference(vel: Velocity): Velocity = {
    new Velocity(XVel - vel.XVel, YVel - vel.YVel)
  }

  def addVec(vec: BoidVector): Velocity = {
    this.XVel = this.XVel + vec.valX
    this.YVel = this.YVel + vec.valY
    this
  }

  def scalarMul(factor: Double): Unit = {
    this.XVel = this.XVel * factor
    this.YVel = this.YVel * factor
  }
}
