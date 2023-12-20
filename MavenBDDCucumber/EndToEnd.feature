Feature: EndToEnd Validation


  Scenario: Buy a shirt using credit card with the same billing and shipping
  
    Given Open <"browser">
    	| browser |
    	| Chrome |
    	| FireFox |
    	| Safari |
    And go to url
    
    When user hover over Men munu
    
    And user click new Arrivals Submenu
    And user click shirt product
    And user click shirt color
    And user click shirt size
    And user click add to bag
    And user click view bag
    And user click checkout cart

		When user type user ID in email box
		| UserID |
		| User1	|
		| User2	|    
	
		And user input password
    And user click sign in
    And user input shipping and billing info
    And user click order product
    
    Then user should see item ordered