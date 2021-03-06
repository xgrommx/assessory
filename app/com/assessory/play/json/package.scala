package com.assessory.play

import com.wbillingsley.handy._
import com.assessory.api._
import course._
import group._
import play.api.libs.json.{Json, JsValue, Writes, Reads}

// Imports the lookups
import com.assessory.reactivemongo._

package object json {

  import scala.language.implicitConversions;
  implicit def refToJson[T <: HasStringId](ref:Ref[T]) = Json.toJson(ref.getId)
  
  implicit object writesRef extends Writes[Ref[HasStringId]] {
    def writes(r:Ref[HasStringId]) = Json.toJson(r.getId)
  }

  implicit def writesRefMany[T <: HasStringId, K] = new Writes[RefManyById[T, K]] {
    def writes(r:RefManyById[T, K]) = Json.toJson(r.getIds)
  }
  
  
  def readsRef[T <: HasStringId](c:Class[T])(implicit lu:LookUp[T, String]) = new Reads[Ref[T]] {
    def reads(j:JsValue) = Reads.StringReads.reads(j).map(s => new LazyId(c, s))
  }
  
  implicit val readsRefUser = readsRef(classOf[User])
  implicit val readsRefGroupSet = readsRef(classOf[GroupSet])
  implicit val readsRefGroup = readsRef(classOf[Group])
  implicit val readsRefCourse = readsRef(classOf[Course])
  implicit val readsRefTask = readsRef(classOf[Task])
  implicit val readsRefTaskOutput = readsRef(classOf[TaskOutput])
  implicit val readsRefGPreenrol = readsRef(classOf[GPreenrol])
}