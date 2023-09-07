package com.example.netclanexplorerapp.models

data class BusinessModel(
    val bImage: Int,
    val bName: String,
    val bCity: String,
    val bRange: Float,
    val bContactNo: Long,
    var isContactClicked: Boolean,
    val bProfession: String,
    val bExpYears: Int,
    val bStatus: String
)