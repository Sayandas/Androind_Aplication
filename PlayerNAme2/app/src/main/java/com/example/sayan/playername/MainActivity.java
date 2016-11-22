package com.example.sayan.playername;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import static android.media.CamcorderProfile.get;

public class MainActivity extends Activity implements View.OnClickListener{
   public Button start,ok,reset,hint,ex,help;
    public TextView point,to,ew;
    public EditText et;
    static int p,c,ch;
    public String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.editText);
        to=(TextView)findViewById(R.id.textView3);
        point=(TextView)findViewById(R.id.textView2);
        start=(Button)findViewById(R.id.button);
        help=(Button)findViewById(R.id.button7);
        ok=(Button)findViewById(R.id.button3);
        hint=(Button)findViewById(R.id.button4);
        reset=(Button)findViewById(R.id.button2);
        ex=(Button)findViewById(R.id.button5);
        ew=(TextView)findViewById(R.id.textView4) ;
        start.setOnClickListener(this);
        ok.setOnClickListener(this);
        ex.setOnClickListener(this);
        help.setOnClickListener(this);
        reset.setOnClickListener(this);
        ok.setEnabled(false);
        hint.setEnabled(false);
        hint.setOnClickListener(this);

        p=0;
        ch=3;
    }
    public void onClick(View v){
        ArrayList<String> wr=new ArrayList<String>();
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(getAssets().open("cricket.txt")));
            String line=br.readLine();
            while(line!=null)
            {
                wr.add(line);
                line=br.readLine();
            }
        }catch(IOException e){
            Toast toast = Toast.makeText(this, "Could not load TextFile", Toast.LENGTH_LONG);
            toast.show();
        }
        switch (v.getId())
        {
            case R.id.button :

                et.setText("");
                Random rn=new Random();
                 s= wr.get(rn.nextInt(wr.size()));
                hint.setEnabled(true);
                String pl=shuffle(s);
                to.setText(pl);
                Toast to2= Toast.makeText(this, "After guess ,press OK", Toast.LENGTH_SHORT);
                to2.show();
                start.setText("N E X T");
                ok.setEnabled(true);
                help.setVisibility(View.INVISIBLE);
                start.setEnabled(false);

                break;
            case R.id.button3 :
                    if(ch>1) {
                        String etext = et.getText().toString().trim();
                        //etext.toLowerCase();
                        if(etext.length()!=0) {
                            if (etext.equalsIgnoreCase(s)) {
                                p++;
                                hint.setEnabled(false);
                                if (p > 9) {
                                    point.setText(p);
                                } else {
                                    point.setText("0" + p);
                                }
                                start.setEnabled(true);
                                to.setText("Press NEXT");
                                ch = 3;
                                ew.setText("C h a n c e : " + ch);
                                ok.setEnabled(false);
                                et.setText("");
                            } else {
                                ch--;
                                ew.setText("C h a n c e : " + ch);
                                Toast to = Toast.makeText(this, "sorry!!Wrong answar", Toast.LENGTH_SHORT);
                                to.show();
                            }
                        }
                        else
                        {
                            Toast to = Toast.makeText(this, "Please enter player's name!", Toast.LENGTH_SHORT);
                            to.show();

                        }
                    }
                else
                    {
                        ok.setEnabled(false);
                        start.setText("S T A R T");
                        ch=3;
                        hint.setEnabled(true);
                        ew.setText("C h a n c e : "+ch);
                        start.setEnabled(true);
                        to.setText("press start button to play");
                        Toast to= Toast.makeText(this, "sorry!! Your 3 chance is finised your score is "+p, Toast.LENGTH_LONG);
                        to.show();
                        Toast to1= Toast.makeText(this, "player is "+s.toUpperCase(), Toast.LENGTH_LONG);
                        help.setVisibility(View.VISIBLE);
                        to1.show();
                        et.setText("");
                        p=0;
                        point.setText("00");

                    }

                break;
            case R.id.button2 :
                            p=0;
                            point.setText("00");
                            start.setEnabled(true);
                            start.setText("S T A R T");
                            hint.setEnabled(false);
                             ch=3;
                help.setVisibility(View.VISIBLE);
                        ew.setText("C h a n c e : "+ch);
                            to.setText("press start button to play");
                ok.setEnabled(false);
                Toast to = Toast.makeText(this, "RESET", Toast.LENGTH_SHORT);
                to.show();
                break;
            case R.id.button4:
                Toast t= Toast.makeText(this, "Starting latter-> "+s.charAt(0), Toast.LENGTH_LONG);
                t.show();
                break;
            case R.id.button5 :
                finish();

                break;
            case R.id.button7:
                Intent intent = new Intent(MainActivity.this,instruction.class);
                startActivity(intent);
                break;







        }

    }
    public String shuffle(String s)
    {

        String shuffledString ="";
        while (s.length() != 0)
        {
            int index = (int) Math.floor(Math.random()*s.length());
            char c=s.charAt(index);
            s=s.substring(0,index)+s.substring(index+1);
            shuffledString+=c;
            if(s.length()>=1)
            {shuffledString+=" - ";}
        }

        return shuffledString;

    }
}
