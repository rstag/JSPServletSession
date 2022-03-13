
<%@page import="com.tests.jsplogin.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
    </head>
    <body style="background: linear-gradient(45deg, black, transparent)">
        <div class="container text-white" style="padding: 30px;">

            <h1>Login Success..</h1>
            <%
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                if (session.getAttribute("user") != null) {
                    Users u = (Users) session.getAttribute("user");
                    out.print(u.getUid() + " " + u.getUname() + "  " + u.getEmail());
                } else {
                    response.sendRedirect("loginpg.jsp");
                }
            %>
            <form action="LogoutUser">
                <div class="mb-3">
                    <input class="btn btn-primary" type="submit" value="Logout">
                </div>
            </form>
            <div class="mb-3">
                <a href="fileupload.jsp"  >Sign up</a>
            </div>
        </div>

    </body>
</html>
