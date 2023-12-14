package com.pr27.data.mappers;

public interface Mapper<I,O> {
    O map(I value);
}