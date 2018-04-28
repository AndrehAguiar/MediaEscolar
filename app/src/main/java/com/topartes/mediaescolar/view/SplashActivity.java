package com.topartes.mediaescolar.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.topartes.mediaescolar.R;
import com.topartes.mediaescolar.controller.MediaEscolarCtrl;
import com.topartes.mediaescolar.model.MediaEscolar;

import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        apresentaTelaSplash();
    }

    private void apresentaTelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                MediaEscolarCtrl mediaEscolarCtrl = new MediaEscolarCtrl(getBaseContext());

                List<MediaEscolar> objetos = MediaEscolarCtrl.listar();

                for (MediaEscolar obj : objetos) {
                    Log.i("CRUD LISTAR", "ID: " + obj.getId() + " - Matéria: " + obj.getMateria());
                }

                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}
