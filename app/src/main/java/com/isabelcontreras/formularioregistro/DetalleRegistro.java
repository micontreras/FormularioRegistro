package com.isabelcontreras.formularioregistro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class DetalleRegistro extends AppCompatActivity {
    private TextView tvNombre;
    private TextView tvFechaNac;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_registro);

        Bundle paramatros = getIntent().getExtras();
        String nombre = paramatros.getString(getResources().getString(R.string.p_nombre));
        String fechaNac = paramatros.getString(getResources().getString(R.string.p_fecha_nac));
        String telefono = paramatros.getString(getResources().getString(R.string.p_telefono));
        String email = paramatros.getString(getResources().getString(R.string.p_email));
        String descContacto = paramatros.getString(getResources().getString(R.string.p_desc_contacto));

        tvNombre= (TextView)findViewById(R.id.tvNombre);
        tvFechaNac= (TextView)findViewById(R.id.tvFechaNac);
        tvTelefono= (TextView)findViewById(R.id.tvTelefono);
        tvEmail= (TextView)findViewById(R.id.tvEmail);
        tvDescContacto= (TextView)findViewById(R.id.tvDescContacto);

        tvNombre.setText(nombre);
        tvFechaNac.setText(fechaNac);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescContacto.setText(descContacto);
    }

    public void mostrarEditar(View view){
        Intent intentDetalle=new Intent(this, MainActivity.class);
        intentDetalle.putExtra(getResources().getString(R.string.p_nombre), tvNombre.getText().toString());
        intentDetalle.putExtra(getResources().getString(R.string.p_fecha_nac),tvFechaNac.getText().toString());
        intentDetalle.putExtra(getResources().getString(R.string.p_telefono), tvTelefono.getText().toString());
        intentDetalle.putExtra(getResources().getString(R.string.p_email), tvEmail.getText().toString());
        intentDetalle.putExtra(getResources().getString(R.string.p_desc_contacto), tvDescContacto.getText().toString());
        startActivity(intentDetalle);
        finish();
    }
}
