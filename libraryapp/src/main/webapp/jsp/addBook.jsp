<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Book - Library Management</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&family=Playfair+Display:wght@400;500;600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="assets/css/common.css">
</head>
<body>
<%@ include file= "includes/header.jsp" %>

<div class="container-fluid">
<div class="row">
    <!-- Sidebar -->
    <%@ include file= "includes/sidebar.jsp" %>

    <!-- Main content -->
    <main class="col-md-9 ms-sm-auto col-lg-10">
        <div class="page-header">
            <h1 class="h2"><i class="bi bi-book-fill me-2"></i>Add New Book</h1>
        </div>

        <c:if test="${not empty errorMessage}">
		    <div class="alert alert-danger alert-dismissible fade show" role="alert">
		    		<c:out value="${errorMessage}"/>
		    		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		    </div>
        </c:if>

        <div class="form-container">
            <form action="BookController" method="post">
                <input type="hidden" name="action" value="addbook">

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="bookTitle" name="bookTitle" placeholder="Book Title">
                            <label for="bookTitle"><i class="bi bi-book me-2"></i>Book Title</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="author" name="author" placeholder="Author">
                            <label for="author"><i class="bi bi-person me-2"></i>Author</label>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="isbn" name="isbn" placeholder="ISBN">
                            <label for="isbn"><i class="bi bi-hash me-2"></i>ISBN Number</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <select class="form-select" id="category" name="category">
                                <option selected disabled value="">Select category</option>
                                <option value="fiction">Fiction</option>
                                <option value="non-fiction">Non-fiction</option>
                                <option value="science">Science</option>
                                <option value="technology">Technology</option>
                                <option value="history">History</option>
                                <option value="biography">Biography</option>
                                <option value="mystery">Mystery</option>
                                <option value="romance">Romance</option>
                            </select>
                            <label for="category"><i class="bi bi-collection me-2"></i>Category</label>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="publisher" name="publisher" placeholder="Publisher">
                            <label for="publisher"><i class="bi bi-building me-2"></i>Publisher</label>
                        </div>
                    </div>
                    <!-- <div class="col-md-6">
                        <div class="form-floating">
                            <input type="date" class="form-control" id="publishDate" placeholder="Publication Date">
                            <label for="publishDate"><i class="bi bi-calendar me-2"></i>Publication Date</label>
                        </div>
                    </div> -->
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="number" class="form-control" id="availableCopies" name="availableCopies" placeholder="Pages">
                            <label for="pages"><i class="bi bi-file-text me-2"></i>Available Copies</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="number" class="form-control" id="numberOfcopies" name="numberOfcopies" placeholder="Copies" min="1" value="1">
                            <label for="copies"><i class="bi bi-stack me-2"></i>Number of Copies</label>
                        </div>
                    </div>
                </div>

                <!-- <div class="form-floating">
                    <textarea class="form-control" id="description" placeholder="Description"></textarea>
                    <label for="description"><i class="bi bi-card-text me-2"></i>Book Description</label>
                </div> -->

                <div class="form-actions">
                    <button type="submit" class="btn-modern">
                        <i class="bi bi-save"></i>Save Book
                    </button>
                </div>
            </form>
        </div>
    </main>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
