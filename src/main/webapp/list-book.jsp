
<%@page import="model.Author"%>
<%@page import="model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List book</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
        crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/main.css">
    
    <%
            ArrayList<Book> books=(ArrayList<Book>) request.getAttribute("books");
     %>
        <script>
            function doUpdate(id){
                window.location.href="Update?id=" +id;
            }
            
            function doDelete(id){
                var c= confirm("Are you sure");
                if(c){
                    window.location.href="Delete?id=" +id;
                }
            }
        </script>
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
                    <h1 class="mt-4" id="h1">List Book</h1>
                    <hr>
                    <div class="wrapper-view-content mt-3" id="wrapper-view-content">
                        
                        <div class="wrapper-table px-3">
                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <td>Book ID</td>
                                        <td>Book Title</td>
                                        <td>Price</td>
                                        <td>Page Count</td>
                                        <td>Date published</td>
                                        <td>Author Name</td>
                                        <td>Active</td>
                                        <td colspan="2"></td>
                                    </tr>
                                </thead>
                                <tbody>
                                <% for(Book b: books){
                                %>
                                    <tr>
                                        <td><%=b.getBook_ID() %></td>
                                        <td><%=b.getTitle() %></td>
                                        <td><%=b.getPrice() %></td>
                                        <td><%=b.getPageCount() %></td>
                                        <td><%=b.getDatepublished() %></td>
                                        <td><%=b.getAuth().getAuthor_Name() %></td>
                                        <td><%=b.isStatus() %></td>
                                        <td><input type="button" onclick="doUpdate(<%=b.getBook_ID() %>)" value="update" /></td>
                                        <td><input type="button" onclick="doDelete(<%=b.getBook_ID() %>)" value="delete" /></td>
                                    </tr>
                                    <%} %>
                                </tbody>
                            </table>
                        </div>
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