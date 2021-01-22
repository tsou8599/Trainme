package _03_listBooks.model;

import java.io.Serializable;
import java.sql.Blob;

// 本類別封裝單筆書籍資料
public class BookBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer bookId;
	private String title;
	private String author;
	private Double listPrice;
	private Double discount;
	private Blob coverImage;
	private String fileName;
	private String bookNo;
	private String category;
	private Integer stock;
	private Integer companyId;
	private String companyName;
	private String discountStr;
	public BookBean(Integer bookId, String title, String author, Double listPrice, Double discount, String fileName, String bookNo, Blob coverImage,
			int companyId, String category) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.listPrice = listPrice;
		this.discount = discount;
		this.fileName = fileName;
		this.bookNo = bookNo;
		this.coverImage = coverImage;
		this.companyId = companyId;
		this.category = category;
		this.stock = 0;

	}

	public BookBean() {
	}

	public Integer getBookId() { // bookId
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
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

	private String priceStr = null;

	public String getPriceStr() {
		return priceStr;
	}

	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public Blob getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(Blob coverImage) {
		this.coverImage = coverImage;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getListPrice() {
		return listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	
	public void setDiscount(Double discount) {   //0.8, 0.75
		this.discount = discount;
		if (discount == 1) {
			discountStr = "";
		} else {
			int dnt = (int)(discount * 100);
			if (dnt % 10 == 0) {
				discountStr = (dnt / 10) + "折";
			} else {
				discountStr = " "  + dnt + "折";
			} 
			
		}
	}
	public String getDiscountStr() {
		return discountStr;
	}
	public String getDescription() {
		return getCompanyName().substring(0, 2) + " "
				+ getAuthor().substring(0, Math.min(3, getAuthor().length())) + " " 
				+ getTitle();
	}
}
