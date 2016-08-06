package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dbConnection.DbConnection;
import models.Account;

public class AccountService {

	private static Connection connection;

	public AccountService() {

		connection = DbConnection.getConnection();
	}

	public void addUser(Account acc) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into useraccount(username,password,fullname,role,address,email) values (?,?,?,?,?,? )");
			preparedStatement.setString(1, acc.getUsername());
			preparedStatement.setString(2, acc.getPassword());
			preparedStatement.setString(3, acc.getFullname());
			preparedStatement.setString(4, acc.getRole());
			preparedStatement.setString(5, acc.getAddress());
			preparedStatement.setString(6, acc.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Account> getAllUsers() {
		List<Account> users = new ArrayList<Account>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select fullname,username,role,address,email from useraccount");
			while (rs.next()) {
				Account user = new Account();
				user.setFullname(rs.getString("fullname"));
				user.setUsername(rs.getString("username"));
				user.setRole(rs.getString("role"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	// get a user with his username
	public List<Account> getAccountById(String username) {
		List<Account> ls = new ArrayList<Account>();
		String sql = "select * from useraccount where username = '" + username+"'";
		try {
			Statement stetment = connection.createStatement();
			ResultSet rs = stetment.executeQuery(sql);
			while (rs.next()) {
				Account n = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				ls.add(n);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ls;
	}

	public void edit(String password, String role, String fullname, String address, String email,String username) {
		try {
			String sql = "update useraccount SET  password = ?, role = ?, fullname = ?, email =?, address = ?"
					+ " where username = '"+username+"'";
			PreparedStatement ps = connection.prepareStatement(sql);

		
			ps.setString(1, password);
			ps.setString(2, role);
			ps.setString(3, fullname);
			ps.setString(4, address);
			ps.setString(5, email);

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void delete(String uname) {
		try {
			String sql = "delete from useraccount where username = '"+uname+"'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

//	public static void main(String[] args) {
//		AccountService acc = new AccountService();
//		System.out.println(acc.getAllUsers());
//	}

}
