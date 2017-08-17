package com.brayadiaz.clase_1_interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String nombre, apellido, email, numero, sexo, hobbies = " ", ciudad;
    private EditText conName, conLastName, conEmail, conNumero;
    private Button boton;
    private TextView conInfo;
    private RadioButton conFemenino, conMasculino;
    private CheckBox cCine, cDormir, cComer, cBailar;
    private Spinner sCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conName = (EditText) findViewById(R.id.conName);
        conLastName = (EditText) findViewById(R.id.conLastName);
        boton = (Button) findViewById(R.id.boton);
        conInfo = (TextView) findViewById(R.id.conInfo);
        conEmail = (EditText) findViewById(R.id.email);
        conNumero = (EditText) findViewById(R.id.numero);
        conFemenino = (RadioButton) findViewById(R.id.femenino);
        conMasculino = (RadioButton) findViewById(R.id.masculino);
        cCine = (CheckBox) findViewById(R.id.cine);
        cDormir = (CheckBox) findViewById(R.id.dormir);
        cComer = (CheckBox) findViewById(R.id.comer);
        cBailar = (CheckBox) findViewById(R.id.bailar);
        sCiudades = (Spinner) findViewById(R.id.sCiudades);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sCiudades.setAdapter(adapter);

        sCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ciudad = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //sCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener());



        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hobbies = " ";
                nombre = conName.getText().toString();
                apellido = conLastName.getText().toString();
                email = conEmail.getText().toString();
                numero = conNumero.getText().toString();

                if(conFemenino.isChecked()) {
                    sexo = "Femenino";
                }else {
                    sexo = "Masculino";
                }

                if (cCine.isChecked()){hobbies += "Cine, ";}
                if (cDormir.isChecked()){hobbies += "Dormir, ";}
                if (cBailar.isChecked()){hobbies += "Bailar, ";}
                if (cComer.isChecked()){hobbies += "Comer ";}
               //int oper1 = Integer.parseInt(conName.getText().toString());
                //int oper2 = Integer.parseInt(conLastName.getText().toString());
               // int suma =  oper1 + oper2;

                conInfo.setText("Nombre: " + nombre + "\nApellido: " + apellido + "\nCorreo: " +
                        email + "\nTelefono: " + numero + "\nSexo: " + sexo + "\nHobbies:" +
                        hobbies + "\nCiudad: " + ciudad);
               // conInfo.setText(" El resultado es: " + suma);
            }
        });
    }
}
