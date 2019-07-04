package controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import dataaccess.DataAccessFacade;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import person.*;



public class MainController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2625218126016555788L;

	static List<Staff> staffUsers = DataAccessFacade.readStaff();

	//Tabs
	@FXML protected TabPane tabPane;
	@FXML protected Tab CheckOutTab;
	@FXML protected Tab CheckListTab;
	@FXML protected Tab addBookTab;
	@FXML protected Tab addMemberTab;
	@FXML protected Tab editMemberTab;
	@FXML protected Tab addStaffTab;
	
	//Labels
	@FXML protected Label username;
	@FXML protected Label password;
	@FXML protected Label lms;
	@FXML protected Label g7;
	@FXML protected Label fnameLabel;
	@FXML protected Label lnameLabel;
	@FXML protected Label titleLabel;


	//TextFields
	@FXML protected TextField user;
	@FXML protected TextField pass;

	//buttons
	@FXML protected Button loginBtn;
	@FXML protected Button logoutBtn;
	@FXML protected TextField firstName;
	@FXML protected Button addMemBtn;
	@FXML protected Label selectBookEmpty;
	
	/////////////////////////////TABLE VIEW////////////////////////
	@FXML protected TableView<?> tableView1;
	@FXML protected TextField searchField1;
	@FXML protected static TableColumn<CheckoutRecordEntry, String> isbnCol;
	
	@FXML
	public void searchByID() {
		if(searchField1.getText().isEmpty()) Services.printAllEntryToTable(tableView1);
		//else 
		//	Services.searchByID(searchField1.getText());
	}
	
	//ListView on CheckOut
		@FXML protected ListView<Book> bookListView;
		@FXML protected ListView<LibraryMember> memListView;
		@FXML void checkOutInit() {
			printListMembersOnListView();
			printListBooksOnListView();
		}
		
		void printListMembersOnListView(){
			memListView.getItems().clear();
			//memList.clear();
			
			List<LibraryMember> listOfLibMember = DataAccessFacade.readUser();
			List<LibraryMember> memList = new ArrayList<LibraryMember>();		
			for(LibraryMember l: listOfLibMember) {			
				//to do process here
				memList.add(l);				
			}
			memListView.setItems(FXCollections.observableArrayList(memList));
		
		}
		void printListBooksOnListView() {
			bookListView.getItems().clear();
			List<Book> lb = DataAccessFacade.readBook();
			List<Book> bookList = new ArrayList<Book>();
			
			bookList.clear();
			
			for(Book b: lb) {
				if(b.isAvailable() && b.getNumCop() > 0)
					bookList.add(b);
			}
			
			if(bookList.size() != 0)
				bookListView.setItems(FXCollections.observableArrayList(bookList));
			else
				selectBookEmpty.setText("no more books!");
			
		}
		
		@FXML 
		public void checkOutAction() { //checkOutButton clicked
			if(bookListView.getSelectionModel().isEmpty()){
				JOptionPane.showMessageDialog(null, "Select a book from list");
			}else if(memListView.getSelectionModel().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Select a member from list");
			}else {
				
				Book selectedBook = bookListView.getSelectionModel().getSelectedItem();
				LibraryMember selectedMember = memListView.getSelectionModel().getSelectedItem();
				
				Librarian librarian = new Librarian(null, null, null, null, null, Role.LIBRARIAN);
				int returnCode = librarian.checkout(selectedBook, selectedMember);
				if(returnCode == -1) {
					JOptionPane.showMessageDialog(null, "Check out did not proceeded!");
					return;
					} else if(returnCode == 0){
						JOptionPane.showMessageDialog(null, "No copies!");
						return;
					}
			}
				
			
//			
			checkOutInit();
			
		}

	@FXML
	public void login() {

		String id = user.getText();
		String password = pass.getText();

		if(id.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Username/Password empty!");
			return;

		}
		Role roleStaff = null;
		for(Staff s: staffUsers) {
			roleStaff = s.isAvailable(id, password);
			if(roleStaff != null)  break;
		}

		if(roleStaff != null) {
			hideMainMenu();
			fnameLabel.setText("Logged as: " + id.toUpperCase());
		}
		else {
			JOptionPane.showMessageDialog(null, "Username/Password wrong!");
			return;
		}
			

		switch(roleStaff) {
		case ADMIN:
			tabPane.setVisible(true);
			lnameLabel.setText("Role: Administrator");
			CheckOutTab.setDisable(true);
			CheckListTab.setDisable(true);
			addBookTab.setDisable(false);
			addMemberTab.setDisable(false);
			addStaffTab.setDisable(false);
			editMemberTab.setDisable(false);

			break;
		case LIBRARIAN:
			lnameLabel.setText("Role: Librarian");
			CheckOutTab.setDisable(false);
			CheckListTab.setDisable(false);
			addBookTab.setDisable(true);
			addMemberTab.setDisable(true);
			addStaffTab.setDisable(true);
			editMemberTab.setDisable(true);

			break;
		case BOTH:
			lnameLabel.setText("Role: Super Administrator");
			CheckOutTab.setDisable(false);
			CheckListTab.setDisable(false);
			addBookTab.setDisable(false);
			addMemberTab.setDisable(false);
			addStaffTab.setDisable(false);
			editMemberTab.setDisable(false);
			break;
		default :
			JOptionPane.showMessageDialog(null, "Username/Password wrong!");

		}


	}


	public void logout() throws IOException {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Log out");
		alert.setContentText("Are you sure to logout?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			showMainMenu();
		} else {
			alert.close();
		}
	}


	public void hideMainMenu() {
		lms.setVisible(false);
		g7.setVisible(false);
		logoutBtn.setVisible(true);
		loginBtn.setVisible(false);
		username.setVisible(false);
		password.setVisible(false);
		user.setVisible(false);
		pass.setVisible(false);

		tabPane.setVisible(true);

		titleLabel.setText("Library Management System G7");
	}

	public void showMainMenu() {
		lms.setVisible(true);
		g7.setVisible(true);
		loginBtn.setVisible(true);

		username.setVisible(true);
		password.setVisible(true);
		user.setVisible(true);
		pass.setVisible(true);
		logoutBtn.setVisible(false);
		tabPane.setVisible(false);

		fnameLabel.setText(" ");
		lnameLabel.setText(" ");
		titleLabel.setText(" ");


	}
}
