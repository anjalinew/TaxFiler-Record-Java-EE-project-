<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- Custom CSS -->
<style>
    body {
        background-color: #f8f9fa;
    }
    
    .jumbotron {
        background-color: cadetblue;
        color: white;
        padding: 2rem 1rem;
        margin-bottom: 2rem;
        border-radius: 0.3rem;
    }
    
    .jumbotron h1 {
        font-size: 3rem;
        font-weight: 400;
    }
    
    .jumbotron p {
        font-size: 1.5rem;
    }
    
    .btn-primary {
        background-color: #007bff;
        border-color: #007bff;
        font-size: 2rem;
        padding: 1rem 2rem;
        border-radius: 2rem;
    }
    
    .btn-primary:hover {
        background-color: #0069d9;
        border-color: #0062cc;
    }
    
    .btn-secondary {
        background-color: #6c757d;
        border-color: #6c757d;
        font-size: 2rem;
        padding: 1rem 2rem;
        border-radius: 2rem;
    }
    
    .btn-secondary:hover {
        background-color: #5a6268;
        border-color: #545b62;
    }
</style>
<title>Welcome to Tax Filing</title>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1>Welcome to Tax Filing</h1>
        <p>Use the buttons below to access the different features of the system.</p>
    </div>
    <div class="row mt-4">
        <div class="col-md-6">
            <a href="display" class="btn btn-primary">Display Client Data</a><br><br>
        </div>
        
        <div class="col-md-6">
            <a href="insert.jsp" class="btn btn-secondary">Insert Client Data</a>
        </div>
    </div>
</div>

<!-- Bootstrap JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-v4zgjKkBIh1fa0BYjkRWJG61jKMaN9MUg0E/txU6G4B6usQjJT0N/NTyQmW3aE6+" crossorigin="anonymous"></script>
</body>
</html>
