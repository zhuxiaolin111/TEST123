package com.neusoft.individuation;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;



public class MyApplications extends Application {
	@Override
	public void onCreate() {

		super.onCreate();
		PlatformConfig.setQQZone("100424468",
				"c7394704798a158208a74ab60104f0ba");
		ImageLoaderUtils.initConfiguration(getApplicationContext());
	}
}
