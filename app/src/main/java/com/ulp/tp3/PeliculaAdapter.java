package com.ulp.tp3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import Model.Pelicula;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {
    private List<Pelicula> listaDePeliculas;
    private Context context;
    private LayoutInflater layoutInflater;

    public PeliculaAdapter(List<Pelicula> listaDePeliculas, Context context, LayoutInflater layoutInflater) {
        this.listaDePeliculas = listaDePeliculas;
        this.context = context;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pelicula pelicula = listaDePeliculas.get(position);
        holder.bind(pelicula);
    }

    @Override
    public int getItemCount() {
        return listaDePeliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo, description;
        private ImageView foto;
        private Button btDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            description = itemView.findViewById(R.id.Description);
            foto = itemView.findViewById(R.id.foto);
            btDescription = itemView.findViewById(R.id.btDescription);
        }

        public void bind(Pelicula pelicula) {
            titulo.setText(pelicula.getTitulo());
            description.setText(pelicula.getSinopsis());
            foto.setImageResource(pelicula.getFoto());

            btDescription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Preparar para ver la descripción de la película
                    Intent intent = new Intent(context, SegundaActivity.class);
                    intent.putExtra("pelicula", pelicula);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}