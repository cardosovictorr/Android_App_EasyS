package com.example.android_app_easys_version4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_app_easys_version4.activities.OptionsPageActivity;

public class MainActivity extends AppCompatActivity {

    Button logInButton;
    EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logInButton = findViewById(R.id.logInButton);
        //userNameEditText = findViewById(R.id.userNameEditText);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the validation for the name and password could come here
                //but we are not going to do it yet
                //lets send the user to the main page after login

                Intent goToMainPageUserIntent = new Intent(MainActivity.this, OptionsPageActivity.class);
                //String userName = userNameEditText.getText().toString();

                /*
                As we are not in need of the Username for now, I am commenting that part and going directly to the next page without needing
                to check username etc...
                //create an Instance of User
                User user = new User();
                user.setUserName(userName);

                goToMainPageUserIntent.putExtra(User.USER_KEY, user);
                //StartActivityFor result is used when it need tos wait for information to go to the next screen

                startActivityForResult(goToMainPageUserIntent, REQUEST_CODE_MAIN_PAGE_SCREEN);
                */
                startActivity(goToMainPageUserIntent);
            }
        });

    }

}
