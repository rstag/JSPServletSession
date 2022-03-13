<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Please enter your name</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>
    </head>
    <body style="background: linear-gradient(45deg, black, transparent)">
        <div class="container text-white" style="padding: 30px;">

            <form action="checkUser">
                <div class="mb-3">
                    <label for="fname" class="form-label">User Id</label>
                    <input type="text" class="form-control" id="fname" name="uid"
                           placeholder="User Id">
                </div>
                <div class="mb-3">
                    <label for="lname" class="form-label">Password</label>
                    <input type="text" class="form-control" id="lname" name="password"
                           placeholder="Password">
                </div>

                <div class="mb-3">
                    <input class="btn btn-primary" type="submit" value="Submit">
                </div>
            </form>
            <div class="mb-3">
                <a href="newuser.jsp"  >Sign up</a>
            </div>
        </div>

    </body>
</html>
