package com.example.practica_t6;

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

public class SegundaPantallaLogin extends AppCompatActivity {

    private Button btnDesconectar;
    private TextView mostrarCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_pantalla_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mostrarCorreo = findViewById(R.id.mostrarCorreo);
        Intent intent = getIntent();
        String correo = intent.getStringExtra("correo");
        mostrarCorreo.setText(correo);

        btnDesconectar = findViewById(R.id.btnDesconectar);
        btnDesconectar.setOnClickListener(v -> {
            finish();
        });

    }
}