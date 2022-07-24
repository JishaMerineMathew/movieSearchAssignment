@searchMovieFeature
Feature: Search for Country and Release date in Wikipedia and IMDB Pages

	@searchMovieScenario
  Scenario Outline: Search Movie Information
    Given I open the browser and open wikipedia page
    When I enter the "<MovieName>" and click wiki search option
    And I should be able to extract the movie country of origin and release date from the wiki page
    Then I open the imdb page in another tab
    And I enter the "<MovieName>" and click imdb search option
    And I should be able to extract the movie country of origin and release date from the imdb page
    And I compare the release dates and country of origin

    Examples: 
      | MovieName        						|
      | Pushpa: The Rise 						|