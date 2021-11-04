package com.genius.interview.design.factory;

public interface FactoryShare {

    /**
     * 获取分享类型
     * @return /
     */
    String getShareFunctionType();

    /**
     * 处理流程
     * @param shareName 分享名称
     * @return /
     */
    String mainProcess(String shareName);

}
