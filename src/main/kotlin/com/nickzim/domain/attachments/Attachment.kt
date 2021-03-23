package com.nickzim.domain.attachments

data class Attachment(
        val type: String?,
        val photo: AttachmentObject?,
        val video: AttachmentObject?,
        val audio: AttachmentObject?,
        val doc: AttachmentObject?,
        val sticker: AttachmentObject?,
        val link: AttachmentObject?
)
