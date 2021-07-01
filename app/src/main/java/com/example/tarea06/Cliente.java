package com.example.tarea06;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String Dni;
    private String Apellidos;
    private String Nombres;
    private String Direccion;
    private String Telefono;
    private com.example.tarea06.Cuenta ObjCuenta01;
    private com.example.tarea06.Cuenta ObjCuenta02;
    private com.example.tarea06.Cuenta ObjCuenta03;

    public Cliente(){
        ObjCuenta01 = new com.example.tarea06.Cuenta();
        ObjCuenta02 = new com.example.tarea06.Cuenta();
        ObjCuenta03 = new com.example.tarea06.Cuenta();
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        this.Dni = dni;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public com.example.tarea06.Cuenta getObjCuenta01() {
        return ObjCuenta01;
    }

    public void setObjCuenta01(com.example.tarea06.Cuenta objCuenta01) {
        ObjCuenta01 = objCuenta01;
    }

    public com.example.tarea06.Cuenta getObjCuenta02() {
        return ObjCuenta02;
    }

    public void setObjCuenta02(com.example.tarea06.Cuenta objCuenta02) {
        ObjCuenta02 = objCuenta02;
    }

    public com.example.tarea06.Cuenta getObjCuenta03() {
        return ObjCuenta03;
    }

    public void setObjCuenta03(com.example.tarea06.Cuenta objCuenta03) {
        ObjCuenta03 = objCuenta03;
    }

    public String toString(){
        return Apellidos + ", " + Nombres;
    }
}