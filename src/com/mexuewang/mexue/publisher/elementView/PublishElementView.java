package com.mexuewang.mexue.publisher.elementView;

import com.mexuewang.mexue.publisher.element.PublisherElement;

/**
 * @author luohao created by 08/01/2016
 *
 */
public interface PublishElementView {

	/**
	 * function:bind element to elementView
	 */
	public void bindElement(PublisherElement publisherElement);

	public int getType();


}
