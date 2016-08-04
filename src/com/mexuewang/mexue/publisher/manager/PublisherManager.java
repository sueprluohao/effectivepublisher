package com.mexuewang.mexue.publisher.manager;

import java.util.List;

import android.content.Context;
import android.util.SparseArray;

import com.mexuewang.mexue.publisher.PublisherConstants;
import com.mexuewang.mexue.publisher.config.PublishElementTypeConfig;
import com.mexuewang.mexue.publisher.config.PublisherElementConfig;
import com.mexuewang.mexue.publisher.config.PublisherElementRequiredConfig;
import com.mexuewang.mexue.publisher.element.PublisherElement;
import com.mexuewang.mexue.publisher.entity.Accessory;
import com.mexuewang.mexue.publisher.entity.Draft;
import com.mexuewang.mexue.publisher.entity.EditTextAccessory;
import com.mexuewang.mexue.publisher.listener.PublisherManagerListener;
/**
 * @author luohao created on 08/03/2016
 * functioin:manage draft and elements
 *
 */
public abstract class PublisherManager {
	protected SparseArray<PublisherElement> mElements = new SparseArray<PublisherElement>();
	protected PublisherManagerListener mPublisherManagerListener;
	protected Context mContext;
	protected Draft mDraft;
	public void init(int publishType,Context context) {
		this.mContext=context;
		buildElement(publishType);
		
	}
	private void buildElement(int publishType) {
		PublishElementTypeConfig publishElementTypeConfig = PublisherElementRequiredConfig.getClassInstance(publishType);
		if (publishElementTypeConfig!=null){
			List<Integer> elementTypes = publishElementTypeConfig.getElementTypes();
			for (Integer elementType : elementTypes) {
				PublisherElement publisherElement = PublisherElementConfig.getClassInstance(elementType);
				if (publisherElement!=null){
					publisherElement.init(mContext);
					mElements.put(elementType, publisherElement);
				}
			}
		}
	}
    public void addPublisherControllerListener(PublisherManagerListener publisherManagerListener){
    	this.mPublisherManagerListener=publisherManagerListener;
    }
	public PublisherElement getELement(int type){
		return mElements.get(type);
	}
	/**f
	 * @param type
	 * @return get specific accessory by publisher type  eg:editTextAccessory
	 */
	public <T extends Accessory> T getAccessory(int type){
		PublisherElement publisherElement=mElements.get(type);
		if (null==publisherElement){
			return null;
		}
		return publisherElement.getAccessary();
	}
	/**
	 * function:the entrance of publisher sending growth,notification,homework.
	 */
	public void send(){
		EditTextAccessory editTextAccessory=getAccessory(PublisherConstants.ELEMENT_EDITTEXT);
		editTextAccessory.getContent();
	};
}
