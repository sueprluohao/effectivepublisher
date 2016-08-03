package com.mexuewang.mexue.publisher.config;

import android.text.TextUtils;
import android.util.SparseArray;

import com.mexuewang.mexue.publisher.PublisherConstants;
import com.mexuewang.mexue.publisher.manager.PublisherManager;
/**
 * @author luohao created on 08/03/2016
 * functioin:a type to one manager. manager was in charge of the manager of publisher elements
 */
public class PublisherManagerConfig {
	
	private static final String packagePath="com.mexuewang.mexue.publisher.manager.";
	private static SparseArray<String> mPublisherManagers=new SparseArray<String>();
	   static {
		   mPublisherManagers.put(PublisherConstants.PUBLISHER_GROWTH, packagePath+"GrowthManager");
		   mPublisherManagers.put(PublisherConstants.PUBLISHER_HOMEWORK, packagePath+"HomeWorkManager");
		   mPublisherManagers.put(PublisherConstants.PUBLISHER_NOTIFCATION, packagePath+"NotificationManager");
	    }

		public static PublisherManager getClassInstance(int type) {
			String className=mPublisherManagers.get(type);
			if (TextUtils.isEmpty(className)){
				return null;
			}
			PublisherManager publisherManager = null;
			try {
				Class<?> newClass = Class.forName(className);
				publisherManager = (PublisherManager) newClass.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return publisherManager;
		}
}
