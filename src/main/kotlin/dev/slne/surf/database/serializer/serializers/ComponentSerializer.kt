package dev.slne.surf.database.serializer.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer

object ComponentSerializer : KSerializer<Component> {
    private val gcs = GsonComponentSerializer.gson()

    override val descriptor = PrimitiveSerialDescriptor(
        "Component",
        PrimitiveKind.STRING
    )

    override fun serialize(
        encoder: Encoder,
        value: Component
    ) {
        encoder.encodeString(gcs.serialize(value))
    }

    override fun deserialize(decoder: Decoder) =
        gcs.deserialize(decoder.decodeString())
}