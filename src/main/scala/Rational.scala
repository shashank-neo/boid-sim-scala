/**
  * Created by shwet.s under project LearnScala. <br/>
  * Created on  12/03/16. <br/>
  * Updated on 12/03/16.  <br/>
  * Updated by shwet.s. <br/>
  *
  *
  */
class Rational(n: Int, d: Int) {
  require(d!= 0)
  val numer = n
  val denom = d
  def this(n: Int) = this(n,1)
  override def toString = this.numer + "/" + this.denom

}
