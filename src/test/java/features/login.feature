Feature: Login Functionality


 
  Scenario: Verify UI elements on the login page
    Given I am on the DL6 Technologies login page
    Then I should see the "DL6 Technologies" header
    And the i/p form should contain:
      | Field         | Placeholder            |
      | Email         | Enter your email       |
      | Password      | Enter your password    |
    And I should see a "Remember Me" checkbox
    And I should see a "Forgot password?" link
    And I should see a "Sign In" button
    And I should see a "Do not have an account yet?" link
    And I should see an "eye icon" in the password field
    
 
  Scenario: Verify eye icon functionality in the password field
    Given I am on the DL6 Technologies login page
    And I enter a password "Password123"
    When I click on the "eye icon" in the password field
    Then the password should be visible as plain text
    When I click on the "eye icon" again
    Then the password should be masked as dots or asterisks
    
  Scenario: Successful login with valid credentials
    Given I am on the DL6 Technologies login page
    When I enter a valid email "pranav0203@yopmail.com"
    And I enter a valid password "Admin@123"
    And I click on the "Sign In" button
    Then I should be redirected to the dashboard
    
 
  Scenario: Login with invalid credentials
    Given I am on the DL6 Technologies login page
    When I enter an invalid email "invalid@example.com"
    And I enter an invalid password "WrongPassword"
    And I click on the "Sign In" button
    Then I should see an error message "Invalid email or password"
    
    
@test   
 Scenario: Remember Me functionality retains login session after browser restart
    Given I am on the DL6 Technologies login page
    When I enter a valid email "pranav0203@yopmail.com"
    And I enter a valid password "Admin@123"
    And I check the "Remember Me" checkbox
    And I click on the "Sign In" button
    Then I should be logged in successfully
    When I close and reopen the browser
    And I navigate to the DL6 Technologies home page
    Then I should still be logged in
    
  Scenario: Forgot password link
    Given I am on the DL6 Technologies login page
    When I click on the "Forgot password?" link
    Then I should be redirected to the password recovery page
    
  Scenario: Navigate to Signup page
    Given I am on the DL6 Technologies login page
    When I click on "Do not have an account yet?"
    Then I should be redirected to the signup page