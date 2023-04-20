<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List,model.TaxFilers" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CSS using CDN -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<%

   List<TaxFilers>  taxFilers = (List)session.getAttribute("taxFilers_list");
  
%>

<table  class="table table-bordered table-hover  text-center mt-5">

<tr>
<th>Filer ID</th>
<th>Name</th>
<th>Contact</th>
<th>AnnualIncome</th>
<th>Expenses</th>
<th>TaxYear</th>
<th>DateFiled</th>

<th>Edit</th>
<th>Delete</th>
</tr>


<%

  for(int i=0;i<taxFilers.size();i++){
	  
	  
	  out.print("<tr>");
	  
	  out.print("<td>"+taxFilers.get(i).getFilerID()+"</td>");
	  
	  out.print("<td>"+taxFilers.get(i).getName()+"</td>");
	  
	  out.print("<td>"+taxFilers.get(i).getContact()+"</td>");
	  
	  out.print("<td>"+taxFilers.get(i).getAnnualIncome()+"</td>");
	  
	  out.print("<td>"+taxFilers.get(i).getExpenses()+"</td>");
	  
	  out.print("<td>"+taxFilers.get(i).getTaxYear()+"</td>");
	  
	  out.print("<td>"+taxFilers.get(i).getDateFiled()+"</td>");
	  
	  
	  out.print("<td> <a class='btn btn-primary' href='edit?c_id="+taxFilers.get(i).getFilerID() +"'' role='button'>Edit....</a> </td>");
	  out.print("<td> <a class='btn btn-danger' href='delete?c_id="+taxFilers.get(i).getFilerID()+"'' role='button'>Delete</a> </td>");
	  out.print("</tr>");
  }

%>

</table>


<div class="d-flex justify-content-center mt-3">
  <a class="btn btn-primary" href="insert.jsp" role="button">Insert Employee Record</a>
</div>
</body>
</html>
