package com.example.tarea06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentEditCliente#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEditCliente extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText et_dni, et_apellidos, et_nombres, et_direccion, et_telefono;

    com.example.tarea06.Cliente cliente;
    // TODO: Rename and change types of parameters
    private Banco banco;
    private int numero;

    public FragmentEditCliente() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEditCliente.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEditCliente newInstance(Serializable banco, int numero) {
        FragmentEditCliente fragment = new FragmentEditCliente();
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
        final View view = inflater.inflate(R.layout.fragment_edit_cliente, container, false);

        et_dni = view.findViewById(R.id.et_dni);
        et_apellidos = view.findViewById(R.id.et_apellidos);
        et_nombres = view.findViewById(R.id.et_nombres);
        et_direccion = view.findViewById(R.id.et_direccion);
        et_telefono = view.findViewById(R.id.et_telefono);

        com.example.tarea06.Cliente[] clientes = {banco.getObjCliente01(), banco.getObjCliente02(), banco.getObjCliente03(), banco.getObjCliente04(), banco.getObjCliente05()};
        cliente = clientes[numero-1];

        et_dni.setText(cliente.getDni());
        et_apellidos.setText(cliente.getApellidos());
        et_nombres.setText(cliente.getNombres());
        et_direccion.setText(cliente.getDireccion());
        et_telefono.setText(cliente.getTelefono());

        view.findViewById(R.id.btn_aceptar).setOnClickListener(this);
        view.findViewById(R.id.btn_cancelar).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_aceptar:
                Intent data = new Intent();
                cliente.setDni(et_dni.getText().toString());
                cliente.setApellidos(et_apellidos.getText().toString());
                cliente.setNombres(et_nombres.getText().toString());
                cliente.setDireccion(et_direccion.getText().toString());
                cliente.setTelefono(et_telefono.getText().toString());
                data.putExtra("banco", banco);
                getActivity().setResult(Activity.RESULT_OK, data);
                break;
            case R.id.btn_cancelar:
                getActivity().setResult(Activity.RESULT_CANCELED);
        }
        getActivity().finish();
    }
}