package com.example.quizz.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.quizz.data.Pregunta
import com.example.quizz.data.PreguntaDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.chromium.base.Callback

@Database(entities = [Pregunta::class], version = 1, exportSchema = false)
abstract class PreguntaDatabase: RoomDatabase() {

    abstract fun preguntaDao(): PreguntaDao

    companion object {
        @Volatile
        private var INSTANCE: PreguntaDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): PreguntaDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PreguntaDatabase::class.java,
                    "word_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .addCallback(PreguntaDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class PreguntaDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onCreate method to populate the database.
             */
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.preguntaDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(preguntaDao: PreguntaDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            preguntaDao.borrarTodasLasPreguntas()

            var pregunta = Pregunta(textoPregunta = "Hola", textoRespuesta1 = "Que tal", textoRespuesta2 = "Buenas tarde", textoRespuesta3 = "Adios", textoRespuesta4 = "Son las 5")
            preguntaDao.addPregunta(pregunta)

        }

    }

}