package com.hdfc.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Logger;

import com.hdfc.datasource.SQLConnectionFactory;
import com.hdfc.model.Account;
import com.hdfc.respository.AccountRepository;

public class JdbcAccountRepository implements AccountRepository{
	
	private static final Logger LOGGER=Logger.getLogger("mts");
	
	public Optional<Account> loadAccountNumber(String number){
		Connection connection=null;
		try {
			connection=SQLConnectionFactory.getConenction();
			
			// step-3 jdbc statement with sql query
			
			String sql="select * from accounts where acc_number=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, number);
			
			// step-4 execute jdbc statement
			
			ResultSet resultSet=preparedStatement.executeQuery();
			 
			// step-5 process result set
			if(resultSet.next()) {
				Account account= new Account();
				account.setAccount(resultSet.getString("acc_number"));
				account.setBalance(resultSet.getDouble("balance"));
				return Optional.of(account);
			}
			
		}catch(SQLException exception) {
			System.out.println(exception.getMessage());
		}
		finally {
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return Optional.empty();
	}

	public void updateAccount(Account account) {
		Connection connection=null;
		try {
			connection =SQLConnectionFactory.getConenction();
			
			//  step-3 jdbc statements with sql query
			String sql="update accounts set balance=? where acc_number=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setDouble(1, account.getBalance());
			preparedStatement.setString(2, account.getAccountNumber());
			
			// step-4 execute jdbc statement
			int rowAffection=preparedStatement.executeUpdate();
			
			if(rowAffection==1) {
				System.out.println("account updated with new data");
			}
			
		}catch(SQLException exception) {
			System.out.println(exception.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
