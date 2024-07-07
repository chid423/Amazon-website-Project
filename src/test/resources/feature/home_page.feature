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
  
  Scenario Outline: Filter phones by brand, camera resolution, model year, and price range
    Given user is on simfree landing page "<url>"
    When user filter the brand to "<brand>"
    And user filter the camera resolution to "<camera_resolution>"
    And user filter the model year to "<model_year>"
    And user filter the price range to between <min_price> and <max_price>
    Then user should see a list of "<brand>" phones that match the criteria

  Examples:
    | url   | brand   | camera_resolution | model_year | min_price | max_price |
    | URL2  | Samsung | £20 MP and above  | 2023       | 50        | 100       |
