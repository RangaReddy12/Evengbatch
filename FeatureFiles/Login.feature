Feature: This is Login Functionality
@scenariowithoutDatatable
Scenario: Verifing Login Module
When I open OrangeHRMS URL on chromebrowser 
And I enter  in username
And I enter  in password 
When I click Login Button
Then I Should see Welcome Link on Home Page
When I close the browser
When i click logout
@scenariowithDatatable
    Scenario Outline: Login Functionality Validation
    When I open OrangeHRMS URL on "<Browser>"
    And I enter "<UserName>" in usernameField
    And I enter "<Password>" in passwordField
    When Iam clicking Login Button
    Then I Should see dashboard in my url
    When Iam  closing the browser
    Examples:
    |Browser|UserName|Password|
    |Chrome|Admin|Qedge123!@#|
    |firefox|Admin|admin123|
    |Chrome|Admin|Qedge123!@#|
    |firefox|Admin|admin123|
    |Chrome|Admin|Qedge123!@#|
    |firefox|Admin|Qedge123!@#|
 @login   
 Scenario: Primus bank login test Scenario
Given user on login page
When title of login page is Primus Bank
Then user enter username and password
Then user clicks on login button
@branchcreation
Scenario: primus bank user creation

Given user click on branch
When user on new branch entry
Then user enter branch name
Then user enter Address1
Then user enter Address2
Then user enter Area
Then user enter Zip code
Then user Select country
Then user Select State
Then user Select City
Then user click on submit button
Then verify new user created
Then user click on logout
Then close the browser
    
    