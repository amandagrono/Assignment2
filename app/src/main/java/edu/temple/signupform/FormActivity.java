package edu.temple.signupform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button;
        button = findViewById(R.id.button);

        myOnclickListener onclickListener = new myOnclickListener();
        button.setOnClickListener(onclickListener);

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



    }
}