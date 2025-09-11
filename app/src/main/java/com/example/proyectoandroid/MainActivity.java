package com.example.proyectoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //eso
    Button btnReg;
    Button button1;
    //EditText


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText InputP = findViewById(R.id.inputP);
        EditText InputPassword = findViewById(R.id.inputC);

        Bundle extras = getIntent().getExtras();


        btnReg = findViewById(R.id.btnRegistrar);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegistrarActivity.class);
                startActivity(intent);
            }
        });


        button1 = findViewById(R.id.btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            public boolean VerificarDatos(){
                boolean Listo = true;
                String InputPGet = InputP.getText().toString();
                String InputPasswordGet = InputPassword.getText().toString();

                if (InputPGet.isEmpty()) {
                    InputP.setError("Ingresar datos");
                    Listo = false;
                }

                if(InputPasswordGet.isEmpty()){
                    InputPassword.setError("Ingresar datos");
                    Listo = false;
                }

                if (extras != null) {
                    // Recupera los datos usando las mismas claves
                    String usuarioExtrasVer = extras.getString("nombre_usuario");
                    String PasswordextrasVer = extras.getString("Password_usuario");

                    if(!InputPGet.equals(usuarioExtrasVer)){
                       InputP.setError("Usuario no encontrado");
                       Listo = false;
                    }

                    if(!InputPasswordGet.equals(PasswordextrasVer)){
                        InputPassword.setError("Contraseña no valida");
                        Listo = false;
                    }
                }

                return Listo;
            }


            @Override
            public void onClick(View v) {

                String NombreUsuario = InputP.getText().toString();
                Intent intent = new Intent(MainActivity.this,PagePrincipalActivity.class);
                intent.putExtra("NomUsuario_listo", NombreUsuario);

                //si los campos EditTxt estan llenados, podremos ocupar el btn
                if(VerificarDatos()){
                    startActivity(intent);
                }
            }
        });
    }
}