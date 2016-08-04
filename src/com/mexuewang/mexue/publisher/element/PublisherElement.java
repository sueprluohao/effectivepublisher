package com.mexuewang.mexue.publisher.element;

import android.content.Context;

import com.mexuewang.mexue.publisher.entity.Accessory;
import com.mexuewang.mexue.publisher.listener.ElementEventListener;

/**
 * @author luohao created by 08/01/2016
 * 
 */
public interface PublisherElement {
	/**
     * funtion:it is invoked before sending draft,and to be a final entity
     */
    public <T extends Accessory> T getAccessary();
	/**
	 * 
	 */
	public void init(Context context);
    /**
     * 
     */
    public void excuteAction();
    /**
     * 
     */
    public void creat();
    /**
     * 
     */
    public void update();

    public void remove();
    
    public void addElementEventListener(Context context,ElementEventListener elementEventListener);
}