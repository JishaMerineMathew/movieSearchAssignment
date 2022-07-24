package StepDefinitions;
import Steps.imdbSteps;
import Steps.wikiSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions {

	@Given("I open the browser and open wikipedia page")
	public void i_open_the_browser_and_open_wikipedia_page() throws InterruptedException {
		wikiSteps.openWikiPage();
	}
	
	@When("I enter the {string} and click wiki search option")
	public void i_enter_the_and_click_wiki_search_option(String string) throws InterruptedException {
		wikiSteps.searchWikiPage(string);
	}
	
	@And("I should be able to extract the movie country of origin and release date from the wiki page")
	public void i_should_be_able_to_extract_the_movie_country_of_origin_and_release_date_from_the_wiki_page() throws InterruptedException {
		wikiSteps.extractWikiInfo();
	}
	
	@Then("I open the imdb page in another tab")
	public void i_open_the_imdb_page_in_another_tab() throws InterruptedException {
		imdbSteps.openImdbPage();
	}
	
	@And("I enter the {string} and click imdb search option")
	public void i_enter_the_and_click_imdb_search_option(String string) throws InterruptedException {
		imdbSteps.searchImdbPage(string);
	}
	
	@And("I should be able to extract the movie country of origin and release date from the imdb page")
	public void i_should_be_able_to_extract_the_movie_country_of_origin_and_release_date_from_the_imdb_page() throws InterruptedException {
		imdbSteps.extractImdbInfo();
	}
	
	@And("I compare the release dates and country of origin")
	public void i_compare_the_release_dates_and_country_of_origin() throws InterruptedException {
		imdbSteps.compareExtractedInfo();
	}
	
}
