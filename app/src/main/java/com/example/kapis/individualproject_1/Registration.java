package com.example.kapis.individualproject_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class Registration extends AppCompatActivity {

    Button submit;
    EditText emailaddress;
    //public String login = "";
    EditText fname, lname, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        emailaddress = (EditText)findViewById(R.id.regEdit4);
        submit = (Button)findViewById(R.id.regBtn);
        fname = (EditText)findViewById(R.id.regEdit1);
        lname =  (EditText)findViewById(R.id.regEdit2);
        pass = (EditText)findViewById(R.id.regEdit5);


        // Intent to move back to previous page upon successful validation
        final Intent success = new Intent(this, Main2Activity.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //created a charsequence for function to validate email
                CharSequence login = emailaddress.getText().toString();

                //check if any fields are empty
                if (emailaddress.getText().toString().isEmpty() || fname.getText().toString().isEmpty()
                        || lname.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "No missing fields allowed",
                            Toast.LENGTH_LONG);
                    toast.show();
                }

                //check email validation
                else if (!isValidEmail(login)){
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Please provide accurate email",
                            Toast.LENGTH_LONG);
                    toast3.show();
                }

                // Validate the length of the name fields
                else if (fname.getText().toString().length() < 3 || lname.getText().toString().length() < 3){
                    Toast toast4 = Toast.makeText(getApplicationContext(), "Name must be at least 3 letters",
                            Toast.LENGTH_LONG);
                    toast4.show();
                }

                // if everything is valid, call the intent to move back to previous page
                else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Account Created",
                            Toast.LENGTH_LONG);
                    toast1.show();
                    startActivity(success);
                }
            }
        });


//        Intent i = new Intent(this, Main2Activity.class);
//        i.putExtra("login", login);
//        startActivity(i);

    }

    // function that checks if email is correct using android's own pattern utility
    public final static boolean isValidEmail(CharSequence target)
    {
        if (TextUtils.isEmpty(target))
        {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
