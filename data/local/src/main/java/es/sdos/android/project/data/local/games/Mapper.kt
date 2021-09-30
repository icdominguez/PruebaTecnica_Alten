package es.sdos.android.project.data.local.games

import es.sdos.android.project.data.local.games.dbo.GameDbo
import es.sdos.android.project.data.local.games.dbo.RoundDbo
import es.sdos.android.project.data.model.game.GameBo
import es.sdos.android.project.data.model.game.RoundBo
import java.util.Date

// TODO
fun GameDbo.toBo() = GameBo(
    id,
    Date(),
    listOf(),
    0,
    true
)

// TODO

fun GameBo.toDbo() = GameDbo(
    0,
    id,
    date,
    rounds.forEach { it.score!! }.toString()
)

// TODO
fun RoundDbo.toBo() = RoundBo(
    id,
    0,
    0,
    0,
    0,
    0,
    0
)

// TODO
fun RoundBo.toDbo() = RoundDbo(
    id
)