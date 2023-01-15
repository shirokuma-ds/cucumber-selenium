package org.shirokuma;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("org/shirokuma")
@ConfigurationParameters({
        @ConfigurationParameter(key = "cucumber.plugin", value = "pretty,json:target/cucumber/report.json"),
        @ConfigurationParameter(key = "cucumber.filter.tags", value = "@WikipediaFeature")
}
)
public class RunCucumberTest {

}
