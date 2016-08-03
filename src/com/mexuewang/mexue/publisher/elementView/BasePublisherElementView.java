package com.mexuewang.mexue.publisher.elementView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.mexuewang.mexue.publisher.element.PublisherElement;
import com.mexuewang.mexue.publisher.listener.ElementEventListener;

/**
 * @author luohao created on 08/03/2016
 * functioin:the abstract base class of all elementView.
 * it was able to extract some common logical segment
 *
 */
public abstract class BasePublisherElementView<T extends PublisherElement>
		extends RelativeLayout implements PublishElementView {

	public BasePublisherElementView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public BasePublisherElementView(Context context) {
		super(context);
	}

	/** the element mapped by elementView */
	protected T mPublishElement;

	/** elementView listener */
	private ElementEventListener mElementEventListener = new BaseElementListener();

	/**
	 * an elementView binded to one element 
	 * {@link PublishActivity#initView()}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void bindElement(PublisherElement publisherElement) {
		mPublishElement = (T) publisherElement;
		mPublishElement.addElementEventListener(getContext(),
				mElementEventListener);
		init();
	}

	/**
	 * if we need to hide elementView when element was removed
	 * {@link PublishActivity}
	 */
	protected void onRemove() {
	}

	/**
	 * elementView will update itself when the data of binded element chanaged.
	 * 
	 * {@link BaseElement#onUpdate()}
	 */
	protected void onUpdate() {

	}

	/**
	 * if we need to do resource recovery ,we use it when binded element was
	 * destroy {@link BaseElement#onDestory()}
	 */
	protected void onDestory() {

	}

	protected void onElementEvent(int eventId) {
	}

	private class BaseElementListener implements ElementEventListener {

		@Override
		public void onEvent(int eventId) {
			onElementEvent(eventId);
		}

	}

	protected abstract void init();

	@Override
	public int getType() {
		return 0;
	}

	protected void onCreate() {

	}

}
