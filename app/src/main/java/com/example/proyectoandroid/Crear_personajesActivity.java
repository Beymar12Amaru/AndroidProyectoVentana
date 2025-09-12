package com.example.proyectoandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Crear_personajesActivity extends AppCompatActivity {

    ImageView imagenGaleria;
    EditText InputCarreraC, InputAños;

    String CarreraEx, AñosEx;


    Button btnCargarImagen, btnLista, btnAñadir;


    private final ActivityResultLauncher<Intent> selectImageLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri imageUri = result.getData().getData();
                        imagenGaleria.setImageURI(imageUri);  // Mostrar la imagen seleccionada
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_personajes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imagenGaleria = findViewById(R.id.imageView);
        InputCarreraC = findViewById(R.id.InputCarreraC);
        InputAños = findViewById(R.id.InputAños);


        CarreraEx = InputCarreraC.getText().toString();
        AñosEx = InputAños.getText().toString();


        btnCargarImagen = findViewById(R.id.btnCargarImagen);
        btnCargarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                selectImageLauncher.launch(Intent.createChooser(intent, "Seleccione una imagen"));
            }
        });



        btnAñadir = findViewById(R.id.btnAñadir);
        btnAñadir.setOnClickListener(new View.OnClickListener() {

            public boolean DatosNull(){
                boolean DatosFall = true;
                if(CarreraEx.isEmpty() && AñosEx.isEmpty()){
                    Toast.makeText(Crear_personajesActivity.this, "Faltan Datos :v", Toast.LENGTH_SHORT).show();
                    DatosFall = false;
                }
                return DatosFall;
            }


            @Override
            public void onClick(View v) {

                if(DatosNull()){
                    Toast.makeText(Crear_personajesActivity.this, "registrado correctamente", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnLista = findViewById(R.id.btnLista);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Crear_personajesActivity.this, ListaActivity.class);
                startActivity(intent);

            }
        });




    }
}