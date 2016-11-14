package com.revenue_express.ziamthai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class LoginAppActivity extends AppCompatActivity {
    EditText edtPassword ;
    AutoCompleteTextView edtEmail;
    Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_app);

        setInitView();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });

    }

    private void setInitView(){
        edtEmail = (AutoCompleteTextView)findViewById(R.id.edtemail);
        edtPassword = (EditText)findViewById(R.id.edtpassword);
        btnlogin = (Button) findViewById(R.id.btnLoginEmail);
    }

    private void checkLogin() {

    }
}
