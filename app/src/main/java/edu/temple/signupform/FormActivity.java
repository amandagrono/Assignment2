package edu.temple.signupform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        button = findViewById(R.id.button);
        Button button2;
        button2 = findViewById(R.id.button2);

        myOnclickListener onclickListener = new myOnclickListener();
        button.setOnClickListener(onclickListener);

        resetOnClickListener reset = new resetOnClickListener();
        button2.setOnClickListener(reset);


    }
    public class resetOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v){
            TextView tv = findViewById(R.id.textView);
            tv.setText("Please Enter Your Information");
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
            Button button = findViewById(R.id.button2);
            button.setVisibility(Button.INVISIBLE);
            button = findViewById(R.id.button);
            button.setVisibility(Button.VISIBLE);

            EditText et = findViewById(R.id.editTextTextPersonName);
            et.getText().clear();
            et = findViewById(R.id.editTextTextEmailAddress);
            et.getText().clear();
            et = findViewById(R.id.editTextTextPassword);
            et.getText().clear();
            et = findViewById(R.id.editTextTextPassword2);
            et.getText().clear();


        }
    }

    public class myOnclickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            EditText et;
            String[] str = new String[4];
            et = findViewById(R.id.editTextTextPersonName);
            str[0] = et.getText().toString();
            et = findViewById(R.id.editTextTextEmailAddress);
            str[1] = et.getText().toString();
            et = findViewById(R.id.editTextTextPassword);
            str[2] = et.getText().toString();
            et = findViewById(R.id.editTextTextPassword2);
            str[3] = et.getText().toString();

            if(str[0].matches("") || str[1].matches("")||str[2].matches("")||str[3].matches("")){
                displayIncompleteError();
            }
            else {
                if (!str[2].equals(str[3])) {
                    displayPasswordError();
                }
                else{
                    messageToUser(str[0]);
                }
            }
        }
        private void displayIncompleteError(){
            Toast toast = Toast.makeText(getApplicationContext(), "Please Fill Out All Information", Toast.LENGTH_SHORT);

            toast.show();
        }
        private void displayPasswordError(){
            Toast toast = Toast.makeText(getApplicationContext(), "Passwords Do Not Match", Toast.LENGTH_SHORT);

            toast.show();
        }
        private void messageToUser(String name){
            TextView tv = findViewById(R.id.textView);
            tv.setText("Hello "+name+ ", welcome to the SignUpForm app");
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
            Button button = findViewById(R.id.button);
            button.setVisibility(Button.INVISIBLE);
            button = findViewById(R.id.button2);
            button.setVisibility(Button.VISIBLE);

        }



    }
}