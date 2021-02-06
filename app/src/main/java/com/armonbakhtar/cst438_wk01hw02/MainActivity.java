package com.armonbakhtar.cst438_wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button login;
    private ArrayList<Users> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createUsers();

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        login = findViewById(R.id.button);

        login.setOnClickListener(v -> {
            String userInput = etUsername.getText().toString();
            String passInput = etPassword.getText().toString();
            Users u = verifyUser(userInput, users);

            if(u != null){
                if(verifyPass(passInput, u)){
                    Intent intent = LandingPage.getIntent(getApplicationContext(),u.getId());
                    startActivity(intent);
                }
                else{
                    etPassword.setBackgroundColor(Color.RED);
                    toast("Invalid Password");
                }
            }
            else{
                etUsername.setBackgroundColor(Color.RED);
                toast("Invalid Username");
            }

        });
    }

    private void toast(String msg){
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0, 0);
        toast.show();
    }
    public static Users verifyUser(String userInput, List<Users> user){
        for(Users u : user){
            if(userInput.equals(u.getUsername())){
                return u;
            }
        }
        return null;
    }

    public static boolean verifyPass(String passInput, Users u){
        return u.getPassword().equals(passInput);
    }

    private void createUsers(){
        users = new ArrayList<>();
        users.add(new Users("admin","admin",1));
        users.add(new Users("test","test",2));
        users.add(new Users("jimmy","neutron",3));
    }

}
