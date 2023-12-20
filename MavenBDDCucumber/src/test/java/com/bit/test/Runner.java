package com.bit.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\Users\\mehed\\OneDrive\\Desktop\\BTC210209E\\MavenBDDCucumber\\Login.feature"}, tags = {"@Regression"}, plugin = {"pretty", "html:Folder_Name"})

public class Runner {
	
	
	

}
