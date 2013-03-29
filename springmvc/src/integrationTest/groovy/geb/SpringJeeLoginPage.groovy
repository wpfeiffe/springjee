package geb
/**
 * Geb representation of the home page for this app
 * User: wpfeiffe
 * Date: 3/22/13
 */
class SpringJeeLoginPage extends Page
{
    static url = "login.htm"
    static at = { title == "Login" }

    static content = {
        loginForm {$("form")}
        loginButton {$("button")}
    }
}
