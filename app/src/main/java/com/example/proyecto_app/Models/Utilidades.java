package com.example.proyecto_app.Models;

import com.example.proyecto_app.R;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {

    private int idImagen;
    private String nomProducto;
    private String descripcion;

    public Utilidades(int idImagen, String nomProducto, String descripcion){
        this.idImagen=idImagen;
        this.nomProducto=nomProducto;
        this.descripcion=descripcion;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static List<Utilidades> getlista (){
    List<Utilidades> lista = new ArrayList<Utilidades>();

        lista.add(new Utilidades(R.drawable.acrilico,"Bote de pintura Acrílica","Pintura acrílica color rosa fluorescente de 120 ml."));
        lista.add(new Utilidades(R.drawable.aerografo,"Aerógrafo","Aerógrafo para pintura de pequeñas piezas, recomendado para modelismo."));
        lista.add(new Utilidades(R.drawable.molde,"Molde de silicona","Molde de silicona con distintas formas de plumas, para pasta de moldear."));
        lista.add(new Utilidades(R.drawable.oleos,"Set de pintura","Set de pintura al oleo, con materiales complementarios."));
        lista.add(new Utilidades(R.drawable.paleta_mezcla,"Paleta para mezclas","Paleta de madera para mezcla de pintura."));
        lista.add(new Utilidades(R.drawable.pastel,"Set de pinturas pastel","Set de pinturas pastel en diferentes tonos. Técnica seca."));
        lista.add(new Utilidades(R.drawable.pinceles,"Set de pinceles","Set de pinceles profesionales, recomendados para pintura al óleo."));
        lista.add(new Utilidades(R.drawable.plumas,"Set de puntas para pluma","Set de puntas para caligrafía con pluma."));
        lista.add(new Utilidades(R.drawable.rotuladores,"Set de rotuladores acrílicos","Set de rotuladores de pintura acrílica."));
        lista.add(new Utilidades(R.drawable.tallado,"Set de herramientas para modelado","Set de herramientas para modelado en materiales blandos."));

        return lista;
    }
}
