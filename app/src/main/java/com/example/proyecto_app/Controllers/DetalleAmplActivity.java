package com.example.proyecto_app.Controllers;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_app.R;

public class DetalleAmplActivity extends AppCompatActivity {

    private ImageView imagenProd;
    private TextView detalletitulo;
    private TextView detalledescr;
    private TextView detalleComent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalleampl);

        this.imagenProd = (ImageView) findViewById(R.id.imagenProd);
        this.detalletitulo = (TextView) findViewById(R.id.detalletitulo);
        this.detalledescr = (TextView) findViewById(R.id.detalledescr);
        this.detalleComent = (TextView) findViewById(R.id.detalleComent);

        detalleComent.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);


        int imagenResource = getIntent().getIntExtra("ITEM_IMAGE",0);
        String nombre = getIntent().getStringExtra("ITEM_NAME");
        String desc = getIntent().getStringExtra("ITEM_DESC");

        if (imagenProd != null) {imagenProd.setImageResource(imagenResource);}
        if (detalletitulo != null) {detalletitulo.setText(nombre);}
        if(detalledescr != null) {detalledescr.setText(desc);}

    }
}
