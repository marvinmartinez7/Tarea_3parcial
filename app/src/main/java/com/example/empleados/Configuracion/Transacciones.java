package com.example.empleados.Configuracion;

public class Transacciones {
    // Database Name
    public static final String NameDatabase = "REmple";

    // Tabla Empleados
    public static final String tablaempleados = "empleados";

    // Campos tabla Empleados
    public static final String idempleado = "idempleado";
    public static final String nombreempleado = "nombreempleado";
    public static final String apellidoempleado = "apellidoempleado";
    public static final String edadempleado = "edademppleado";
    public static final String direccionempleado = "direccionempleado";
    public static final String puestoempleado = "puestoempleado";

    // Crear tabla empleados
    public static final String CreateTableEmpleados = "CREATE TABLE empleados (idempleado INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombreempleado TEXT, apellidoempleado TEXT, edademppleado TEXT, direccionempleado TEXT, puestoempleado TEXT)";

    public static final String DROPTableEmpleados = "DROP TABLE IF EXISTS empleados";
}
