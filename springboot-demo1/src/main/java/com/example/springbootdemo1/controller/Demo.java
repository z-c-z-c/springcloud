package com.example.springbootdemo1.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo1.easyexcel.DemoListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author zc
 * @Description TODO
 * @date 2021/8/26 12:12 上午
 * @Version 1.0
 */
@RestController
public class Demo {
    @GetMapping(value = "/demo")
    public ResponseEntity<Object> testDemo(){
        return new ResponseEntity<>("项目启动成功！！！", HttpStatus.OK);
    }

    @PostMapping(value = "/importFile")
    public void importFile(MultipartFile file, HttpServletRequest request) throws IOException {
        DemoListener demoListener = new DemoListener();
        List<Map<String,String>> list = EasyExcel.read(file.getInputStream(),demoListener).sheet(0).headRowNumber(2).doReadSync();
        System.out.println(JSONObject.toJSONString(list));
        System.out.println(JSONObject.toJSONString(demoListener.getDataList()));
    }
}
