package br.com.wab.myapplication.model

data class GenericResponse(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: MutableList<GenericResultsResponse>
)