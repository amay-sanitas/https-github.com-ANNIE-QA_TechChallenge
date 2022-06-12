Feature: Test the account registration functionality


  @SmokeSuiteAPI
  @APIpost
  Scenario: User is able to register a PET successfully on the store site

    Given user post the add pet request with id '123123' and dog name "PlutoTest"
    Then user get response code '200'
    And user verify the dog name "PlutoTest" in response


