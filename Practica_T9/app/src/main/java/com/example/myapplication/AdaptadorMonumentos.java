package com.example.myapplication;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorMonumentos extends Recyclerview.Adapter<AdaptadorMonumentos.HolderMonumentos>{


    public static class HolderMonumentos extends RecyclerView.ViewHolder {
        TextView tvNombre;
        TextView tvUbicacion;
        TextView tvDescripcion;
        ImageView imagenMonumento;

        public HolderMonumentos(View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvUbicacion = itemView.findViewById(R.id.tvUbicacion);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            imagenMonumento = itemView.findViewById(R.id.imagenMonumento);


        }
    }
    private ArrayList<Monumento> monumentos;
    private Context context;


    //Video minuto 6:54

}
