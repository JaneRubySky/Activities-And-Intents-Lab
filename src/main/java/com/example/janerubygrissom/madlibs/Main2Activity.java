package com.example.janerubygrissom.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView madLibText;
    Button goBack;
    String adjectiveOne, adjectiveTwo, nounOne, nounTwo, animal, game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        adjectiveOne = intent.getStringExtra("adjectiveOne");
        adjectiveTwo = intent.getStringExtra("adjectiveTwo");
        nounOne = intent.getStringExtra("nounOne");
        nounTwo = intent.getStringExtra("nounTwo");
        animal = intent.getStringExtra("animal");
        game = intent.getStringExtra("game");

        goBack = (Button) findViewById(R.id.goBack);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        madLibText = (TextView) findViewById(R.id.textview_madlib);
        madLibText.setText("_______ " + adjectiveOne + " _____________ " +
                adjectiveTwo + "______________ " + nounOne + "_________________ " + nounTwo + "_______________" +
                "_______________" + animal + "________________" + game + ".");
    }
}
