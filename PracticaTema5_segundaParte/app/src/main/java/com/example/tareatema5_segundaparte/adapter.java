package com.example.tareatema5_segundaparte;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<adapter.coches>{

    private coches[] listaCoches;
    public adapter(coches[] listaCoches){
        this.listaCoches = listaCoches;
    }


public static class cochesViewHolder extends RecyclerView.ViewHolder{

    public TextView marcaView;
    public ImageView portadaView;
    private Context context;

    public cochesViewHolder(View view, Context context){

        super(view);
        this.context = context;

        marcaView = view.findViewById(R.id.marcaView);
        portadaView = view.findViewById(R.id.imageView);

    }
    public void BindCoches(coches coche){

        marcaView.setText(coche.marca);
        portadaView.setImageResource(context.getResources()
                .getIdentifier(coche.image,
                        "drawable",
                        "com.example.listas"));
    }



}
}