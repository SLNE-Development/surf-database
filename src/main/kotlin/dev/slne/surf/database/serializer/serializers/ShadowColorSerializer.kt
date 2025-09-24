package dev.slne.surf.database.serializer.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import net.kyori.adventure.text.format.ShadowColor

object ShadowColorSerializer : KSerializer<ShadowColor> {
    override val descriptor = PrimitiveSerialDescriptor(
        "ShadowColor",
        PrimitiveKind.INT
    )

    override fun serialize(
        encoder: Encoder,
        value: ShadowColor
    ) {
        encoder.encodeInt(value.value())
    }

    override fun deserialize(decoder: Decoder) =
        ShadowColor.shadowColor(decoder.decodeInt())
}