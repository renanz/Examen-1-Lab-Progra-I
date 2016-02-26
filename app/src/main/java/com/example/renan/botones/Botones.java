package com.example.renan.botones;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Botones extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones);
        String opc[];
        opc = new String[4];
        opc[0] = "+";
        opc[1] = "-";
        opc[2] = "*";
        opc[3] = "/";
        int operador_int = 0;
        Spinner operador = (Spinner) findViewById(R.id.operador);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, opc);
        operador.setAdapter(adapter);

        operador.setOnItemSelectedListener(new OnItemSelectedListener() {
            int operador_int = 0;

            @Override
            public void onItemSelected(AdapterView<?> adapter, View view, int pos, long id) {
                switch (pos) {
                    case 0:
                        Toast.makeText(adapter.getContext(), "Suma. ", Toast.LENGTH_SHORT).show();
                        operador_int = 1;
                        break;
                    case 1:
                        Toast.makeText(adapter.getContext(), "Resta. ", Toast.LENGTH_SHORT).show();
                        operador_int = 2;
                        break;
                    case 2:
                        Toast.makeText(adapter.getContext(), "Multiplicacion. ", Toast.LENGTH_SHORT).show();
                        operador_int = 3;
                        break;
                    case 3:
                        Toast.makeText(adapter.getContext(), "Division. ", Toast.LENGTH_SHORT).show();
                        operador_int = 4;
                        break;
                }
                Button calcular = (Button) findViewById(R.id.calcular);

                calcular.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText num1 = (EditText) findViewById(R.id.num1);
                        EditText num2 = (EditText) findViewById(R.id.num2);
                        TextView resultado = (TextView) findViewById(R.id.resultado);


                        double num1_double = Double.parseDouble(num1.getText().toString());
                        double num2_double = Double.parseDouble(num2.getText().toString());
                        double resultado_double = 0;
                        if (operador_int==1){
                            resultado_double = num1_double + num2_double;
                        }
                        else if (operador_int==2){
                            resultado_double = num1_double - num2_double;
                        }
                        else if (operador_int==3){
                            resultado_double = num1_double * num2_double;
                        }
                        else if (operador_int==4){
                            resultado_double = num1_double / num2_double;
                        }
                        boolean checked = ((CheckBox) findViewById(R.id.Double_Int)).isChecked();
                        if (checked){
                            resultado.setText("" + resultado_double);
                        }
                        else
                            resultado.setText("" + (int)resultado_double);


                    };
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });
        boolean checked = ((CheckBox) findViewById(R.id.Double_Int)).isChecked();

        // Check which checkbox was clicked
        switch(findViewById(R.id.Double_Int).getId()) {
            case R.id.Double_Int:
                if (checked){
                    Toast.makeText(adapter.getContext(), "Boton presionado. ", Toast.LENGTH_SHORT).show();

                }

                break;

        }


        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Botones Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.renan.botones/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Botones Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.renan.botones/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
