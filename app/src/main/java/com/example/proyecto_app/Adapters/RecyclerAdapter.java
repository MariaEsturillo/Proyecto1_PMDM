package com.example.proyecto_app.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_app.Controllers.DetalleAmplActivity;
import com.example.proyecto_app.Controllers.ListaActivity;
import com.example.proyecto_app.Controllers.RegistroActivity;
import com.example.proyecto_app.Models.Utilidades;
import com.example.proyecto_app.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    private androidx.appcompat.view.ActionMode mActionMode;

    private Context context;
    private List<Utilidades> utilidadesList;
    private AppCompatActivity activity;

    public RecyclerAdapter(Context context, List<Utilidades> utilidadesList, AppCompatActivity activity){
        this.context = context;
        this.utilidadesList = utilidadesList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detalle,parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        int posicionActual = holder.getAdapterPosition();
        Utilidades utilidades = utilidadesList.get(posicionActual);
        holder.imgProducto.setImageResource(utilidades.getIdImagen());
        holder.nomproducto.setText(utilidades.getNomProducto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (posicionActual != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(context, DetalleAmplActivity.class);
                    intent.putExtra("ITEM_IMAGE", utilidades.getIdImagen());
                    intent.putExtra("ITEM_NAME", utilidades.getNomProducto());
                    intent.putExtra("ITEM_DESC", utilidades.getDescripcion());
                    context.startActivity(intent);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int posicionActual = holder.getAdapterPosition();
                if (posicionActual != RecyclerView.NO_POSITION && activity != null) {
                  activity.startSupportActionMode(new ActionMode.Callback() {
                      @Override
                      public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                          mode.getMenuInflater().inflate(R.menu.action_menu,menu);
                          mode.setTitle("Menu");

                          return true;
                      }

                      @Override
                      public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                          return false;
                      }

                      @Override
                      public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                          int itemId = item.getItemId();
                          if(itemId == R.id.borrar){
                              AlertDialog alertDialog = createAlertDialog("Aviso","Va a borrar este producto, ¿Está seguro? ",posicionActual);
                              alertDialog.show();
                          }
                          mode.finish();
                          return true;
                      }

                      @Override
                      public void onDestroyActionMode(ActionMode mode) {
                          mActionMode = null;
                      }
                  });
              }
                return true;
            }
        });
    }



    @Override
    public int getItemCount() {
        return utilidadesList.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder{

        ImageView imgProducto;
        TextView nomproducto;


        public RecyclerHolder(@NonNull View itemView){
            super(itemView);
            imgProducto = (ImageView) itemView.findViewById(R.id.img_item);
            nomproducto = (TextView) itemView.findViewById(R.id.txt_item_titulo);

        }
    }
    private AlertDialog createAlertDialog(String titulo, String mensaje, int posicionActual) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titulo);
        builder.setMessage(mensaje);
        builder.setPositiveButton("BORRAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                utilidadesList.remove(posicionActual);
                notifyItemRemoved(posicionActual);
                notifyItemRangeChanged(posicionActual, utilidadesList.size());
                myLongToast("Producto borrado");
            }
        });
        builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                myLongToast("Acción cancelada");

                dialogInterface.dismiss();
            }
        });
        return builder.create();
    }

    private void myLongToast(String mensaje) {
        Toast.makeText(context,mensaje,Toast.LENGTH_LONG).show();
    }

}
