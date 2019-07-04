package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import dataaccess.DataAccessFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.transform.Scale;
import person.*;

import java.util.LinkedList;
import java.util.List;

import dataaccess.DataAccessFacade;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.CheckoutRecordEntry;

public class Services extends MainController{


	@SuppressWarnings("rawtypes")
	static void printAllEntryToTable(TableView tableView){
		List<CheckoutRecordEntry> listOfEntries = DataAccessFacade.readEntry();
		for(CheckoutRecordEntry c: listOfEntries) {		
			TableColumn<CheckoutRecordEntry, String> column1 = MainController.isbnCol;
		   column1.setCellValueFactory(new PropertyValueFactory<>("bookISBN"));
		
		    tableView.getColumns().clear();
//			tableView.setItems(getIsbns());
//			tableView.getColumns().addAll(isbn,isbn1,title,copyNum,remDays,status);

		}
		
	        
		//tableView.
		
	}
	
	
 void searchByID(String searchtext){
		
	}
 
 /////////////////////////////////////////////////from Kira//////////////////////
 	//static List<Staff> staffUsers = DataAccessFacade.readStaff();
	static List<Book> bookList = DataAccessFacade.readBook();
	static List<LibraryMember> lins = DataAccessFacade.readUser();

	boolean searchMember = false;
	boolean bookSerach = false;
	boolean checkOutSerach = false;
	String userUsername = null;
	String userPassword = null;

	private Administrator admin = null;


	@FXML private TabPane tabPane;
	@FXML private Tab CheckOutTab;
	@FXML private Tab CheckListTab;
	@FXML private Tab addMemberTab;
	@FXML private Tab addBookTab;
	@FXML private Tab BookListTab;

	//Labels
	@FXML private Label username;
	@FXML private Label password;
	@FXML private Label lms;
	@FXML private Label g7;
	@FXML private Label fnameLabel;
	@FXML private Label lnameLabel;
	@FXML private Label titleLabel;

	//table view for books
	@FXML private TableView<Book> tableView;
	@FXML private TableColumn<Book, String> isbn;
	@FXML private TableColumn<Book, String> isbn1;
	@FXML private TableColumn<Book, String> title;
	@FXML private TableColumn<Book, String> author;
	@FXML private TableColumn<Book, Integer> copyNum;
	@FXML private TableColumn<Book, Integer> remDays;
	@FXML private TableColumn<Book, Boolean> status;


//	// table view for chekOut List
//	@FXML private TableView<CheckOut> tableView1;
//	@FXML private TableColumn<CheckOut, String> isbnCol;
//	@FXML private TableColumn<CheckOut, String> titleCol;
//	@FXML private TableColumn<CheckOut, LocalDate> checkDateCol;
//	@FXML private TableColumn<CheckOut, LocalDate> dueCol;
//	@FXML private TableColumn<CheckOut, Integer> overCol;
//	@FXML private TableColumn<CheckOut, Boolean> fineCol;
//	@FXML private TableColumn<CheckOut, LocalDate> paidDateCol;
	
	// table view for chekOut List
	@FXML private TableView<CheckoutRecordEntry> tableView1;
	@FXML private TableColumn<CheckoutRecordEntry, String> isbnCol;
	@FXML private TableColumn<CheckoutRecordEntry, String> titleCol;
	@FXML private TableColumn<CheckoutRecordEntry, LocalDate> checkDateCol;
	@FXML private TableColumn<CheckoutRecordEntry, LocalDate> dueCol;
	@FXML private TableColumn<CheckoutRecordEntry, Integer> overCol;
	@FXML private TableColumn<CheckoutRecordEntry, Boolean> fineCol;
	@FXML private TableColumn<CheckoutRecordEntry, LocalDate> paidDateCol;

	//TextFieldsta
	@FXML private TextField user;
	@FXML private TextField pass;


	//Text Field for Add Memebr
	@FXML private TextField memName;
	@FXML private TextField memLName;
	@FXML private TextField memMembID;
	@FXML private TextField memcity;
	@FXML private TextField memState;
	@FXML private TextField memeZip;
	@FXML private TextField memPhone;
	@FXML private TextField memStreet;





	// Text Field for Add Staff Member
	@FXML private TextField firstName;
	@FXML private TextField lastName;
	@FXML private TextField street;
	@FXML private TextField city;
	@FXML private TextField state;
	@FXML private TextField zip;
	@FXML private TextField phone;
	@FXML private TextField passForAddStaff;
	
	@FXML private TextField lastName2;
	@FXML private CheckBox ad;
	@FXML private CheckBox lib;


	// Text field for Add Book
	@FXML private TextField titleField;
	@FXML private TextField fnameField;
	@FXML private TextField lnameField;
	@FXML private TextField isbnField;
	@FXML private TextField streetField;
	@FXML private TextField cityField;
	@FXML private TextField borrowLimitField;
	@FXML private TextField stateField;
	@FXML private TextField zipField;
	@FXML private TextField copyNumField;
	@FXML private TextField phoneField;
	@FXML private CheckBox availableCheckBox;


	// Text fields for Edit Members
	@FXML private TextField editFirstName;
	@FXML private TextField editLastName;
	@FXML private TextField editState;
	@FXML private TextField editZip;
	@FXML private TextField editPhone;
	@FXML private TextField editPassword;
	@FXML private TextField editUserName;
	@FXML private TextField editCity;
	@FXML private TextField editStreet;
	@FXML private CheckBox editAdmin;
	@FXML private CheckBox EditLib;

	// Search book field

	@FXML private TextField search;
	@FXML private TextField searchField1;
	@FXML private TextField searchField11;

	//buttons
	@FXML private Button loginBtn;
	@FXML private Button logoutBtn;
	@FXML private Button addMemBtn;
	@FXML private Button addBookBtn;
	@FXML private Button searchBtn;
	@FXML private Button resetBtn;
	@FXML private Button searchUser;
	@FXML private Button editBtn;
	@FXML private Button addMemBtn1;


	@FXML
	public void addMember() throws IOException,NullPointerException{

		Address address = new Address(street.getText(), city.getText(), state.getText(), zip.getText(), phone.getText());

		admin = new Administrator("kirubel", "kelemu", address, userUsername, userPassword, Role.ADMIN);

		 String phonel  = phone.getText();
	        Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
	        Matcher matcher = pattern.matcher(phonel);
	        if(matcher.matches()){
	        	if(ad.isSelected()){

	    			if(admin.addNewMember(firstName.getText(), lastName.getText(), address, lastName2.getText(), passForAddStaff.getText(),Role.ADMIN)){

	    					Administrator adds = new Administrator(firstName.getText(), lastName.getText(), address, lastName2.getText(), passForAddStaff.getText(),Role.ADMIN);
	    					DataAccessFacade.saveStaff(adds);

	    					System.out.println(firstName.getText() + lastName.getText() + lastName2.getText() +  passForAddStaff.getText());


	    				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    				alert.setTitle("Succesfull Registration");
	    				alert.setContentText("You Have Successfully Created ADMINSTRATOR User, Go to Main Window?");
	    				Optional<ButtonType> result = alert.showAndWait();
	    				if (result.get() == ButtonType.OK) {
	    					clearAddMemberFields();
	    				} else {
	    					alert.close();
	    				}
	    			}
	    			else{

	    				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    				alert.setTitle("User Name already Exists");
	    				alert.setContentText("There is a user with the Username already. Do you want to create with diffrent UserName?");
	    				Optional<ButtonType> result = alert.showAndWait();
	    				if (result.get() == ButtonType.OK) {
	    					clearAddMemberFields();
	    				} else {
	    					alert.close();
	    				}
	    			}


	    		}

	    		if(lib.isSelected()){
	    			if(admin.addNewMember(firstName.getText(), lastName.getText(), address, lastName2.getText(), passForAddStaff.getText(),Role.LIBRARIAN)){

	    				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    				alert.setTitle("Succesfull Registration");
	    				alert.setContentText("You Have Successfully Created Librarian User, Go to Main Window?");
	    				Optional<ButtonType> result = alert.showAndWait();
	    				if (result.get() == ButtonType.OK) {
	    					clearAddMemberFields();
	    				} else {
	    					alert.close();
	    				}

	    			}
	    			else{

	    				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    				alert.setTitle("User Name already Exists");
	    				alert.setContentText("There is a user with the Username already. Do you want to create with diffrent UserName?");
	    				Optional<ButtonType> result = alert.showAndWait();
	    				if (result.get() == ButtonType.OK) {
	    					clearAddMemberFields();
	    				} else {
	    					alert.close();
	    				}

	    			}



	    		}
	    		if(lib.isSelected() && ad.isSelected()){
	    			if(admin.addNewMember(firstName.getText(), lastName.getText(), address, lastName2.getText(), passForAddStaff.getText(),Role.BOTH)){

	    				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    				alert.setTitle("Succesfull Registration");
	    				alert.setContentText("You Have Successfully Created ADMINSTRATOR User, Go to Main Window?");
	    				Optional<ButtonType> result = alert.showAndWait();
	    				if (result.get() == ButtonType.OK) {
	    					clearAddMemberFields();
	    				} else {
	    					alert.close();
	    				}
	    			}
	    			else{

	    				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    				alert.setTitle("User Name already Exists");
	    				alert.setContentText("There is a user with the Username already. Do you want to create with diffrent UserName?");
	    				Optional<ButtonType> result = alert.showAndWait();
	    				if (result.get() == ButtonType.OK) {
	    					clearAddMemberFields();
	    				} else {
	    					alert.close();
	    				}
	    			}
	    		}
	        }
	        else {
	        	
	        	 Alert alert = new Alert(Alert.AlertType.WARNING);
	             alert.setTitle("Phone Number doesn't match");
	             alert.setContentText("The Phone Number doesn't match the expression; Phone Number must be in the form XXX-XXXXXXX ");
	             Optional<ButtonType> result = alert.showAndWait();
	             if (result.get() == ButtonType.OK) {
	             } else {
	                 alert.close();
	             }
	        	
	        }
		
		
		

	}

	@FXML
	public void addBook () throws IOException{

		Address adress = new Address(stateField.getText(), cityField.getText(), stateField.getText(), zipField.getText(), phoneField.getText());
		admin = new Administrator("kirubel", "kelemu", adress, userUsername, userPassword, Role.ADMIN);

		if(admin.isBookAvailable(isbnField.getText())){

			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Updating BooK Copies");
			alert.setContentText("You Have Successfully updated copies of the book; Go to Main Window?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				clearAddBookFields();
			} else {
				alert.close();
			}
		}
		else{

			if(availableCheckBox.isSelected()){
				admin.addNewBook(titleField.getText(), isbnField.getText(), Integer.parseInt(copyNumField.getText()), true, Integer.parseInt(borrowLimitField.getText()), fnameField.getText(), lnameField.getText(), streetField.getText(), cityField.getText(), stateField.getText(), zipField.getText(), phoneField.getText(), "This is bio", "this is bio");

				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Succesfuly Book Added ");
				alert.setContentText("You Have Successfully added a book; Go to Main Window?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					clearAddBookFields();
				} else {
					alert.close();
				}

			}
			else{
				admin.addNewBook(titleField.getText(), isbnField.getText(), Integer.parseInt(copyNumField.getText()), true, Integer.parseInt(borrowLimitField.getText()), fnameField.getText(), lnameField.getText(), streetField.getText(), cityField.getText(), stateField.getText(), zipField.getText(), phoneField.getText(), "This is bio", "this is bio");

				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Succesfuly Book Added ");
				alert.setContentText("You Have Successfully added a book; Go to Main Window?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					clearAddBookFields();
				} else {
					alert.close();
				}


			}

		}

	}

	@FXML
	public void searchUserName(){

		Address address  = new Address("root", "root", "root", "root", "root");
		Staff staff = new Administrator("kirubel", "kelemu", address, userUsername, userPassword, Role.ADMIN);
		LibraryMember member = null;
		for(LibraryMember s: lins){
			if(s.getMembId().equals(searchField11.getText())){
				searchMember = true;
				member = s;
			}
		}

		if(searchMember){
			editFirstName.setText(member.getFirstName());
			editLastName.setText(member.getLastName());
		}

		else{

			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("User Name Not Found");
			alert.setContentText("There is No user with with the specific user Name, Try again!!!");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				clearEditMemberFields();
			} else {
				alert.close();
			}

		}

	}
	@FXML
	public void editMember(){

		LibraryMember old = null;
		for(LibraryMember s: lins){
			if(s.getMembId().equals(searchField11.getText())){
				searchMember = true;
				old = s;
				lins.remove(s);
				break;
			}
		}

		Address adress  = new Address(editStreet.getText(), editCity.getText(), editState.getText(), editZip.getText(), editPhone.getText());
		LibraryMember newOne = new LibraryMember(editFirstName.getText(), editLastName.getText(), adress, searchField11.getText());
		DataAccessFacade.saveUser(newOne);

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("User Profile Edited");
		alert.setContentText("The User Profile has been edited Sucessfully!!!");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			clearEditMemberFields();
		} else {
			alert.close();
		}



	}

	@FXML
	public void addMemberUser(){

		Address adress = new Address(memState.getText(), memcity.getText(), memStreet.getText(), memeZip.getText(), memPhone.getText());
		admin = new Administrator("kirubel", "kelemu", adress, userUsername, userPassword, Role.ADMIN);
		    
			String phone = memPhone.getText();
	        Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
	        Matcher matcher = pattern.matcher(phone);
	        
	        if(matcher.matches()) {
	        	if(admin.isUserMemberAvailable(memMembID.getText())){

	    			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    			alert.setTitle("Librarian Member is Already Exists ");
	    			alert.setContentText("Do you want to replace the Libraarian Member?");
	    			Optional<ButtonType> result = alert.showAndWait();
	    			if (result.get() == ButtonType.OK) {
	    				admin.addUser(memName.getText(), memLName.getText(), adress, memMembID.getText());
	    			} else {
	    				alert.close();
	    			}

	    		}
	    		else{

	    			admin.addUser(memName.getText(), memLName.getText(), adress, memMembID.getText());

	    			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	    			alert.setTitle("Succesfuly Library Member Added ");
	    			alert.setContentText("You Have Successfully a Librarian Member to our System; Go to Main Window?");
	    			Optional<ButtonType> result = alert.showAndWait();
	    			if (result.get() == ButtonType.OK) {
	    				ClearUserMemberFields();
	    			} else {
	    				alert.close();
	    			}
	    		}
	        }
	        else {
	        	
	        	Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Phone Number doesn't match");
	            alert.setContentText("The Phone Number doesn't match the expression; Phone Number must be in the form XXX-XXXXXXX ");
	            Optional<ButtonType> result = alert.showAndWait();
	            if (result.get() == ButtonType.OK) {
	                admin.addUser(memName.getText(), memLName.getText(), adress, memMembID.getText());
	            } else {
	                alert.close();
	            }

	        }
	        
		
	        

	}


	private ObservableList<Book> getBook(){
		bookList = DataAccessFacade.readBook();
		List<Book> foundBook = new ArrayList<>();
		for(Book noo : bookList){
			if(noo.getTitle().toLowerCase().contains(search.getText().toLowerCase())){
				foundBook.add(noo);
				bookSerach = true;
				System.out.println("found book");
			}
		}
		ObservableList<Book> books = FXCollections.observableArrayList(foundBook);
		return books;
	}
	private ObservableList<Book> getBooks(){
		ObservableList<Book> books = FXCollections.observableArrayList();
		for(Book b: bookList){
			books.add(b);
		}
		return books;
	}

	@FXML
	public void viewBook() throws IOException{
		bookList = DataAccessFacade.readBook();

		isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		isbn1.setCellValueFactory(new PropertyValueFactory<>("copyid"));
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
		//author.setCellValueFactory(new PropertyValueFactory<>("numCop"));
		copyNum.setCellValueFactory(new PropertyValueFactory<>("numCop"));
		remDays.setCellValueFactory(new PropertyValueFactory<>("borrowDayLimit"));
		status.setCellValueFactory(new PropertyValueFactory<>("available"));

		tableView.getColumns().clear();
		tableView.setItems(getBooks());
		tableView.getColumns().addAll(isbn,isbn1,title,copyNum,remDays,status);

//		for(Book noo : bookList){
//			System.out.println(noo);
//		}

	}

	@FXML
	public void searchBook() throws IOException{

		isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
		isbn1.setCellValueFactory(new PropertyValueFactory<>("copyid"));
		title.setCellValueFactory(new PropertyValueFactory<>("title"));
		copyNum.setCellValueFactory(new PropertyValueFactory<>("numCop"));
		remDays.setCellValueFactory(new PropertyValueFactory<>("borrowDayLimit"));
		status.setCellValueFactory(new PropertyValueFactory<>("available"));

		tableView.getColumns().clear();
		tableView.setItems(getBook());
		tableView.getColumns().addAll(isbn,isbn1,title,copyNum,remDays,status);

		if(!bookSerach){
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("No Result Found");
			alert.setContentText("There is no such book called " + " " +  search.getText() + " Go to Main Window?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				// Clear all text Fields
			} else {
				alert.close();
			}
		}
	}

	@FXML
	public void restSearch() throws IOException{
		viewBook();
		search.setText(null);
	}


	private ObservableList<CheckoutRecordEntry> getRecord(){
		//List<CheckoutRecordEntry> checkOutRecords = DataAccessFacade.readEntry();
		
		ObservableList<CheckoutRecordEntry> records = getRecords();
		ObservableList<CheckoutRecordEntry> searched = FXCollections.observableArrayList();
		
		
//		records.add(new CheckOut("power12", "The Power", LocalDate.now(), LocalDate.now().plusDays(5), 23.45, false, LocalDate.now().plusDays(10)));
//		records.add(new CheckOut("power13", "The ghjkhgjk", LocalDate.now(), LocalDate.now().plusDays(5), 23.45, false, LocalDate.now().plusDays(10)));
//		records.add(new CheckOut("power14", "The Power of nation", LocalDate.now(), LocalDate.now().plusDays(5), 23.45, false, LocalDate.now().plusDays(10)));
//		records.add(new CheckOut("power15", "The Power of love", LocalDate.now(), LocalDate.now().plusDays(5), 23.45, false, LocalDate.now().plusDays(10)));
//		records.add(new CheckOut("power16", "The ghghgf", LocalDate.now(), LocalDate.now().plusDays(5), 23.45, false, LocalDate.now().plusDays(10)));

		for (CheckoutRecordEntry c: records){
			if(c.getBook().getIsbn().toLowerCase().contains(searchField1.getText().toLowerCase())){
				searched.add(c);
				checkOutSerach = true;
			}
		}

		return searched;
	}
	private ObservableList<CheckoutRecordEntry> getRecords(){
		
		List<CheckoutRecordEntry> checkOutRecords = DataAccessFacade.readEntry();		
		ObservableList<CheckoutRecordEntry> records = FXCollections.observableArrayList();
		
		for(CheckoutRecordEntry c: checkOutRecords) {
			records.add(c);
//		
		}
		
		return records;
	}

	public void viewRecords() throws IOException{
	//	records.add(new CheckOut("power12", "The Power", LocalDate.now(), LocalDate.now().plusDays(5), 23.45, false, LocalDate.now().plusDays(10)));
//		isbnCol.setCellValueFactory(c->c.getValue());
		
		isbnCol.setCellValueFactory(new PropertyValueFactory<>("bookISBN"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
		checkDateCol.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
		dueCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		overCol.setCellValueFactory(new PropertyValueFactory<>("BookOverDue"));
		fineCol.setCellValueFactory(new PropertyValueFactory<>("IsFine"));
		paidDateCol.setCellValueFactory(new PropertyValueFactory<>("MemberName"));

		tableView1.getColumns().clear();
		tableView1.setItems(getRecords());
		tableView1.getColumns().addAll(isbnCol,titleCol,checkDateCol,dueCol,overCol,fineCol,paidDateCol);

	}

	@FXML
	public void searchRecord() throws IOException{

		isbnCol.setCellValueFactory(new PropertyValueFactory<>("bookISBN"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
		checkDateCol.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
		dueCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		overCol.setCellValueFactory(new PropertyValueFactory<>("BookOverDue"));
		fineCol.setCellValueFactory(new PropertyValueFactory<>("IsFine"));
		paidDateCol.setCellValueFactory(new PropertyValueFactory<>("MemberName"));

		tableView1.getColumns().clear();
		tableView1.setItems(getRecord());
		tableView1.getColumns().addAll(isbnCol,titleCol,checkDateCol,dueCol,overCol,fineCol,paidDateCol);


		if(!checkOutSerach){
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("No Result Found");
			alert.setContentText("There is no such book called " + " " +  search.getText() + " Go to Main Window?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				// Clear all text Fields
			} else {
				alert.close();
			}
		}
	}

	@FXML
	public void printRecords(){
		Printer printer = Printer.getDefaultPrinter();
	    PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
	    double scaleX = pageLayout.getPrintableWidth() / tableView1.getBoundsInParent().getWidth()-0.1;
	    double scaleY = pageLayout.getPrintableHeight() / tableView1.getBoundsInParent().getHeight();
	    tableView1.getTransforms().add(new Scale(scaleX, scaleY));

	    PrinterJob job = PrinterJob.createPrinterJob();
	    if (job != null) {
	        boolean successPrintDialog = true;
	        if(successPrintDialog){
	            boolean success = job.printPage(pageLayout,tableView1);
	            if (success) {
	                job.endJob();
	            }
	        }
	    }
	}
	@FXML
	void printOverDueCalled() {
		ObservableList<CheckoutRecordEntry> records = getRecords();
		ObservableList<CheckoutRecordEntry> filterRecords = FXCollections.observableArrayList();
		
		for(CheckoutRecordEntry c: records) {
			if(c.getBookOverDue() < 0) {
				filterRecords.add(c);
			}
			
		}
		
		isbnCol.setCellValueFactory(new PropertyValueFactory<>("bookISBN"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
		checkDateCol.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
		dueCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		overCol.setCellValueFactory(new PropertyValueFactory<>("BookOverDue"));
		fineCol.setCellValueFactory(new PropertyValueFactory<>("IsFine"));
		paidDateCol.setCellValueFactory(new PropertyValueFactory<>("MemberName"));

		tableView1.getColumns().clear();
		tableView1.setItems(filterRecords);
		tableView1.getColumns().addAll(isbnCol,titleCol,checkDateCol,dueCol,overCol,fineCol,paidDateCol);
		if(!filterRecords.isEmpty()) printRecords();
			
	}
	//----------------------------------------------------------------------
	private void clearAddMemberFields(){

		 firstName.setText(null);
		 lastName.setText(null);
		 street.setText(null);
		 city.setText(null);
		 state.setText(null);
		 zip.setText(null);
		 phone.setText(null);
		 passForAddStaff.setText(null);
		 lastName2.setText(null);
		 ad.setSelected(false);
		 lib.setSelected(false);
	}
	private void clearAddBookFields(){
		 titleField.setText(null);
		 fnameField.setText(null);
		 lnameField.setText(null);
		 isbnField.setText(null);
		 streetField.setText(null);
		 cityField.setText(null);
		 borrowLimitField.setText(null);
		 stateField.setText(null);
		 zipField.setText(null);
		 copyNumField.setText(null);
		 phoneField.setText(null);
		 availableCheckBox.setText(null);
	}
	private void clearEditMemberFields(){
		 editFirstName.setText(null);
		 editLastName.setText(null);
		 editState.setText(null);
		 editZip.setText(null);
		 editPhone.setText(null);
		 editCity.setText(null);
		 editStreet.setText(null);


	}

	private void ClearUserMemberFields(){
		 memName.setText(null);
		 memLName.setText(null);
		 memMembID.setText(null);
		 memcity.setText(null);
		 memState.setText(null);
		 memeZip.setText(null);
		 memPhone.setText(null);
		 memStreet.setText(null);

	}
 /////////////////////////////////////////////////end Kira/////////////////////////////////

}
