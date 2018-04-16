package br.com.uninove.aula.meutime.customviews;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.com.uninove.aula.meutime.R;

/**
 * Created by jsoft-ti on 15/04/18.
 */

public class MeuJogador extends LinearLayout{
    private ImageView imgFoto;
    private TextView txtNome;
    private Context context;

    public ImageView getImgFoto() {
        return imgFoto;
    }

    public void setImgFoto(Bitmap imgFoto) {
        this.imgFoto.setImageBitmap(imgFoto);
    }

    public TextView getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(String txtNome) {
        this.txtNome.setText(txtNome);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    public MeuJogador(Context context,  AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.MeuJogador,
                0, 0);
        init();
        try {
            imgFoto.setImageResource(R.drawable.jogadornone);
            txtNome.setText(R.string.string_selecione_jogador);
        } finally {
            a.recycle();
        }
    }

    private void init(){
        inflate(getContext(),R.layout.meu_jogador,this);
        this.txtNome = (TextView)findViewById(R.id.txtNome);
        this.imgFoto = (ImageView)findViewById(R.id.imgFoto);



    }



    private boolean isDeviceSupportCamera() {
        if (this.context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA))
            return true;
        else {
            Toast.makeText(this.context, "Camera não suportada", Toast.LENGTH_SHORT).show();
            return false;
        }
    }



}
