package com.revenue_express.ziamthai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText edtName ,edtEmail,edtPassword,edtConfirmPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setInitView();
        checkRegister();
    }

    private void setInitView(){
        edtEmail = (EditText) findViewById(R.id.edtemail);
        edtName = (EditText) findViewById(R.id.edtname);
        edtPassword = (EditText)findViewById(R.id.edtpassword);
        edtConfirmPassword = (EditText)findViewById(R.id.edtconfirmpassword);

        btnRegister = (Button) findViewById(R.id.btnRegister);

    }

    private void checkRegister() {

    }
}
