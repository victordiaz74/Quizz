package com.example.quizz.adapter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pregunta::class], version = 1, exportSchema = false)
abstract class PreguntaDatabase: RoomDatabase() {

    abstract fun preguntaDao(): PreguntaDao

    companion object{
        @Volatile
        private var INSTANCE: PreguntaDatabase? = null

        fun getDatabase(context: Context): PreguntaDatabase{
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
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}