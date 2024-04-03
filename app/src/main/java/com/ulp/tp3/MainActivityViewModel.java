package com.ulp.tp3;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import Model.Pelicula;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<List<Pelicula>> listMutable;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Pelicula>> getListMutable() {
        if (listMutable == null) {
            listMutable = new MutableLiveData<>();
        }
        return listMutable;
    }

    public void crearLista() {
        ArrayList<Pelicula> lista = new ArrayList<>();
        lista.add(new Pelicula("Interestelar",
                "Matthew McConaughey, Anne Hathaway, Jessica Chastain",
                "Un grupo de exploradores se embarca en un viaje interestelar en busca de un nuevo hogar para la humanidad, luchando contra el tiempo y el espacio para salvar a la humanidad.",
                "Christopher Nolan", R.drawable.interestellar));
        lista.add(new Pelicula("Fight Club",
                "Brad Pitt, Edward Norton, Helena Bonham Carter",
                "Un joven sin rumbo se une a un enigmático hombre llamado Tyler Durden para formar un club clandestino donde los hombres luchan entre sí como forma de catarsis, desencadenando una serie de eventos incontrolables.",
                "David Fincher", R.drawable.fightclub));
        lista.add(new Pelicula("Forrest Gump",
                "Tom Hanks, Robin Wright, Gary Sinise",
                "La vida de un hombre sencillo desde su infancia hasta la edad adulta, mientras vive una serie de extraordinarias experiencias que lo llevan a cruzarse con importantes eventos históricos de Estados Unidos.",
                "Robert Zemeckis", R.drawable.forrestgump));

        // Establecer la lista en el LiveData
        listMutable.setValue(lista);
    }

    public void verDescripcion() {
        Intent intent = new Intent(getApplication().getApplicationContext(), SegundaActivity.class);
    }
}
