package com.example.netclanexplorerapp.models

data class MerchantModel(
    val mImage: Int,
    val mName: String,
    val mCity: String,
    val mRange: String,
    val mContactNo: Long,
    var isContactClickedM: Boolean,
    val mLocation: String,
    val mStatus: String
)