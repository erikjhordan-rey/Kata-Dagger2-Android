package io.github.erikjhordanrey.kata_dagger2.view.adapter

import androidx.cardview.widget.CardView

interface CharacterAdapter {
    val elevation: Float
    fun getCardViewAt(position: Int): CardView?
    fun getCount(): Int

    companion object {
        const val MAX_ELEVATION = 8
    }
}
