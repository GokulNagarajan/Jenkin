import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.mindtree.AnnotationsService.Column;
import com.mindtree.AnnotationsService.Id;
import com.mindtree.AnnotationsService.Table;
import com.mindtree.entity.Employee.Employee;


public class Annotation2DML {
	private static Scanner scan=new Scanner(System.in);
	private static Connection con;
	private static Statement stmt;
	private static String sql;
	static int n=0,i=0;
	static String saveQuery="",updateQuery="";
	private static int choice;
	static Employee emp=new Employee();
	static Method [] methods=emp.getClass().getMethods();
	static Annotation [] annotations=emp.getClass().getAnnotations();
	static String table = null,col1 = null,col2 = null,col3 = null;
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db","root","Welcome123");  
			System.out.println("Connecting the database");
			System.out.println();
			stmt=con.createStatement();
			useAnnotation();
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
					saveQuery=save(emp);
					System.out.println("Sql Query : ");
					System.out.println(saveQuery);
					try
					{
					stmt.executeUpdate(saveQuery);
					}
					catch (Exception e) {
						System.out.println("Id Already exists");
					}
					break;
				case 2:
					updateQuery=update(emp);
					System.out.println("Sql Query : ");
					System.out.println(updateQuery);
					stmt.executeUpdate(updateQuery);
					break;
				default:
					System.exit(0);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static String save(Employee e)  {
		System.out.println("Enter the Employee Details to be Inserted");
		getDetails(e);
		sql="INSERT INTO "+table+" ("+col1+","+col2+","+col3+") "+"VALUES ('"+e.getEmployeeId()+"','"+e.getEmployeeName()+"','"+e.getHireDate()+"')";
		return sql;
	}

	private static String update(Employee e)  {
		getDetails(e);
		System.out.println("Enter the Employee Details to be Updated");
		sql="UPDATE "+table+" SET "+col2+" = '"+e.getEmployeeName()+"' , "+col3+" = '"+e.getHireDate()+"' WHERE "+col1+" = "+e.getEmployeeId();
		return sql;
	}
	public static void useAnnotation()
	{
		for(Annotation a:annotations)
		{
			if(a instanceof Table)
			{
				for(Method m:methods)
				{
					table=((Table) a).name();
					Column c=m.getAnnotation(Column.class);
					if(c!=null)
					{
						Id i=m.getAnnotation(Id.class);
						if(i!=null)
						{
							if(m.getName().equals("setEmployeeId"))
								col1=c.name();
						}
						if(m.getName().equals("setEmployeeName"))
							col2=c.name();
						if(m.getName().equals("setHireDate"))
							col3=c.name();
						//System.out.println(m.getName());
					}
				}
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
