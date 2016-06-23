package com.neusoft.simallutil;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.neusoft.individuation.R;

import java.util.List;
import java.util.Map;

public class MyAsyncTask extends AsyncTask<String, Void, List<Map<String, String>>>{
	private ProgressDialog dialog;
	private Context context;
	public MyAsyncTask(Context context) {
		super();
		this.context = context;
	}

	@Override
	protected List<Map<String, String>> doInBackground(String... params) {
		// TODO Auto-generated method stub
		List<Map<String, String>> list = MyJson.getJson(MyHttp.getHttp(params[0]));

		return list;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

		dialog = new ProgressDialog(context);
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.setTitle("Loadding");
		dialog.setMessage("Loadding...");
		dialog.setIcon(R.drawable.z);
		//显示
		dialog.show();
	}

	@Override
	protected void onPostExecute(List<Map<String, String>> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		//dialog.dismiss();
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
}
