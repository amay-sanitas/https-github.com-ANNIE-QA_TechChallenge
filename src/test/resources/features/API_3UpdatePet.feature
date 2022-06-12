Feature: Test the account update functionality


  @SmokeSuiteAPI
  @APIput
  Scenario: User is able to update a PET successfully on the store site

    Given user put the update pet request to pet id "123123" and pet name "PlutoTest" status to "sold"
    Then user get the response code '200'
    And user gets the updated "sold" status in response


