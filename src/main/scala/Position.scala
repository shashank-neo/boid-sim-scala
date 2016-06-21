/**
  * Created by shwet.s under project LearnScala. <br/>
  * Created on  19/03/16. <br/>
  * Updated on 19/03/16.  <br/>
  * Updated by shwet.s. <br/>
  *
  *
  */
class Position(posx: Double, posy: Double) {
  var posX = posx
  var posY = posy

  def add( pos: Position ): Unit = {
    this.posX += pos.posX
    this.posY += pos.posY
  }

  def subtract( pos: Position): Unit = {
    this.posX -= pos.posX
    this.posY -= pos.posY
  }

  def distance(pos: Position): Double = {
    var dist = 0.0
    dist = Math.sqrt((this.posX - pos.posX)*(this.posX - pos.posX) + (this.posY - pos.posY)*(this.posY - pos.posY))
    dist
  }

  def scalarDiv(factor: Double): Unit = {
    this.posX /= factor
    this.posY /= factor
  }

  def difference(pos: Position): Position = {
    new Position(this.posX - pos.posX, this.posY - pos.posY)
  }

  def addVec(vec: BoidVector): Position = {
    this.posX += vec.valX
    this.posY += vec.valY
    this
  }
}
