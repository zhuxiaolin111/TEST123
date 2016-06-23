package com.neusoft.individuation;

import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;

public class ImageLoaderUtils {

	/*
	 * ��ʼ��
	 */
	public static void initConfiguration(Context context) {

		Builder configuiation = new Builder(context);
		configuiation.memoryCacheExtraOptions(480, 480)
				.diskCacheExtraOptions(480, 800, null).threadPoolSize(3)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.tasksProcessingOrder(QueueProcessingType.FIFO)
				.denyCacheImageMultipleSizesInMemory()
				.memoryCacheSize(2 * 1024 * 1024).diskCacheFileCount(100)
				.diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
				.imageDecoder(new BaseImageDecoder(true))
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
				.writeDebugLogs();

		ImageLoader.getInstance().init(configuiation.build());

	}

	/*
	 * ��ʼ��DisplayImageOptions
	 */
	public static DisplayImageOptions initOptions() {

		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_launcher)
				.showImageOnFail(R.drawable.ic_launcher).cacheInMemory(true)
				.cacheOnDisc(true).build();

		return options;
	}

}