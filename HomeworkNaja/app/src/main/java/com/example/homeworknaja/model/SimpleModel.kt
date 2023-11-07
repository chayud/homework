package com.example.homeworknaja.model

import java.io.Serializable

data class SimpleModel (
    val id :String,
    val title:String,
    val subtitle:String,
    val avatarImage:String,
    val youtubeImage:String,
    val youtubeUrl:String,
    val comments:MutableList<Comment>
): Serializable
data class  Comment(
    val commentId : Int,
    val commentByName : String,
    val comment:String
): Serializable
