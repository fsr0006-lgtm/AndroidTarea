package com.example.myapplication;
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

    //Video minuto 6:54

}
