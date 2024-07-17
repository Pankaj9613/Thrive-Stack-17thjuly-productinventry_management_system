package productinventry_management_system;
import java.util.*;
import java.sql.*;
public class InventryImpl implements Inventry{
	Scanner sc = new Scanner(System.in);
	Inventry_management a = new Inventry_management();
	@Override
	public void addNewProduct() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter Your Data To insert");
		System.out.println("Enter Product id");
		a.setId(sc.nextInt());
		System.out.println("Enter Product Name");
		a.setProductName(sc.next());
		System.out.println("Enter product description");
		a.setDescription(sc.next());
		System.out.println("Enter Product quantity");
		a.setQuantity(sc.nextInt());
		System.out.println("Enter product price");
		a.setPrice(sc.nextInt());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventry","root","rootroot");
		String sql = "insert into Product values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,a.getId());
		ps.setString(2,a.getProductName());
		ps.setString(3,a.getDescription());
		ps.setInt(4, a.getQuantity());
		ps.setInt(5, a.getPrice());
		ps.execute();
		ps.close();
		conn.close();
		System.out.println("Successfuly data is inserted");
	}

	@Override
	public void viewallproduct() throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventry","root","rootroot");
		String sql = "Select * from product";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Your product information is "+" product id "+rs.getInt(1)+" Product name is "+rs.getString(2)+" Product description is "+rs.getString(3)+" product Quantity is "+rs.getInt(4)+" product price is "+rs.getInt(5));
			
		}
		rs.close();
		ps.close();
		conn.close();
		System.out.println("Successfuly viewed your project");
	}

	@Override
	public void updateproductinformation() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter Your Data To update\n you should update with the help of id");
		
		System.out.println("Enter Product id");
		a.setId(sc.nextInt());
		System.out.println("Enter Product Name");
		a.setProductName(sc.next());
		System.out.println("Enter product description");
		a.setDescription(sc.next());
		System.out.println("Enter Product quantity");
		a.setQuantity(sc.nextInt());
		System.out.println("Enter product price");
		a.setPrice(sc.nextInt());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventry","root","rootroot");
		String sql = "Update product set productName =?, description=?, Quantity=?, Price=? where id =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,a.getProductName());
		ps.setString(2,a.getDescription());
		ps.setInt(3, a.getQuantity());
		ps.setInt(4, a.getPrice());
		ps.setInt(5,a.getId());
		ps.executeUpdate();
		ps.close();
		conn.close();
		System.out.println("Your product updated Successfuly");
		
	}

	@Override
	public void deleteproduct() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("you should update with the help of id");
		System.out.println("Enter Id To delete Product");
		a.setId(sc.nextInt());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventry","root","rootroot");
		String sql = "delete from product where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, a.getId());
		ps.execute();
		System.out.println("Your Product is deleted");
	}

	@Override
	public void searchproduct() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter product name to search product");
		a.setProductName(sc.next());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventry","root","rootroot");
		String sql = "Select * from product where productName=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,a.getProductName());
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Your product  is "+" product id "+rs.getInt(1)+" Product name is "+rs.getString(2)+" Product description is "+rs.getString(3)+" product Quantity is "+rs.getInt(4)+" product price is "+rs.getInt(5));
			
		}
		rs.close();
		ps.close();
		conn.close();
		
	}
	
}
