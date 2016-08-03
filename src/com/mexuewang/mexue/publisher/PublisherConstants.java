package com.mexuewang.mexue.publisher;

import com.mexuewang.mexue.util.ConstulInfo;

/**
 * @author luohao created on 08/03/2016
 * functioin:list constants releated to publisher
 *
 */
public class PublisherConstants {
	/**
	 * function type
	 */
	public static final int PUBLISHER_GROWTH=0x8001;
	public static final int PUBLISHER_HOMEWORK=0x8002;
	public static final int PUBLISHER_NOTIFCATION=0x8003;
	/**
	 * business type
	 */
	public static final int ELEMENT_EDITTEXT=0x9001;
	public static final int ELEMENT_PIC=0x9002;
	public static final int ELEMENT_LABLE=0x9003;
	public static final int ELEMENT_PUBLISH_SCOPE=0x9004;
	
	public static final String PUBLISHER_TYPE_KEY="publisher_type";
	
	
	public static final int FindGrowthInfoForPublish = ConstulInfo.ActionNet.FindGrowthInfoForPublish
			.ordinal();
	
	/**
	 * publisher event
	 */
	public static final int ELEMENTVIEW_TOAST=0x7001;
	public static final int ELEMENTVIEW_UPDATE=0x7002;
}
