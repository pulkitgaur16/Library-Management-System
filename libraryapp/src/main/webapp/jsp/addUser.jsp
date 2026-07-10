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
    <%@ include file= "includes/sidebar.jsp" %>

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

        <div class="form-container">
            <form id="userForm" action="UserController" method="post">
                <input type="hidden" name="action" value="addUser">
                
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name">
                            <label for="firstName"><i class="bi bi-person me-2"></i>First Name</label>
                            <div id="firstNameError" class="text-danger small mt-1"></div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name">
                            <label for="lastName"><i class="bi bi-person me-2"></i>Last Name</label>
                            <div id="lastNameError" class="text-danger small mt-1"></div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                            <label for="email"><i class="bi bi-envelope me-2"></i>Email Address</label>
                            <div id="emailError" class="text-danger small mt-1"></div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-floating">
                            <input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone">
                            <label for="phone"><i class="bi bi-telephone me-2"></i>Phone Number</label>
                            <div id="phoneError" class="text-danger small mt-1"></div>
                        </div>
                    </div>
                </div>

                <div class="form-floating">
                    <textarea class="form-control" id="address" name="address" placeholder="Address"></textarea>
                    <label for="address"><i class="bi bi-geo-alt me-2"></i>Address</label>
                    <div id="addressError" class="text-danger small mt-1"></div>
                </div>

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
<script>
function setupAddUserValidation() {
    const form = document.querySelector('.form-container form');
    if (!form) {
        return;
    }

    // Get input fields
    const firstName = document.getElementById('firstName');
    const lastName = document.getElementById('lastName');
    const email = document.getElementById('email');
    const phone = document.getElementById('phone');
    const address = document.getElementById('address');

    // Get placeholder error text containers
    const firstNameError = document.getElementById('firstNameError');
    const lastNameError = document.getElementById('lastNameError');
    const emailError = document.getElementById('emailError');
    const phoneError = document.getElementById('phoneError');
    const addressError = document.getElementById('addressError');

    form.addEventListener('submit', function(event) {
        let hasError = false;

        // 1. First Name Validation
        if (!firstName.value.trim()) {
            firstNameError.textContent = 'Please enter the first name.';
            hasError = true;
        } else {
            firstNameError.textContent = '';
        }

        // 2. Last Name Validation
        if (!lastName.value.trim()) {
            lastNameError.textContent = 'Please enter the last name.';
            hasError = true;
        } else {
            lastNameError.textContent = '';
        }

        // 3. Email Address Validation
        const emailValue = email.value.trim();
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailValue) {
            emailError.textContent = 'Please enter the email address.';
            hasError = true;
        } else if (!emailRegex.test(emailValue)) {
            emailError.textContent = 'Please enter a valid email address (e.g., name@example.com).';
            hasError = true;
        } else {
            emailError.textContent = '';
        }

        // 4. Phone Number Validation
        const phoneValue = phone.value.trim();
        const phoneRegex = /^\d{10}$/; // Assumes standard 10-digit number validation
        if (!phoneValue) {
            phoneError.textContent = 'Please enter the phone number.';
            hasError = true;
        } else if (!phoneRegex.test(phoneValue)) {
            phoneError.textContent = 'Phone number must be exactly 10 digits containing only numbers.';
            hasError = true;
        } else {
            phoneError.textContent = '';
        }

        // 5. Address Validation
        if (!address.value.trim()) {
            addressError.textContent = 'Please enter the physical address.';
            hasError = true;
        } else {
            addressError.textContent = '';
        }

        // Block submit event if any field is invalid
        if (hasError) {
            event.preventDefault();
        }
    });
}

// Initialize validation tracking configurations safely
if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', setupAddUserValidation);
} else {
    setupAddUserValidation();
}
</script>
</body>
</html>
