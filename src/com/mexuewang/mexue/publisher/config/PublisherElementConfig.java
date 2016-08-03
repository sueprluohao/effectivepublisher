package com.mexuewang.mexue.publisher.config;

import android.text.TextUtils;
import android.util.SparseArray;

import com.mexuewang.mexue.publisher.PublisherConstants;
import com.mexuewang.mexue.publisher.element.PublisherElement;

/**
 * @author luohao created on 08/03/2016 
 * functioin:The configuration of publisher Element 
 */
public class PublisherElementConfig {

	private static final String packagePath = "com.mexuewang.mexue.publisher.element.";
	private static SparseArray<String> mElements = new SparseArray<String>();
	static {
		mElements.put(PublisherConstants.ELEMENT_EDITTEXT, packagePath
				+ "EditTextElement");
		mElements.put(PublisherConstants.ELEMENT_LABLE, packagePath
				+ "LabelElement");
		mElements.put(PublisherConstants.ELEMENT_PUBLISH_SCOPE, packagePath
				+ "PublishScopeElement");
		mElements.put(PublisherConstants.ELEMENT_PIC, packagePath
				+ "PicElement");
	}

	public static PublisherElement getClassInstance(int type) {
		String className = mElements.get(type);
		if (TextUtils.isEmpty(className)) {
			return null;
		}
		PublisherElement publisherElement = null;
		try {
			Class<?> newClass = Class.forName(className);
			publisherElement = (PublisherElement) newClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return publisherElement;

	}

}
