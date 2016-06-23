package com.neusoft.individuation;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.neusoft.database.MyDbHepler;

public class LoginActivity extends Activity implements OnClickListener {
	SharedPreferences pref;
	SharedPreferences.Editor editor;
	private MyDbHepler helper;
	private static SQLiteDatabase db;
	private EditText login_username, login_password;
	private Button login_login, login_register, login_disanfang;
	CheckBox checkBox;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
		// 获取ActionBar


		ActionBar ab = this.getActionBar();
		// 把标题换为自定义的
		ab.setTitle("小Z桌面");
		//绑定数据库
		helper = new MyDbHepler(this, "user", null, 1);
		db = helper.getReadableDatabase();
		login_username = (EditText) findViewById(R.id.login_username);
		login_password = (EditText) findViewById(R.id.login_password);
		login_login = (Button) findViewById(R.id.login_login);
		login_register = (Button) findViewById(R.id.login_register);
		login_disanfang = (Button) findViewById(R.id.login_other);
		checkBox = (CheckBox) findViewById(R.id.jizhu);
		login_login.setOnClickListener(this);
		login_register.setOnClickListener(this);
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		boolean remember_rb2 = pref.getBoolean("remember_password", false);
		if (remember_rb2) {
			String username = pref.getString("username", "");
			String password = pref.getString("password", "");
			login_username.setText(username);
			login_password.setText(password);
			checkBox.setChecked(true);
		}

	}

	@Override
	public void onClick(View v) {
		String username = login_username.getText().toString();
		String password = login_password.getText().toString();
		int id = v.getId();

		switch (id) {
			case R.id.login_login:
				Cursor cursor = Login(username, password);
				editor = pref.edit();
				if (checkBox.isChecked()) {
					editor.putBoolean("remember_password", true);
					editor.putString("username", username);
					editor.putString("password", password);
				} else {
					editor.clear();
				}
				if (cursor.getCount() == 0) {
					Toast.makeText(LoginActivity.this, "用户名或密码错误!", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(LoginActivity.this, "用户" + username + ",欢迎你!", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(LoginActivity.this, IndexActivity.class);
					intent.putExtra("username", username);
					startActivity(intent);
					finish();
				}
				break;
			case R.id.login_register:
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
				break;

		}
	if (checkBox.isChecked()) {
			editor.putBoolean("remember_password", true);
			editor.putString("username", username);
			editor.putString("password", password);
		} else {
			editor.clear();
		}
		editor.commit();

	}

	public static Cursor Login(String username, String password) {
		Cursor cursor = db.query(
				"user",
				new String[]{"username", "password"},
				"username=? and password=?",
				new String[]{username, password}, null, null, null);
		Log.i("------", cursor.getCount() + "");
		return cursor;
	}

}
