
public class Books {
	int bid;
	String bname;
	float bprice;
	String author;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public float getBprice() {
		return bprice;
	}
	public void setBprice(float bprice) {
		this.bprice = bprice;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Books(int bid, String bname, float bprice, String a) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bprice = bprice;
		this.author = a;
	}
	public Books() {
		super();
	}
	@Override
	public String toString() {
		return "BookId = "+ bid + ", BookName = " + bname + ", Price = " + bprice + ", Author = " + author;
	}
	
	
}
