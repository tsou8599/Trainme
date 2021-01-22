package _03_listBooks.service;

import java.util.List;
import java.util.Map;

import _03_listBooks.model.BookBean;

public interface BookService {
	// 依bookId來刪除單筆記錄
	int deleteBook(int no);
	
	// 依bookId來查詢單筆記錄
	BookBean getBook(int bookId);

	// 取出所有的類型
	List<String> getCategory();
	
	String getCategoryTag();
	
	Map<Integer, BookBean> getPageBooks(int pageNo);
	
//	int getPageNo();
	
	int getRecordsPerPage();

	long getRecordCounts();
	
	int getTotalPages();
	
	// 新增一筆記錄
	int saveBook(BookBean bean);

//	void setPageNo(int pageNo);

	void setRecordsPerPage(int recordsPerPage);

	void setSelected(String category);
	// 計算紀錄總筆數
	int updateBook(BookBean bean, long sizeInBytes) ;

}
