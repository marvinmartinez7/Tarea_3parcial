package com.example.empleados.Configuracion;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteConexion extends SQLiteOpenHelper {
    public SQLiteConexion(@Nullable Context context, @Nullable String dbname, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        // Definimos el constructor de la clase
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creamos las tablas de la base de datos
        db.execSQL(Transacciones.CreateTableEmpleados);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Eliminamos las tablas de la base de datos, funcion para limpiar la db
        db.execSQL(Transacciones.DROPTableEmpleados);

        // Creamos nuevamente las tablas
        onCreate(db);
    }

}
