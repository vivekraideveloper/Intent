package com.vijayjaidewan01vivekrai.intent_github;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button internal, external, playstore, specific, passingData, pendingIntent;
    EditText editText;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internal = findViewById(R.id.internal);
        external = findViewById(R.id.external);
        playstore = findViewById(R.id.playstore);
        specific = findViewById(R.id.specific);
        passingData = findViewById(R.id.dataPassing);
        pendingIntent = findViewById(R.id.pendingIntent);
        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);

        internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.music");
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });

        playstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });

        specific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.vijayjaidewan01vivekrai.androidfirebase"));

                if (intent != null) {
                    startActivity(intent);
                }
            }
        });

        passingData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hey open", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data", editText.getText().toString());
                startActivity(intent);
            }
        });

        pendingIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data", editText.getText().toString());
                startActivityForResult(intent, 0);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == 1 && data != null) {

            Bundle bundle = data.getExtras();
            textView.setText(bundle.getString("pending"));


        }
    }
}
