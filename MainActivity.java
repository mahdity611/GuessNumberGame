package com.example.guessthenumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Random;

public class MainActivity extends Activity {

    int numberToGuess;
    EditText editTextGuess;
    TextView textViewStatus;
    Button buttonGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGuess = findViewById(R.id.editTextGuess);
        textViewStatus = findViewById(R.id.textViewStatus);
        buttonGuess = findViewById(R.id.buttonGuess);

        generateRandomNumber();

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guessText = editTextGuess.getText().toString();
                if (!guessText.isEmpty()) {
                    int guess = Integer.parseInt(guessText);
                    checkGuess(guess);
                }
            }
        });
    }

    void generateRandomNumber() {
        Random rand = new Random();
        numberToGuess = rand.nextInt(100) + 1;
    }

    void checkGuess(int guess) {
        if (guess == numberToGuess) {
            textViewStatus.setText("مبروك! خمنت الرقم الصحيح.");
            generateRandomNumber();
        } else if (guess < numberToGuess) {
            textViewStatus.setText("الرقم أكبر!");
        } else {
            textViewStatus.setText("الرقم أصغر!");
        }
    }
}
