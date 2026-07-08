<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ include file= "includes/header.jsp" %>

<style>
    .info-card {
        background: linear-gradient(135deg, rgba(52, 152, 219, 0.1) 0%, rgba(155, 89, 182, 0.1) 100%);
        border: 1px solid rgba(52, 152, 219, 0.2);
        border-radius: var(--border-radius);
        padding: 1.5rem;
        margin-bottom: 2rem;
    }

    .info-card .icon {
        font-size: 2rem;
        color: #3498db;
        margin-bottom: 1rem;
    }

    .user-type-card {
        border: 2px solid #e9ecef;
        border-radius: var(--border-radius);
        padding: 1.5rem;
        margin-bottom: 1rem;
        cursor: pointer;
        transition: var(--transition);
        background: rgba(255, 255, 255, 0.8);
    }

    .user-type-card:hover {
        border-color: #1ABC9C;
        background: rgba(26, 188, 156, 0.05);
        transform: translateY(-2px);
        box-shadow: var(--card-shadow);
    }

    .user-type-card.selected {
        border-color: #1ABC9C;
        background: rgba(26, 188, 156, 0.1);
        box-shadow: var(--card-shadow);
    }

    .user-type-card .icon {
        font-size: 2.5rem;
        margin-bottom: 1rem;
    }

    .user-type-card h6 {
        margin-bottom: 0.5rem;
        color: #2c3e50;
    }

    .user-type-card p {
        font-size: 0.9rem;
        color: #6c757d;
        margin-bottom: 0;
    }
</style>

<div class="container-fluid">
<div class="row">
    <!-- Sidebar -->
    <%@ include file= "includes/sidebar.jsp" %>

    <!-- Main content -->
	<main class="col-md-9 ms-sm-auto col-lg-10">
        <div class="page-header">
            <h1 class="h2"><i class="bi bi-person-plus me-2"></i>Add New User</h1>
        </div>

        <c:if test="${not empty errorMessage}">
		    <div class="alert alert-danger alert-dismissible fade show" role="alert">
		    		<c:out value="${errorMessage}"/>
		    		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		    </div>
        </c:if>

        <!-- Info Card -->
        <!-- <div class="info-card">
            <div class="icon">
                <i class="bi bi-info-circle"></i>
            </div>
            <h5>User Registration</h5>
            <p class="mb-0">Register new library members and staff. Choose the appropriate user type and fill in the required information to create a new account.</p>
        </div> -->

        <!-- User Type Selection -->
        <div class="form-container">
            <form id="userForm" action="UserController" method="post">
                <input type="hidden" name="action" value="addUser">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name">
                            <label for="firstName"><i class="bi bi-person me-2"></i>First Name</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name">
                            <label for="lastName"><i class="bi bi-person me-2"></i>Last Name</label>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                            <label for="email"><i class="bi bi-envelope me-2"></i>Email Address</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone">
                            <label for="phone"><i class="bi bi-telephone me-2"></i>Phone Number</label>
                        </div>
                    </div>
                </div>

                <!-- <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="date" class="form-control" id="dateOfBirth" placeholder="Date of Birth">
                            <label for="dateOfBirth"><i class="bi bi-calendar me-2"></i>Date of Birth</label>
                        </div>
                    </div>
                </div> -->

                <div class="form-floating">
                    <textarea class="form-control" id="address" name="address" placeholder="Address"></textarea>
                    <label for="address"><i class="bi bi-geo-alt me-2"></i>Address</label>
                </div>

                <!-- <div id="credentialsSection" style="display: none;">
                    <h6 class="mb-3 mt-4">Account Credentials</h6>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                                <label for="password"><i class="bi bi-lock me-2"></i>Password</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-floating">
                                <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password">
                                <label for="confirmPassword"><i class="bi bi-lock me-2"></i>Confirm Password</label>
                            </div>
                        </div>
                    </div>
                </div> -->

                <div class="form-actions">
                    <button type="submit" class="btn-modern">
                        <i class="bi bi-person-plus"></i>Create User
                    </button>
                </div>
            </form>
        </div>
    </main>

</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- <script>
    let selectedUserType = '';

    function selectUserType(type) {
        selectedUserType = type;

        // Remove selected class from all cards
        document.querySelectorAll('.user-type-card').forEach(card => {
            card.classList.remove('selected');
        });

        // Add selected class to clicked card
        event.currentTarget.classList.add('selected');

        // Enable and set the user role dropdown
        const userRoleSelect = document.getElementById('userRole');
        userRoleSelect.disabled = false;
        userRoleSelect.value = type;

        // Show credentials section for librarian and admin
        const credentialsSection = document.getElementById('credentialsSection');
        if (type === 'librarian' || type === 'admin') {
            credentialsSection.style.display = 'block';
        } else {
            credentialsSection.style.display = 'none';
        }
    }

    // Form validation
    document.addEventListener('DOMContentLoaded', function() {
        const form = document.getElementById('userForm');
        const passwordField = document.getElementById('password');
        const confirmPasswordField = document.getElementById('confirmPassword');

        // Password confirmation validation
        function validatePasswords() {
            if (passwordField.value !== confirmPasswordField.value) {
                confirmPasswordField.setCustomValidity('Passwords do not match');
                confirmPasswordField.style.borderColor = '#dc3545';
            } else {
                confirmPasswordField.setCustomValidity('');
                confirmPasswordField.style.borderColor = '#1ABC9C';
            }
        }

        if (confirmPasswordField) {
            confirmPasswordField.addEventListener('input', validatePasswords);
            passwordField.addEventListener('input', validatePasswords);
        }

        // Form submission
        form.addEventListener('submit', function(e) {
            e.preventDefault();

            if (!selectedUserType) {
                alert('Please select a user type first.');
                return;
            }

            // Here you would normally submit the form data
            alert('User would be created successfully!');
        });
    });
</script> -->
</body>
</html>
