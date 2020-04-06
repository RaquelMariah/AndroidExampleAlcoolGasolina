package com.ramaria.androidexamplealcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText text_preco_gasolina, text_preco_alcool;
    private TextView text_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_preco_alcool = findViewById(R.id.text_preco_alcool);
        text_preco_gasolina = findViewById(R.id.text_preco_gasolina);
        text_resultado = findViewById(R.id.text_resultado);

        }
    public void calcularPreco(View view){
    //recuperar valores digitados pelo usuário
        String precoAlcool = text_preco_alcool.getText().toString();
        String precoGasolina = text_preco_gasolina.getText().toString();
    //validação de campos
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){
    //conversão
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            //base de cálculo valor > 0.7
            Double resultado = valorAlcool / valorGasolina;
            if(resultado >=0.7){
                text_resultado.setText("A melhor opção é: Gasolina");
            }else{
                text_resultado.setText("A melhor oção é: Alcool");
            }

        }else{
            text_resultado.setText("Preencha todos os campos!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")){
            camposValidados = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados=false;
        }
        return camposValidados;
    }
}
