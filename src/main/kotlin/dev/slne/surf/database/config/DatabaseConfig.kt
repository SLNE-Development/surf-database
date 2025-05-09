package dev.slne.surf.database.config

import org.spongepowered.configurate.objectmapping.ConfigSerializable

@ConfigSerializable
data class DatabaseConfig(
    val storageMethod: String = "local",

    val local: LocalDatabaseConfig? = null,
    val external: ExternalDatabaseConfig? = null,

    val hikari: DatabaseHikariConfig = DatabaseHikariConfig()
)