package dto;

public class Student {
	private String smobile;
	private String sname;
	private String semail;
	private Integer sage;
	private String squal;
	private String sdesg;
	public String getSmobile() {
		return smobile;
	}
	public void setSmobile(String smobile) {
		this.smobile = smobile;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public String getSqual() {
		return squal;
	}
	public void setSqual(String squal) {
		this.squal = squal;
	}
	public String getSdesg() {
		return sdesg;
	}
	public void setSdesg(String sdesg) {
		this.sdesg = sdesg;
	}
	
	@Override
	public String toString() {
		return "Student [smobile=" + smobile + ", sname=" + sname + ", semail=" + semail + ", sage=" + sage + ", squal="
				+ squal + ", sdesg=" + sdesg + "]";
	}
	
	
	
	
}
