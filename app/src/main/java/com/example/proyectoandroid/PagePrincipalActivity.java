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

public class PagePrincipalActivity extends AppCompatActivity {

    Button btnSomos;
    Button btnLista;
    Button btnPerfil;

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

        btnSomos = findViewById(R.id.btnSomos);
        btnLista = findViewById(R.id.btnLista);
        btnPerfil = findViewById(R.id.btnPerfil);
        TextView txtBienvenido = findViewById(R.id.txtBienvenido);

        Bundle extras = getIntent().getExtras();

        /*if(extras != null){
            String nombreUsu = extras.getString("nombre_usuario");
            txtBienvenido.setText(nombreUsu);
        } */

        // completen las funciones teniendo en cuenta las ventanas y el nombre que les pusieron :v
        /*
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSomos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        }); */






    }
}