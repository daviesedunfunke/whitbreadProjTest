/**
 * 
 */
package testExecution;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author davies edunfunke
 *
 */

@RunWith (Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\dedunfunke\\workspace8\\org.whitbreadTest.com\\Features",
		glue = {"stepDefinition"},
		dryRun = false,
		tags = {"@addCustomer, @getCustomer, @delCustomer"},
		monochrome = true
		)
public class ApiWhitbreadtestExecution {

}