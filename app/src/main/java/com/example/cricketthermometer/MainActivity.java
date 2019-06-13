package com.example.cricketthermometer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    String userInput;
    int celsiusTemp, fahrenheitTemp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.results);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userInput = editText.getText().toString();

                if(userInput.length() != 0) {

                    Log.d("user input", userInput);

                    editText.setText("");
                    textView.setText("");

                    calculateTemp(userInput);

                    textView.append(Html.fromHtml("<p>It is approximately " + fahrenheitTemp + "°F fahrenheit and " + celsiusTemp + "°C celsius.</p>"));

                    //Log.d("chrips", calculateFahrenheit(userInput));
                    closeKeyboard();
                }
            }
        });

    }


    private void calculateTemp(String userInput){

        celsiusTemp = Integer.parseInt(userInput) / 3 + 4;

        fahrenheitTemp = (celsiusTemp * 9/5) + 32;



    }

    private void closeKeyboard(){
        View view = this.getCurrentFocus();

        if(view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }




}
