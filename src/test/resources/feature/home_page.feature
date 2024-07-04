Feature: List all Samsung phones with specific specifications

  Scenario: List Samsung phones with specific camera resolution, model year, and price range
    Given user am on the Amazon home page "URL"
    When user click on All
    And user navigate to the Electronics and Computers section
    And user navigate to the Phones and Accessories section
    And user is on page and Accessories home page "URL1"
    
     @tag1
  Scenario: Mobile phone 
    Given user navigate to the Mobile Phones page "URL1"
    When user click on simFree 
    Then user should see landing page
    

  @tag2
  Scenario Outline: Sim free Samsung
    Given user is on simfree landing page "URL2"
    When user filter the brand to Samsung
    And user filter the camera resolution to 20 MP and above
    And user filter the model year to 2023
    And user filter the price range to between £50 and £100
    Then user should see a list of Samsung phones that match the criteria
    