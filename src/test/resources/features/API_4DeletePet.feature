Feature: Test the delete account functionality


  @SmokeSuiteAPI
  @APIdelete
  Scenario: User is able to delete a PET successfully from the store site

    Given user call the delete pet request with id '123123'
    Then record is deleted and user get the success response code '200'
    Then user call the get pet request to validate deletion with id '123123'

