import java.util.*;
public class GenericsWildcardVarargs {

	public static void main(String[] args) {
		GenericsWildcardVarargs g=new GenericsWildcardVarargs();
		MyGenerics1<Integer> n=g.new MyGenerics1<Integer>();
		n.set(10);
		System.out.println(n.get());
		MyGenerics1<String> s=g.new MyGenerics1<String>();
		s.set("Hello");
		System.out.println(s.get());
		MyGenerics1<Double> d=g.new MyGenerics1<Double>();
		d.set(7.7);
		System.out.println(d.get());
		MyGenerics2<Integer> a=g.new MyGenerics2<Integer>();
		a.set(32);
		System.out.println(a.get());
		MyGenerics2<Double> f=g.new MyGenerics2<Double>();
		f.set((double) 16);
		System.out.println(f.get());
		/*
		MyGenerics2<String> x=g.new MyGenerics2<String>();
		x.get("Hai");
		System.out.println(x.get());
		*/
		Integer [] intArrs = {1,2,3};
		Double [] doubleArrs = {1.1,2.2,3.3};
		String [] stringArrs = {"i","am","gokul"};
		System.out.println("Integer array using printGenerics");
		for(int i=0;i<intArrs.length;i++)
			printGenerics(intArrs[i]);
		System.out.println("Double array using printGenerics");
		for(int i=0;i<doubleArrs.length;i++)
			printGenerics(doubleArrs[i]);
		System.out.println("String array using printGenerics");
		for(int i=0;i<stringArrs.length;i++)
			printGenerics(stringArrs[i]);
		System.out.println("Integer Varargs using printInt");
		printInt(1);
		printInt(2,3);
		printInt(4,5,6);
		printInt(intArrs);
		System.out.println("String Varargs using printString");
		printString("i");
		printString("i","am");
		printString("i","am","gokul");
		printString(stringArrs);
		System.out.println("Print int Varargs with string");
		printIntVar("hi",1);
		printIntVar("hi",2,3);
		printIntVar("hi",4,5,6);
		printIntVar("hi",intArrs);
		System.out.println("Print string Varargs with int");
		printStringVar(7,"i");
		printStringVar(7,"i","am");
		printStringVar(7,"i","am","gokul");
		printStringVar(7,stringArrs);
		List<String> stringList=new ArrayList<String>();
		List<Integer> intList=new ArrayList<Integer>();
		List<Double> doubleList=new ArrayList<Double>();
		for(int i:intArrs)
			intList.add(i);
		for(double i:doubleArrs)
			doubleList.add(i);
		for(int i=0;i<stringArrs.length;i++)
			stringList.add(stringArrs[i]);
		System.out.println("Print int array using Element Generics");
		printArr(intArrs);
		System.out.println("Print double array using Element Generics");
		printArr(doubleArrs);
		System.out.println("Print string array using Element Generics");
		printArr(stringArrs);
		System.out.println("Print int array Generics");
		printArrGenerics(intList);
		System.out.println("Print  double array Generics");
		printArrGenerics(doubleList);
		System.out.println("Print  string array Generics");
		printArrGenerics(stringList);
		
	}
	
	public static <T> void printGenerics(T t)
	{
			System.out.println(t);
	}
	public static <T> void printArrGenerics(List<? extends T> lists)
	{
		for(T l:lists)
			printGenerics(l);
	}
	public static <E> void printArr(E[] elements)
	{
		for(E e:elements)
			System.out.print(e+" ");
		System.out.println("");
	}
	public static void printString(String...strings)
	{
		for(String s:strings)
			System.out.print(s+" ");
		System.out.println("");
	}
	public static void printInt(Integer...input)
	{
		for(int i:input)
			System.out.print(i+" ");
		System.out.println("");
	}
	public static void printStringVar(int i,String...strings)
	{
		System.out.println(i);
		for(String s:strings)
			System.out.print(s+" ");
		System.out.println("");
	}
	public static void printIntVar(String s,Integer...input)
	{
		System.out.println(s);
		for(int i:input)
			System.out.print(i+" ");
		System.out.println("");
	}
public class MyGenerics1<T>
{
	T t;
	void set(T t)
	{
		this.t=t;
	}
	T get()
	{
		return t;
	}
}
public class MyGenerics2<T extends Number>
{
	T t;
	void set(T t)
	{
		this.t=t;
	}
	T get()
	{
		return this.t;
	}
}
}