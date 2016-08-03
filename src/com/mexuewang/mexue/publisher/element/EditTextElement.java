package com.mexuewang.mexue.publisher.element;

import android.content.Context;

import com.mexuewang.mexue.model.sendData.GrowthData;



/**
 * @author luohao created by 08/01/2016
 * function:specific business logic releated to component of editText 
 */
public class EditTextElement extends BasePublisherElement {
	@Override
	public void init(Context context) {
		super.init(context);
	}

	@Override
	public void excuteAction() {
		
	}

	@Override
	public void creat() {
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void remove() {
		
	}
	public void setContent(String content){
		GrowthData growthData=getmGrowthData();
		growthData.setContent(content);
	}

}
