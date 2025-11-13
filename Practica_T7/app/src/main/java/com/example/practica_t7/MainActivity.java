package com.example.practica_t7;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

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

        mediaPlayer = MediaPlayer.create(this, R.raw.musica);

            Button btnPlay = findViewById(R.id.btnPlay);
            Button btnPause = findViewById(R.id.btnPause);
            Button btnStop = findViewById(R.id.btnStop);


            btnPlay.setOnClickListener(v -> {
                mediaPlayer.start();
            });
            btnPause.setOnClickListener(v -> {
                mediaPlayer.pause();
            });
            btnStop.setOnClickListener(v -> {
                mediaPlayer.stop();
            });
            SeekBar seekBar = findViewById(R.id.seekBar);
            TextView tiempoLleva = findViewById(R.id.tiempoLleva);
            TextView tiempoQueda = findViewById(R.id.tiempoQueda);
            mediaPlayer.setOnPreparedListener(mp -> {
                seekBar.setMax(mediaPlayer.getDuration());
                tiempoLleva.setText("00:00");

                // Duración total al iniciar
                int duracion = mediaPlayer.getDuration();
                int minutosTotales = duracion / 1000 / 60;
                int segundosTotales = duracion / 1000 % 60;
                String tiempoTotal = String.format("%02d:%02d", minutosTotales, segundosTotales);
                tiempoQueda.setText(tiempoTotal);
            });
            //Actualiza el progreso cada segundo
        Handler handler = new Handler();
        Runnable actualizar = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                //Tiempo texView tiempoLleva
                int minutos = mediaPlayer.getCurrentPosition() / 1000 / 60;
                int segundos = mediaPlayer.getCurrentPosition() / 1000 % 60;
                String tiempo = String.format("%02d:%02d", minutos, segundos);
                tiempoLleva.setText(tiempo);
                //Tiempo textView timepoQueda
                int tiempoRestante = mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition();
                int minutosRestantes = tiempoRestante / 1000 / 60;
                int segundosRestantes = tiempoRestante / 1000 % 60;
                String tiempoRest = String.format("-%02d:%02d", minutosRestantes, segundosRestantes);
                tiempoQueda.setText(tiempoRest);

                //Actualizacion por segundo
                handler.postDelayed(this,1000);
            }
        };
        handler.post(actualizar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        SoundPool soundPool = new SoundPool.Builder().setMaxStreams(10).build();
        int sonido1 = soundPool.load(this,R.raw.sonido1,1);
        int sonido2 = soundPool.load(this,R.raw.sonido2,1);
        int sonido3 = soundPool.load(this,R.raw.sonido3,1);
        int sonido4 = soundPool.load(this,R.raw.sonido4,1);

        Button btnSonido1 = findViewById(R.id.btnSonido1);
        btnSonido1.setOnClickListener(v -> {
            soundPool.play(sonido1,1,1,1,0,1);
        });
        Button btnSonido2 = findViewById(R.id.btnSonido2);
        btnSonido2.setOnClickListener(v -> {
            soundPool.play(sonido2,1,1,1,0,1);
        });
        Button btnSonido3 = findViewById(R.id.btnSonido3);
        btnSonido3.setOnClickListener(v -> {
            soundPool.play(sonido3,1,1,1,0,1);
        });
        Button btnSonido4 = findViewById(R.id.btnSonido4);
        btnSonido4.setOnClickListener(v -> {
            soundPool.play(sonido4,1,1,1,0,1);
        });

    }
}