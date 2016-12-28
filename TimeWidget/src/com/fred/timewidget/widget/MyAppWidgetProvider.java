package com.fred.timewidget.widget;

import java.lang.Thread.State;
import java.util.Calendar;

import com.fred.timewidget.R;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MyAppWidgetProvider extends AppWidgetProvider {
	public static final String TAG = "MyAppWidgetProvider";
	public static final String REFRESH = "com.fred.timewidget.widget";
	public Context mContext;

	public MyAppWidgetProvider() {
		super();
	}

	BroadcastReceiver mBroadcast = new BroadcastReceiver() {

		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();

			if (action.equals(Intent.ACTION_TIME_TICK)) {
				context.sendBroadcast(new Intent(REFRESH));
				Log.e(TAG, "+++++send");
			}

		}

	};

	Thread TickThread = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true) {

				try {

					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mContext.sendBroadcast(new Intent(REFRESH));// 通知刷新Widget的Intent
			}
		}

	});

	@Override
	public void onReceive(final Context context, Intent intent) {
		super.onReceive(context, intent);
		Log.i(TAG, "onReceive : action = " + intent.getAction());
		mContext = context;
		String action = intent.getAction();
		if (REFRESH.equals(action)) {
			showTime(context);
		} else if (Intent.ACTION_TIME_TICK.equals(action)) {
			showTime(context);
		}
		super.onReceive(context, intent);
	}

	/**
	 * 每次窗口小部件被点击更新都调用一次该方法
	 */
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		Log.i(TAG, "onUpdate");		
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		mContext = context;
		RemoteViews views = new RemoteViews(context.getPackageName(),
				R.layout.widget);
		Calendar cal = Calendar.getInstance();
		views.setTextViewText(R.id.time, cal.getTime().toLocaleString());
		appWidgetManager.updateAppWidget(appWidgetIds, views);
		if(TickThread.getState().equals(State.NEW)){
			TickThread.start();
		}

	}


	private void showTime(Context context) {
		RemoteViews views = new RemoteViews(context.getPackageName(),
				R.layout.widget);
		Calendar cal = Calendar.getInstance();
		views.setTextViewText(R.id.time, cal.getTime().toLocaleString());
		ComponentName thisWidget = new ComponentName(context,
				MyAppWidgetProvider.class);
		AppWidgetManager.getInstance(context)
				.updateAppWidget(thisWidget, views);
	}

}
