package com.example.shuangxiang.rxjavatest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.shuangxiang.rxjavatest.mvp.Bean;
import com.example.shuangxiang.rxjavatest.ChildInfo;
import com.example.shuangxiang.rxjavatest.R;
import com.example.shuangxiang.rxjavatest.adapter.ExpandableListViewAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shuang.xiang on 2016/7/12.
 */
public class TokenRetryWhenFragment extends Fragment {


    private static final String TAG = "TokenRetryWhenFragment";
    @BindView(R.id.e_lv_parameter)
    ExpandableListView eLvParameter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.parameter_setting, container, false);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        String s = "[{\"createBy\":\"\",\"createDate\":\"2016-08-08 20:18:13\",\"delFlag\":\"0\",\"deviceModelId\":\"gxznhrjz\",\"elements\":[{\"address\":\"D1295\",\"categoryId\":\"gxznhrjz_c_07\",\"css\":null,\"displayName\":\"二次供温时段\",\"icon\":\"\",\"id\":\"gxznhrjz_e_15\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":15,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"℃\",\"valueType\":\"REAL\"},{\"address\":\"D1399\",\"categoryId\":\"gxznhrjz_c_07\",\"css\":null,\"displayName\":\"二次供回压差\",\"icon\":\"\",\"id\":\"gxznhrjz_e_16\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":16,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"Mpa\",\"valueType\":\"REAL\"},{\"address\":\"D1409\",\"categoryId\":\"gxznhrjz_c_07\",\"css\":null,\"displayName\":\"二次回压\",\"icon\":\"\",\"id\":\"gxznhrjz_e_17\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":17,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"Mpa\",\"valueType\":\"REAL\"},{\"address\":\"D1411\",\"categoryId\":\"gxznhrjz_c_07\",\"css\":null,\"displayName\":\"二次回压偏差\",\"icon\":\"\",\"id\":\"gxznhrjz_e_18\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":18,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"Mpa\",\"valueType\":\"REAL\"}],\"id\":\"gxznhrjz_c_07\",\"name\":\"控制参数\",\"number\":7,\"type\":\"PARAM\",\"updateBy\":\"\",\"updateDate\":\"2016-08-08 20:18:13\"},{\"createBy\":\"\",\"createDate\":\"2016-08-08 20:18:13\",\"delFlag\":\"0\",\"deviceModelId\":\"gxznhrjz\",\"elements\":[{\"address\":\"D1279\",\"categoryId\":\"gxznhrjz_c_08\",\"css\":null,\"displayName\":\"二次供水温度高限\",\"icon\":\"\",\"id\":\"gxznhrjz_e_29\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":29,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"℃\",\"valueType\":\"REAL\"},{\"address\":\"D1281\",\"categoryId\":\"gxznhrjz_c_08\",\"css\":null,\"displayName\":\"二次供水压力高限\",\"icon\":\"\",\"id\":\"gxznhrjz_e_30\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":30,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"MPa\",\"valueType\":\"REAL\"},{\"address\":\"D1285\",\"categoryId\":\"gxznhrjz_c_08\",\"css\":null,\"displayName\":\"二次回水压力低限\",\"icon\":\"\",\"id\":\"gxznhrjz_e_32\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":32,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"MPa\",\"valueType\":\"REAL\"},{\"address\":\"D1289\",\"categoryId\":\"gxznhrjz_c_08\",\"css\":null,\"displayName\":\"水箱液位低限\",\"icon\":\"\",\"id\":\"gxznhrjz_e_34\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":34,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"m\",\"valueType\":\"REAL\"}],\"id\":\"gxznhrjz_c_08\",\"name\":\"报警参数\",\"number\":8,\"type\":\"PARAM\",\"updateBy\":\"\",\"updateDate\":\"2016-08-08 20:18:13\"},{\"createBy\":\"\",\"createDate\":\"2016-08-08 20:18:13\",\"delFlag\":\"0\",\"deviceModelId\":\"gxznhrjz\",\"elements\":[{\"address\":\"D1283\",\"categoryId\":\"gxznhrjz_c_09\",\"css\":null,\"displayName\":\"二次供水压力高高限\",\"icon\":\"\",\"id\":\"gxznhrjz_e_31\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":31,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"MPa\",\"valueType\":\"REAL\"},{\"address\":\"D1287\",\"categoryId\":\"gxznhrjz_c_09\",\"css\":null,\"displayName\":\"二次回水压力低低限\",\"icon\":\"\",\"id\":\"gxznhrjz_e_33\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":33,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"MPa\",\"valueType\":\"REAL\"},{\"address\":\"D1277\",\"categoryId\":\"gxznhrjz_c_09\",\"css\":null,\"displayName\":\"水箱液位低低限\",\"icon\":\"\",\"id\":\"gxznhrjz_e_35\",\"level\":\"\",\"max\":0,\"min\":0,\"number\":35,\"processMode\":\"\",\"showType\":\"input\",\"tableId\":\"gxznhrjz_t_1\",\"unit\":\"m\",\"valueType\":\"REAL\"}],\"id\":\"gxznhrjz_c_09\",\"name\":\"保护参数\",\"number\":9,\"type\":\"PARAM\",\"updateBy\":\"\",\"updateDate\":\"2016-08-08 20:18:13\"}]";

        Gson gson = new Gson();
        Bean[] been = gson.fromJson(s, Bean[].class);
        int length = been.length;
        String[] parentNames = new String[length];
        for (int i = 0; i < length; i++) {
            Bean bean = been[i];
            String name = bean.getName();
            parentNames[i] = name;
        }
        HashMap<String, List<ChildInfo>> map = new HashMap<>();
        List<String> parent = new ArrayList<>();
        int parentLength = parentNames.length;
        for (int i = 0; i < parentLength; i++) {
            parent.add(parentNames[i]);
        }
        for (int j = 0; j < length; j++) {
            List<ChildInfo> childInfos = new ArrayList<>();
            int size = been[j].getElements().size();
            for (int i = 0; i < size; i++) {
                String displayName = been[j].getElements().get(i).getDisplayName();
                int number = been[j].getElements().get(i).getNumber();
                ChildInfo childInfo = new ChildInfo(displayName, String.valueOf(number));
                childInfos.add(childInfo);
            }
            map.put(parent.get(j), childInfos);
        }
        eLvParameter.setGroupIndicator(null);
        ExpandableListViewAdapter adapter = new ExpandableListViewAdapter(map, parent, getActivity());
        eLvParameter.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            eLvParameter.expandGroup(i);
        }
    }


}
