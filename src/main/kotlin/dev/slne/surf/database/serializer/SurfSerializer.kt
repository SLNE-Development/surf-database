package dev.slne.surf.database.serializer

import dev.slne.surf.database.serializer.serializers.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.ShadowColor
import net.kyori.adventure.text.format.TextColor
import java.time.ZonedDateTime
import java.util.*

object SurfSerializer {

    private val baseModule = SerializersModule {
        contextual(TextColor::class, TextColorSerializer)
        contextual(ShadowColor::class, ShadowColorSerializer)
        contextual(Component::class, ComponentSerializer)
        contextual(ZonedDateTime::class, ZonedDateTimeSerializer)
        contextual(UUID::class, UuidSerializer)
    }

    private val externalModules = mutableSetOf<SerializersModule>()

    private var _json: Json = buildJson()
    val json get() = _json

    private fun buildJson(): Json {
        val mergedModules = SerializersModule {
            include(baseModule)
            externalModules.forEach { include(it) }
        }

        return Json {
            serializersModule = mergedModules
            classDiscriminator = "type"
            ignoreUnknownKeys = true
            encodeDefaults = true
            isLenient = true
        }
    }

    private fun rebuildJson() {
        _json = buildJson()
    }

    fun registerModule(module: SerializersModule) {
        externalModules.add(module)
        rebuildJson()
    }

}