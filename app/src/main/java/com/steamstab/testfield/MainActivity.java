package com.steamstab.testfield;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.steamstab.testfield.rx.RxjavaTest;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
//                startActivity(intent);
//            }
//        });

        Observable.timer(10, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Intent intent = new Intent(MainActivity.this, RxjavaTest.class);
                        startActivity(intent);
                    }
                });

    }
}
