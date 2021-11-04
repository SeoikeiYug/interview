package com.genius.interview.design.factory;

import org.springframework.stereotype.Component;

@Component
public class FactoryShareSuccessOrder implements FactoryShare {

    @Override
    public String getShareFunctionType() {
        return FactoryShareMethod.EnumShareType.SUCCESS_ORDER.getName();
    }

    @Override
    public String mainProcess(String shareName) {
        return shareName;
    }
}
