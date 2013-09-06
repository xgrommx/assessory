package com.assessory.api.question

case class IntegerQuestion(
  
    id: String,
    
    prompt: String,
    
    max: Int = 5,
    
    min: Int = 0,
    
    required: Boolean = true,
    
    active: Boolean = true

) extends Question {
  
  val kind = IntegerQuestion.kind
  
}

object IntegerQuestion {
  
  val kind = "Integer"
  
}

case class IntegerAnswer(
  
  question: String,
  
  answer: Int

) extends Answer