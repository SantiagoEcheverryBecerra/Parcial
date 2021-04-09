package com.seb.formalarioproductos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ib.custom.toast.CustomToastView;

import models.Producto;


public class Consultar extends AppCompatActivity implements View.OnClickListener {

    private Button btnSin;
    private Button btnCon;
    private Button btnCostoso;
    private Button btnBarato;
    private Button btnPromedio;
    private TextView tvLista;

    MainActivity MainActivity = new MainActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        btnSin = findViewById(R.id.btnSin);
        btnCon = findViewById(R.id.btnCon);
        btnCostoso = findViewById(R.id.btnCostoso);
        btnBarato = findViewById(R.id.btnBarato);
        btnPromedio = findViewById(R.id.btnPromedio);
        tvLista = findViewById(R.id.tvLista);


        btnSin.setOnClickListener(this);
        btnCon.setOnClickListener(this);
        btnCostoso.setOnClickListener(this);
        btnBarato.setOnClickListener(this);
        btnPromedio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSin) {
            sinIva();
        }
        if (v.getId() == R.id.btnCon) {
            conIva();
        }
        if (v.getId() == R.id.btnCostoso) {
            costoso();
        }
        if (v.getId() == R.id.btnBarato) {
            bataro();
        }
        if (v.getId() == R.id.btnPromedio) {
            promedio();
        }
    }

    public void sinIva() {
        String Producto= "";
        for (int i = 0; i < MainActivity.listProductos.size(); i++) {
            if(MainActivity.listProductos.get(i).getExento()) {

                Producto = MainActivity.listProductos.get(i).getNombre() + " " + MainActivity.listProductos.get(i).getNombre() + " " + MainActivity.listProductos.get(i).getValor();
            }
        }
        tvLista.setText(" El producto Exento de IVA es: " + Producto);
    }

    public void conIva() {
        String Producto= "";
        for (int i = 0; i < MainActivity.listProductos.size(); i++) {
            if(!MainActivity.listProductos.get(i).getExento()) {

                Producto = MainActivity.listProductos.get(i).getNombre() + " " + MainActivity.listProductos.get(i).getNombre() + " " + MainActivity.listProductos.get(i).getValor();
            }
        }
        tvLista.setText(" El producto con IVA es: " + Producto);
    }

    public void costoso() {
        int costoso = 0;
        String  Producto= "";
        for (int i = 0; i < MainActivity.listProductos.size(); i++) {
            if(MainActivity.listProductos.get(i).getValor() > costoso) {
                costoso = MainActivity.listProductos.get(i).getValor();
                Producto = MainActivity.listProductos.get(i).getNombre() + " " + MainActivity.listProductos.get(i).getValor();
            }
        }
        tvLista.setText(" El producto más costoso es: " + Producto);

    }

    public void bataro() {
        int barato = 999999999;
        String  Producto= "";
        for (int i = 0; i < MainActivity.listProductos.size(); i++) {
            if(MainActivity.listProductos.get(i).getValor() < barato) {
                barato = MainActivity.listProductos.get(i).getValor();
                Producto = MainActivity.listProductos.get(i).getNombre() + " " + MainActivity.listProductos.get(i).getValor();
            }
        }
        tvLista.setText(" El producto más barato es: " + Producto);
    }

    public void promedio() {
        int promedio = 0;
        int contador = 0;
        for (int i = 0; i < MainActivity.listProductos.size(); i++) {
            contador =contador+MainActivity.listProductos.get(i).getValor();
        }
        promedio = contador/MainActivity.listProductos.size();
        tvLista.setText(" El producto más barato es: " + promedio);
    }
}