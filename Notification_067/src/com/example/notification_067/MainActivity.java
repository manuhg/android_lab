package com.example.notification_067;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button start, stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start = (Button) findViewById(R.id.start);
		start.setOnClickListener(this);
		stop = (Button) findViewById(R.id.stop);
		stop.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.equals(start)) {
			Intent it = new Intent(this, MyService.class);
			Bundle b = new Bundle();
			b.putBoolean("stop", true);
			it.putExtra("data", b);
			startService(it);
		} else {
			/*
			 * Intent it=new Intent(this,ServiceClass.class); Bundle b=new
			 * Bundle(); b.putBoolean("stop", false); it.putExtra("data", b);
			 * startService(it);To stop the notification but it will not stop
			 * the service, to stop we use stoService()
			 */
			Intent it = new Intent(this, MyService.class);
			stopService(it);
		}
	}
}