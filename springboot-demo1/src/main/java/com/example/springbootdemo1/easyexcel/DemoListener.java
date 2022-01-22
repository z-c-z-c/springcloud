package com.example.springbootdemo1.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author zc
 */
public class DemoListener extends AnalysisEventListener<Map<Integer,String>> {

    public List<Map<String,String>> dataList=new ArrayList<>();

    Map<Integer, String> key = new HashMap<>();

    List<String> keyList=new ArrayList<>();

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext analysisContext) {
        System.out.println("解析到的第一条数据："+ JSONObject.toJSONString(data));
        HashMap<String, String> objectObjectHashMap = new HashMap<>(16);
        Set<Integer> integerSet = data.keySet();
        String id=null;
        for (Integer integer : integerSet) {
            String s = key.get(integer);
            objectObjectHashMap.put(s,data.get(integer));
        }
        dataList.add(objectObjectHashMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("解析道一条头数据："+headMap.toString()+","+context.readSheetHolder().getRowIndex());
        Set<Integer> integerSet=headMap.keySet();
        for(Integer integer : integerSet){
            keyList.add(headMap.get(integer));
        }
        key.putAll(headMap);
    }

    public List<Map<String, String>> getDataList() {
        return dataList;
    }

    public void setDataList(List<Map<String, String>> dataList) {
        this.dataList = dataList;
    }

    public DemoListener(List<Map<String, String>> dataList) {
        this.dataList = dataList;
    }

    public DemoListener() {
    }
}
