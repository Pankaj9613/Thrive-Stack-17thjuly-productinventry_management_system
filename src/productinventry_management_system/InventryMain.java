package productinventry_management_system;
import java.util.*;
public class InventryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		InventryImpl i = new InventryImpl();
		try{while(true)
		{
			System.out.println("Welcome To Product Inventry Management System");
			System.out.println("Enter Your choice\n 1 For. Add New Products\n 2 for. View All Products \n 3 For. Update Product Information\n 4 For. Delete Products\n 5. Search Products\n 6:Exit()");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				i.addNewProduct();
				break;
			case 2:
				i.viewallproduct();
				break;
			case 3:
				i.updateproductinformation();
				break;
			case 4:
				i.deleteproduct();
				break;
			case 5:
				i.searchproduct();
				break;
			case 6 :
				System.out.println("No Choice is Provided");
				return;
			}
		}

	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
