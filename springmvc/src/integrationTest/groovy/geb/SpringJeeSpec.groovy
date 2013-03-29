package geb

import geb.spock.GebReportingSpec
import spock.lang.Stepwise

/**
 * Spec to get to the homepage
 * User: wpfeiffe
 * Date: 3/22/13
 */
@Stepwise
class SpringJeeSpec extends GebReportingSpec {

    def "go home"() {
        when:
            go "http://localhost:8080/springmvc/login.htm"

        then:
            title == "Login"
            $("h2").text() == "Log In"
    }

    def "login geb page"() {
        given: "I'm at the login page"
            to SpringJeeLoginPage

        when: "I enter credentials"
            loginForm.j_username = "admin"
            loginForm.j_password = "Password1"
            loginButton.click()

        then: "I am redirected to the main page"
            1 == 1

    }

    def "fail on login"() {
        given: "I'm at the login page"
            to SpringJeeLoginPage

        when: "I enter BAD credentials"
            loginForm.j_username = "admin"
            loginForm.j_password = "Fail"
            loginButton.click()

        then: "I am redirected to the login page with a fail message"
            $("div.alert.alert-error").text().contains("Error logging in: Bad credentials")

    }
}
