package eu.epitech.cashmanagerapp

import com.google.gson.annotations.SerializedName

data class PictureModel(
    @SerializedName("filename")
    var filename: String? = null
)