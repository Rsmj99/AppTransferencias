package com.example.tarea06;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDepoReti#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDepoReti extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView tv_mtdepositos, tv_mtretiros, tv_ndepositos, tv_nretiros, tv_saldo, tv_tipo1, tv_tipo2, tv_tipo3, tv_tipo4, tv_tipo5, tv_monto1, tv_monto2, tv_monto3, tv_monto4, tv_monto5;
    private Spinner spcuenta;

    // TODO: Rename and change types of parameters
    private Banco banco;
    private int numero;

    public FragmentDepoReti() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDepoReti.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDepoReti newInstance(Serializable banco, int numero) {
        FragmentDepoReti fragment = new FragmentDepoReti();
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
        final View view = inflater.inflate(R.layout.fragment_depo_reti, container, false);

        tv_mtdepositos = view.findViewById(R.id.tv_mtdepositos);
        tv_mtretiros = view.findViewById(R.id.tv_mtretiros);
        tv_ndepositos = view.findViewById(R.id.tv_ndepositos);
        tv_nretiros = view.findViewById(R.id.tv_nretiros);
        tv_saldo = view.findViewById(R.id.tv_saldo);
        spcuenta = view.findViewById(R.id.spcuenta);

        tv_tipo1 = view.findViewById(R.id.tv_tipo1);
        tv_tipo2 = view.findViewById(R.id.tv_tipo2);
        tv_tipo3 = view.findViewById(R.id.tv_tipo3);
        tv_tipo4 = view.findViewById(R.id.tv_tipo4);
        tv_tipo5 = view.findViewById(R.id.tv_tipo5);

        tv_monto1 = view.findViewById(R.id.tv_monto1);
        tv_monto2 = view.findViewById(R.id.tv_monto2);
        tv_monto3 = view.findViewById(R.id.tv_monto3);
        tv_monto4 = view.findViewById(R.id.tv_monto4);
        tv_monto5 = view.findViewById(R.id.tv_monto5);

        Cliente[] clientes = {banco.getObjCliente01(), banco.getObjCliente02(), banco.getObjCliente03(), banco.getObjCliente04(), banco.getObjCliente05()};
        Cuenta[] cuentas = {clientes[numero-1].getObjCuenta01(), clientes[numero-1].getObjCuenta02(), clientes[numero-1].getObjCuenta03()};
        ArrayAdapter<Cuenta> adapter = new ArrayAdapter<Cuenta>(getActivity(), android.R.layout.simple_spinner_item, cuentas);
        spcuenta.setAdapter(adapter);

        spcuenta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv_mtdepositos.setText(cuentas[i].mtdepositos + "");
                tv_mtretiros.setText(cuentas[i].mtretiros + "");
                tv_ndepositos.setText(cuentas[i].ndepositos + "");
                tv_nretiros.setText(cuentas[i].nretiros + "");
                tv_saldo.setText(cuentas[i].getSaldo() + "");

                tv_tipo1.setText((cuentas[i].ObjOperaciones[0] != null) ? "TIPO:     " + cuentas[i].ObjOperaciones[0].getTipo().toString() : "");
                tv_tipo2.setText((cuentas[i].ObjOperaciones[1] != null) ? "TIPO:     " + cuentas[i].ObjOperaciones[1].getTipo().toString() : "");
                tv_tipo3.setText((cuentas[i].ObjOperaciones[2] != null) ? "TIPO:     " + cuentas[i].ObjOperaciones[2].getTipo().toString() : "");
                tv_tipo4.setText((cuentas[i].ObjOperaciones[3] != null) ? "TIPO:     " + cuentas[i].ObjOperaciones[3].getTipo().toString() : "");
                tv_tipo5.setText((cuentas[i].ObjOperaciones[4] != null) ? "TIPO:     " + cuentas[i].ObjOperaciones[4].getTipo().toString() : "");

                tv_monto1.setText((cuentas[i].ObjOperaciones[0] != null) ? "MONTO:     " + cuentas[i].ObjOperaciones[0].getMonto() + "" : "");
                tv_monto2.setText((cuentas[i].ObjOperaciones[1] != null) ? "MONTO:     " + cuentas[i].ObjOperaciones[1].getMonto() + "" : "");
                tv_monto3.setText((cuentas[i].ObjOperaciones[2] != null) ? "MONTO:     " + cuentas[i].ObjOperaciones[2].getMonto() + "" : "");
                tv_monto4.setText((cuentas[i].ObjOperaciones[3] != null) ? "MONTO:     " + cuentas[i].ObjOperaciones[3].getMonto() + "" : "");
                tv_monto5.setText((cuentas[i].ObjOperaciones[4] != null) ? "MONTO:     " + cuentas[i].ObjOperaciones[4].getMonto() + "" : "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        return view;
    }
}