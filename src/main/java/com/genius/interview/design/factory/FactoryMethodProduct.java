package com.genius.interview.design.factory;

public class FactoryMethodProduct extends FactoryMethod {

    @Override
    protected Product createProduct(String name) {
        if (EnumProductType.activityOne.getName().equals(name)) {
            return new OneProduct();
        } else if (EnumProductType.activityTwo.getName().equals(name)) {
            return new TwoProduct();
        }
        return null;
    }

    public static class OneProduct extends Product {}
    public static class TwoProduct extends Product {}

    public static void main(String[] args) {
        FactoryMethodProduct factoryMethodProduct = new FactoryMethodProduct();
        Product product = factoryMethodProduct.product("one", "one");
        System.out.println(product.getProductName());
    }
}
