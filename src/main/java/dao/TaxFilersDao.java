package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.TaxFilers;

public class TaxFilersDao {
public Connection getConnection() {
		
		System.out.println("In connection method");
		
		Connection con = null;

		// Write the Connection parameters

		String url = "jdbc:mysql://localhost:3306/filersrecord";

		String user = "root";

		String pwd = "";

		// Register the Driver

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Connection Ho gia Hai / Connection Successfull");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}
	
public List<TaxFilers> read() {

	List<TaxFilers> taxFilers = new ArrayList<>();

	String sql = "select * from taxfilers";
	System.out.println("In dao read method");
	// connect to database using getConnection Method just defined above
	
	Connection con = getConnection();
	System.out.println("after connection");
	// For Select query we use Statement	

	try {

		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			TaxFilers taxFilers_from_resultset = new TaxFilers(rs.getInt("filerID"), rs.getString("name"),
					rs.getString("contact"), rs.getDouble("annualIncome"), rs.getDouble("expenses"),rs.getInt("taxYear"), rs.getDate("dateFiled"));
			System.out.println(taxFilers_from_resultset);
			taxFilers.add(taxFilers_from_resultset);
		}

		System.out.println(taxFilers);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return taxFilers;

}

public String insert(TaxFilers taxFilers_to_be_inserted, HttpServletRequest request) {
    String result = "";
    String sql = "insert into taxfilers (FilerID, Name, Contact, AnnualIncome, Expenses, TaxYear, DateFiled) values (?,?,?,?,?,?,?)";
    Connection con = getConnection();
    try {
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, taxFilers_to_be_inserted.getFilerID());
        pstmt.setString(2, taxFilers_to_be_inserted.getName());
        pstmt.setString(3, taxFilers_to_be_inserted.getContact());
        pstmt.setDouble(4, taxFilers_to_be_inserted.getAnnualIncome());
        pstmt.setDouble(5, taxFilers_to_be_inserted.getExpenses());
        pstmt.setInt(6, taxFilers_to_be_inserted.getTaxYear());
        pstmt.setDate(7, taxFilers_to_be_inserted.getDateFiled());
        int status = pstmt.executeUpdate();
        if (status > 0) {
            System.out.println("Record Added Successfully!");
            result = "display.jsp";
        } else {
            System.out.println("Some Error Occurred. Please Try Again!");
            result = "insert.jsp";
            request.setAttribute("errorMessage", "User with this ID already exists. Please try again with a different ID.");
        }
    } catch (SQLIntegrityConstraintViolationException e) {
        System.out.println("Duplicate Key Error: User with this ID already exists. Please Try Again!");
        result = "insert.jsp";
        request.setAttribute("errorMessage", "User with this ID already exists. Please try again with a different ID.");
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return result;
}

public boolean checkIfFilerIdExists(int filerID) {
    boolean exists = false;
    String sql = "SELECT FilerID FROM taxfilers WHERE FilerID=?";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, filerID);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            exists = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return exists;
}

public TaxFilers getRecById(int id_to_getRecord) {
	
	TaxFilers taxFilers = null ;
	
	Connection con = getConnection();
	
	String sql = "select * from taxfilers where filerID  = ?";
	
	try {
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, id_to_getRecord);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			taxFilers = new TaxFilers(rs.getInt("filerID"), rs.getString("name"),
					rs.getString("contact"), rs.getDouble("annualIncome"), rs.getDouble("expenses"),rs.getInt("taxYear"), rs.getDate("dateFiled"));
		}
		
	   System.out.println(taxFilers);
	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return taxFilers;
	
}

public void updateById(int curr_id ,TaxFilers updated_taxfiler) {
	
	Connection con = getConnection();
	
	String sql = "update taxfilers set FilerID=? ,Name=? ,Contact=?,AnnualIncome=?,Expenses=?,TaxYear=?, DateFiled= ?"
			+ " where FilerID= ?";
	
    try {
		
    	PreparedStatement pstmt = con.prepareStatement(sql);
    	
    	pstmt.setInt(1,updated_taxfiler.getFilerID());
	
    	pstmt.setString(2, updated_taxfiler.getName());
    	
    	pstmt.setString(3, updated_taxfiler.getContact());
    	
    	pstmt.setDouble(4, updated_taxfiler.getAnnualIncome());
    	
    	pstmt.setDouble(5, updated_taxfiler.getExpenses());
    	
    	pstmt.setInt(6,updated_taxfiler.getTaxYear());
    	
    	pstmt.setDate(7,updated_taxfiler.getDateFiled());
    
        pstmt.setInt(8, curr_id);
        
        int status = pstmt.executeUpdate();
        
        if(status>0) {
        	
        	System.out.println("Record Updated Successfully");
        	read();
        }
        else {
        	System.out.println("Try Again Please ,there is an error!!!");
        }
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
}

public void delete(int id_to_deleteRec) {
	
	Connection con = getConnection();
	
	String sql = "delete from taxfilers where FilerID = ?";
	
	try {
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, id_to_deleteRec);
	
	   int status = pstmt.executeUpdate();
	
	   if(status>0) {
		   
		   System.out.println("Record Deleted Successfully");
		   read();
	   }
	   else {
		   System.out.println("Tray again please!!!");
	   }
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


}
