package br.com.wab.myapplication.model

import javax.inject.Inject

class Berry @Inject constructor(
  val id: Int?,
  val name: String?,
  val size: Int?
)