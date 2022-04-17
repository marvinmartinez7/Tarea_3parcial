package com.example.empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.empleados.Configuracion.SQLiteConexion;
import com.example.empleados.Configuracion.Transacciones;

public class ActivityActualizarEmpleado extends AppCompatActivity {
    SQLiteConexion conexion;
    EditText actualizaridempleado_input, actualizarnombreempleado_input, actualizarapellidoempleado_input, actualizaredadempleado_input, actualizardireccionempleado_input, actualizarpuestoempleado_input;
    Button btnactualizarempleado, btneliminarempleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_empleado);
        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);

        actualizaridempleado_input = (EditText) findViewById(R.id.actualizaridempleado_input);
        actualizarnombreempleado_input = (EditText) findViewById(R.id.actualizarnombreempleado_input);
        actualizarapellidoempleado_input = (EditText) findViewById(R.id.actualizarapellidoempleado_input);
        actualizaredadempleado_input = (EditText) findViewById(R.id.actualizaredadempleado_input);
        actualizardireccionempleado_input = (EditText) findViewById(R.id.actualizardireccionempleado_input);
        actualizarpuestoempleado_input = (EditText) findViewById(R.id.actualizarpuestoempleado_input);

        btnactualizarempleado = (Button) findViewById(R.id.btnactualizarempleado);
        btneliminarempleado = (Button) findViewById(R.id.btneliminarempleado);

        // extramemos los put que vienen del activity anterior
        String pxIdEmpleado = getIntent().getStringExtra("pxIdEmpleado");
        String pxNombreEmpleado = getIntent().getStringExtra("pxNombreEmpleado");
        String pxApellidoEmpleado = getIntent().getStringExtra("pxApellidoEmpleado");
        String pxEdadEmpleado = getIntent().getStringExtra("pxEdadEmpleado");
        String pxDireccionEmpleado = getIntent().getStringExtra("pxDireccionEmpleado");
        String pxPuestoEmpleado = getIntent().getStringExtra("pxPuestoEmpleado");

        // llenamos los EditText
        actualizaridempleado_input.setText(pxIdEmpleado);
        actualizarnombreempleado_input.setText(pxNombreEmpleado);
        actualizarapellidoempleado_input.setText(pxApellidoEmpleado);
        actualizaredadempleado_input.setText(pxEdadEmpleado);
        actualizardireccionempleado_input.setText(pxDireccionEmpleado);
        actualizarpuestoempleado_input.setText(pxPuestoEmpleado);

        btnactualizarempleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarContacto();
            }
        });

        btneliminarempleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarContacto();
            }
        });

    }
    private void actualizarContacto() {
        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = { actualizaridempleado_input.getText().toString() };

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombreempleado, actualizarnombreempleado_input.getText().toString());
        valores.put(Transacciones.apellidoempleado, actualizarapellidoempleado_input.getText().toString());
        valores.put(Transacciones.edadempleado, actualizaredadempleado_input.getText().toString());
        valores.put(Transacciones.direccionempleado, actualizardireccionempleado_input.getText().toString());
        valores.put(Transacciones.puestoempleado, actualizarpuestoempleado_input.getText().toString());

        db.update(Transacciones.tablaempleados, valores, Transacciones.idempleado + "=?", params);
        // Toast.makeText(getApplicationContext(), "Dato Actualizado", Toast.LENGTH_LONG).show();

        db.close();
        CleanScreen();

        Intent intent = new Intent(getApplicationContext(),ActivityListViewEmpleados.class);
        startActivity(intent);
    }

    private void CleanScreen() {
        actualizaridempleado_input.setText("");
        actualizarnombreempleado_input.setText("");
        actualizarapellidoempleado_input.setText("");
        actualizaredadempleado_input.setText("");
        actualizardireccionempleado_input.setText("");
        actualizarpuestoempleado_input.setText("");
    }

    private void eliminarContacto() {
        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = { actualizaridempleado_input.getText().toString() };

        String wherecond = Transacciones.idempleado + "=?";
        db.delete(Transacciones.tablaempleados, wherecond, params);
        // Toast.makeText(getApplicationContext(), "Dato eliminado", Toast.LENGTH_LONG).show();

        CleanScreen();
        db.close();

        Intent intent = new Intent(getApplicationContext(),ActivityListViewEmpleados.class);
        startActivity(intent);
    }
}