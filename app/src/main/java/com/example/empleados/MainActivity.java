package com.example.empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.empleados.Configuracion.SQLiteConexion;
import com.example.empleados.Configuracion.Transacciones;

public class MainActivity extends AppCompatActivity {
    SQLiteConexion conexion;

    EditText nombreempleado_input, apellidoempleado_input, edadempleado_input, direccionempleado_input, puestoempleado_input;
    Button btnguardarempleado, btnlistaempleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombreempleado_input = (EditText) findViewById(R.id.nombreempleado_input);
        apellidoempleado_input = (EditText) findViewById(R.id.apellidoempleado_input);
        edadempleado_input = (EditText) findViewById(R.id.edadempleado_input);
        direccionempleado_input = (EditText) findViewById(R.id.direccionempleado_input);
        puestoempleado_input = (EditText) findViewById(R.id.puestoempleado_input);

        btnguardarempleado = (Button) findViewById(R.id.btnguardarempleado);
        btnlistaempleado = (Button) findViewById(R.id.btnlistaempleado);

        btnguardarempleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { AgregarEmpleados(); }
        });

        btnlistaempleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityListViewEmpleados.class);
                startActivity(intent);
            }
        });
    }
    private void AgregarEmpleados() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombreempleado, nombreempleado_input.getText().toString());
        valores.put(Transacciones.apellidoempleado, apellidoempleado_input.getText().toString());
        valores.put(Transacciones.edadempleado, edadempleado_input.getText().toString());
        valores.put(Transacciones.direccionempleado, direccionempleado_input.getText().toString());
        valores.put(Transacciones.puestoempleado, puestoempleado_input.getText().toString());

        Long resultado = db.insert(Transacciones.tablaempleados, Transacciones.idempleado, valores);
        Toast.makeText(getApplicationContext(), "Empleado Ingresado: Codigo: " + resultado.toString(), Toast.LENGTH_LONG).show();

        db.close();
        CleanScreen();
    }

    private void CleanScreen() {
        nombreempleado_input.setText("");
        apellidoempleado_input.setText("");
        edadempleado_input.setText("");
        direccionempleado_input.setText("");
        puestoempleado_input.setText("");
    }
}