
public class Derived extends Base{

	@Override
	public void fun() {
		// TODO Auto-generated method stub
		System.out.println("Override Annotation");
	}
	@Deprecated
	public void display()
	{
		System.out.println("Deprecated Annotation");
	}
	@SuppressWarnings({"unused" })
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("Suppress Warning");
		int a=1;
		int b=1;
		int c=1;
		int d=1;
	}

}
