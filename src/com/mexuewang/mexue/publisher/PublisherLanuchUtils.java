package com.mexuewang.mexue.publisher;

import android.app.Activity;
import android.content.Intent;

import com.mexuewang.mexue.R;
import com.mexuewang.mexue.main.MainActivity;
/**
 * @author luohao created on 08/03/2016
 * functioin:the entrance of lanuch of activity
 *
 */
public class PublisherLanuchUtils {
    public static void lanuchPublisher(int publisherType,Activity activity,Class<?> cla){
    	if (null==activity||null==cla){
    		return;
    	}
    	Intent intent=new Intent(activity, cla);
    	intent.putExtra("type", "ordinary");
    	intent.putExtra(PublisherConstants.PUBLISHER_TYPE_KEY, PublisherConstants.PUBLISHER_GROWTH);
    	activity.startActivityForResult(intent, MainActivity.GROWTH);
		activity.overridePendingTransition(R.anim.in_from_right,
				R.anim.out_to_left);
    }
}
