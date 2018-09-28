package com.example.manu_067_lab1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, Runnable {
	int i = 0;
	Button start, stop;
	TextView counter;
	Thread thread;
	boolean running = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		start = (Button) findViewById(R.id.start);
		stop = (Button) findViewById(R.id.stop);
		counter = (TextView) findViewById(R.id.counter_val);
		start.setOnClickListener(this);
		stop.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void run() {
		while (i < 10000 && running) {
			try {
				thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			handler.sendEmptyMessage(i);
			i++;
		}

	}

	@Override
	public void onClick(View v) {
		if (v.equals(start)) {
			i = 0;
			running = true;
			thread = new Thread(this);
			thread.start();
		} else if (v.equals(stop)) {
			running = false;
		}

	}

	Handler handler = new Handler() {
		public void handleMessage(Message m) {
			counter.setText(" " + m.what);
		}
	};
}
