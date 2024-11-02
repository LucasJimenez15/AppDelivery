package com.example.appdelivery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Crea un nuevo Handler que permite ejecutar código después de un retraso especificado
        new Handler().postDelayed(new Runnable() {

            // Implementa el método run() que se ejecutará después del retraso
            @Override
            public void run() {

                // Crea una Intent que indica que queremos iniciar MainActivity
                Intent intencion = new Intent(SplashActivity.this, MainActivity.class);

                // Lanza la MainActivity, iniciando la transición desde la SplashActivity
                startActivity(intencion);

                // Llama a finish() para cerrar la SplashActivity
                // Esto asegura que al presionar "atrás" no se regrese a la pantalla de Splash
                finish();
            }

            // 3000 milisegundos = 3 segundos, tiempo de espera antes de ejecutar el código en run()
        }, 3000);


    }
}