<%@ page import="java.util.List" %>
<%@ page import="To.registerTo" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Registrations</title>
</head>
<body>
    <h2>All Registrations</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Date of Birth</th>
            <th>Phone</th>
            <th>Address</th>
        </tr>
        <%
            // Retrieve the list of registrations from the request attribute
            List<To.registerTo> registrations = 
                (List<To.registerTo>) request.getAttribute("registrations");
            
            if (registrations != null && !registrations.isEmpty()) {
                // Iterate over each registration and print its details
                for (registerTo reg : registrations) {
        %>
        <tr>
            <td><%= reg.getId() %></td>
            <td><%= reg.getName() %></td>
            <td><%= reg.getEmail() %></td>
            <td><%= reg.getDateOfBirth() %></td>
            <td><%= reg.getPhoneNumber() %></td>
            <td><%= reg.getAddress() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">No registrations found.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
