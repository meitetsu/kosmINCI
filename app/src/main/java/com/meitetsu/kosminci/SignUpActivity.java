package com.meitetsu.kosminci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, SignUpActivity.class);
        return intent;
    }

    private EditText mUsername;
    private EditText mPassword;
    private EditText mPasswordReply;
    private Button mSignUpButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);

        mUsername = findViewById(R.id.username);

        mPassword = findViewById(R.id.password);

        mSignUpButton = findViewById(R.id.signUpButton);
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                //Validating the log in data
//                boolean validationError = false;
//
//                StringBuilder validationErrorMessage = new StringBuilder("Proszę, wpisz ");
//                if (isEmpty(mUsername)) {
//                    validationError = true;
//                    validationErrorMessage.append("nazwę użytkownika");
//                }
//                if (isEmpty(mPassword)) {
//                    if (validationError) {
//                        validationErrorMessage.append(" i ");
//                    }
//                    validationError = true;
//                    validationErrorMessage.append("hasło");
//                }
//                if (isEmpty(mPasswordReply)) {
//                    if (validationError) {
//                        validationErrorMessage.append(" i ");
//                    }
//                    validationError = true;
//                    validationErrorMessage.append("ponownie swoje hasło");
//                }
//                else {
//                    if (!isMatching(mPassword, mPasswordReply)) {
//                        if (validationError) {
//                            validationErrorMessage.append(" i ");
//                        }
//                        validationError = true;
//                        validationErrorMessage.append("to samo hasło dwukrotnie.");
//                    }
//                }
//                validationErrorMessage.append(".");
//
//                if (validationError) {
//                    Toast.makeText(SignUpActivity.this, validationErrorMessage.toString(), Toast.LENGTH_LONG).show();
//                    return;
//                }

                //Setting up a progress dialog
                final ProgressDialog dlg = new ProgressDialog(SignUpActivity.this);
                dlg.setTitle("Proszę czekać.");
                dlg.setMessage("Rejestrowanie użytkownika...");
                dlg.show();

                ParseUser user = new ParseUser();
                // Set the user's username and password, which can be obtained by a forms
                user.setUsername(mUsername.getText().toString());
                user.setPassword(mPassword.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            alertDisplayer("Zarejestrowano pomyślnie!","Witaj, " + mUsername.getText().toString() + "!");
                        } else {
                            ParseUser.logOut();
                            Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }

//    private boolean isEmpty(EditText text) {
//        if (text.getText().toString().trim().length() > 0) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    private boolean isMatching(EditText text1, EditText text2){
//        if(text1.getText().toString().equals(text2.getText().toString())){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    private void alertDisplayer(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent intent = new Intent(SignUpActivity.this, LogoutActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        AlertDialog ok = builder.create();
        ok.show();
    }
}
