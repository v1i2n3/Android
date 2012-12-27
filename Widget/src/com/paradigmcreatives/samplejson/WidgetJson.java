
package com.paradigmcreatives.samplejson;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class WidgetJson extends AppWidgetProvider{
	
	
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		final int n = appWidgetIds.length;
		System.out.println("n value " +n);
		for(int i = 0 ; i < n ; i++)  {
			int appwidget = appWidgetIds[i];
			Intent miIntent = new Intent(context,MainActivity.class);
			PendingIntent mPendingIntent = PendingIntent.getActivity(context, 0, miIntent, 0);
			RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget1);
			views.setOnClickPendingIntent(R.id.button, mPendingIntent);
			appWidgetManager.updateAppWidget(appwidget, views);
		}
		
		
		
	}

}
