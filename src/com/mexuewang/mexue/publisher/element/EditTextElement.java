package com.mexuewang.mexue.publisher.element;

import android.content.Context;

import com.mexuewang.mexue.publisher.entity.Accessory;
import com.mexuewang.mexue.publisher.entity.EditTextAccessory;



/**
 * @author luohao created by 08/01/2016
 * function:specific business logic releated to component of editText 
 */
public class EditTextElement extends BasePublisherElement {
	private EditTextAccessory mEditTextAccessory;
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
	   if (null==mEditTextAccessory){
		   mEditTextAccessory=new EditTextAccessory(); 
	   }
	   mEditTextAccessory.setContent(content);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Accessory> T getAccessary() {
		return (T) mEditTextAccessory;
	}
    
}
