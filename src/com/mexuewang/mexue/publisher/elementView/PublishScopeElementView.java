package com.mexuewang.mexue.publisher.elementView;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.mexuewang.mexue.R;
import com.mexuewang.mexue.adapter.growup.GrowInfoAdapter;
import com.mexuewang.mexue.model.growup.FindGrowthInfo;
import com.mexuewang.mexue.model.growup.GrowthInfo;
import com.mexuewang.mexue.publisher.PublisherConstants;
import com.mexuewang.mexue.publisher.element.PublishScopeElement;
import com.mexuewang.mexue.util.StaticClass;
import com.mexuewang.mexue.view.MGridView;
/**
 * @author luohao created on 08/03/2016
 * functioin:the view of gridview for user group 
 *
 */
public class PublishScopeElementView extends
		BasePublisherElementView<PublishScopeElement> {
	private MGridView mGridView;
	private GrowInfoAdapter adapter;
	private List<GrowthInfo> list = new ArrayList<GrowthInfo>();

	public PublishScopeElementView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public PublishScopeElementView(Context context) {
		super(context);
		initView();
	}

	private void initView() {
		LayoutInflater.from(getContext()).inflate(R.layout.publisher_scope,
				this);
		this.mGridView = (MGridView) findViewById(R.id.gv_growth_info);
		this.adapter = new GrowInfoAdapter(getContext(), list);
		this.mGridView.setAdapter(adapter);
		this.mGridView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						GrowthInfo growthInfo = list.get(position);
						if (null == growthInfo) {
							return;
						}
						String name = growthInfo.getName();
						if (growthInfo.isEnable()) {
							adapter.setSelection(position);
							mPublishElement.update(name);
						} else {
							if (name.equals("我的年级")) {
								StaticClass.showToast2(getContext(),
										"班级成长之星有特权发到“我的年级”");
							} else if (name.equals("我的校园")) {
								StaticClass.showToast2(getContext(),
										"年级成长之星有特权发到“我的校园”");
							}
						}
					}
				});

	}

	@Override
	protected void onElementEvent(int eventId) {
		switch (eventId) {
		case PublisherConstants.ELEMENTVIEW_TOAST:
			FindGrowthInfo findGrowthInfo = mPublishElement
					.getmFindGrowthInfo();
			if (null == findGrowthInfo) {
				return;
			}
			StaticClass.showToast2(getContext().getApplicationContext(),
					findGrowthInfo.getMsg());
			break;
		case PublisherConstants.ELEMENTVIEW_UPDATE:
			this.list.clear();
			if (mPublishElement.getmData() == null) {
				// 初始化一个默认的
			} else {
				list.addAll(mPublishElement.getmData());
			}
			this.adapter.notifyDataSetChanged();
			break;
		default:
			break;
		}
	}

	@Override
	protected void init() {

	}

}
