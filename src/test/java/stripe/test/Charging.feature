Feature: Charging

  Scenario Outline: User Can create a Charge
     When  create a charge with "<value>" with "<currency>" using "<source>" with "<description>"
     Then  check that balance is more than Zero
     And   check that currency is in USD
    Examples:
      | value |currency|source     | description   |
      | 50   | usd    |tok_visa   | Test charge   |

  Scenario Outline: User Can create Charging and retrieve assert response
    When  create a charge with "<value>" with "<currency>" using "<source>" with "<description>"
    Then  check that Authorized amount is "<value>"
    And   check that card brand is "<brand>"
    And   check that Expiry month  should be "<month>"
    And   check that Expiry year  should be "<year>"

    Examples:
      | value |currency|source    | description  |brand| month|year|
      |  50   | usd    |tok_visa  |Test charge   |visa |4     |2025|


Scenario Outline: User Can check schema response for balance end point
    When  retrieve balance
    Then  check that schema response is correct "<schemaPath>"

   Examples:
   | schemaPath  |
   | schema.json  |

