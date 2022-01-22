package com.example.springbootdemo1.designmodel;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * @author zc
 * @Description TODO 观察者模式
 * @date 2021/6/9 11:24 下午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class BeObserved {
    private IObserve iObserve;
    @NotNull
    private String message;
    private void doSomething(){
        System.out.println("doSomething.execute。。。。。");
        if(iObserve==null){
            return;
        }
        iObserve.observeSomething(message);
    }

    public void beforeFunction() {
        System.out.println("before.execute。。。。。");
        doSomething();
    }
    public void addListener(IObserve iObserve) {
        this.iObserve = iObserve;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        BeObserved beObserved=new BeObserved("1213");
        beObserved.addListener(new IObserve() {
            @Override
            public void observeSomething(String message) {
                System.out.println("这里实现了接口：  " + message);
            }
        });
        beObserved.beforeFunction();
    }
}
