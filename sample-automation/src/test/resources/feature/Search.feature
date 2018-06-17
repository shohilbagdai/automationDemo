Feature: Search functionality 

As a user
I want to search function on home page
So that I can search for different product from home page

@test
Scenario: Verify when user search for any product search result populate as per user search criteria
Given I am on ETSY home page
When I search for "Sports shoes"
Then I should see search result populate as per entered search criteria "Sports shoes" 
When I select first result from auto suggest result
Then I should see search result page for "Sports shoes" 
When I select "Highest Price" from sort by dropdown
Then I should see products display as per "Highest Price" sort by option
When I grab price for first ten product
Then I should be able to print collected price from first ten product

