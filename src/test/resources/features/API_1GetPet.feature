Feature: Test the get account functionality


  @SmokeSuiteAPI
  @APIget
  Scenario: User is able to get a PET successfully from the store site

    Given user call the get pet by "available" request
    Then user get the success response code '200'
    Then user gets the pet details in the response




