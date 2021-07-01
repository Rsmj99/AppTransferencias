package com.example.tarea06;

import java.io.Serializable;
import java.text.NumberFormat;

public class Cuenta implements Serializable {

    private String Numero;
    private double Saldo;

    Operacion[] ObjOperaciones = new Operacion[5];
    private com.example.tarea06.Estado Estado;

    double mtdepositos;
    int ndepositos;
    double mtretiros;
    int nretiros;

    public Cuenta(){
        Estado = com.example.tarea06.Estado.CERRADO;
        mtdepositos = 0;
        ndepositos = 0;
        mtretiros = 0;
        nretiros = 0;
    }

    public com.example.tarea06.Estado getEstado() {
        return Estado;
    }

    public void setEstado(com.example.tarea06.Estado estado) {
        Estado = estado;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    public String toString(){
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
//        return Numero + ": " + numberFormat.format(Saldo);
        return "Cta. Nº " + Numero;
    }
}
