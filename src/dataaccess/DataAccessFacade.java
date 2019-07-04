package dataaccess;
import person.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataAccessFacade implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8592657179188160602L;
	public static final String OUTPUT_DIR = System.getProperty("user.dir")
			+ "\\src\\storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	private static final String file = "memberfile.txt";
	private static final String bookFile = "bookfile.txt";
	private static final String userFile = "userfile.txt"; //LibraryMember
	private static final String entryFile = "entryfile.txt";
	private static final String authorFile = "authorfile.txt";
	private static List<Staff> memberList = new ArrayList<Staff>();
	private static List<Book> bookList = new ArrayList<>();
	private static List<LibraryMember> userList = new ArrayList<>();
	private static List<Author> authorList = new ArrayList<>();

	public static void saveStaff(Staff member) {

		if(member == null) return;
		memberList = readStaff();
		memberList.add(member);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, file);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(memberList);
			out.flush();

		} catch(IOException e) {
			//e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static List<Staff> readStaff() {
		ObjectInputStream in = null;
		List<Staff> staffs = new ArrayList<Staff>();
		Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, file);
		try {
			in = new ObjectInputStream(Files.newInputStream(path));
			staffs = (ArrayList)in.readObject();
		} catch(ClassNotFoundException | IOException e) {
			//e.printStackTrace();

		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return staffs;
	}

	public static void saveBook(Book book) {

		if(book == null) return;
		bookList = readBook();
		bookList.add(book);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, bookFile);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(bookList);
			out.flush();

		} catch(IOException e) {
			//e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void saveBookList(List<Book> bookList) {

		if(bookList == null) return;
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, bookFile);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(bookList);
			out.flush();

		} catch(IOException e) {
			//e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static List<Book> readBook() {
		ObjectInputStream in = null;
		List<Book> books = new ArrayList<Book>();
		Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, bookFile);
		try {
			in = new ObjectInputStream(Files.newInputStream(path));
			books = (ArrayList)in.readObject();
		} catch(ClassNotFoundException | IOException e) {
			//e.printStackTrace();

		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return books;
	}
	public static void saveUser(LibraryMember member) {

		if(member == null) return;
		userList = readUser();
		userList.add(member);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, userFile);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(userList);
			out.flush();

		} catch(IOException e) {
			//e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	@SuppressWarnings("unchecked")
	public static List<LibraryMember> readUser() {
		ObjectInputStream in = null;
		List<LibraryMember> users = new ArrayList<LibraryMember>();
		Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, userFile);
		try {
			in = new ObjectInputStream(Files.newInputStream(path));
			users = (ArrayList<LibraryMember>)in.readObject();
		} catch(ClassNotFoundException | IOException e) {
			//e.printStackTrace();

		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return users;
	}

public static void saveEntry(List<CheckoutRecordEntry> entry) {
		if(entry == null) return;
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, entryFile);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(entry);
			out.flush();

		} catch(IOException e) {
			//e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static List<CheckoutRecordEntry> readEntry() {
		ObjectInputStream in = null;
		List<CheckoutRecordEntry> entries = new ArrayList<CheckoutRecordEntry>();
		Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, entryFile);
		try {
			in = new ObjectInputStream(Files.newInputStream(path));
			entries = (ArrayList)in.readObject();
		} catch(ClassNotFoundException | IOException e) {
			//e.printStackTrace();

		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return entries;
	}
	public static void saveAuthor(Author author) {

		if(author == null) return;
		authorList = readauthor();
		authorList.add(author);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, authorFile);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(authorList);
			out.flush();

		} catch(IOException e) {
			//e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static List<Author> readauthor() {
		ObjectInputStream in = null;
		List<Author> authors = new ArrayList<Author>();
		Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, authorFile);
		try {
			in = new ObjectInputStream(Files.newInputStream(path));
			authors = (ArrayList)in.readObject();
		} catch(ClassNotFoundException | IOException e) {
			//e.printStackTrace();

		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return authors;
	}


}
