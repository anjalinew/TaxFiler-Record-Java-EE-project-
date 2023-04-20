<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <h1 class="mt-4">Insert Record</h1>
    <%
		// check if an error message is set in the request attribute
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (errorMessage != null) {
			out.println("<p style=\"color:red;\">" + errorMessage + "</p>");
		}
	%>
    <form action="insert" method="post">
        <div class="row mt-4">
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="FilerID" style="font-weight: bold;" class="form-label">Filer ID:</label>
                    <input type="number" name="FilerID" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="Name" style="font-weight: bold;" class="form-label">Name:</label>
                    <input type="text" name="Name" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="Contact" style="font-weight: bold;" class="form-label">Contact:</label>
                    <input type="text" name="Contact" class="form-control" required>
                </div>
            </div>
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="AnnualIncome" style="font-weight: bold;" class="form-label">Annual Income:</label>
                    <input type="number" name="AnnualIncome" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="Expenses" style="font-weight: bold;" class="form-label">Expenses:</label>
                    <input type="number" name="Expenses" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="TaxYear" style="font-weight: bold;" class="form-label">Tax Year:</label>
                    <input type="number" name="TaxYear" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="DateFiled" style="font-weight: bold;" class="form-label">Date Filed:</label>
                    <input type="date" name="DateFiled" class="form-control" required>
                </div>
            </div>
        </div>
        <div class="mt-4">
            <input type="submit" value="Insert" class="btn btn-primary">
            <a href="index.jsp" class="btn btn-secondary">Back to Home</a>
        </div>
    </form>
</div>
</body>
</html>
