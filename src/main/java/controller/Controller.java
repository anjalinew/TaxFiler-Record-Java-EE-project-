package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaxFilersDao;
import model.TaxFilers;

@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    TaxFilersDao  dao = new TaxFilersDao();
    TaxFilers emp = new TaxFilers();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		String url = request.getServletPath();
		
		switch(url) {
		
		case "/insert":{
			
			
			insert(request, response);
			out.print("<h1 style='color:green; text-align:center;'>From Insert Page!!!</h1>");
			
			break ;
		}
		
       case "/edit":{
			
    	    edit(request, response);
			out.print("<h1 style='color:green; text-align:center;'>From Edit Page!!!</h1>");
		     break ;
		}
		case "/update":{
			update(request, response);
			out.print("<h1 style='color:green; text-align:center;'>From Update Page!!!</h1>");
		     break ;
		}
		case "/display":{
			System.out.println("In Display");
			display(request, response);
			out.print("<h1 style='color:green; text-align:center;'>From Display Page!!!</h1>");
			break ;
		}
		
		case "/delete":{
			
			delete(request, response);
			out.print("<h1 style='color:green; text-align:center;'>From Delete Page!!!</h1>");
		    break ;
		}
		
		default:{
			
			out.print("<h1 style='color:green; text-align:center;'>Please Use a Valid Url !!!</h1>");
		}
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		List<TaxFilers>  taxFilers = new ArrayList<>();
		
		System.out.println(taxFilers);
		
		taxFilers = dao.read();
		
		System.out.println(taxFilers);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("taxFilers_list", taxFilers);
		
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		
		rd.forward(request, response);
		
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub

	    PrintWriter out = response.getWriter();

	    response.setContentType("text/html");

	    int FilerID = Integer.parseInt(request.getParameter("FilerID"));

	    // check if the filer ID already exists in the database
	    if (dao.checkIfFilerIdExists(FilerID)) {
	        // set an error message in the request attribute
	        request.setAttribute("errorMessage", "Filer ID already exists. Please try again with a different ID.");

	        // forward the request back to the insert page
	        RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
	        rd.forward(request, response);
	        return;
	    }

	    String Name = request.getParameter("Name");

	    String Contact = request.getParameter("Contact");

	    double AnnualIncome = Double.parseDouble(request.getParameter("AnnualIncome"));

	    double Expenses = Double.parseDouble(request.getParameter("Expenses"));

	    int TaxYear = Integer.parseInt(request.getParameter("TaxYear"));

	    Date DateFiled = Date.valueOf(request.getParameter("DateFiled"));

	    TaxFilers taxFilers_to_be_inserted = new TaxFilers(FilerID, Name, Contact, AnnualIncome, Expenses, TaxYear,
	            DateFiled);

	    System.out.println(taxFilers_to_be_inserted);
	    dao.insert(taxFilers_to_be_inserted, request);

	    display(request, response);

	}

	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		
		// get the id of Taxfiler coming as a request parameter
		// from the use of edit button in edit.jsp
		
		int id_to_edit_rec = Integer.parseInt(request.getParameter("c_id"));
		 
		// lets call the TaxFilersDao calss method to get the taxfiler
		// Record using this id_to_edit_rec
		
		TaxFilers taxfiler_to_edit = dao.getRecById(id_to_edit_rec);
		
		out.print(taxfiler_to_edit);
		// Set this Employee as a Session Attribute to send it 
		// to edit.jsp
		
		HttpSession session = request.getSession();
		
		session.setAttribute("taxfiler_from_db", taxfiler_to_edit);
		
		RequestDispatcher  rd = request.getRequestDispatcher("edit.jsp");
		
		rd.forward(request, response);
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		int FilerID= Integer.parseInt(request.getParameter("c_id"));
		
		String Name = request.getParameter("Name");
		
		String Contact = request.getParameter("Contact");
		
		double AnnualIncome = Double.parseDouble(request.getParameter("AnnualIncome"));
		
		double  Expenses = Double.parseDouble(request.getParameter("Expenses"));
		
		int   TaxYear = Integer.parseInt(request.getParameter("TaxYear"));; 
		
		Date  DateFiled = Date.valueOf(request.getParameter("DateFiled"));
		
		TaxFilers updated_taxfiler = new TaxFilers(FilerID,Name,Contact,AnnualIncome,Expenses,TaxYear,DateFiled);		
		
		HttpSession session = request.getSession();
	    
	    int old_id = (int)session.getAttribute("c_id");
	    
	    // call the TaxfilersDao method 
	    // updateById(int curr_id ,Employee updated_emp) 
	    
	    dao.updateById(old_id, updated_taxfiler);
	    
	    // Now call the display method to display the updated taxfiler
	    // in display.jsp
	    
	    display(request, response);
	}
	
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		int id_to_delete_rec = Integer.parseInt(request.getParameter("c_id"));
		
		// call the TaxfilersDao class delete(int id_to_deleteRec) method and
		// pass id_to_delete_rec as argument
		
		dao.delete(id_to_delete_rec);
		
		display(request, response);
		
	}
}
