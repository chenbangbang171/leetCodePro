package com.build;
/**
 * 
 * 对于成员变量数量较多并且对象是不可变的实例对象时，建议使用构建器模式来创建对象
 * 避免了参数过多造成的混淆，并且保护了成员属性不变，清晰明了，
 * 其中的成员内部类Build，就是为了构建Product对象
 * */
public class Product {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        //required parameters
        private final int servingSize;
        private final int servings;

        //optional parameters
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder setCalories(int val){
            calories = val;
            return this;
        }
        public Builder setFat(int val){
            fat = val;
            return this;
        }

        public Builder setSodium(int val){
            sodium = val;
            return this;
        }
        public Builder setCarbohyd(int val){
            carbohydrate = val;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }


    private Product(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
    

    @Override
	public String toString() {
		return "Product [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories + ", fat="
				+ fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}


	public static void main(String[] args) {
		Product p1 = new Product.Builder(124, 22).setCalories(22).setFat(33).setSodium(100).setCarbohyd(22).build();
		
		System.out.println(p1);
	}


}
