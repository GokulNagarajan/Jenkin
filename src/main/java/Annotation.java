
public class Annotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();  
		a.m();
		a.n();
	}

}
class A{  
void m(){System.out.println("hello m");}  
  
@Deprecated  
void n(){System.out.println("hello n");}  
}  