package br.com.auto.suite_runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.auto.test.capture_data_director.TestCaptureDataDirector;

@RunWith(Suite.class)
@Suite.SuiteClasses(TestCaptureDataDirector.class)
public class SuiteRunner {

}
