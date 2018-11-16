package com.example.calc_;

import com.example.calculator.calculator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class Mycalc extends Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return stub;
	}
	calculator.Stub stub=new calculator.Stub()
	{

		@Override
		public int add(int a, int b) throws RemoteException {
			// TODO Auto-generated method stub
			return a+b;
		}

		@Override
		public int sub(int a, int b) throws RemoteException {
			// TODO Auto-generated method stub
			return a-b;
		}

		@Override
		public int mul(int a, int b) throws RemoteException {
			// TODO Auto-generated method stub
			return a*b;
		}
		
	};

}
