import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Phone[] phone=new Phone[4];
		for(int i=0;i<phone.length;i++){
		    int phoneid=sc.nextInt();
		    sc.nextLine();
		    String os=sc.next();
		    String brand=sc.next();
		    int price=sc.nextInt();
		    sc.nextLine();
		    phone[i]=new Phone(phoneid,os,brand,price);
		}
		
		String sbrand=sc.next();
		String sos=sc.next();
		
		int sum=findPriceForGivenBrand(phone,sbrand);
		Phone pid=getPhoneIdBasedOnOs(phone,sos);
		
		if(sum>0){
		    System.out.println(sum);
		}
		else{
		    System.out.println("The given Brand is not available");
		}
		
		if(pid!=null){
		    System.out.println(pid.getphoneid());
		}
		else{
		    System.out.println("No phone are available with specified os and price range");
		}
	}
	
	public static int findPriceForGivenBrand(Phone[] phone,String brand){
	    int sum=0;
	    for(int i=0;i<phone.length;i++){
	        if(phone[i].getbrand().equalsIgnoreCase(brand)){
	            sum+=phone[i].getprice();
	        }
	    }
	    if(sum>0){
	        return sum;
	    }
	    else{
	        return 0;
	    }
	}
	
	public static Phone getPhoneIdBasedOnOs(Phone[] phone,String os){
	    Phone temp=null;
	    for(int i=0;i<phone.length;i++){
	        if(phone[i].getos().equalsIgnoreCase(os) && phone[i].getprice()>=50000){
	            temp=phone[i];
	            return temp;
	        }
	    }
	    return temp;
	} 
}

class Phone{
    private int phoneid;
    private String os;
    private String brand;
    private int price;
    
    public int getphoneid(){
        return phoneid;
    }
    public void setphoneId(int phoneid){
        this.phoneid=phoneid;
    }
    public String getos(){
        return os;
    }
    public void setos(String os){
        this.os=os;
    }
    public String getbrand(){
        return brand;
    }
    public void setbrand(String brand){
        this.brand=brand;
    }
    public int getprice(){
        return price;
    }
    public void setprice(int price){
        this.price=price;
    }
    public Phone(int phoneid, String os, String brand, int price){
        super();
        this.phoneid=phoneid;
        this.os=os;
        this.brand=brand;
        this.price=price;
    }
}
