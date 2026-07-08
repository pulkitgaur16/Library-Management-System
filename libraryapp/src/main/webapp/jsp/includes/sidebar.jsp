<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block sidebar collapse">
    <div class="position-sticky sidebar-sticky">
        <ul class="nav flex-column">
            
            <li class="nav-item">
                <a class="nav-link ${empty param.action || param.action == 'dashboard' ? 'active' : ''}" href="/libraryapp/jsp/dashboard.jsp">
                    <i class="bi bi-speedometer2"></i>Dashboard
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link ${param.action == 'assignBookForm' ? 'active' : ''}" href="/libraryapp/BookController?action=assignBookForm">
                    <i class="bi bi-arrow-right-circle"></i>Assign Book
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link ${param.action == 'returnBookForm' ? 'active' : ''}" href="/libraryapp/BookController?action=returnBookForm">
                    <i class="bi bi-arrow-left-circle"></i>Return Book
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link ${param.action == 'allBookList' || param.action == 'viewBook' ? 'active' : ''}" href="/libraryapp/BookController?action=allBookList">
                    <i class="bi bi-book"></i>Books
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link ${param.action == 'showAddBook' ? 'active' : ''}" href="/libraryapp/BookController?action=showAddBook">
                    <i class="bi bi-plus-circle"></i>Add Book
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link ${param.action == 'allUserList' || param.action == 'viewUser' ? 'active' : ''}" href="/libraryapp/UserController?action=allUserList">
                    <i class="bi bi-people"></i>Users
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link ${param.action == 'showAddUser' ? 'active' : ''}" href="/libraryapp/UserController?action=showAddUser">
                    <i class="bi bi-person-plus"></i>Add User
                </a>
            </li>
            
        </ul>
    </div>
</nav>