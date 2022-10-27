package com.example.quizz

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.quizz.data.Pregunta
import com.example.quizz.data.PreguntaDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Pregunta::class), version = 1, exportSchema = false)
abstract class PreguntaDatabase: RoomDatabase() {

    abstract fun preguntaDao(): PreguntaDao

    companion object{
        @Volatile
        private var INSTANCE: PreguntaDatabase? = null

        fun getDatabase(context: Context, scope:CoroutineScope): PreguntaDatabase {
            val temporal = INSTANCE
            //Comprobamos si existe y si existe se le devuelve sino creamos una nueva
            if(temporal != null){
                return temporal
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PreguntaDatabase::class.java,
                    "pregunta_tabla"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(PreguntaBDCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        class PreguntaBDCallback(private val scope: CoroutineScope): PreguntaDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let {
                    preguntaDatabase -> scope.launch {
                        populateDatabase(preguntaDatabase.preguntaDao())
                    }
                }
            }

            suspend fun populateDatabase(preguntaDao: PreguntaDao) {
                // Borramos el contenido
                preguntaDao.borrarTodasLasPreguntas()

                // Añadimos una pregunta
                var pregunta = Pregunta(textoPregunta = "1º Pregunta")
                preguntaDao.addPregunta(pregunta)

            }
        }
    }

}

