package com.example.tarea06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogAcciones extends AppCompatActivity implements View.OnClickListener {

    private FragmentEditCliente fragmentEditCliente;
    private FragmentApCeCuenta fragmentApCeCuenta;
    private FragmentDepoReti fragmentDepoReti;
    private FragmentTransferencias fragmentTransferencias;

    private FragmentTransaction fragmentTransaction;
    Banco banco;
    int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_acciones);

        banco = (Banco) getIntent().getSerializableExtra("banco");
        numero = getIntent().getExtras().getInt("numero");

        fragmentEditCliente = FragmentEditCliente.newInstance(banco, numero);
        fragmentApCeCuenta = FragmentApCeCuenta.newInstance(banco, numero);
        fragmentDepoReti = FragmentDepoReti.newInstance(banco, numero);
        fragmentTransferencias = FragmentTransferencias.newInstance(banco, numero);

        findViewById(R.id.btn_edcliente).setOnClickListener(this);
        findViewById(R.id.btn_accuenta).setOnClickListener(this);
        findViewById(R.id.btn_deporeti).setOnClickListener(this);
        findViewById(R.id.btn_transfe).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch(view.getId()){
            case R.id.btn_edcliente:
                fragmentTransaction.replace(R.id.fragment_principal, fragmentEditCliente);
                break;
            case R.id.btn_accuenta:
                fragmentTransaction.replace(R.id.fragment_principal, fragmentApCeCuenta);
                break;
            case R.id.btn_deporeti:
                fragmentTransaction.replace(R.id.fragment_principal, fragmentDepoReti);
                break;
            case R.id.btn_transfe:
                fragmentTransaction.replace(R.id.fragment_principal, fragmentTransferencias);
        }
        fragmentTransaction.commit();
    }
}