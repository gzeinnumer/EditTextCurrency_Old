package com.gzeinnumer.edittextcurrency_old;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.edittextcurrency_old.utils.CurrencyConverter;
import com.gzeinnumer.edittextcurrency_old.utils.StringTools;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        sample1();
    }

    private void sample1() {
        editText.addTextChangedListener(new CurrencyConverter(editText));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Log.d(TAG, "onClick: " + StringTools.trimCommaOfString(str));

                textView.setText(StringTools.trimCommaOfString(str));
            }
        });
    }
}