package com.example.thecall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TextMessage extends AppCompatActivity {
    EditText newText;
    Button saveNext;
    DatabaseReference db;
    String count="1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_message);
        newText=findViewById(R.id. messageText);
        saveNext=findViewById(R.id.sendingA);

        db=FirebaseDatabase.getInstance().getReference();
        saveNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newMssg=newText.getText().toString();
                if(!newMssg.equals(" ")) {
                    Text text=new Text();
                    text.setText(newMssg);
                    text.setLocation("abc");
                    addToDb(text);
                    Intent intent = new Intent(TextMessage.this, MainActivity.class);
                    intent.putExtra("new message", newMssg);
                    startActivity(intent);
                }else{
                    Toast.makeText(TextMessage.this, "Please write text",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void addToDb(Text text){
        try {
            db.child("Message").child(count).setValue(text);
            Log.d("Data", "Sent");
            count=String.valueOf(Integer.parseInt(count)+1);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Data","Not sent");
        }

        //Toast.makeText(TextMessage.this,"Sent to db", Toast.LENGTH_SHORT).show();
    }
}