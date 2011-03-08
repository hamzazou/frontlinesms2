package frontlinesms2

import spock.lang.*
import grails.plugin.spock.*

class EmailTranslatorSpec extends UnitSpec {
	def t

	setupSpec() {
		t = new EmailTranslator()
	}

	def "it's a TransformProcessor"() {
		then:
			t instanceof org.apache.camel.processor.TransformProcessor
	}

	def "email from field is converted to a suitable FMessage from field"() {
		given:
			def testExchange = createTestExchange()
		when:
			t.process(testExchange)
		then:
			FMessage out = testExchange.getOut()
			assert out.src == "email:test@example.com"
	}

	def "email to field is converted to a suitable FMessage to desitination field"() {
		given:
			def testExchange = createTestExchange()
		when:
			t.process(testExchange)
		then:
			FMessage out = testExchange.getOut()
			assert out.dst == "email:frontlinesms1@example.com"
	}

	def "email body is converted to a suitable FMessage body"() {
		given:
			def testExchange = createTestExchange()
		when:
			t.process(testExchange)
		then:
			FMessage out = testExchange.getOut()
			assert out.body == "Hello there, here's the test email body converted into a textual message."
	}

	def "original email is available from the FMessage"() {
		given:
			def testEmail = createTestEmail()
			def createTestExchange = createTestExchange(testEmail)
		when:
			t.process(testExchange)
		then:
			FMessage out = testExchange.getOut()
			assert out.original == testEmail
	}
}

