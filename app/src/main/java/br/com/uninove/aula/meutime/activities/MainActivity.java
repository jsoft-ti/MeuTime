package br.com.uninove.aula.meutime.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import br.com.uninove.aula.meutime.R;
import br.com.uninove.aula.meutime.customviews.MeuJogador;

public class MainActivity extends Activity{
    private MeuJogador meuJogador1,meuJogador2,meuJogador3,meuJogador4,meuJogador5,meuJogador6,meuJogador7,meuJogador8,meuJogador9,meuJogador10,meuJogador11;
    private MeuJogador jogadorSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void editarJogar(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            this.jogadorSelecionado = (MeuJogador)view;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            jogadorSelecionado.setImgFoto(imageBitmap);
            solicitarNomeJogador();
        }
    }

    public void solicitarNomeJogador(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Insira o nome do Jogador");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                jogadorSelecionado.setTxtNome(input.getText().toString());
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
