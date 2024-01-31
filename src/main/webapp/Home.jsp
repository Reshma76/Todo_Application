<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
    div {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
    </style>
</head>
<body>
    <div>
        <h1>Todo Home</h1>
        <table border="2 px solid black">
            <tr>
                <th>Task Name</th>
                <th>Task Description</th>
                <th>Date Created</th>
                <th>Status</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
        </table>
        <br>
        <a href="session-add-task"><button>Add Task</button></a><br>
        <a href="logout"><Button>Logout</Button></a> 
    </div>
</body>
</html>