package com.example.tarea06;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_dni1, tv_dni2, tv_dni3, tv_dni4, tv_dni5, tv_apenom1, tv_apenom2, tv_apenom3, tv_apenom4, tv_apenom5;

    Banco banco = new Banco();
    Cliente cliente1 = banco.getObjCliente01();
    Cliente cliente2 = banco.getObjCliente02();
    Cliente cliente3 = banco.getObjCliente03();
    Cliente cliente4 = banco.getObjCliente04();
    Cliente cliente5 = banco.getObjCliente05();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cliente1.setDni("15784889");
        cliente1.setApellidos("Benites Flores");
        cliente1.setNombres("José Armando");
        cliente1.getObjCuenta01().setNumero("0101");
        cliente1.getObjCuenta02().setNumero("0102");
        cliente1.getObjCuenta03().setNumero("0103");
        cliente1.getObjCuenta01().setEstado(Estado.ABIERTO);
        cliente1.getObjCuenta01().setSaldo(1000);

        cliente2.setDni("15487948");
        cliente2.setApellidos("Morales Duarte");
        cliente2.setNombres("Gabriela Josefina");
        cliente2.getObjCuenta01().setNumero("0201");
        cliente2.getObjCuenta02().setNumero("0202");
        cliente2.getObjCuenta03().setNumero("0203");
        cliente2.getObjCuenta01().setEstado(Estado.ABIERTO);
        cliente2.getObjCuenta01().setSaldo(1000);

        cliente3.setDni("46587615");
        cliente3.setApellidos("Flores Morante");
        cliente3.setNombres("Ana Clara");
        cliente3.getObjCuenta01().setNumero("0301");
        cliente3.getObjCuenta02().setNumero("0302");
        cliente3.getObjCuenta03().setNumero("0303");
        cliente3.getObjCuenta01().setEstado(Estado.ABIERTO);
        cliente3.getObjCuenta01().setSaldo(1000);

        cliente4.setDni("16485974");
        cliente4.setApellidos("Corrales Ortiz");
        cliente4.setNombres("Maria Luisa");
        cliente4.getObjCuenta01().setNumero("0401");
        cliente4.getObjCuenta02().setNumero("0402");
        cliente4.getObjCuenta03().setNumero("0403");
        cliente4.getObjCuenta01().setEstado(Estado.ABIERTO);
        cliente4.getObjCuenta01().setSaldo(1000);

        cliente5.setDni("79845715");
        cliente5.setApellidos("Castro Paredes");
        cliente5.setNombres("Julio Cesar");
        cliente5.getObjCuenta01().setNumero("0501");
        cliente5.getObjCuenta02().setNumero("0502");
        cliente5.getObjCuenta03().setNumero("0503");
        cliente5.getObjCuenta01().setEstado(Estado.ABIERTO);
        cliente5.getObjCuenta01().setSaldo(1000);

        tv_dni1 = findViewById(R.id.tv_dni1);
        tv_dni2 = findViewById(R.id.tv_dni2);
        tv_dni3 = findViewById(R.id.tv_dni3);
        tv_dni4 = findViewById(R.id.tv_dni4);
        tv_dni5 = findViewById(R.id.tv_dni5);

        tv_apenom1 = findViewById(R.id.tv_apenom1);
        tv_apenom2 = findViewById(R.id.tv_apenom2);
        tv_apenom3 = findViewById(R.id.tv_apenom3);
        tv_apenom4 = findViewById(R.id.tv_apenom4);
        tv_apenom5 = findViewById(R.id.tv_apenom5);

        findViewById(R.id.btn_accion01).setOnClickListener(this);
        findViewById(R.id.btn_accion02).setOnClickListener(this);
        findViewById(R.id.btn_accion03).setOnClickListener(this);
        findViewById(R.id.btn_accion04).setOnClickListener(this);
        findViewById(R.id.btn_accion05).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        tv_dni1.setText("DNI: " + banco.getObjCliente01().getDni());
        tv_dni2.setText("DNI: " + banco.getObjCliente02().getDni());
        tv_dni3.setText("DNI: " + banco.getObjCliente03().getDni());
        tv_dni4.setText("DNI: " + banco.getObjCliente04().getDni());
        tv_dni5.setText("DNI: " + banco.getObjCliente05().getDni());

        tv_apenom1.setText(banco.getObjCliente01().getApellidos() + ", " + banco.getObjCliente01().getNombres());
        tv_apenom2.setText(banco.getObjCliente02().getApellidos() + ", " + banco.getObjCliente02().getNombres());
        tv_apenom3.setText(banco.getObjCliente03().getApellidos() + ", " + banco.getObjCliente03().getNombres());
        tv_apenom4.setText(banco.getObjCliente04().getApellidos() + ", " + banco.getObjCliente04().getNombres());
        tv_apenom5.setText(banco.getObjCliente05().getApellidos() + ", " + banco.getObjCliente05().getNombres());
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, DialogAcciones.class);
        intent.putExtra("banco", banco);

        switch(view.getId()){
            case R.id.btn_accion01:
                intent.putExtra("numero", 1);
                startActivityForResult(intent, 1);
                break;
            case R.id.btn_accion02:
                intent.putExtra("numero", 2);
                startActivityForResult(intent, 2);
                break;
            case R.id.btn_accion03:
                intent.putExtra("numero", 3);
                startActivityForResult(intent, 3);
                break;
            case R.id.btn_accion04:
                intent.putExtra("numero", 4);
                startActivityForResult(intent, 4);
                break;
            case R.id.btn_accion05:
                intent.putExtra("numero", 5);
                startActivityForResult(intent, 5);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    banco = (Banco) data.getExtras().getSerializable("banco");
            }
            Toast.makeText(this, "Cliente actualizado", Toast.LENGTH_SHORT).show();
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
        }
    }
}