package com.example.user.calculoimc;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void btnCalcularOnClick(View v) {

        TextView lblResultado = (TextView) findViewById(R.id.lblResultado);
        TextView lblImc = (TextView) findViewById(R.id.lblImc);
        TextView lblSexo = (TextView) findViewById(R.id.lblSexo);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        EditText txtPeso = (EditText) findViewById(R.id.txtPeso);
        EditText txtAltura = (EditText) findViewById(R.id.txtAltura);
        RadioGroup rbresultado = (RadioGroup) findViewById(R.id.radioSex);
        int valorCheck = rbresultado.getCheckedRadioButtonId();

        // validando campos vazios
        if ((txtPeso.getText().toString().equals("")) || (txtAltura.getText().toString().equals(""))) {
            if (txtPeso.getText().toString().equals("")){
                txtPeso.setError("Campo Obrigatório!");
                Toast.makeText(MainActivity.this, "Informe seu peso!", Toast.LENGTH_SHORT).show();
           } if (txtAltura.getText().toString().equals("")){
                txtAltura.setError("Campo Obrigatório!");
                Toast.makeText(MainActivity.this, "Informe sua altura!", Toast.LENGTH_SHORT).show();
         }
            imageView.setImageResource(R.mipmap.aguardando);
        } else {
            int peso = Integer.parseInt(txtPeso.getText().toString());
            float altura = Float.parseFloat(txtAltura.getText().toString());
            Float resultado = peso / (altura * altura);


                if (resultado < 17) {
                    lblResultado.setText("Resultado: Muito abaixo do peso!");
                    imageView.setImageResource(R.mipmap.abaixo);
                } else if (resultado < 18.49) {
                    lblResultado.setText("Resultado: Abaixo do peso!");
                    imageView.setImageResource(R.mipmap.abaixo);
                } else if (resultado < 24.99) {
                    lblResultado.setText("Resultado: Peso Normal!!!");
                    imageView.setImageResource(R.mipmap.ideal);
                } else if (resultado < 29.99) {
                    lblResultado.setText("Resultado: Acima do peso!");
                    imageView.setImageResource(R.mipmap.acima);
                } else if (resultado < 34.99) {
                    lblResultado.setText("Resultado: Obesidade I !");
                    imageView.setImageResource(R.mipmap.acima);
                } else if (resultado < 39.99) {
                    lblResultado.setText("Resultado: Obesidade II (Severa)!");
                    imageView.setImageResource(R.mipmap.acima);
                }
                else {
                    lblResultado.setText("mResultado: Obesidade III (Mórbida)!");
                    imageView.setImageResource(R.mipmap.acima);
                }

            lblImc.setText("IMC: " + resultado.toString());

            if (valorCheck == 2131427419) { //feminino
                lblSexo.setText("Sexo: Feminino");
            }else{
                lblSexo.setText("Sexo: Masculino");
                }


        }

    }
}
