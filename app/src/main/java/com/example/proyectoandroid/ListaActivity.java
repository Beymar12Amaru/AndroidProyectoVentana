package com.example.proyectoandroid;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListaActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String ExtraNombreCarrera = extras.getString("NombreCarrera");
            String ExtraAñosCarrera = extras.getString("AñosCarrera");

            TextView txtNombreCarr1 = findViewById(R.id.txtNombreCarr1);
            TextView txtDuracion1 = findViewById(R.id.txtDuracion1);

            txtNombreCarr1.setText(ExtraNombreCarrera);
            txtDuracion1.setText(ExtraAñosCarrera);
        }
    }
}