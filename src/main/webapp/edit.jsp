<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.TaxFilers" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Tax Filer</title>
<!-- Adding Bootstrap CSS using CDN -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%  
  // get the current tax filer from session
  TaxFilers taxfilers = (TaxFilers)session.getAttribute("taxfiler_from_db");
  
  // set the current id of the tax filer as a session attribute 
  // we will be using this id as old Id of tax filer in update method
  session.setAttribute("c_id", taxfilers.getFilerID());
%>

<div class="container">
  <h1 class="mb-5">Update Tax Filer</h1>
  <form action="update">
    <div class="mb-3">
      <label for="id"  style="font-weight: bold;" class="form-label">Filer ID</label>
      <input type="text" class="form-control" id="id" name="c_id" value="<%=taxfilers.getFilerID()%>">
    </div>
    <div class="mb-3">
      <label for="Name" style="font-weight: bold;" class="form-label">Name</label>
      <input type="text" class="form-control" id="Name" name="Name" value="<%=taxfilers.getName() %>">
    </div>
    <div class="mb-3">
      <label for="Contact" style="font-weight: bold;" class="form-label">Contact</label>
      <input type="text" class="form-control" id="Contact" name="Contact" value="<%=taxfilers.getContact() %>">
    </div>
    <div class="mb-3">
      <label for="AnnualIncome" style="font-weight: bold;" class="form-label">Annual Income</label>
      <input type="number" class="form-control" id="AnnualIncome" name="AnnualIncome" value="<%=taxfilers.getAnnualIncome() %>">
    </div>
    <div class="mb-3">
      <label for="Expenses" style="font-weight: bold;" class="form-label">Expenses</label>
      <input type="number" class="form-control" id="Expenses" name="Expenses" value="<%=taxfilers.getExpenses() %>">
    </div>
    <div class="mb-3">
      <label for="TaxYear" style="font-weight: bold;" class="form-label">Tax Year</label>
      <input type="number" class="form-control" id="TaxYear" name="TaxYear" value="<%=taxfilers.getTaxYear() %>">
    </div>
    <div class="mb-3">
      <label for="DateFiled" style="font-weight: bold;" class="form-label">Date Filed</label>
      <input type="date" class="form-control" id="DateFiled" name="DateFiled" value="<%=taxfilers.getDateFiled() %>">
    </div>
    <div class="mb-3">
  <button type="submit" class="btn btn-primary">Submit</button> 
    </div>
  </form>
</div>
</body>
</html>