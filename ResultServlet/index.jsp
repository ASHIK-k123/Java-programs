<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Student Result Form</title>

<script>
function validateForm() {

    let f = document.forms["form"];

    // Check empty fields
    for (let i = 0; i < f.length; i++) {
        if (f[i].value === "") {
            alert("All fields are required!");
            return false;
        }
    }

    // Validate marks range
    let subs = ["sub1","sub2","sub3","sub4","sub5"];

    for (let s of subs) {
        let val = parseInt(f[s].value);
        if (val < 0 || val > 100) {
            alert("Marks must be between 0 and 100");
            return false;
        }
    }

    return true;
}
</script>

</head>
<body>

<h2>Student Result Form</h2>

<form name="form" action="processResult" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="rollno"><br><br>
Name: <input type="text" name="name"><br><br>

Sub1: <input type="number" name="sub1"><br><br>
Sub2: <input type="number" name="sub2"><br><br>
Sub3: <input type="number" name="sub3"><br><br>
Sub4: <input type="number" name="sub4"><br><br>
Sub5: <input type="number" name="sub5"><br><br>

<input type="submit" value="Calculate Result">

</form>

</body>
</html>
