import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.mindtree.AnnotationsService.Column;
import com.mindtree.AnnotationsService.Id;
import com.mindtree.AnnotationsService.Table;
import com.mindtree.entity.Employee.Employee;

public class Annotation2DMLMain {
	private static Scanner scan=new Scanner(System.in);
	private static String sql;
	static int n=0,i=0;
	private static int choice;
	static Employee emp=new Employee();
	static Method [] methods;
	static Annotation [] annotations;
	static boolean present=false;
	static String table = null,col1 = null,col2 = null,col3 = null;
	public static void main(String[] args) throws ParseException 
	{
		useAnnotation(emp);
		while(true)
		{
			try
			{
				System.out.println("\n1: Save/Insert");
				System.out.println("2: Edit/Update");
				System.out.println("Enter other Number to exit");
				System.out.println("Enter choice");
				choice=scan.nextInt();
			}
			catch(Exception e1)
			{
				System.out.println("\nEnter valid Choice");
				scan.next();
				continue;
			}
			switch(choice)
			{
				case 1:
					System.out.println("Sql Query : ");
					System.out.println(save(emp));
					break;
				case 2:
					System.out.println("Sql Query : ");
					System.out.println(update(emp));
					break;
				default:
					System.exit(0);
				}
			}
	}
	private static String save(Employee e)  {
		System.out.println("Enter the Employee Details to be Inserted");
		getDetails(e);
		sql="INSERT INTO "+table+"("+col1+","+col2+","+col3+") "+"VALUES ('"+e.getEmployeeId()+"','"+e.getEmployeeName()+"','"+e.getHireDate()+"')";
		return sql;
	}

	private static String update(Employee e)  {
		getDetails(e);
		System.out.println("Enter the Employee Details to be Updated");
		sql="UPDATE "+table+" SET "+col2+"='"+e.getEmployeeName()+"' , "+col3+" ='"+e.getHireDate()+"' WHERE "+col1+"="+e.getEmployeeId();
		return sql;
	}
	public static void useAnnotation(Employee e)
	{
		methods=e.getClass().getMethods();
		annotations=e.getClass().getAnnotations();
		for(Annotation a:annotations)
		{
			if(a instanceof Table)
			{
				table=((Table) a).name();
			}
		}
		for (Method m : methods) 
		{
			Column c = m.getAnnotation(Column.class);
			if (c != null) {
				Id i = m.getAnnotation(Id.class);
				if (i != null) {
					if (m.getName().equals("setEmployeeId"))
						col1 = c.name();
				}
				if (m.getName().equals("setEmployeeName"))
					col2 = c.name();
				if (m.getName().equals("setHireDate"))
					col3 = c.name();
			}
		}
		
	}
	public static void getDetails(Employee e)
	{
		int eId;
		String eName;
		String hDate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date sqlDate;
		java.sql.Date date;
		while(true)
		{
			try
			{
				System.out.println("Enter the Empolyee Id : ");
				eId=scan.nextInt();
				e.setEmployeeId(eId);
				break;
			}
			catch(Exception e1)
			{
				System.out.println("Enter Employee Id");
				scan.next();
			}
		}
		scan.nextLine();
		System.out.println("Enter the Empolyee Name : ");
		eName=scan.nextLine();
		e.setEmployeeName(eName);
		while(true)
		{
		try
		{
			System.out.println("Enter the Hire Date : ");
			hDate=scan.nextLine();
			dateFormat.setLenient(false);
			sqlDate=dateFormat.parse(hDate);
			if(sqlDate.getYear()<-9100||sqlDate.getYear()>8099)
			{
				System.out.println("\nEnter year between 1000 to 9999");
				continue;
			}
			
			break;
		}
		catch(Exception e1)
		{
			System.out.println("\nEnter valid Date as input");
			continue;
		}
		}
		date=new java.sql.Date(sqlDate.getTime());
		e.setHireDate(date);
		}	
}
