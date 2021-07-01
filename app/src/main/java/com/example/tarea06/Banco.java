package com.example.tarea06;

import java.io.Serializable;

public class Banco implements Serializable {

    private Cliente ObjCliente01;
    private Cliente ObjCliente02;
    private Cliente ObjCliente03;
    private Cliente ObjCliente04;
    private Cliente ObjCliente05;

    public Banco(){
        ObjCliente01 = new Cliente();
        ObjCliente02 = new Cliente();
        ObjCliente03 = new Cliente();
        ObjCliente04 = new Cliente();
        ObjCliente05 = new Cliente();
    }

    public Cliente getObjCliente01() {
        return ObjCliente01;
    }

    public void setObjCliente01(Cliente objCliente01) {
        ObjCliente01 = objCliente01;
    }

    public Cliente getObjCliente02() {
        return ObjCliente02;
    }

    public void setObjCliente02(Cliente objCliente02) {
        ObjCliente02 = objCliente02;
    }

    public Cliente getObjCliente03() {
        return ObjCliente03;
    }

    public void setObjCliente03(Cliente objCliente03) {
        ObjCliente03 = objCliente03;
    }

    public Cliente getObjCliente04() {
        return ObjCliente04;
    }

    public void setObjCliente04(Cliente objCliente04) {
        ObjCliente04 = objCliente04;
    }

    public Cliente getObjCliente05() {
        return ObjCliente05;
    }

    public void setObjCliente05(Cliente objCliente05) {
        ObjCliente05 = objCliente05;
    }
}
