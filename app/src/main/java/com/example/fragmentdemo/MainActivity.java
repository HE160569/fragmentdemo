package com.example.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentA fragA;
    FragmentB fragB;
    FragmentManager fragManager;
    FragmentTransaction frag_tran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragA = FragmentA.newInstance(null,null);
        fragB = FragmentB.newInstance(null,null);
        fragManager = getSupportFragmentManager();
        ((Button)findViewById(R.id.btn_add)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn_replace)).setOnClickListener(this);
        ((Button)findViewById(R.id.btn_remove)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btn_add){
            frag_tran = fragManager.beginTransaction();
            frag_tran.add(R.id.fr_container,fragA,"");
            frag_tran.commit();
        }
        else if(v.getId()== R.id.btn_replace){
//            goToFragB();
        }
        else if(v.getId()== R.id.btn_remove){
            frag_tran = fragManager.beginTransaction();
            frag_tran.remove(fragB);
            frag_tran.commit();
        }

    }

    public void goToFragB(String s, int size){
        fragB = FragmentB.newInstance(s, String.valueOf(size));
        frag_tran = fragManager.beginTransaction();
        frag_tran.replace(R.id.fr_container,fragB,"");
//        frag_tran.addToBackStack("fragA");
        frag_tran.commit();
    }
}