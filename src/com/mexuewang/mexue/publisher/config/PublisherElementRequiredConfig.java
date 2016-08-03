package com.mexuewang.mexue.publisher.config;

import android.util.SparseArray;

import com.mexuewang.mexue.publisher.PublisherConstants;
/**
 * @author luohao created on 08/03/2016
 * functioin:Activity map to Element in a one to many relationship
 */
public class PublisherElementRequiredConfig {

	private static SparseArray<PublishElementTypeConfig> mElements = new SparseArray<PublishElementTypeConfig>();
	static {
		mElements.put(PublisherConstants.PUBLISHER_GROWTH,
				new PublishElementTypeConfig(
						PublisherConstants.ELEMENT_EDITTEXT,
						PublisherConstants.ELEMENT_LABLE,
						PublisherConstants.ELEMENT_PIC,
						PublisherConstants.ELEMENT_PUBLISH_SCOPE));
		mElements.put(PublisherConstants.PUBLISHER_HOMEWORK,
				new PublishElementTypeConfig(
						PublisherConstants.ELEMENT_EDITTEXT,
						PublisherConstants.ELEMENT_LABLE,
						PublisherConstants.ELEMENT_PIC,
						PublisherConstants.ELEMENT_PUBLISH_SCOPE));
		mElements.put(PublisherConstants.PUBLISHER_NOTIFCATION,
				new PublishElementTypeConfig(
						PublisherConstants.ELEMENT_EDITTEXT,
						PublisherConstants.ELEMENT_LABLE,
						PublisherConstants.ELEMENT_PIC,
						PublisherConstants.ELEMENT_PUBLISH_SCOPE));
	}

	public static PublishElementTypeConfig getClassInstance(int type) {
		return mElements.get(type);
	}
}
