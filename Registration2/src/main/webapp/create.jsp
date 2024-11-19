<!DOCTYPE html>
<html>
<head>
    <title>Create Registration</title>
</head>
<body>
    <h2>Create Registration</h2>
    <form action="registrationController?action=create" method="post">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        Date of Birth: <input type="date" name="dob" required><br>
        Phone Number: <input type="text" name="phone"><br>
        Address: <textarea name="address"></textarea><br>
        <button type="submit">Create</button>
    </form>
</body>
</html>
