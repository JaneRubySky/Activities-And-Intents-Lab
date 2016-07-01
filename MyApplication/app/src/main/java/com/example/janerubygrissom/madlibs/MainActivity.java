package com.example.janerubygrissom.madlibs;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText adjectiveOne;
        final EditText adjectiveTwo;
        final EditText nounOne;
        final EditText nounTwo;
        final EditText animal;
        final EditText game;
        final List<EditText> editText;

        adjectiveOne = (EditText) findViewById(R.id.edittext_one);
        adjectiveTwo = (EditText) findViewById(R.id.edittext_two);
        nounOne = (EditText) findViewById(R.id.edittext_three);
        nounTwo = (EditText) findViewById(R.id.edittext_four);
        animal = (EditText) findViewById(R.id.edittext_five);
        game = (EditText) findViewById(R.id.edittext_six);

        editText = new ArrayList<>();

        editText.add(adjectiveOne);
        editText.add(adjectiveTwo);
        editText.add(nounOne);
        editText.add(nounTwo);
        editText.add(animal);
        editText.add(game);

        for (EditText anotherEditText : editText) {
            editTextListener(anotherEditText);
        }
        //Button submit = (Button) findViewById(R.id.submit);
        ImageView submit = (ImageView) findViewById(R.id.heart);
        Drawable drawable = getResources().getDrawable(R.drawable.heart);
        submit.setImageDrawable(drawable);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEditTextInput(editText)); {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("adjectiveOne", adjectiveOne.getText().toString());
                    intent.putExtra("adjectiveTwo", adjectiveTwo.getText().toString());
                    intent.putExtra("nounOne", nounOne.getText().toString());
                    intent.putExtra("nounTwo", nounTwo.getText().toString());
                    intent.putExtra("animal", animal.getText().toString());
                    intent.putExtra("game", game.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }


    public void editTextListener(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (editText.getText().toString().length() == 0 && editText.isEnabled())
                    editText.setError("Enter some text");
                else if (editText.getText().toString().length() > 64 && editText.isEnabled()) {
                    editText.setError("This is way too long.");
                } else {
                    editText.setError(null);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText.getText().toString().length() < 3 && editText.isEnabled()) {
                    editText.setError("Write ");
                } else {
                    editText.setError(null);
                }
            }


        });
    }
    public boolean checkEditTextInput(List<EditText> editTexts) {

        for (EditText editText : editTexts) {
            if (editText.getError() != null) {

                editText.setError("Go back and fix your errors");
//                        Error errors = errors.make(linearLayout, "Go back and fix your errors", Errors.LENGTH_LONG);
//                        errors.show();
                return false;
            }
        }
        return true;
    }


}

