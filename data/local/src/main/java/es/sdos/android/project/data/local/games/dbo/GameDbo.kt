package es.sdos.android.project.data.local.games.dbo

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "games")
data class GameDbo (
    @PrimaryKey(autoGenerate = true)
    var uid: Int,
    var id: Long?,
    var date: Date,
    var shoots: String
)