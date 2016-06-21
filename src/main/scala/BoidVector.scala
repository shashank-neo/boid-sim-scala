/**
  * Created by shwet.s under project LearnScala. <br/>
  * Created on  19/03/16. <br/>
  * Updated on 19/03/16.  <br/>
  * Updated by shwet.s. <br/>
  *
  *
  */
class BoidVector(x: Double, y: Double) {
  var valX = x
  var valY = y

  def add(vec: BoidVector): Unit = {
    this.valX += vec.valX
    this.valY += vec.valY
  }

}
