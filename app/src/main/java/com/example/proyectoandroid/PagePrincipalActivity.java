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
    String NombreUsuariover;
    String CorreoUs;
    String RutUs;

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
            String nombreRecibido = extras.getString("NomUsuario_listo");
            String CorreoRecibido = extras.getString("CorreoUsuario_listo");
            String RutRecibido = extras.getString("RutUsuario_listo");

            TextView tvNombre = findViewById(R.id.txtBienvenido);

            tvNombre.setText("Bienvenido " + nombreRecibido);

            NombreUsuariover = nombreRecibido;
            CorreoUs = CorreoRecibido;
            RutUs = RutRecibido;

        }


        btnPerfil = findViewById(R.id.btnPerfil);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String UsuarioVer = NombreUsuariover;
                String CorreoVer = CorreoUs;
                String RutVer = RutUs;

                Intent intent = new Intent(PagePrincipalActivity.this, PerfilActivity.class);
                intent.putExtra("usuarioNombre1",UsuarioVer );
                intent.putExtra("usuarioCorreo1",CorreoVer );
                intent.putExtra("usuarioRut1",RutVer );

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