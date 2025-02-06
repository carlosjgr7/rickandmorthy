package org.carlosjgr7.project.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class InfoResponse(
    val next: String?,
    val pages: Int,
    val prev: String?
)