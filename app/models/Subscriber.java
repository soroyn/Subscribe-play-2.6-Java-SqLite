package models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import play.data.validation.Constraints;
import java.sql.*;

public class Subscriber {
	
	static List<Subscriber> Subscribers;
	
	@Constraints.Required
	public String amail;
	@Constraints.Required
	public String fname;
	public String lname;
	
	public Subscriber () {}
	public Subscriber (String fname, String lname, String amail) {
		this.fname= fname;
		this.lname = lname;
		this.amail= amail;
	}
	
	public void save() {

		  Connection c = null;
	      Statement stmt = null;
	      try {
		         Class.forName("org.sqlite.JDBC");
		         c = DriverManager.getConnection("jdbc:sqlite:subscribers.db");
		         c.setAutoCommit(false);
		         System.out.println("Opened database successfully");

		         stmt = c.createStatement();
		         String sql = "INSERT INTO SUBSCRIBERS (FNAME, LNAME, EMAIL) " +
		                        "VALUES ('"+fname+"', '"+lname+"', '"+amail+"' );"; 
		         stmt.executeUpdate(sql);

		         stmt.close();
		         c.commit();
		         c.close();
		      } catch ( Exception r ) {
		         System.err.println( r.getClass().getName() + ": " + r.getMessage() );
		         System.exit(0);
		      }
		  }
	}
	

