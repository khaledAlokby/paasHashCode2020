import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryOutPut {
	
	public static List<OutPutFile> generateOutPutList(List<Library> libs) {
		return libs.stream().map(LibraryOutPut::convertLibraryToDTO).collect(Collectors.toList());
	}
	
	public static OutPutFile convertLibraryToDTO(Library library) {
		String idAndBookNames = library.id + " " + library.books.size();
		String booksIds = "";
		for (Book b : library.scannedBooks) {
			booksIds += b.id + " ";
		}
		return new OutPutFile(idAndBookNames, booksIds);
	}
	
}
