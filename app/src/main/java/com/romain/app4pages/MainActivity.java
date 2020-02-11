package com.romain.app4pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int SECOND_CALL_ID = 1234;

    private EditText idTextMain;
    private Button idBtnMainActivity;
    private TextView lblMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idTextMain = (EditText) findViewById(R.id.idTxtMain);
        idBtnMainActivity = (Button) findViewById(R.id.idBtnMainActivity);
        lblMain = (TextView) findViewById(R.id.lblMain);

        idBtnMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                     // On demande à voir le this de MainActivity, NON pas le this de OnClickListener
                    MainActivity.this,
                    // On passe un descripteur de type, NON pas un objet
                    SecondActivity.class
                );
                // On charge notre intention avec des données (comme une HashTable): une paire d'informations (clé, valeur)
                intent.putExtra("message", idTextMain.getText().toString());
                /* MainActivity.this*/
                // ForResult pour pouvoir récupérer des données en sortie
                startActivityForResult(intent, SECOND_CALL_ID);


            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SECOND_CALL_ID){
            lblMain.setText("Result == " + resultCode);
        }

    }

}
