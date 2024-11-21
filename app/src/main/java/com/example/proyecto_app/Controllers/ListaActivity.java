package com.example.proyecto_app.Controllers;

import static com.example.proyecto_app.Models.Utilidades.getlista;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_app.Adapters.RecyclerAdapter;
import com.example.proyecto_app.Models.Utilidades;
import com.example.proyecto_app.R;

import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private ActionMode mActionMode;


    private RecyclerView recyclerView;
    private RecyclerAdapter recAdapter;
    private Context context;
    private List<Utilidades> utilidadesList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);

        this.recyclerView = (RecyclerView) findViewById(R.id.ReciclerViewGrid);
        this.recAdapter = new RecyclerAdapter(this,getlista(),this);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setAdapter(recAdapter);
        recyclerView.setLayoutManager(layoutManager);

        getlista();

    }



}
