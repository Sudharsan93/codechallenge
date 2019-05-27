Feature: Validate the JSON place holder for Post APIs

  Scenario: Allow to create the record for json place holder API
    Given the json place holder API mS is been hit with body request and allow to create new record
      | uri                                        | postPayload                                         |
      | https://jsonplaceholder.typicode.com/posts | { "title" : "foo" , "body" : "bar" , "userId" : 1 } |
    Then validate the status code as for post service
      | responseCode |
      |          201 |
    Then validate the new record
      | recordId |
      |      101 |
