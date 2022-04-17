package com.example.empleados.Tablas;

public class Empleados {
    private Integer idempleados;
    private String nombreempleado;
    private String apellidoempleado;
    private String edadempleado;
    private String direccionempleado;
    private String puestoempleado;

    public Empleados(Integer idempleados, String nombreempleado, String apellidoempleado, String edadempleado, String direccionempleado, String puestoempleado) {
        this.idempleados = idempleados;
        this.nombreempleado = nombreempleado;
        this.apellidoempleado = apellidoempleado;
        this.edadempleado = edadempleado;
        this.direccionempleado = direccionempleado;
        this.puestoempleado = puestoempleado;
    }

    public Empleados() { }

    public Integer getIdempleados() {
        return idempleados;
    }

    public void setIdempleados(Integer idempleados) {
        this.idempleados = idempleados;
    }

    public String getNombreempleado() {
        return nombreempleado;
    }

    public void setNombreempleado(String nombreempleado) {
        this.nombreempleado = nombreempleado;
    }

    public String getApellidoempleado() {
        return apellidoempleado;
    }

    public void setApellidoempleado(String apellidoempleado) {
        this.apellidoempleado = apellidoempleado;
    }

    public String getEdadempleado() {
        return edadempleado;
    }

    public void setEdadempleado(String edadempleado) {
        this.edadempleado = edadempleado;
    }

    public String getDireccionempleado() {
        return direccionempleado;
    }

    public void setDireccionempleado(String direccionempleado) {
        this.direccionempleado = direccionempleado;
    }

    public String getPuestoempleado() {
        return puestoempleado;
    }

    public void setPuestoempleado(String puestoempleado) {
        this.puestoempleado = puestoempleado;
    }
}
