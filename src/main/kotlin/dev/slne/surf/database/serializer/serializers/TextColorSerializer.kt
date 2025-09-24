package dev.slne.surf.database.serializer.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import net.kyori.adventure.text.format.TextColor

object TextColorSerializer : KSerializer<TextColor> {
    override val descriptor = PrimitiveSerialDescriptor(
        "TextColor",
        PrimitiveKind.INT
    )

    override fun serialize(
        encoder: Encoder,
        value: TextColor
    ) {
        encoder.encodeInt(value.value())
    }

    override fun deserialize(decoder: Decoder) =
        TextColor.color(decoder.decodeInt())
}