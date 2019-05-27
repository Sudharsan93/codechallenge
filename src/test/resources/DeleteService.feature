#Author: sudharsan.lm10@gamil.com
Feature: Validate the JSON place holder for Delete APIs

  Scenario Outline: Allow to retrieve the json place holder data one user
    Given the place holder API is been hit with "<uri>" "<inputRequest>" and delete the detail
    Then validate the status code as "<responseCode>" for delete service

    Examples: 
      | uri                                        | inputRequest | responseCode |
      | https://jsonplaceholder.typicode.com/posts |            1 |          200 |
      | https://jsonplaceholder.typicode.com/posts |           25 |          200 |
      | https://jsonplaceholder.typicode.com/posts |           50 |          200 |
      | https://jsonplaceholder.typicode.com/posts |          100 |          200 |
