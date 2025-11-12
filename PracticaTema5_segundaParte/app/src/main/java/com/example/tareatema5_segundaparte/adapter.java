package com.example.tareatema5_segundaparte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<adapter.CochesViewHolder> {

    private coches[] listaCoches;

    public adapter(coches[] listaCoches) {
        this.listaCoches = listaCoches;
    }

    @NonNull
    @Override
    public CochesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marcas_item, parent, false);
        return new CochesViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull CochesViewHolder holder, int position) {
        holder.bindCoches(this.listaCoches[position]);
    }

    @Override
    public int getItemCount() {
        return this.listaCoches.length;
    }

    public static class CochesViewHolder extends RecyclerView.ViewHolder {

        public TextView marcaView;
        public ImageView portadaView;
        private Context context;

        public CochesViewHolder(View view, Context context) {
            super(view);
            this.context = context;
            marcaView = view.findViewById(R.id.marcaView);
            portadaView = view.findViewById(R.id.imageView);
        }

        public void bindCoches(coches coche) {
            marcaView.setText(coche.getMarca());
            portadaView.setImageResource(
                    context.getResources().getIdentifier(
                            coche.getImage(),
                            "drawable",
                            context.getPackageName()
                    )
            );
        }
    }
}
