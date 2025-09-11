package com.example.proyectoandroid;

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

    Button btnSomos;
    Button btnLista;
    Button btnPersonajes;

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


            // Muestra los datos en los TextViews del layout
            TextView tvNombre = findViewById(R.id.txtBienvenido);

            tvNombre.setText("Bienvenido " + nombreRecibido);
        }


        btnPersonajes = findViewById(R.id.btnPersonajes);

        /*btnPersonajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagePrincipalActivity.this, VetananpMain2Activity.class);
                startActivity(intent);
            }
        });*/




    }
}