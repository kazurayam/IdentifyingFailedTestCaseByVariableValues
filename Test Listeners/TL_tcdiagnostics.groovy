import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils

class TL_tcdiagnostics {
	
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		String tsId = testSuiteContext.getTestSuiteId()
		String tsStatus = testSuiteContext.getStatus() 
	}

	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		String tcId = testCaseContext.getTestCaseId()
		Map<String, Object> tcVariables = testCaseContext.getTestCaseVariables()
		String tcUniqueId = getTestCaseUniqueId(tcId, tcVariables)
		String tcStatus = testCaseContext.getTestCaseStatus()
		
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		String tcId = testCaseContext.getTestCaseId()
		Map<String, Object> tcVariables = testCaseContext.getTestCaseVariables()
		String tcUniqueId = getTestCaseUniqueId(tcId, tcVariables)
		String tcStatus = testCaseContext.getTestCaseStatus()
	}

	
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		String tsId = testSuiteContext.getTestSuiteId()
		String tsStatus = testSuiteContext.getStatus()
	}
	
	private String getTestCaseUniqueId(String tcId, Map<String, Object> tcVariables) {
		return DigestUtils.sha1Hex("${tcId} ${tcVariables.toString()}")
	}
}