package com.genius.interview.design.decorator;

/**
 * 装饰器（常用装饰器类：Collections.SynchronizedList; BufferedInputStream）
 */
public class IPhoneScreenFilmDecorator implements Phone {

    private final Phone phone;

    public IPhoneScreenFilmDecorator(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void toCall() {
        padScreenFilm();
        phone.toCall();
    }

    private void padScreenFilm() {
        System.out.println("新手机，贴膜保护！");
    }

    public static void main(String[] args) {
        IPhone iPhone = new IPhone();
        IPhoneScreenFilmDecorator iPhoneScreenFilmDecorator = new IPhoneScreenFilmDecorator(iPhone);
        iPhoneScreenFilmDecorator.toCall();
    }

}
