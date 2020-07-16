package com.home.pokemondemo2.model.remote

import com.google.gson.annotations.SerializedName

data class HomeResponse(
        val result: Result
) {
    data class Result(
            val limit: Int,
            val offset: Int,
            val count: Int,
            val sort: String,
            val results: List<Result>
    ) {
        data class Result(
                val `99年`: String,
                val 資料產生週期: String,
                val `96年`: String,
                val `102年`: String,
                val `104年`: String,
                val 填報機關: String,
                val `106年`: String,
                val 資料產生時間: String,
                val `100年`: String,
                val `108年`: String,
                val 單位: String,
                val 公式: String,
                val `98年`: String,
                val 統計項目: String,
                val `97年`: String,
                val `105年`: String,
                val `107年`: String,
                @SerializedName("統計項目定義")
                val title: String,
                val `95年`: String,
                @SerializedName("109年1-3月")
                val content: String,
                val `101年`: String,
                val _id: Int,
                val `94年`: String,
                val `103年`: String
        )
    }
}