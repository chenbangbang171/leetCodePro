package main.java.build;

public class Bread {
	private final int d1;
	private final int d2; 
	private final int d3;
	private final int d4;
	private final int d5;
	
	public static class Builder{
		private final int d1 ;
		private final int d2 ;
		
		private int d3 = 0; 
		private int d4 = 0;
		private int d5 = 0;
		
		public Builder(int d1, int d2) {
			this.d1 = d1;
			this.d2 = d2;
		}
		
		public Builder setD4 (int d4) {
			this.d4 = d4;
			return this;
		}
		public Builder setD5 (int d5) {
			this.d5 = d5;
			return this;
		}
		public Builder setD3 (int d3) {
			this.d3 = d3;
			return this;
		}
		
		public Bread build() {
			return new Bread(this);
		}
		
	}
	
	private Bread(Builder builder) {
		this.d1 = builder.d1;
		this.d2 = builder.d2;
		this.d3 = builder.d3;
		this.d4 = builder.d4;
		this.d5 = builder.d5;
		
	}
	
	/*
	 * 重写equals流程及原则：
	 * 	1.判断入参对象和当前对象是不是同地址对象 若不是返回false
	 *  2.判断入参是否为空和判断入参对象和当前对象是否是同类  不满足返回false
	 *  3.进行强转，
	 *  4.入参对象和当前对象的成员变量一一比较  都一样则返回true
	 * 	
	 * 原则：
	 * 	1.自反性，若x.equals(y)== true 则，y.equals(x) 要求也是true
	 *  2.对称性，若x.equals(y)为true，则要求y.equals(x) 也是true
	 *  3.传递性 ，若x.equals(y) 为true 且y.equals(z)为true ，则要求 x.equals(z) 也是true
	 *  4.一致性，若x.equals(y)为true或者false,则要求x.equals(y)在以后任何时候调用都是返回true或者false
	 *  5.对null一致性，要求对所有对象，x.equals(null) 都返回false
	 * */
	public static void main(String[] args) {
		//Bread bread = new Bread.Builder(1, 2).setD3(1).setD4(4).setD5(5).build();
		
		
		
		
	}
	
	/*
	 * ArrayList扩容grow()方法流程步骤
	 * 	parameter： 当前扩容的最小容量需求 minCapacity
	 * 	1.获取旧数组长度
	 * 	2.计算新数组长度： newCapacity = oldCapactity + oldCapacity >> 1(位移运算符，向右移动一位，即除以2)
	 * 	3.判断新容量newCapacity是否满足最小容量需求，若不满足，则minCapacity为新容量
	 * 	4.判断新容量是否超出了数组允许的最大容量 Integer.MAX_value;
	 * 	5.使用Arrays.copyOf(elementData,newCapacity);将旧数组的数据拷贝到新数组；
	 * 
	 * */
	
	

	
}
