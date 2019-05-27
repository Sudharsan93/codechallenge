#Author: sudharsan.lm10@gamil.com
Feature: Validate the JSON place holder for Get APIs

  Scenario Outline: Allow to retrieve the json place holder data
    Given the place holder API is been hit with "<uri>" and retrieve detail
    Then validate the status code as "<responseCode>"
    Then validate the record count with <recordCount>

    Examples: 
      | uri                                        | responseCode | recordCount |
      | https://jsonplaceholder.typicode.com/posts |          200 |         100 |

  Scenario Outline: Allow to retrieve the json place holder data one user
    Given the place holder API is been hit with "<uri>" "<inputRequest>" and retrieve detail for the input
    Then validate the status code as "<responseCode>"
    Then validate the response with <inputRequest>

    Examples: 
      | uri                                        | inputRequest | responseCode |
      | https://jsonplaceholder.typicode.com/posts |            1 |          200 |
      | https://jsonplaceholder.typicode.com/posts |           25 |          200 |
      | https://jsonplaceholder.typicode.com/posts |           50 |          200 |
      | https://jsonplaceholder.typicode.com/posts |          100 |          200 |

  Scenario Outline: Allow to retrieve the json place holder data
    Given the place holder API is been hit with "<uri>" and retrieve detail
    Then validate the status code as "<responseCode>"

    Examples: 
      | uri                                               | responseCode |
      | https://jsonplaceholder.typicode.com/invalidposts |          404 |
