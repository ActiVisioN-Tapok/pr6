package com.example.pr6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button bgButton;
    ConstraintLayout constrLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bgButton = findViewById(R.id.btn);
        constrLayout = findViewById(R.id.lt);
        context = MainActivity.this;
        bgButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.message);
        final CharSequence[] items = {getText(R.string.red), getText(R.string.blue), getText(R.string.green)};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        constrLayout.setBackgroundResource(R.color.red);
                        Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        constrLayout.setBackgroundResource(R.color.blue);
                        Toast.makeText(context, R.string.blue, Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        constrLayout.setBackgroundResource(R.color.green);
                        Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}