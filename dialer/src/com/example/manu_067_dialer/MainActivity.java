package com.example.manu_067_dialer;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	EditText telnum;
	Button call, save, del;
	Button dialpad_btns[] = new Button[12];
	int ids[] = { R.id.btn_zero, R.id.btn_one, R.id.btn_two, R.id.btn_three,
			R.id.btn_four, R.id.btn_five, R.id.btn_six, R.id.btn_seven,
			R.id.btn_eight, R.id.btn_nine, R.id.btn_star, R.id.btn_hash };
	String txts[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "*",
			"#" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < 12; i++) {
			dialpad_btns[i] = (Button) findViewById(ids[i]);
			dialpad_btns[i].setOnClickListener((OnClickListener) this);
		}
		call = (Button) findViewById(R.id.btn_call);
		call.setOnClickListener((OnClickListener) this);
		save = (Button) findViewById(R.id.btn_save);
		save.setOnClickListener((OnClickListener) this);
		del = (Button) findViewById(R.id.btn_del);
		del.setOnClickListener((OnClickListener) this);
		telnum = (EditText) findViewById(R.id.tel_num);

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
		boolean flag = false;
		for (int i = 0; i < 12; i++) {
			if (v.equals(dialpad_btns[i])) {
				flag = true;
				telnum.append(txts[i]);
			}
		}
		if (!flag) {

			if (v.equals(del)) {
				String s = telnum.getText().toString();
				int n = s.length();
				if (n > 0)
					s = s.substring(0, n - 1);
				telnum.setText(s);
				telnum.setSelection(n - 1);
			} else if (v.equals(call)) {
				String num = telnum.getText().toString();
				Intent it = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
						+ num));
				startActivity(it);
			} else if (v.equals(save)) {
				String num = telnum.getText().toString();
				Intent it1 = new Intent(Intent.ACTION_INSERT,
						ContactsContract.Contacts.CONTENT_URI);
				it1.putExtra(ContactsContract.Intents.Insert.PHONE, num);
				startActivity(it1);
			}
		}
	}

}
