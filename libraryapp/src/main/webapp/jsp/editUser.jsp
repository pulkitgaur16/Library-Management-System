
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file= "includes/header.jsp" %>

<div class="container-fluid">
<div class="row">
    <!-- Sidebar -->
    <%@ include file= "includes/sidebar.jsp" %>

    <!-- Main content -->
	<main class="col-md-9 ms-sm-auto col-lg-10">
        <div class="page-header">
            <h1 class="h2"><i class="bi bi-person-fill me-2"></i>Edit User</h1>
        </div>

        <c:if test="${not empty successMessage}">
		    <div class="alert alert-success alert-dismissible fade show" role="alert">
		    		<c:out value="${successMessage}"/>
		    		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		    </div>
        </c:if>

        <c:if test="${not empty errorMessage}">
		    <div class="alert alert-danger alert-dismissible fade show" role="alert">
		    		<c:out value="${errorMessage}"/>
		    		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		    </div>
        </c:if>

        <div class="form-container">
            <form action="UserController" method="post">
                <input type="hidden" name="action" value="updateUser">
                <input type="hidden" name="userId" value="${user.userId}">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" value="${user.firstName}">
                            <label for="firstName"><i class="bi bi-person me-2"></i>First Name</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" value="${user.lastName}">
                            <label for="lastName"><i class="bi bi-person me-2"></i>Last Name</label>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="${user.email}">
                            <label for="email"><i class="bi bi-envelope me-2"></i>Email Address</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone" value="${user.phoneNo}">
                            <label for="phone"><i class="bi bi-telephone me-2"></i>Phone Number</label>
                        </div>
                    </div>
                </div>

                <!-- <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="date" class="form-control" id="dateOfBirth" placeholder="Date of Birth" value="1990-05-15">
                            <label for="dateOfBirth"><i class="bi bi-calendar me-2"></i>Date of Birth</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <select class="form-select" id="userRole">
                                <option value="member" selected>Library Member</option>
                                <option value="librarian">Librarian</option>
                                <option value="admin">Administrator</option>
                            </select>
                            <label for="userRole"><i class="bi bi-person-check me-2"></i>User Role</label>
                        </div>
                    </div>
                </div> -->

                <div class="form-floating">
                    <textarea class="form-control" id="address" name="address" placeholder="Address">${user.address}</textarea>
                    <label for="address"><i class="bi bi-geo-alt me-2"></i>Address</label>
                </div>

                <!-- <h6 class="mb-3 mt-4">Change Password (Optional)</h6>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="password" class="form-control" id="newPassword" placeholder="New Password">
                            <label for="newPassword"><i class="bi bi-lock me-2"></i>New Password</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password">
                            <label for="confirmPassword"><i class="bi bi-lock me-2"></i>Confirm Password</label>
                        </div>
                    </div>
                </div> -->

                <div class="form-actions">
                    <button type="submit" class="btn-modern">
                        <i class="bi bi-save"></i>Update User
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
