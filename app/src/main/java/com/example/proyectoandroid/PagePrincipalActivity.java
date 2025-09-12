package com.example.proyectoandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PagePrincipalActivity extends AppCompatActivity {


    Button btnCrear;
    Button btnPerfil;
    //creamos una varialbe para almacenar el string de la otra pagina
    String NombreUsuariover, CorreoUs, RutUs;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            // Recupera los datos usando las mismas claves
            NombreUsuariover = extras.getString("NomUsuario_listo");
            CorreoUs = extras.getString("CorreoUsuario_listo");
            RutUs = extras.getString("RutUsuario_listo");

            TextView tvNombre = findViewById(R.id.txtBienvenido);

            tvNombre.setText("Bienvenido " + NombreUsuariover);

        }


        btnPerfil = findViewById(R.id.btnPerfil);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PagePrincipalActivity.this, PerfilActivity.class);
                intent.putExtra("usuarioNombre1",NombreUsuariover );
                intent.putExtra("usuarioCorreo1",CorreoUs );
                intent.putExtra("usuarioRut1",RutUs );
                startActivity(intent);
            }
        });

        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagePrincipalActivity.this, Crear_personajesActivity.class);
                startActivity(intent);
            }
        });




    }
}