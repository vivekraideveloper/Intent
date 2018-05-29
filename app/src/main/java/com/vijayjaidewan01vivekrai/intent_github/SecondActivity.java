package com.vijayjaidewan01vivekrai.intent_github;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);
        button = findViewById(R.id.button);

        Bundle bundle = getIntent().getExtras();
        textView.setText(bundle.getString("data"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("pending", editText.getText().toString());
                setResult(1, intent);
                finish();
            }
        });
    }
}
