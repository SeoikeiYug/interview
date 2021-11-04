package com.genius.interview.design.factory;

import java.util.HashMap;
import java.util.Map;

public class FactoryReflection {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        addProductKey(EnumProductType.activityOne, ActivityOne.class);
        Product product = getProduct(EnumProductType.activityOne);
        System.out.println(product.toString());
    }

    private static final Map<EnumProductType, Class> activityMap = new HashMap<>();

    public static void addProductKey(EnumProductType enumProductType, Class product) {
        activityMap.put(enumProductType, product);
    }

    public static Product getProduct(EnumProductType enumProductType) throws InstantiationException, IllegalAccessException {
        Class aClass = activityMap.get(enumProductType);
        return (Product) aClass.newInstance();
    }

    public static class Product {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ActivityOne extends Product {
        private String stock;

        @Override
        public String toString() {
            return "activityOne{" + "stock='" + stock + "'" + "}" ;
        }
    }

    public static class ActivityTwo extends Product {
        private String stock;

        @Override
        public String toString() {
            return "activityTwo{" + "stock='" + stock + "'" + "}" ;
        }
    }

    public enum EnumProductType {
        activityOne, activityTwo;
    }
}
