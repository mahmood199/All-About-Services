package com.download.service.ui.music

import com.download.service.model.Song


sealed class ItemClickListener {
    data class ItemClicked(
        val song: Song,
        val position: Int,
        val totalItem: Int
    ) :
        ItemClickListener()
}