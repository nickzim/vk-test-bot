package com.nickzim.domain

import com.nickzim.domain.attachments.Attachment

data class Message(
        val id: Int?,
        val date: Int?,
        val peer_id: Int?,
        val from_id: Int?,
        val text: String?,
        val random_id: Int?,
        val ref: String?,
        val ref_source: String?,
        val attachments: Array<Attachment>?,
        val important: Boolean?,
        val fwd_messages: Array<Message>?,
        val conversation_message_id: Int?

)
