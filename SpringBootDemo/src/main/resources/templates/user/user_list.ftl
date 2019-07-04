<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div>
        <table>
            <thead>
            <tr>
                <th>id</th>
                <th>userName</th>
                <th>password</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.password}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
    <div>
        <button onclick="add();">新增</button>
    </div>
</body>
<script>

    function add() {
        window.location.href = "user/goAdd";
    }
</script>
</html>