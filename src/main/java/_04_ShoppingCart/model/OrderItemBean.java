package _04_ShoppingCart.model;

//本類別封裝單筆訂單資料
public class OrderItemBean {

	Integer seqno;
	Integer orderNo;
	Integer bookId;
	String description;
	Double unitPrice;
	Integer quantity;
	Double discount;
	
	private String title;
	private String author;
	private String companyName;

	public OrderItemBean(Integer seqno, Integer orderNo, Integer bookId,
			String description, Integer quantity, Double unitPrice, Double discount,
			String title, String author, String companyName) {
		this.seqno = seqno;
		this.orderNo = orderNo;
		this.bookId = bookId;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.title = title;
		this.author = author;
		this.companyName = companyName;
	}
	public OrderItemBean(Integer orderNo, Integer bookId,
			String description, Integer quantity, Double unitPrice, Double discount) {
		this.orderNo = orderNo;
		this.bookId = bookId;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}
	public OrderItemBean() {
		
	}
	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}