package com.car_dealer.io;

public interface Serializer {
    <T> void serialize(T t, String fileName);
    <T> T deserialize(Class<T> tClass, String fileName);
}
