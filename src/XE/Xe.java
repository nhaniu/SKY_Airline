package XE;

import java.util.Scanner;

public class Xe {
	protected int km;
	protected double dungtich, luonghang;
	public Xe() {
		this.km = 0;
		this.dungtich = 0;
		this.luonghang=0;
	}
	public Xe(int kmm, double dt,double lh ) {
		this.km = kmm;
		this.dungtich = dt;
		this.luonghang = lh;
	}
	public double themhang() {
		int kg;
		Scanner scanner=new Scanner(System.in);
		System.out.println("nhap so luong hang can them: ");
		kg=scanner.nextInt();		
		return this.luonghang + kg;
	}
	public double bot_hang() {
		int kg;
		Scanner scanner=new Scanner(System.in);
		System.out.println("nhap so luong hang can bot: ");
		kg=scanner.nextInt();
		return this.luonghang - kg;
	}
	public double doxang() {
		int litxang;
		Scanner scanner=new Scanner(System.in);
		System.out.println("nhap so luong xang can do: ");
		litxang=scanner.nextInt();
		return this.dungtich + litxang;
	}
	public double xechay() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("nhap so km xe chay: ");
		km=scanner.nextInt();
		return km;
	}
	
	public boolean ktraxang() {
		if(this.dungtich==0) {
			System.out.println("xe het xang\n");
			return true;
		}
		else 
		{
			System.out.println("xe con xang\n");
			return false;
		}
	}
	 public double luongxangcon() {
		 return dungtich;
	 }
	public static void main(String[] args) {
		

	}

}
