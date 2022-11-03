package com.example.quizz.sqliteBD

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class MiBDOpenHelper(context: Context, factory: SQLiteDatabase.CursorFactory?):
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
    }

    override fun onCreate(db: SQLiteDatabase?) {
        try{
            var crearTablaPreguntas = "CREATE TABLE $TABLA_PREGUNTAS ($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMNA_TEXTO TEXT, $COLUMNA_RESPUESTA1 TEXT," +
                    "$COLUMNA_RESPUESTA2 TEXT, $COLUMNA_RESPUESTA3 TEXT, $COLUMNA_RESPUESTA4 TEXT)"
            db!!.execSQL(crearTablaPreguntas)
        } catch (e: SQLiteException) {
            Log.e("$TAG (onCreate)", e.message.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        try {
            val dropTablaPregunta = "DROP TABLE IF EXISTS $TABLA_PREGUNTAS"
            db!!.execSQL(dropTablaPregunta)
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

    fun obtenerPreguntas(): Cursor {
        val db= this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.TABLA_PREGUNTAS}", null)
        return cursor
    }

    fun obtenerPreguntaId(idPregunta: String): Cursor {
        val db= this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM ${MiBDOpenHelper.TABLA_PREGUNTAS} WHERE $COLUMNA_ID=idPregunta", null)
        return cursor
    }

}


