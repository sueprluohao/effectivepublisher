package com.mexuewang.mexue.publisher.element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.text.TextUtils;

import com.android.http.RequestMap;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mexuewang.mexue.model.growup.FindGrowthInfo;
import com.mexuewang.mexue.model.growup.GrowthInfo;
import com.mexuewang.mexue.model.sendData.GrowthData;
import com.mexuewang.mexue.model.user.UserInfoItem;
import com.mexuewang.mexue.model.user.UserInformation;
import com.mexuewang.mexue.publisher.PublisherConstants;
import com.mexuewang.mexue.util.ConstulInfo;
import com.mexuewang.mexue.vollbean.RequestMapChild;
import com.mexuewang.mexue.vollbean.TokUseriChSingle;


/**
 * @author luohao created by 08/01/2016
 * function:specific business logic of selected class releated to component of gridview 
 */
public class PublishScopeElement extends BasePublisherElement {

	private List<GrowthInfo> mList=new ArrayList<GrowthInfo>();
	private FindGrowthInfo mFindGrowthInfo;
	public FindGrowthInfo getmFindGrowthInfo() {
		return this.mFindGrowthInfo;
	}
	public List<GrowthInfo> getmData() {
		return this.mList;
	}
	/* 
	 * function��to do buniess operation
	 */
	@Override
	public void init(Context context) {
		super.init(context);
		RequestMap params = new RequestMapChild(context.getApplicationContext());
		params.put("m", "findGrowthInfoForPublish");
		this.mRquestManager.post(ConstulInfo.URL_API + "growth",
				params, mPublisherRequestListener, ConstulInfo.SHOULDCACHE,
				ConstulInfo.TIMEOUTCOUNT, ConstulInfo.RETRYTIMES, PublisherConstants.FindGrowthInfoForPublish);
	}

	@Override
	public void excuteAction() {
		
	}

	@Override
	public void creat() {
		
	}
    public void update(String name){
    	GrowthData growthData=super.getmGrowthData();
    	if (null==growthData){
    		return;
    	}
    	growthData.setClassIds(getClassInfo());
    	if ("�ҵİ༶".equals(name)) {
    		growthData.setIsPrivate("0");
    		growthData.setMedalType(null);
		} else if ("˽��".equals(name)) {
			growthData.setIsPrivate("1");
			growthData.setMedalType(null);
		} else if ("�ҵ��꼶".equals(name)) {
			growthData.setIsPrivate("0");
    		growthData.setMedalType("1");
		} else if ("�ҵ�У԰".equals(name)) {
			growthData.setIsPrivate("0");
    		growthData.setMedalType("2");
		}
    }
	/* 
	 * function:get the data of buniess opertaion
	 */
	@Override
	public void update() {
		
		
		
	}

	@Override
	public void remove() {
		
	}
	/* 
	 * function :�˷�����ߵķ�������ԭ�д��룬���ع�
	 */
	@Override
	protected void responseSuccess(Gson gson,JsonReader reader) {
		try {
			this.mFindGrowthInfo = gson.fromJson(reader, FindGrowthInfo.class);
			if (this.mFindGrowthInfo!=null&&mFindGrowthInfo.isSuccess()) {
				List<GrowthInfo> result = mFindGrowthInfo.getResult();
				//ɾ��display��false��������ʾ
				Iterator<GrowthInfo> iterator = result.iterator();
				while (iterator.hasNext()) {
					if (!iterator.next().isDisplay()) {
						iterator.remove();
					}
				}
				this.mList.addAll(result);
			}else {
				if (mFindGrowthInfo!=null&&!TextUtils.isEmpty(mFindGrowthInfo.getMsg())) {
					mElementEventListener.onEvent(PublisherConstants.ELEMENTVIEW_TOAST);
				}
			}
			super.mElementEventListener.onEvent(PublisherConstants.ELEMENTVIEW_UPDATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* ��ǰ�ɵĴ��룬���Ż�
	 * 
	 */
	@Override
	protected void responseError() {
		this.mList.clear();
		GrowthInfo growthInfo1 = new GrowthInfo();
		growthInfo1.setName("�ҵİ༶");
		this.mList.add(growthInfo1);
		GrowthInfo growthInfo2 = new GrowthInfo();
		growthInfo2.setName("˽��");
		this.mList.add(growthInfo2);
		super.mElementEventListener.onEvent(PublisherConstants.ELEMENTVIEW_UPDATE);
		
	}

	private String getClassInfo() {
		String classId="";
		UserInformation userUtils = TokUseriChSingle.getUserUtils(mContext);
		List<UserInfoItem> classList = userUtils.getClassList();
		if (classList != null) {
			UserInfoItem userInfoItem = classList.get(0);
			if (userInfoItem != null) {
				classId = userInfoItem.getClassId();
			}
		}
		return classId;
	}
}
