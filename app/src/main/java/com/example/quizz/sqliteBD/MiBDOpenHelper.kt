package com.example.quizz.sqliteBD

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.quizz.fragmentos.FragmentoSolucion

class MiBDOpenHelper(context: Context?, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

        val TAG = "SQLite"

    companion object{
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "preguntas_tabla.db"
        val TABLA_PREGUNTAS = "preguntas"
        val COLUMNA_ID = "idPregunta"
        val COLUMNA_TEXTO = "textoPregunta"
        val COLUMNA_RESPUESTA1 = "textoRespuesta1"
        val COLUMNA_RESPUESTA2 = "textoRespuesta2"
        val COLUMNA_RESPUESTA3 = "textoRespuesta3"
        val COLUMNA_RESPUESTA4 = "textoRespuesta4"

        val TABLA_PUNTUACIONES = "puntuaciones"
        val COLUMNA_PTS_MAX = "puntuacionMax"

    }

    override fun onCreate(db: SQLiteDatabase?) {

        try{
            var crearTablaPreguntas = "CREATE TABLE $TABLA_PREGUNTAS ($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMNA_TEXTO TEXT, $COLUMNA_RESPUESTA1 TEXT," +
                    "$COLUMNA_RESPUESTA2 TEXT, $COLUMNA_RESPUESTA3 TEXT, $COLUMNA_RESPUESTA4 TEXT)"
            db!!.execSQL(crearTablaPreguntas)
            var crearTablaPuntos = "CREATE TABLE $TABLA_PUNTUACIONES ($COLUMNA_PTS_MAX TEXT)"
            db!!.execSQL(crearTablaPuntos)
            var insert = "INSERT INTO $TABLA_PUNTUACIONES ($COLUMNA_PTS_MAX) VALUES ('1')"
            db!!.execSQL(insert)
        } catch (e: SQLiteException) {
            Log.e("$TAG (onCreate)", e.message.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        try {
            val dropTablaPregunta = "DROP TABLE IF EXISTS $TABLA_PREGUNTAS"
            db!!.execSQL(dropTablaPregunta)
            val dropTablaPuntuaciones = "DROP TABLE IF EXISTS $TABLA_PUNTUACIONES"
            db!!.execSQL(dropTablaPuntuaciones)
            onCreate(db)
        } catch (e: SQLiteException) {
            Log.e("$TAG (onUpgrade)", e.message.toString())
        }
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
        Log.e("$TAG (onOpen)", "Base de datos abierta")

    }

    fun crearPregunta(textoPregunta: String, textoRespuesta1: String, textoRespuesta2: String, textoRespuesta3: String, textoRespuesta4: String) {
        val data = ContentValues()
        data.put(COLUMNA_TEXTO,textoPregunta)
        data.put(COLUMNA_RESPUESTA1, textoRespuesta1)
        data.put(COLUMNA_RESPUESTA2, textoRespuesta2)
        data.put(COLUMNA_RESPUESTA3, textoRespuesta3)
        data.put(COLUMNA_RESPUESTA4, textoRespuesta4)

        val db= this.writableDatabase
        db.insert(TABLA_PREGUNTAS,null,data)
        db.close()
    }

    fun crearPuntuacionMax(textoPuntuacionMax: String) {
        val data = ContentValues()
        data.put(COLUMNA_PTS_MAX,textoPuntuacionMax)

        val db= this.writableDatabase
        db.insert(TABLA_PUNTUACIONES,null,data)
        db.close()
    }

    fun obtenerPreguntas(): Cursor {
        val db= this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.TABLA_PREGUNTAS}", null)
        return cursor
    }

    fun obtenerPreguntaId(idPregunta: String): Cursor {
        val num = (Integer.parseInt(idPregunta))
        Log.e("$idPregunta (onOpen)", "idPregunta que se le pasa a la consulta: $idPregunta")

        val db= this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.TABLA_PREGUNTAS} WHERE $COLUMNA_ID=$num", null)
        cursor.moveToFirst()
        return cursor
    }

    //funcion para hacer random las preguntas
    fun obtenerPreguntaRandom(): Cursor{
        val db = this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.TABLA_PREGUNTAS} ORDER BY RANDOM() LIMIT 1", null)
        if (cursor.moveToFirst()) {
            return cursor
        }
        return cursor
    }

    fun obtenerPuntuacionMax(): Cursor {
        val db= this.readableDatabase
        var insert = "INSERT INTO $TABLA_PUNTUACIONES ($COLUMNA_PTS_MAX) VALUES ('1')"
        db!!.execSQL(insert)
        var cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.TABLA_PUNTUACIONES} ORDER BY $COLUMNA_PTS_MAX desc LIMIT 1", null)
        cursor.moveToFirst()
        return cursor
    }

}


