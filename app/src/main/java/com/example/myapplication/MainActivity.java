package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText weightInput, sizeInput;
    private Button calculateButton;
    private ImageView resultImage;
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightInput = findViewById(R.id.weightInput);
        sizeInput = findViewById(R.id.sizeInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultImage = findViewById(R.id .resultImage);
        resultText = findViewById(R.id.resultText);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateIMC();
            }
        });
    }
    private void calculateIMC() {

        String weightString = weightInput.getText().toString();
        String sizeString = sizeInput.getText().toString();
        if (!weightString.isEmpty() && !sizeString.isEmpty()) {

            float weight = Float.parseFloat(weightString);
            float size = Float.parseFloat(sizeString) / 100;


            float imc = weight / (size * size);


            displayIMC(imc);
        } else {

            resultText.setText("Veuillez remplir tous les champs.");
            resultImage.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }
    private void displayIMC(float imc) {
        // Déterminer la catégorie d'IMC
        String category;
        if (imc < 18.5) {
            category = "Maigre";
            resultImage.setImageResource(R.drawable.maigre);
        } else if (imc < 24.9) {
            category = "Normal";
            resultImage.setImageResource(R.drawable.normal);
        } else if (imc < 29.9) {
            category = "Surpoids";
            resultImage.setImageResource(R.drawable.surpoids);
        } else if(imc < 40){
            category = "Obèse";
            resultImage.setImageResource(R.drawable.obese);
        } else{
            category= "Obèse massive";
            resultImage.setImageResource(R.drawable.t_obese);
        }

        // Afficher le résultat
        resultText.setText("Votre IMC est : " + imc + "\nCatégorie : " + category);
    }
}
