package com.example.kapis.individualproject_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button register;
    Button signIn;
    EditText email;
    EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email = (EditText)findViewById(R.id.editText8);
        pass = (EditText)findViewById(R.id.editText9);
        register = (Button) findViewById(R.id.register);
        signIn = (Button) findViewById(R.id.signin);



        // button that calls the function to open the registration page from signing in
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistrationForm();
            }
        });

        signIn = (Button) findViewById(R.id.signin);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence username = email.getText().toString();

                //validating if the fields have correct values in them
                if (isValidEmail(username) && pass.getText().toString().length() > 3 ) {
                    openSignInPage();
                }

                //notifying if fields arent valid
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter a valid email",
                            Toast.LENGTH_LONG);
                    toast.show();
                }
            }


        });
    }

    //opens the registration page
    public void openRegistrationForm() {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    //opens the sign in page if the email address is valid
    public void openSignInPage() {
        Intent intent = new Intent(this, SignInPage.class);
        startActivity(intent);
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
