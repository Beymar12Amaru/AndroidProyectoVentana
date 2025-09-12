package com.example.proyectoandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PerfilActivity extends AppCompatActivity {

    Button btnVolverPagePrin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            // Recupera los datos usando las mismas claves
            String extrasObtenerNom = extras.getString("usuarioNombre1");
            String extrasObtenerCor = extras.getString("usuarioCorreo1");
            String extrasObtenerRut = extras.getString("usuarioRut1");

            TextView txtNombreMostrar = findViewById(R.id.txtNombreMostrar);
            TextView txtCorreoMostrar = findViewById(R.id.txtCorreoMostrar);
            TextView txtRutMostrar = findViewById(R.id.txtRutMostrar);

            txtNombreMostrar.setText( extrasObtenerNom);
            txtCorreoMostrar.setText(extrasObtenerCor);
            txtRutMostrar.setText(extrasObtenerRut);
        }

        btnVolverPagePrin = findViewById(R.id.btnVolverPagePrin);

        btnVolverPagePrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}