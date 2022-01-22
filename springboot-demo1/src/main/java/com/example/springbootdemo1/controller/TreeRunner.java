package com.example.springbootdemo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo1.vo.TreeVo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zc
 */
@Component
public class TreeRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        List<TreeVo> treeVoList=getTreeVoList();
        Map<String,List<TreeVo>> treeVoMap=treeVoList.stream().collect(Collectors.groupingBy(TreeVo::getParentId));
        replaceId("zc",treeVoMap,"zc");
        List<TreeVo> treeVoMapList=new ArrayList<>();
        Set<String> keys=treeVoMap.keySet();
        for(String key : keys){
            treeVoMapList.addAll(treeVoMap.get(key));
        }
        System.out.println("treeVoList:"+JSONObject.toJSONString(treeVoList));
        System.out.println("treeVoMapList:"+JSONObject.toJSONString(treeVoMapList));
    }

    public void replaceId(String rootNodeId,Map<String,List<TreeVo>> treeVoMap,String parentId){
        List<TreeVo> treeVoList=treeVoMap.get(rootNodeId);
        if (CollectionUtils.isEmpty(treeVoList)){
            return;
        }
        for(TreeVo treeVo : treeVoMap.get(rootNodeId)){
            String oldId=treeVo.getId();
            treeVo.setId(UUID.randomUUID().toString());
            treeVo.setParentId(parentId);
            replaceId(oldId,treeVoMap,treeVo.getId());
        }
    }

    private List<TreeVo> getTreeVoList(){
        List<TreeVo> treeVoList=new ArrayList<>();
        TreeVo treeVo=new TreeVo();
        treeVo.setId("1");
        treeVo.setParentId("zc");
        treeVo.setName("firstNode");
        treeVoList.add(treeVo);
        treeVo=new TreeVo();
        treeVo.setId("2");
        treeVo.setParentId("zc");
        treeVo.setName("twoNode");
        treeVoList.add(treeVo);
        treeVo=new TreeVo();
        treeVo.setId("3");
        treeVo.setParentId("zc");
        treeVo.setName("lastNode");
        treeVoList.add(treeVo);
        treeVo=new TreeVo();
        treeVo.setId("1.1");
        treeVo.setParentId("1");
        treeVo.setName("fistNode_Children_first");
        treeVoList.add(treeVo);
        treeVo=new TreeVo();
        treeVo.setId("1.2");
        treeVo.setParentId("1");
        treeVo.setName("fistNode_Children_two");
        treeVoList.add(treeVo);
        treeVo=new TreeVo();
        treeVo.setId("1.3");
        treeVo.setParentId("1");
        treeVo.setName("fistNode_Children_last");
        treeVoList.add(treeVo);
        treeVoList.add(treeVo);
        treeVo=new TreeVo();
        treeVo.setId("2.1");
        treeVo.setParentId("2");
        treeVo.setName("TwoNode_Children_first");
        treeVoList.add(treeVo);
        treeVo=new TreeVo();
        treeVo.setId("2.2");
        treeVo.setParentId("2");
        treeVo.setName("TwoNode_Children_last");
        treeVoList.add(treeVo);
        treeVo=new TreeVo();
        treeVo.setId("3.1");
        treeVo.setParentId("3");
        treeVo.setName("LastNode_Children_last");
        treeVoList.add(treeVo);
        return treeVoList;
    }
}
