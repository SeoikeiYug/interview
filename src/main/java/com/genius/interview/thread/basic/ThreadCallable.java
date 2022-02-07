package com.genius.interview.thread.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCallable implements Callable<Data> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadCallable threadCallable = new ThreadCallable();
        FutureTask<Data> dataFutureTask = new FutureTask<>(threadCallable);
        Thread thread = new Thread(dataFutureTask);
        thread.start();
        System.out.println(dataFutureTask.get().getData());
    }

    @Override
    public Data call() throws Exception {
        return new Data("data is ok");
    }
}

@Getter
@Setter
@AllArgsConstructor
class Data {
    private String data;
}
