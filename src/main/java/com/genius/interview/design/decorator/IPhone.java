package com.genius.interview.design.decorator;

public class IPhone implements Phone {

    @Override
    public void toCall() {
        System.out.println("使用IPhone手机通话!");
    }

}
