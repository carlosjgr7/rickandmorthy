package org.carlosjgr7.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform