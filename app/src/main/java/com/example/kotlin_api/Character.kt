package com.example.kotlin_api

import java.io.Serializable

data class Character (
   val name: String,
   val species: String,
   val img: String
): Serializable