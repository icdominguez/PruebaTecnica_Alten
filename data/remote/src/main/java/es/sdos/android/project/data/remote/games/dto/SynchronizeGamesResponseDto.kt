package es.sdos.android.project.data.remote.games.dto

import com.google.gson.annotations.SerializedName

data class SynchronizeGamesResponseDto(
    @SerializedName("game_scores")
    val games: List<GameDto>
)