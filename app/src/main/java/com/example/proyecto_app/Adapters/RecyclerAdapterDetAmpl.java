package com.example.proyecto_app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_app.Controllers.DetalleAmplActivity;
import com.example.proyecto_app.Models.Utilidades;
import com.example.proyecto_app.R;

import java.util.List;

public class RecyclerAdapterDetAmpl extends RecyclerView.Adapter<RecyclerAdapterDetAmpl.RecyclerHolder> {

    private Context context;
    private List<Utilidades> utilidadesList;

    public RecyclerAdapterDetAmpl(Context context, List<Utilidades> utilidadesList){
        this.context = context;
        this.utilidadesList = utilidadesList;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalleampl,parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        Utilidades utilidades = utilidadesList.get(position);

        holder.imagenProd.setImageResource(utilidades.getIdImagen());
        holder.detalletitulo.setText(utilidades.getNomProducto());
        holder.detalledescr.setText(utilidades.getDescripcion());


    }



    @Override
    public int getItemCount() {
        return utilidadesList.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder{

        ImageView imagenProd;
        TextView detalletitulo;
        TextView detalledescr;

        public RecyclerHolder(@NonNull View itemView){
            super(itemView);

            imagenProd = (ImageView) itemView.findViewById(R.id.imagenProd);
            detalletitulo = (TextView) itemView.findViewById(R.id.detalletitulo);
            detalledescr = (TextView) itemView.findViewById(R.id.detalledescr);

        }
    }
}
