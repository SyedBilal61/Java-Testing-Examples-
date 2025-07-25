package testing.example.bank;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


	public class MyStringUtilsTest {

	    private MyStringUtils myStringUtils;

	    @Before
	    public void setup() {
	        myStringUtils = new MyStringUtils();
	    }

	    @Test
	    public void testLeftTrimWithNullString() {
	        assertNull(myStringUtils.leftTrim(null));
	    }
	    
	    @Test
		public void testLeftTrimWithEmptyString() {
		    assertEquals("", myStringUtils.leftTrim(""));
		}
	    @Test
	    public void testLeftTrimWithOneLeadingSpace(){
	    assertEquals("abc",myStringUtils.leftTrim("\tabc"));
	     }                                              
	    @Test
	    public void testLeftTrimWithSeveralKindsOfWhiteSpaces() {
	    	    // For documentation only: not used in TDD
	    	    assertEquals("abc", myStringUtils.leftTrim("\tabc"));
	    	}

	}	
