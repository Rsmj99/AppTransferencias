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
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentApCeCuenta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentApCeCuenta extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Spinner spinner;
    private Switch sw_estado;
    Cuenta cuenta;

    // TODO: Rename and change types of parameters
    private Banco banco;
    private int numero;

    public FragmentApCeCuenta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentApCeCuenta.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentApCeCuenta newInstance(Serializable banco, int numero) {
        FragmentApCeCuenta fragment = new FragmentApCeCuenta();
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
        final View view = inflater.inflate(R.layout.fragment_ap_ce_cuenta, container, false);

        spinner = view.findViewById(R.id.spinner);
        sw_estado = view.findViewById(R.id.sw_estado);

        Cliente[] clientes = {banco.getObjCliente01(), banco.getObjCliente02(), banco.getObjCliente03(), banco.getObjCliente04(), banco.getObjCliente05()};
        Cuenta[] cuentas = {clientes[numero-1].getObjCuenta01(), clientes[numero-1].getObjCuenta02(), clientes[numero-1].getObjCuenta03()};
        ArrayAdapter<Cuenta> adapter = new ArrayAdapter<Cuenta>(getActivity(), android.R.layout.simple_spinner_item, cuentas);
        spinner.setAdapter(adapter);

        view.findViewById(R.id.btn_aceptar).setOnClickListener(this);
        view.findViewById(R.id.btn_cancelar).setOnClickListener(this);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cuenta = cuentas[i];
                sw_estado.setChecked(cuenta.getEstado().equals(Estado.ABIERTO));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        sw_estado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cuenta.setEstado(Estado.ABIERTO);
                    Toast.makeText(getActivity(), "Aperturado", Toast.LENGTH_SHORT).show();
                } else {
                    cuenta.setEstado(Estado.CERRADO);
                    Toast.makeText(getActivity(), "Cerrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_aceptar:
                Intent data = new Intent();
                data.putExtra("banco", banco);
                getActivity().setResult(Activity.RESULT_OK, data);
                break;
            case R.id.btn_cancelar:
                getActivity().setResult(Activity.RESULT_CANCELED);
        }
        getActivity().finish();
    }
}