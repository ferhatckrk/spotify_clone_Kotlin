package com.plcoding.spotifycloneyt.entities.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.plcoding.spotifycloneyt.entities.Song
import com.plcoding.spotifycloneyt.other.Constants.SONG_COLLECTIN
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {
    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTIN)


    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }


    }

}