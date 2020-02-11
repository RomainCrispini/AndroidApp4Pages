package com.romain.app4pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView lblSecond;
    private Button idBtnSecondClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lblSecond = (TextView) findViewById(R.id.lblSecond);
        idBtnSecondClose = (Button) findViewById(R.id.idBtnSecondClose);

        // Doit renvoyer chaine de caractères (getString) dont la clé est "message" (cf MainActivity)
        // this est mon activité, this.getIntent renvoit l'intention qui a démarré mon activité, on lui récupère ses extrasData (objet type bundle)
        // et on passe en paramètre la clé "message"
        String inputData = this.getIntent().getExtras().getString("message");
        // et on set le label avec le string récupéré
        lblSecond.setText(inputData);

        idBtnSecondClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(33);
                finish();
            }
        });

    }
}
