package com.pr27.basic.concurency;


@FunctionalInterface
public interface TaskCallback<T> {
    void onCompleted(T result, Fault fault);
}
