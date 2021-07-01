package com.example.tarea06;

import java.io.Serializable;

public class Operacion implements Serializable {

    private double Monto;
    private Tipo Tipo;

    public Operacion(double monto, com.example.tarea06.Tipo tipo) {
        Monto = monto;
        Tipo = tipo;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double monto) {
        Monto = monto;
    }

    public com.example.tarea06.Tipo getTipo() {
        return Tipo;
    }

    public void setTipo(com.example.tarea06.Tipo tipo) {
        Tipo = tipo;
    }
}
