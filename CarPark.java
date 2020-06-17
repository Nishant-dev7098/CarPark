import java.util.*;

public class CarPark{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("car_parking_lot  ");
		int num_slot=sc.nextInt();
		
		List<Integer> slot=new LinkedList<>();
		List<String> vehicle_reg_num=new LinkedList<>();
		List<String> vehicle_color=new LinkedList<>();
		
		for(int i=0;i<num_slot;i++)
		{
			slot.add(i+1);
			System.out.print("park  ");
			String reg_num=sc.next();
			String color=sc.next();
			vehicle_reg_num.add(reg_num);
			vehicle_color.add(color);
		}
		
		System.out.print("leave ");
		
		List<Integer> vacant_slots=new LinkedList<>();
		int y=1;
		while(y!=0)
		{
			int emp_slot=sc.nextInt();
			vacant_slots.add(emp_slot);
			System.out.print("Press 1 to vacant more slots else press 0");
			int a=sc.nextInt();
			y=a;
		}
		int total_vacant_slots=vacant_slots.size();
		
		List<String> new_vec_reg_num=new LinkedList<>();
		List<String> new_vec_col=new LinkedList<>();
		
		y=1;
		System.out.println("status  ");
		
		while(y!=0)
		{
			System.out.print("park  ");
			String reg_num=sc.next();
			String color=sc.next();
			new_vec_reg_num.add(reg_num);
			new_vec_col.add(color);
			System.out.print("Press 1 to get parking space else press 0");
			int a=sc.nextInt();
			y=a;
		}
		
		System.out.print("registration_numbers_for_cars_with_color");
		String reg_num_with_color=sc.next();
		
		System.out.print("slot_numbers_for_cars_with_color");
		String slot_num_with_car_color=sc.next();
		
		List<String> car_enquiry=new LinkedList<>();
		y=1;
		while(y!=0)
		{
			System.out.print("slot_number_for_registration_number");
			String reg_num=sc.next();
			car_enquiry.add(reg_num);
			System.out.print("Press 1 for more enquiry else press 0");
			int a=sc.nextInt();
			y=a;
		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println("Creating a parking lot with "+num_slot+" slots");
		System.out.println();
		
		for(int i=0;i<num_slot;i++)
		{
			System.out.println("Allocated slot number: "+(i+1));
		}
		
		System.out.println();
		System.out.print("Free Slots: ");
		
		for(int i=0;i<vacant_slots.size();i++)
		{
			System.out.print(vacant_slots.get(i));
			if(i!=vacant_slots.size()-1)
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Slot No.  Registration No    Color");
		
		for(int i=0;i<num_slot;i++)
		{
			if(vacant_slots.contains(i+1))
				continue;
			System.out.println(slot.get(i)+"          "+vehicle_reg_num.get(i)+"     "+vehicle_color.get(i));
		}
		
		System.out.println();
		
		for(int i=0;i<new_vec_col.size();i++)
		{
			if(total_vacant_slots>0)
			{
				vehicle_reg_num.set(vacant_slots.get(i)-1,new_vec_reg_num.get(i));
				vehicle_color.set(vacant_slots.get(i)-1,new_vec_col.get(i));
				System.out.println("Allocated slot number: "+vacant_slots.get(i));
				total_vacant_slots--;
			}
			else{
				System.out.println("Sorry parking lot is full");
			}
		}
		System.out.println();
		for(int i=0;i<num_slot;i++)
		{
			if(vehicle_color.get(i).equalsIgnoreCase(reg_num_with_color))
				System.out.print(vehicle_reg_num.get(i)+" ");
		}
		System.out.println();
		System.out.println();
		for(int i=0;i<num_slot;i++)
		{
			if(vehicle_color.get(i).equalsIgnoreCase(slot_num_with_car_color))
				System.out.print(slot.get(i)+", ");
		}
		System.out.println();
		System.out.println();
		for(int i=0;i<car_enquiry.size();i++)
		{
			if(vehicle_reg_num.contains(car_enquiry.get(i)))
				System.out.println(slot.get(i));
			else
				System.out.println("Not Found");
		}
	}
}