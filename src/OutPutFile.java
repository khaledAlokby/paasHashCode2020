public class OutPutFile {
	
	String idAndBooksNum;
	String booksIds;
	
	public void setIdAndBooksNum(String idAndBooksNum) {
		this.idAndBooksNum = idAndBooksNum;
	}
	
	public void setBooksIds(String booksIds) {
		this.booksIds = booksIds;
	}
	
	public String getIdAndBooksNum() {
		return idAndBooksNum;
	}
	
	public OutPutFile() {
	}
	
	public String getBooksIds() {
		return booksIds;
	}
	
	public OutPutFile(String idAndBooksNum, String booksIds) {
		this.idAndBooksNum = idAndBooksNum;
		this.booksIds = booksIds;
	}
}
