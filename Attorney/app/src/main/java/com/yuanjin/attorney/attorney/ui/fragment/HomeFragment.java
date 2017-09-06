package com.yuanjin.attorney.attorney.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.yuanjin.attorney.attorney.R;
import com.yuanjin.attorney.attorney.adapter.GridViewAdapter;
import com.yuanjin.attorney.attorney.adapter.Home_seekLawOffice_adapter;
import com.yuanjin.attorney.attorney.adapter.Home_seekLawyer_adapter;
import com.yuanjin.attorney.attorney.adapter.SlideShowAdapter;
import com.yuanjin.attorney.attorney.bean.LawOfficeBean;
import com.yuanjin.attorney.attorney.bean.LawyerBean;
import com.yuanjin.attorney.attorney.constant.Constants;
import com.yuanjin.attorney.attorney.ui.activity.LawOfficeDetailActivity;
import com.yuanjin.attorney.attorney.ui.activity.SearchActivity;
import com.yuanjin.attorney.attorney.utils.GsonTools;
import com.yuanjin.attorney.attorney.utils.ThreadUtil;
import com.yuanjin.attorney.attorney.utils.ToastUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Chan on 2017/8/21.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private RollPagerView             mRollViewPager;
    private SlideShowAdapter          mSlideShowAdapter;
    private GridView                  mGridView;
    private List<Map<String, Object>> listItem;
    private GridViewAdapter           mGridViewAdapter;
    //gridview图片资源
    private int[]    imageId = {R.mipmap.marriage_ico, R.mipmap.contract_ico,
            R.mipmap.life_ico, R.mipmap.traffic_ico,
            R.mipmap.labor_ico, R.mipmap.company_ico,
            R.mipmap.consume_ico, R.mipmap.other_ico};
    private String[] titles  = {"婚姻继承", "合同纠纷", "人身损害", "交通事故", "劳动保障", "公司经营", "消费维权", "其他案例"};
    //    private String[] lable = {"找律所", "找律师"};
    //    private List<HomeLableDetailsInfo> mShowItems = new ArrayList<>();
    private ListView                              mLv_seeklawyer;
    private OkHttpClient                          mOkHttpClient;
    private RelativeLayout                        mRl_search;
    private ImageView                             mIv_SearchBox;
    private ImageView                             mSeek_lawoffice;
    private ImageView                             mSeek_lawyer;
    private TextView                              mTv_seekLawOffice;
    private TextView                              mTv_seekLawyer;
    private Home_seekLawOffice_adapter            mHome_seekLawOffice_adapter;
    private Home_seekLawyer_adapter               mHome_seekLawyer_adapter;
    private TextView                              mHome_seeklawyer_more;
    private List<LawyerBean.LawyerListBean>       mLawyerList;
    private List<LawOfficeBean.LawofficeListBean> mLawofficeList;
    private LawyerBean                            mLawyerBean;

    @Override
    protected View createSuccessView() {
        View view = View.inflate(getContext(), R.layout.view_home, null);
        //搜索栏
        //        mSearchView = (SearchView) view.findViewById(R.id.iv_search);
        //        mSearchView.setQueryHint("搜索");
        initStatusBar(view);
        initView(view);
        return view;
    }

    private void initStatusBar(View view) {
        // 沉浸式状态栏
/*        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 这个属性4.4算是全透明（有的机子是过渡形式的透明），5.0就是半透明了 我的模拟器、真机都是半透明，
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {// 4.4 全透明状态栏
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// 5.0 全透明实现
            Window window = getActivity().getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);// calculateStatusColor(Color.WHITE, (int) alphaValue)
        }*/

    }

    //轮播图
    private void initView(View view) {
  /*      mTab_main_title = (TabLayout) view.findViewById(R.id.tab_main_title_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_main_show_layout);
        mRl_search = (RelativeLayout) view.findViewById(R.id.rl_search);*/
        mIv_SearchBox = (ImageView) view.findViewById(R.id.iv_search_box);
        mRollViewPager = (RollPagerView) view.findViewById(R.id.rollViewPager);
        mGridView = (GridView) view.findViewById(R.id.home_gridview);
        mSeek_lawoffice = (ImageView) view.findViewById(R.id.seek_lawoffice);
        mSeek_lawyer = (ImageView) view.findViewById(R.id.seek_lawyer);
        mLv_seeklawyer = (ListView) view.findViewById(R.id.lv_seeklawyer);
        mTv_seekLawOffice = (TextView) view.findViewById(R.id.tv_seekLawOffice);
        mTv_seekLawyer = (TextView) view.findViewById(R.id.tv_seekLawyer);
        mHome_seeklawyer_more = (TextView) view.findViewById(R.id.home_seeklawyer_more);
        mRollViewPager.setHintView(new ColorPointHintView(getContext(), Color.RED, Color.WHITE));
        mRollViewPager.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //首页轮播图条目点击事件
            }
        });
        mSlideShowAdapter = new SlideShowAdapter();
        mRollViewPager.setAdapter(mSlideShowAdapter);
        //        mSeek_lawoffice.setOnClickListener(this);
        //        mSeek_lawyer.setOnClickListener(this);
        mTv_seekLawOffice.setOnClickListener(this);
        mTv_seekLawyer.setOnClickListener(this);
        mIv_SearchBox.setOnClickListener(this);
        mHome_seeklawyer_more.setOnClickListener(this);
        //        mRl_search.setOnClickListener(this);//搜索框跳转activity
        initGridView();
        initTabLayout();
        //        seekLawoffice();//加载律所信息
    }

    private void initTabLayout() {
       /* HomeLableDetailsInfo homeLableDetailsInfo = new HomeLableDetailsInfo();
        homeLableDetailsInfo.mFragment = new HomeSeekLawOffice();
        homeLableDetailsInfo.title = lable[0];
        mShowItems.add(homeLableDetailsInfo);
        HomeLableDetailsInfo homeLableDetailsInfo11 = new HomeLableDetailsInfo();
        homeLableDetailsInfo11.mFragment = new HomeSeekLawyer();
        homeLableDetailsInfo11.title = lable[1];
        mShowItems.add(homeLableDetailsInfo11);

        mViewPager.setAdapter(new HomeLableAdapter(getChildFragmentManager(), mShowItems));

        mTab_main_title.setupWithViewPager(mViewPager);

        mTab_main_title.setTabMode(TabLayout.MODE_FIXED);*/
    }

    //初始化GridView
    private void initGridView() {
        if (listItem == null) {
            listItem = new ArrayList<>();
        }

        for (int i = 0; i < titles.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imageId[i]);
            map.put("title", titles[i]);
            listItem.add(map);
        }
        mGridViewAdapter = new GridViewAdapter(getContext(), listItem);
        mGridView.setAdapter(mGridViewAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //                ToastUtils.ToastShow(getContext(),"条目"+position+"被点击了");
            }
        });
    }

    @Override
    protected Object requestData() {
        //找律所网络请求
        mOkHttpClient = new OkHttpClient.Builder().build();
        RequestBody body1 = new FormBody.Builder().add("feature", "1").add("page", "1").add("rows", "1").build();
        Request request1 = new Request.Builder()
                .url(Constants.SEEK_LAWOFFICE)
                .post(body1)
                .build();
        mOkHttpClient.newCall(request1).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                ThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mLawyerBean != null) {
                            //seekLawyer();
                            seekLawoffice();
                        } else {
                            ToastUtils.ToastShow(getContext(), "正在初始化");
                        }

                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    LawOfficeBean lawOfficeBean = GsonTools.changeGsonToBean(string, LawOfficeBean.class);
                    if (lawOfficeBean.getResponseCode() == 100) {
                        mLawofficeList = lawOfficeBean.getLawofficeList();
                        ThreadUtil.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                seekLawoffice();//加载律所信息

                            }
                        });
                    }
                }
            }
        });
        //找律师请求
        RequestBody body2 = new FormBody.Builder().add("feature", "1").add("page", "1").add("rows", "1").build();
        Request request2 = new Request.Builder()
                .url(Constants.SEEK_LAWYER)
                .post(body2)
                .build();
        mOkHttpClient.newCall(request2).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    mLawyerBean = GsonTools.changeGsonToBean(string, LawyerBean.class);
                    if (mLawyerBean != null) {
                        mLawyerList = mLawyerBean.getLawyerList();
                    } else {
                        ThreadUtil.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ToastUtils.ToastShow(getContext(), "网络异常");
                            }
                        });
                    }

                }
            }
        });
     /*   TestBean beanData = LoadData.getInstance().getBeanData(BASE_URL + "/v1/home/gethotlawyer?COUNT=5", TestBean.class);
        System.out.println(beanData.getName());*/


        return "";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_seekLawyer:
                mSeek_lawoffice.setVisibility(View.INVISIBLE);
                mSeek_lawyer.setVisibility(View.VISIBLE);
                mTv_seekLawOffice.setTextColor(Color.parseColor("#878788"));
                mTv_seekLawyer.setTextColor(Color.parseColor("#ffffff"));
                if (mLawyerBean != null) {
                    seekLawyer();

                } else {
                    ToastUtils.ToastShow(getContext(), "正在初始化");
                }

                break;
            case R.id.tv_seekLawOffice:
                mSeek_lawoffice.setVisibility(View.VISIBLE);
                mSeek_lawyer.setVisibility(View.INVISIBLE);
                mTv_seekLawyer.setTextColor(Color.parseColor("#878788"));
                mTv_seekLawOffice.setTextColor(Color.parseColor("#ffffff"));
                seekLawoffice();


                break;
            case R.id.iv_search_box:
                getContext().startActivity(new Intent(getContext(), SearchActivity.class));
                break;
            case R.id.home_seeklawyer_more:

                getContext().startActivity(new Intent(getContext(), LawOfficeDetailActivity.class));

//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.chanceFragment(2);

//                mainActivity.changeAppointFragment("案例库");

                break;
        }
    }

    //找律师listview
    private void seekLawyer() {
        mHome_seekLawyer_adapter = new Home_seekLawyer_adapter(getContext(), mLawyerList,getActivity());
        mLv_seeklawyer.setAdapter(mHome_seekLawyer_adapter);
        mHome_seekLawyer_adapter.notifyDataSetChanged();

    }

    //找律所listview
    private void seekLawoffice() {
        mHome_seekLawOffice_adapter = new Home_seekLawOffice_adapter(getContext(), mLawofficeList,getActivity());
        mLv_seeklawyer.setAdapter(mHome_seekLawOffice_adapter);
        mHome_seekLawOffice_adapter.notifyDataSetChanged();

    }


}
