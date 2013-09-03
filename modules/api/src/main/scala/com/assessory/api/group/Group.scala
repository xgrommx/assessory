package com.assessory.api.group

import com.assessory.api.User
import com.assessory.api.course.Course
import com.wbillingsley.handy.{Ref, RefNone, RefManyById, HasStringId}

case class Group (
    
  id:String,
  
  course:Ref[Course] = RefNone,
  
  set:Ref[GroupSet] = RefNone,
  
  leavable:Boolean = false,
  
  joinable:Boolean = false,
  
  name:Option[String] = None,
  
  members:RefManyById[User, String] = new RefManyById(classOf[User], Seq.empty) 

) extends HasStringId