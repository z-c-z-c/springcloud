package com.example.springbootdemo1.designmodel;

/**
 * @author zc
 * @Description TODO 监察者模式
 * @date 2021/6/9 11:20 下午
 * @Version 1.0
 */
public interface IObserve {
    /**
     *
     * 观察事件执行
     * @param message 消息
     */
    void observeSomething(String message);
}
