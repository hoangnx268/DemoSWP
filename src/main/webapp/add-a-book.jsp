<%@page import="model.Author"%>
<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/main.css">
    <%
            ArrayList<Author> author=(ArrayList<Author>) request.getAttribute("author");
     %>
</head>

<body>
    <div class="container-fluid p-0">
        <nav class="navbar bg-light navbar-light d-flex justify-content-center p-0">
            <a href="#" class="navbar-brand px-3 text-primary">BOOK MANAGEMENT WEB APPLICATION</a>
            
        </nav>

        <div class="main row">
            <div class="col-3 p-0 bg-light " id="menu">
                <ul class="list-group d-flex flex-column mt-5">
                    <li class="list-group-item px-3 btn btn-light text-center text-primary " 
                        id="btn-form-content">
                        
                        <a href="Create" >Add a book</a>
                    </li>

                    <li class="list-group-item px-3 btn btn-light text-center text-primary " 
                        id="btn-view-content">
                        
                        <a href="List" >List book</a>
                    </li>
                    
                </ul>
            </div>
            <div class="col-9" id="content-view">
                

                <div class="container">
                    <h1 class="mt-4" id="h1">Create Books</h1>
                    <hr>
                    <div class="wrapper-form-content mt-3" id="wrapper-form-content">
                        <form class="px-3" action="Create" method="post">
                            <div class="form-group mb-3">
                                <label for="title" class="mb-1">Book Title: </label>
                                <input type="text" size="50" id="title" name="title" class="form-control form-control-sm">
                            </div>
                            <div class="form-group mb-3">
                                <label for="pageCount" class="mb-1">Page Count: </label>
                                <input type="text" id="pageCount" name="pageCount" class="form-control form-control-sm">
                            </div>
                            <div class="form-group mb-3">
                                <label for="price" class="mb-1">Price: </label>
                                <input type="number" id="price" name="price" class="form-control form-control-sm">
                            </div>
                            <div class="form-group mb-3">
                                <label for="datePublished" class="mb-1">Date published: </label>
                                <input type="date" id="datePublished" name="datePublished" class="form-control form-control-sm">
                            </div>
                            <div class="form-group mb-3">
                                <label for="authorName" class="mb-1">Author Name: </label>
                                <select class="form-control" name="Author_Id" id="auth">
                                <% for(Author a: author){
                                %>
                                	<option value="<%=a.getAuthor_Id() %>"><%=a.getAuthor_Name() %></option>
                                	
                                <%} %>
                                
                                </select>
                                
                            </div>
                            
                            <div class="form-group mb-3">
                                <label class="form-label ">Status:</label><br/>
                                <label class="form-check-label">
                                    <input type="radio"  name="status" value="active" checked>Active
                                    <input type="radio"  name="status" value="inactive">Inactive
                                </label>
                            </div>
                            <div class="btn-group mb-3">
                                <input type="submit" class="btn btn-light btn-sm border mr-2" value="Create"></input>                                
                            </div>
                        </form>
                    </div>
                </div>


            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.5.1.js" 
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous">
    </script>
    
    
    <script src="../js/main.js"></script>
</body>

</html>