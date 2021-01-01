package com.ossovita.parselearning;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------------DATABASE------------------
        /*
        //-------------VERİ EKLEME--------------------
        ParseObject object = new ParseObject("Fighters");
        object.put("name","Khabib");
        object.put("age",32);
        //objeyi arka planda kaydet
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                //hata varsa
                if(e!=null){
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }else{  //hata yoksa
                    Toast.makeText(MainActivity.this, "Object saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //--------------------VERİ ÇEKME-----------------
        //bir sorgu objesi oluşturuyoruz, Fighters classını tarayacak
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Fighters");
        query.getInBackground("ePBZUHvl7P", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if(e!=null){//hata varssa
                    e.printStackTrace();
                }else{
                    String objectName = object.getString("name");
                    int objectAge = object.getInt("age");
                    Toast.makeText(MainActivity.this, objectName + " " + objectAge, Toast.LENGTH_SHORT).show();
                }
            }
        });
/*


         */
        /*
        //--------------------FİLTRELEMELER-----------------------
        //Fighters classına sorgu yapacağız :)
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Fighters");
        //İsmi McGregor olanı geç diyerek filtreledik
        query.whereEqualTo("name","McGregor");
        //30 yaşından büyük olanları çek
        //query.whereGreaterThan("age",30);
        //Fighters classı üzerinde arka planda arama yapacak
        //Tüm classı tarar, tüm objeleri görebilir, içinden istediklerimizi seçip aldık
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e!=null){ //hata varsa
                    e.printStackTrace();
                }else{ //hata yoksa
                    for(ParseObject object : objects){
                       String objectName = object.getString("name");
                       int objectAge = object.getInt("age");
                        Toast.makeText(MainActivity.this, objectName + " " + objectAge, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });*/

        //---------------USER SIGN UP----------------------
        ParseUser user = new ParseUser();
        user.setUsername("yasin");
        user.setPassword("123456");
        //signup metodu
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){//hata varsa
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "User Signed Up!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //--------------------USER SIGN IN-----------------------------
        ParseUser.logInInBackground("yasin", "123456", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){//hata varsa
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }else{//hata yoksa
                    Toast.makeText(MainActivity.this, "User Signed In!: " + user.getUsername() , Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}