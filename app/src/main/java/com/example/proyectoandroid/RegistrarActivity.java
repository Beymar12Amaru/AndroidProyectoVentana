package com.example.proyectoandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrarActivity extends AppCompatActivity {

    Button btnRegistrarse;
    Button btnVolver;



    @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnVolver = findViewById(R.id.btnVolver);
        EditText ReInputNombre = findViewById(R.id.inputNombre);
        EditText ReInputRut = findViewById(R.id.inputRut);
        EditText ReInputCorreo = findViewById(R.id.inputCorreo);
        EditText ReInputPassword = findViewById(R.id.inputPassword);



        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btnRegistrarse.setOnClickListener(new View.OnClickListener() {

            // verificamos que los campos EditTxt no esten vacios
            public boolean CampoVerificar() {
                boolean listo = true;

                //almacenamos datos ingresados
                String VeriCamNombre = ReInputNombre.getText().toString();
                String VeriCamRut = ReInputRut.getText().toString();
                String VeriCamCorreo = ReInputCorreo.getText().toString();
                String VeriCamPassword = ReInputPassword.getText().toString();

                if(VeriCamNombre.isEmpty()){
                    ReInputNombre.setError("faltan datos >:c");
                    listo = false;
                }

                if(VeriCamRut.isEmpty()){
                    ReInputRut.setError("faltan datos >:c");
                    listo = false;
                }

                if(VeriCamCorreo.isEmpty()){
                    ReInputCorreo.setError("faltan datos >:c");
                    listo = false;
                }

                if(VeriCamPassword.isEmpty()){
                    ReInputPassword.setError("faltan datos >:c");
                    listo=false;
                }

                return listo;
            }

            @Override
            public void onClick(View v) {
                String VeriCamNombre1 = ReInputNombre.getText().toString();
                String VeriCamPassword1 = ReInputPassword.getText().toString();

                Intent intent = new Intent(RegistrarActivity.this,MainActivity.class);
                intent.putExtra("nombre_usuario", VeriCamNombre1);
                intent.putExtra("Password_usuario", VeriCamPassword1);

                if(CampoVerificar()){
                    Toast.makeText(RegistrarActivity.this, "Registrado Correctamente :v", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });




    }

    //funcion para verificar los cmpos llenos



}