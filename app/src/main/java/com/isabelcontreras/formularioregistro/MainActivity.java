package com.isabelcontreras.formularioregistro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatePickerDialog picker;
    private TextInputEditText tvNombre;
    private TextInputEditText tvFechaNac;
    private TextInputEditText tvTelefono;
    private TextInputEditText tvEmail;
    private TextInputEditText tvDescContacto;
    private Button buttonSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNombre= (TextInputEditText)findViewById(R.id.tvNombre);
        tvFechaNac= (TextInputEditText)findViewById(R.id.tvFechaNac);
        tvTelefono= (TextInputEditText)findViewById(R.id.tvTelefono);
        tvEmail= (TextInputEditText)findViewById(R.id.tvEmail);
        tvDescContacto= (TextInputEditText)findViewById(R.id.tvDescContacto);
        buttonSiguiente=(Button)findViewById(R.id.buttonSiguiente);

        Bundle paramatros = getIntent().getExtras();
        if(paramatros!=null){
            String nombre = paramatros.getString(getResources().getString(R.string.p_nombre));
            String fechaNac = paramatros.getString(getResources().getString(R.string.p_fecha_nac));
            String telefono = paramatros.getString(getResources().getString(R.string.p_telefono));
            String email = paramatros.getString(getResources().getString(R.string.p_email));
            String descContacto = paramatros.getString(getResources().getString(R.string.p_desc_contacto));
            tvNombre.setText(nombre);
            tvFechaNac.setText(fechaNac);
            tvTelefono.setText(telefono);
            tvEmail.setText(email);
            tvDescContacto.setText(descContacto);
        }

    }

    public void getDatePicker(View view) {
        final Calendar cldr = Calendar.getInstance();
        int dia = cldr.get(Calendar.DAY_OF_MONTH);
        int mes = cldr.get(Calendar.MONTH);
        int anio = cldr.get(Calendar.YEAR);
        picker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int anio, int mesAnio, int diaMes) {
                        tvFechaNac.setText((getDia(diaMes)) + "/" + (getMes(mesAnio)) + "/" + anio);
                    }
                }, anio, mes, dia);
        picker.show();
    }

    public void mostrarConfirmacion(View view){
        Intent intentDetalle=new Intent(MainActivity.this, DetalleRegistro.class);
        intentDetalle.putExtra(getResources().getString(R.string.p_nombre), tvNombre.getText().toString());
        intentDetalle.putExtra(getResources().getString(R.string.p_fecha_nac),tvFechaNac.getText().toString());
        intentDetalle.putExtra(getResources().getString(R.string.p_telefono), tvTelefono.getText().toString());
        intentDetalle.putExtra(getResources().getString(R.string.p_email), tvEmail.getText().toString());
        intentDetalle.putExtra(getResources().getString(R.string.p_desc_contacto), tvDescContacto.getText().toString());
        startActivity(intentDetalle);
        finish();
    }
    public String getDia(int dia){
        if(dia<9){
            return "0"+(dia);
        }
        return ""+(dia);
    }

    public String getMes(int mes){
        if(mes<9){
            return "0"+(mes+1);
        }
        return ""+(mes+1);
    }

}
