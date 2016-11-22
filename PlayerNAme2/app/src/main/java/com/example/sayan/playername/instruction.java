package com.example.sayan.playername;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class instruction extends Activity implements View.OnClickListener{
    static TextView tv;
    public Button b;
    public ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
         tv = (TextView) findViewById(R.id.textView5);
        b=(Button)findViewById(R.id.button6);
        iv=(ImageView)findViewById(R.id.imageView);
        iv.setImageResource(R.drawable.help);
        b.setOnClickListener(this);
        tv.setText("Instruction:-" + "\n" + "After click start Button, you see jumbled up of cricket player name (1.point in the picture or red color text),example:- suppose player name 'Afridi' after jumbled up R-A-D-I-I-F and then you guess the player and write the player name to text editor(no 4), then press 'ok'" + "\n" + "You get 3 chance for right guess(point no. 2)" + "\n" + "if you give right answer and get 1 point ,(show at point 3 )" + "\n" + "And you can get hints ,so press hint button.");
    }
    public void onClick(View v)
        {
                finish();
         }


}

