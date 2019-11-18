package eu.epitech.cashmanagerapp

import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("products")
    var products: List<ProductModel> = listOf()
)