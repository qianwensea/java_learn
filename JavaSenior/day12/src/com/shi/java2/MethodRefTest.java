package com.shi.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * 1.使用情境: 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 * 2.方法引用可以看做是Lambda表达式深层次的表达。换句话说，方法引用就是Lambda表达式，也就是函数式接口的一个实例，
 * 通过方法的名字来指向一个方法，可以认为是Lambda表达式的一个语法糖。
 *
 * 3.使用格式: 类(或对象) :: 方法名
 *
 * 4.具体分为如下的三种情况:
 * 		情况1:  对象 :: 非静态方法
 * 		情况2:  类   ::	静态方法
 * 		情况3:  类  ::  非静态方法
 *
 * 5.方法引用的使用要求: 要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法相同(情况1和情况2)
 *
 *
 *
 * @author 千文sea
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {
		Consumer<String> con1 = str -> System.out.println(str);
		con1.accept("hello");
		System.out.println("***********************************");
		PrintStream out = System.out;
		Consumer<String> con2 = out :: println;
		con2.accept("world");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee emp = new Employee(1001, "Tom", 23, 1000);
		Supplier<String> sup1 = () -> emp.getName();
		System.out.println("**************************");
		Supplier<String> sup2 = emp :: getName;
		sup2.get();
	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com1 = (o1,o2) -> Integer.compare(o1,o2);
		System.out.println(com1.compare(12, 21));
		System.out.println("***************************");
		Comparator<Integer> com2 = Integer::compare;
		System.out.println(com2.compare(33, 22));
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double,Long> fun = new Function<Double, Long>() {
			@Override
			public Long apply(Double aDouble) {
				return Math.round(aDouble);
			}
		};
		Function<Double,Long> fun1 = aDouble -> Math.round(aDouble);
		System.out.println(fun1.apply(23.3));
		System.out.println("*************************");
		Function<Double,Long> fun2 = Math :: round;
		System.out.println(fun2.apply(2.9));
	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com = (s1,s2) -> s1.compareTo(s2);
		System.out.println(com.compare("abc", "acb"));
		System.out.println("************************");
		Comparator<String> com1 = String::compareTo;
		System.out.println(com1.compare("bcd", "bce"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String,String> bip = (t1,t2) -> t1.equals(t2);
		System.out.println(bip.test("abc", "acb"));
		System.out.println("***************************");
		BiPredicate<String,String> bip1 = String::equals;
		System.out.println(bip1.test("bcd", "bce"));
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee emp = new Employee(1001, "Tom", 23, 1000);
		Function<Employee,String> fun = e -> e.getName();
		System.out.println(fun.apply(emp));
		System.out.println("*****************************");
		Function<Employee,String> fun1 = Employee::getName;
		System.out.println(fun1.apply(emp));
	}
}