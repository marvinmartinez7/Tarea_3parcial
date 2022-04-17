package com.example.empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.empleados.Configuracion.SQLiteConexion;
import com.example.empleados.Configuracion.Transacciones;
import com.example.empleados.Tablas.Empleados;

import java.util.ArrayList;

public class ActivityListViewEmpleados extends AppCompatActivity {
    SQLiteConexion conexion;
    ListView listaempleados;
    ArrayList<Empleados> lista;
    ArrayList<String> ArregloEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_empleados);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listaempleados = (ListView) findViewById(R.id.empleados_listview);

        ObtenerListaPersonas();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloEmpleados);
        listaempleados.setAdapter(adp);

        listaempleados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Empleados e = lista.get(i);
                // Toast.makeText(getApplicationContext(),"id: " + e.getIdempleados() + " Nombre: " + e.getNombreempleado() + "Apellido" + e.getApellidoempleado()+ " Edad: " + e.getEdadempleado() + " Direccion: " + e.getDireccionempleado() + " Puesto: " + e.getPuestoempleado(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),ActivityActualizarEmpleado.class);

                intent.putExtra("pxIdEmpleado", e.getIdempleados().toString());
                intent.putExtra("pxNombreEmpleado", e.getNombreempleado());
                intent.putExtra("pxApellidoEmpleado", e.getApellidoempleado());
                intent.putExtra("pxEdadEmpleado", e.getEdadempleado());
                intent.putExtra("pxDireccionEmpleado", e.getDireccionempleado());
                intent.putExtra("pxPuestoEmpleado", e.getPuestoempleado());

                startActivity(intent);

            }
        });
    }
    private void ObtenerListaPersonas() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Empleados list_empleados = null;

        lista = new ArrayList<Empleados>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tablaempleados, null);

        while(cursor.moveToNext()) {
            list_empleados = new Empleados();
            list_empleados.setIdempleados(cursor.getInt(0));
            list_empleados.setNombreempleado(cursor.getString(1));
            list_empleados.setApellidoempleado(cursor.getString(2));
            list_empleados.setEdadempleado(cursor.getString(3));
            list_empleados.setDireccionempleado(cursor.getString(4));
            list_empleados.setPuestoempleado(cursor.getString(5));

            lista.add(list_empleados);
        }

        cursor.close();
        fill_list();
    }

    private void fill_list() {
        ArregloEmpleados = new ArrayList<String>();

        for(int i=0; i<lista.size(); i++) {
            ArregloEmpleados.add(lista.get(i).getIdempleados() + " | " + lista.get(i).getNombreempleado() +" "+ lista.get(i).getApellidoempleado());
        }
    }
}