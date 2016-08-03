package com.mexuewang.mexue.publisher.element;

import android.content.Context;

import com.mexuewang.mexue.publisher.listener.ElementEventListener;

/**
 * @author luohao created by 08/01/2016
 * 
 */
public interface PublisherElement {
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
    /**
     * @param bundle
     */
    /**
     * aaaaaa
     */
    public void remove();
    
    public void addElementEventListener(Context context,ElementEventListener elementEventListener);
}