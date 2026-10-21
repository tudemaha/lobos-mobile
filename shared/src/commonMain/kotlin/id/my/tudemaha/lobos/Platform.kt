package id.my.tudemaha.lobos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform