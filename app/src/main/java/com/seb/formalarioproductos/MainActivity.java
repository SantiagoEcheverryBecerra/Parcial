package com.seb.formalarioproductos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;
import java.util.List;

import models.Producto;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private EditText txtNombre;
private EditText txtCodigo;
private EditText txtValor;
private CheckBox chExento;
private EditText txtDescripcion;
private Button btnAgregar;
private Button btnConsultar;
public List<Producto> listProductos = new ArrayList();


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre= findViewById(R.id.txtNombre);
        txtCodigo=findViewById(R.id.txtCodigo);
        txtValor=findViewById(R.id.txtValor);
        txtDescripcion=findViewById(R.id.txtDescripcion);
        btnAgregar=findViewById(R.id.btnAgregar);
        btnConsultar=findViewById(R.id.btnConsultar);
        chExento=findViewById(R.id.chExento);
        btnConsultar.setOnClickListener(this);
        btnAgregar.setOnClickListener(this);

        }

@Override
public void onClick(View v) {
        if (v.getId() == R.id.btnAgregar){
        String Nombre = txtNombre.getText().toString();
        int Codigo;
        if (txtCodigo.getText().toString().equals("")){
                Codigo= 0;
        } else {
                Codigo = Integer.parseInt(txtCodigo.getText().toString());
        }
        int Valor;
        if (txtValor.getText().toString().equals("")){
                Valor= 0;
        } else {
                Valor = Integer.parseInt(txtValor.getText().toString());
        }
        Boolean Exento = Boolean.parseBoolean(chExento.getText().toString());
        String Descripcion = txtDescripcion.getText().toString();

        if (Nombre.isEmpty()){
                CustomToastView.makeErrorToast(this, "Error al validar el Nombre", R.layout.custom_toast).show();
                return;
        }
        if (Codigo == 0){
                CustomToastView.makeErrorToast(this, "Error al validar el Código", R.layout.custom_toast).show();
                return;
        }
        if (Valor == 0){
                CustomToastView.makeErrorToast(this, "Error al validar el Valor", R.layout.custom_toast).show();
                return;
        }
        if (Descripcion.isEmpty()){
                CustomToastView.makeErrorToast(this, "Error al validar la Descrición", R.layout.custom_toast).show();
                return;
        }
        crearProducto(Nombre, Codigo, Valor, Exento, Descripcion);
        }
        if (v.getId() == R.id.btnConsultar){
        Intent consulta = new Intent(this, Consultar.class);
        startActivity(consulta);

                Producto producto1 = new Producto("Arroz", 0121, 2500, true, "Grano");
                Producto producto2 = new Producto("Arroz", 0154, 1500, false, "Grano");
                Producto producto3 = new Producto("Arroz", 0157, 500, true, "Grano");
                this.listProductos.add(producto1);
                this.listProductos.add(producto2);
                this.listProductos.add(producto3);
        }

        }

        public void crearProducto (String Nombre, int Codigo, int Valor, Boolean Exento, String Descripcion){

                Producto producto = new Producto(Nombre, Codigo, Valor, Exento, Descripcion);
                this.listProductos.add(producto);
                limpiarCampos();
        }

        public void limpiarCampos()
        {
                txtNombre.setText("");
                txtCodigo.setText("");
                txtValor.setText("");
                txtDescripcion.setText("");
        }





}