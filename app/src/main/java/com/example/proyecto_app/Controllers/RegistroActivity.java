package com.example.proyecto_app.Controllers;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_app.R;
import com.google.android.material.snackbar.Snackbar;

public class RegistroActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextTextEmail;
    private EditText editTextEdad;
    private Button Enviar;
    private int edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        this.editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        this.editTextTextEmail= (EditText) findViewById(R.id.editTextTextEmail);
        this.editTextEdad= (EditText) findViewById(R.id.editTextEdad);
        this.Enviar= (Button) findViewById(R.id.buttonenviar);


        Enviar.setBackground(getDrawable(R.drawable.botones_redondeados));
        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextNombre.getText().toString().isEmpty()) {
                    myLongToast("El campo nombre está vacío, por favor introduzca su nombre. ");
                } else if (editTextTextEmail.getText().toString().isEmpty()) {
                    myLongToast("El campo e-mail está vacío, por favor introduzca su e-mail. ");
                } else if (editTextEdad.getText().toString().isEmpty() && !editTextEdad.getText().toString().matches("\\d+")) {
                    myLongToast("El campo edad está vacío o no se han introducido numeros, por favor introduzca su edad. ");
                }
                else {
                    edad = Integer.parseInt(editTextEdad.getText().toString());
                    if (edad < 18) {
                        Snackbar snackbar = Snackbar.make(view, "Debes de tener 18 años o más para registrarte", Snackbar.LENGTH_LONG);
                        snackbar.setBackgroundTint(Color.argb(255, 0, 160, 126));
                        View snackbarView = snackbar.getView();
                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) snackbarView.getLayoutParams();
                        params.setMargins(0, 0, 0, 110);
                        snackbarView.setLayoutParams(params);
                        snackbar.setAction("Entendido", new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                editTextEdad.setText("");
                            }
                        });
                        snackbar.setActionTextColor(Color.WHITE);
                        snackbar.show();
                    } else {
                        AlertDialog alertdialog = createAlertDialog("¡Bienvenido!", "Nos alegra que te unas a nuestra comunidad de artistas, usuario registrado correctamente.");
                        alertdialog.show();
                    }
                }
            }
        });
    }

    private AlertDialog createAlertDialog(String titulo, String mensaje) {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegistroActivity.this);
        builder.setTitle(titulo);
        builder.setMessage(mensaje);
        builder.setNegativeButton("CERRAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        return builder.create();
    }

    private void myLongToast(String mensaje) {
        Toast.makeText(RegistroActivity.this,mensaje,Toast.LENGTH_LONG).show();
    }
}
