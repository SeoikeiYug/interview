package com.genius.interview.design.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FactoryShareMethod {

    @Autowired
    private List<FactoryShare> factoryShares;

    /**
     * 根据分享类型获取对应的分享处理方式
     * @param type /
     * @return /
     */
    public FactoryShare getShareFunction(String type) {
        for (FactoryShare factoryShare : factoryShares) {
            if (factoryShare.getShareFunctionType().equals(type)) {
                return factoryShare;
            }
        }
        return null;
    }

    public enum EnumShareType {
        SUCCESS_ORDER("successOrder");

        EnumShareType(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
