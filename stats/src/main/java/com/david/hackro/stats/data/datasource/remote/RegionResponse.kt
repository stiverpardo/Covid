package com.david.hackro.stats.data.datasource.remote

import com.david.hackro.stats.domain.DataItem
import com.david.hackro.stats.domain.Regions
import com.squareup.moshi.Json

data class RegionResponse(@field:Json(name = "data") val data: List<DataItem>)

data class DataItem(
    @field:Json(name = "iso") val iso: String,
    @field:Json(name = "name") val name: String
)

fun RegionResponse.toDomain() = Regions(data.map { it.toDomain() })

fun DataItem.toDomain() = com.david.hackro.stats.data.datasource.remote.DataItem(iso = iso, name = name)
