Feature: Validate the JSON place holder for Put APIs

  Scenario Outline: Allow to update the record for json place holder API
    Given the json place holder API mS is been hit with body request "<uri>" "<inputRequest>" "<id>" "<title>" "<body>" "<userId>"and allow to update record
    Then validate the status code as "<responseCode>" for put service
    Then validate the response with <inputRequest> for put service

    Examples: 
      | uri                                        | inputRequest | id  | title | body | userId | responseCode |
      | https://jsonplaceholder.typicode.com/posts |            1 |   1 | abc   | xyz  |      1 |          200 |
      | https://jsonplaceholder.typicode.com/posts |           25 |  25 | abc   | xyz  |     25 |          200 |
      | https://jsonplaceholder.typicode.com/posts |           50 |  50 | abc   | xyz  |     50 |          200 |
      | https://jsonplaceholder.typicode.com/posts |          100 | 100 | abc   | xyz  |    100 |          200 |
