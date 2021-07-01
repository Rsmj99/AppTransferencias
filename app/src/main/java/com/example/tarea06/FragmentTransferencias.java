package com.example.tarea06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTransferencias#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTransferencias extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Banco banco;
    private int numero;

    private RadioGroup rg_tipo;
    private EditText et_monto;
    private Spinner spinner1, spinner2, spinner3;
    private LinearLayout linlay;

    public FragmentTransferencias() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTransferencias.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTransferencias newInstance(Serializable banco, int numero) {
        FragmentTransferencias fragment = new FragmentTransferencias();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, banco);
        args.putInt(ARG_PARAM2, numero);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            banco = (Banco) getArguments().getSerializable(ARG_PARAM1);
            numero = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_transferencias, container, false);

        rg_tipo = view.findViewById(R.id.rg_tipo);
        spinner1 = view.findViewById(R.id.spinner1);
        spinner2 = view.findViewById(R.id.spinner2);
        spinner3 = view.findViewById(R.id.spinner3);
        linlay = view.findViewById(R.id.linlay);
        et_monto = view.findViewById(R.id.et_monto);

        Cliente[] clientes = {banco.getObjCliente01(), banco.getObjCliente02(), banco.getObjCliente03(), banco.getObjCliente04(), banco.getObjCliente05()};
        ArrayAdapter<Cliente> adapter3 = new ArrayAdapter<Cliente>(getActivity(), android.R.layout.simple_spinner_item, clientes);
        spinner3.setAdapter(adapter3);

        List<Cuenta> hacuentas = new ArrayList<Cuenta>();
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                hacuentas.clear();
                if (clientes[i].getObjCuenta01().getEstado() == Estado.ABIERTO) hacuentas.add(clientes[i].getObjCuenta01());
                if (clientes[i].getObjCuenta02().getEstado() == Estado.ABIERTO) hacuentas.add(clientes[i].getObjCuenta02());
                if (clientes[i].getObjCuenta03().getEstado() == Estado.ABIERTO) hacuentas.add(clientes[i].getObjCuenta03());
                ArrayAdapter<Cuenta> adapter2 = new ArrayAdapter<Cuenta>(getActivity(), android.R.layout.simple_spinner_item, hacuentas);
                spinner2.setAdapter(adapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        List<Cuenta> decuentas = new ArrayList<Cuenta>();
        if (clientes[numero-1].getObjCuenta01().getEstado() == Estado.ABIERTO) decuentas.add(clientes[numero-1].getObjCuenta01());
        if (clientes[numero-1].getObjCuenta02().getEstado() == Estado.ABIERTO) decuentas.add(clientes[numero-1].getObjCuenta02());
        if (clientes[numero-1].getObjCuenta03().getEstado() == Estado.ABIERTO) decuentas.add(clientes[numero-1].getObjCuenta03());
        ArrayAdapter<Cuenta> adapter1 = new ArrayAdapter<Cuenta>(getActivity(), android.R.layout.simple_spinner_item, decuentas);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter1);

        rg_tipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.btn_depositar){
                    linlay.setVisibility(View.VISIBLE);

                } else if (i == R.id.btn_retirar){
                    linlay.setVisibility(View.INVISIBLE);
                }
            }
        });

        view.findViewById(R.id.btn_aceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                Cuenta cuenta1 = decuentas.get(spinner1.getSelectedItemPosition());
                Cuenta cuenta2 = hacuentas.get(spinner2.getSelectedItemPosition());
                double saldo1 = cuenta1.getSaldo();
                double monto = Double.parseDouble(et_monto.getText().toString());
                double trans = saldo1-monto;

                if (trans >= 0){
                    cuenta1.setSaldo(trans);
                    cuenta1.mtretiros += monto;
                    cuenta1.nretiros++;
                    for (int i = 4; i >= 0; i--){
                        if (i == 0) cuenta1.ObjOperaciones[i] = new Operacion(monto, Tipo.RETIRO);
                        else cuenta1.ObjOperaciones[i] = cuenta1.ObjOperaciones[i-1];
                    }
                    if (rg_tipo.getCheckedRadioButtonId() == R.id.btn_depositar) {
                        cuenta2.setSaldo(cuenta2.getSaldo()+monto);
                        cuenta2.mtdepositos += monto;
                        cuenta2.ndepositos++;
                        for (int i = 4; i >= 0; i--){
                            if (i == 0) cuenta2.ObjOperaciones[i] = new Operacion(monto, Tipo.DEPOSITO);
                            else cuenta2.ObjOperaciones[i] = cuenta2.ObjOperaciones[i-1];
                        }
                    }
                } else {
                    Toast.makeText(getActivity(), "MONTO NO DISPONIBLE", Toast.LENGTH_SHORT).show();
                    return;
                }

                data.putExtra("banco", banco);
                getActivity().setResult(Activity.RESULT_OK, data);
                getActivity().finish();
            }
        });

        view.findViewById(R.id.btn_cancelar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().setResult(Activity.RESULT_CANCELED);
                getActivity().finish();
            }
        });
        return view;
    }
}