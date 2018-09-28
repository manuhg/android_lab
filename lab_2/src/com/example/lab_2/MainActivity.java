package com.example.lab_2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, Runnable {
	Button search,insert;
	EditText name,id,age,addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search=(Button)findViewById(R.id.search);
        insert=(Button)findViewById(R.id.insert);
        search.setOnClickListener(this);
        insert.setOnClickListener(this);
        name=(EditText)findViewById(R.id.e_name);
        id=(EditText)findViewById(R.id.e_id);
        age=(EditText)findViewById(R.id.e_age);
        addr=(EditText)findViewById(R.id.e_addr);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
