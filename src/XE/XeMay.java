package XE;

public class XeMay extends Xe{
	public XeMay() {
		super();
	}
	public XeMay(int km, int dt,int kg) {
		super();
	}
	public double themhang() {
		return super.themhang();
	}
	public double bot_hang() {
		return super.bot_hang();
	}
	public double doxang() {
		return super.doxang();
	}
	public double xechay() {
		return super.xechay();
	}
	public boolean ktraxang() {
		return super.ktraxang();
	}
	public double luongxangcon() {
		
		if(xechay()<=100) {
			return this.luongxangcon()- ((xechay()*2)/100);
		}
		else 
			return (this.luongxangcon()- (((xechay()*2)/100)+(this.luonghang*0.1/10)));
	

}}