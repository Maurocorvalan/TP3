package com.ulp.tp3;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import Model.Pelicula;

public class SegundaActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Pelicula> mutablePelicula;

    public SegundaActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Pelicula> getMutablePelicula() {
        if (mutablePelicula == null) {
            mutablePelicula = new MutableLiveData<>();
        }
        return mutablePelicula;
    }

    public void traerPelicula(Intent intent) {
        Pelicula pelicula = (Pelicula) intent.getSerializableExtra("pelicula");
        if (pelicula != null) {
            mutablePelicula.setValue(pelicula);
        }
    }
}
