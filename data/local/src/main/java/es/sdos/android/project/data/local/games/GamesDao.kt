package es.sdos.android.project.data.local.games

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import es.sdos.android.project.data.local.games.dbo.GameDbo
import es.sdos.android.project.data.local.games.dbo.RoundDbo

@Dao
abstract class GamesDao {

    @Query("SELECT * FROM games where id = :gameId")
    abstract suspend fun getGame(gameId: Long): GameDbo?

    @Query("SELECT * FROM games")
    abstract suspend fun getGames(): List<GameDbo>

    @Query("SELECT * FROM rounds where id = :gameId")
    abstract suspend fun getRounds(gameId: Long): List<RoundDbo>

    @Insert
    abstract suspend fun saveGame(gameDbo: GameDbo) : Long

    @Insert
    abstract suspend fun saveRound(roundDbo: RoundDbo) : Long

    @Query("DELETE FROM games WHERE id = :gameId")
    abstract suspend fun deleteGame(gameId: Long)

    @Query("DELETE FROM rounds WHERE id = :gameId")
    abstract suspend fun deleteRounds(gameId: Long)

}