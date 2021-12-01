package main.java.methodTest;

import java.util.Arrays;

public class TestList<E> {
	
	//定义初始化数组容量
	private final static int DEFAULT_CAPACITY = 10;
	
	//定义数组的最大容量
	private final static int 	MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8 ;
	
	//定义初始数组
	private Object[]  elementdata;
	
	//数组有效元素个数
	private int size = 0;
	
	//定义无参构造
	public TestList() {
		elementdata = new Object[DEFAULT_CAPACITY];
	}
	
	//定义有参构造，参数为用户写进的容量
	public TestList(int initCapacity) {
		if (initCapacity < 0  || initCapacity > MAX_ARRAY_SIZE) {
			throw new IllegalArgumentException("不合法数据！");
		}
		
		elementdata = new Object[initCapacity];
	}
	
	
	//添加元素到数组的末尾
	public boolean add(E e) {
		return add(size, e);
	}
	
	boolean add(int index, E e) {
		//检查index是否合法
		rangeCheckForAdd(index);
		
		//如果数组已满，调用grow方法进行扩容
		if (size == elementdata.length ) {
			grow(size + 1);
		}
		//扩容后将指定下标以后的元素依次后移
		for (int i = size; i > index; i--) {
			elementdata[i] = elementdata[i - 1];
		}	
		
		//插入
		elementdata[index] = e;
		
		//有效元素加一
		size += 1;
		
		return true;
		
	}
	
	/**
	 * 数组底层的grow扩容方法，调用此方法说明数组已满，size = elementData.length
	 * @param minCapacity 最小需求容量
	 * 
	 * */
	public void grow(int minCapacity) {
		//获取当前数组的长度，即旧数组长度
		int oldCapacity = elementdata.length;
		
		//将数组长度变为1.5倍，即新数组长度
		int newCapacity = oldCapacity + oldCapacity >> 1;
		
		//判断新数组长度是否满足最小需求，如果不满足则将最小需求作为新数组长度
		if (newCapacity < minCapacity) {
			newCapacity = minCapacity;
		}
		
		//判断此时的新数组长度是否超出了数组容许的最大容量，如果超出则抛出异常
		if (newCapacity > MAX_ARRAY_SIZE) {
			throw new IllegalArgumentException("Out Of Max Array Size");
		}
		
		//一切确定好以后，用Arrays.copyOf方法创建一个新数组，其中elementdata为旧数组，newCapacity为新数组长度，
		//创建好以后将新数组地址赋给旧数组，完成扩容
		elementdata = Arrays.copyOf(elementdata, newCapacity);
		
	}
	
	//为add方法专门写的检查输入下标是否合法的方法 插入位置可以是size
	public void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("插入位置不合法！");
		}
	}
	
	//删除指定下标的元素
	public boolean remove(int index) {
		//检查输入下标是否合法
		rangeCheck(index);
		
		//将index后的元素依次前移
		for (int i = index; i < size - 1; i++) {
			elementdata[i] = elementdata[i+1];
		}
		
		//最后一个元素前移过后 ，此位置赋为null
		elementdata[size - 1] = null;
		
		//有效元素-1
		size -= 1;
		
		return true;
	}
	
	//判断输入的位置是否合法，输入的下标必须是有效元素的下标
	public void rangeCheck(int index) {
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("输入位置不合法！");
		}
	}
	
	//删除指定元素
	boolean remove(Object obj) {
		//判断此元素是否存在
		if (contains(obj)) {
			
			//获取该元素的下标
			int index = getIndex(obj);
			
			//调用删除指定下标的元素的方法
			remove(index);
			
			return true;
		}
		return false;
		
		
	}
	
	//查找指定元素的下标
	public int getIndex(Object obj) {
		//初始化下标为-1
		int index = -1;
		for (int i = 0; i < size; i++) {
			//使用getData方法获取每个下标的元素
			E temp = getData(i);
			//比较元素是否是入参元素
			if (temp.equals(obj)) {
				//如果是返回true
				return i;
			}
		}
		
		//没有查到返回-1
		return index;
	}

	public E getData(int index) {
		//判断下标是否合法
		rangeCheck(index);
		//返回该下标的元素
		return (E) elementdata[index - 1];		
	}
	
	
	//判断此元素是否存在
	public boolean contains(Object obj) {
		
		//调用查找下标方法，若返回值为-1则没有该元素
		return getIndex(obj) > 0;
		
	}
	
	//在指定下标位置设置指定元素
	public E setData(int index, E e) {
		//检查下标是否合法
		rangeCheck(index);
		
		//将此下标的原有元素取出
		E temp = getData(index);
		
		//将新元素赋值给此下标
		elementdata[index] = e;
		
		//将获取的旧元素返回
		return temp;
		
	}
	
	//获取类型为Object类型的数组
	public Object[] toArray() {
		//将集合作为数组返回
		return Arrays.copyOf(elementdata, size);
		
	}
	
	//获取指定位置到指定位置的下标的元素
	public TestList<E> getSubList(int SIndex, int Eindex){
		//新建一个长度刚好适合的集合
		TestList<E> list = new TestList<E>(Eindex - SIndex);
		//把数据装进去
		for (int i = SIndex; i < Eindex; i++) {
			list.add(getData(i));
		}
		
		return list;
		
	}

	//获取集合的字符串输出
	@Override
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder("[");
		
		for (int i = 0; i < size - 1; i++) {
			stringBuilder.append(getData(i) + ",");
		}
		
		stringBuilder.append(getData(size - 1) +" ]");
		
		return stringBuilder.toString();
		
	}
	
	public static void main(String[] args) {
		TestList<String> arr = new TestList<String>(3);
		arr.add("1");
		arr.add("2");
		arr.add("3");
		arr.add("4");
//		arr.add("4");
		System.out.println(arr.size);
		
	}
	
	
	
	
	
	

}
