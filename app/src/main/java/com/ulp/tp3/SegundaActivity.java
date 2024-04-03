package com.ulp.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import Model.Pelicula;

public class SegundaActivity extends AppCompatActivity {
    private SegundaActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_segunda);

        // Inicializa el ViewModel
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(SegundaActivityViewModel.class);

        vm.getMutablePelicula().observe(this, new Observer<Pelicula>() {
            @Override
            public void onChanged(Pelicula pelicula) {
                // Actualiza la interfaz de usuario con la información de la película
                TextView titulo = findViewById(R.id.Title);
                TextView tvDirector = findViewById(R.id.tvDirector);
                TextView tvActores = findViewById(R.id.tvActores);
                TextView tvDescription = findViewById(R.id.tvDescription);
                ImageView ivImg = findViewById(R.id.ivImg);

                titulo.setText(pelicula.getTitulo());
                tvDirector.setText(pelicula.getDirector());
                tvActores.setText(pelicula.getActores());
                tvDescription.setText(pelicula.getSinopsis());
                ivImg.setImageResource(pelicula.getFoto());
            }
        });

        vm.traerPelicula(getIntent());

        Button bt = findViewById(R.id.btVolver);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
