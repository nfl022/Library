package com.nfl.library.service;

public interface IConvertData {
    <T> T obtainData (String json, Class<T> clas);
}
