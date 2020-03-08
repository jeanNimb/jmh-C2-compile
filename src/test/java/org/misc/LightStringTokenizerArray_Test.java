package org.misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * This class tests the correct function of the LightStringTokenizerArray class.
 *
 * @author Rene Schwietzke
 * @version 1.2.0.0.12 2002/07/06
 * 
 * @see com.LightStringTokenizerCharArray.sitereports.util.LightStringTokenizerArray
 */
public class LightStringTokenizerArray_Test
{

    /**
	 * Test 1
	 * 
	 * @see com.xceptance.sitereports.util.LightStringTokenizerArray#
	 */
    @Test 
	public void test_standardtokenize01()
	{
		String string    = "token1/token2/token3";
		
		LightStringTokenizerCharArray lst = new LightStringTokenizerCharArray(string, '/');
		
		assertEquals("token1", lst.nextToken());
		assertEquals("token2", lst.nextToken());
		assertEquals("token3", lst.nextToken());

		assertTrue(!lst.hasMoreTokens());
	}

	/**
	 * Test 2
	 * 
	 * @see com.xceptance.sitereports.util.LightStringTokenizerArray#
	 */
    @Test 
	public void test_standardtokenize02()
	{
		String string    = "/token1/token2/token3";
		
		LightStringTokenizerCharArray lst = new LightStringTokenizerCharArray(string, '/');
		
		assertEquals("", lst.nextToken());
		assertEquals("token1", lst.nextToken());
		assertEquals("token2", lst.nextToken());
		assertEquals("token3", lst.nextToken());

		assertTrue(!lst.hasMoreTokens());
	}

	/**
	 * Test 3
	 * 
	 * @see com.xceptance.sitereports.util.LightStringTokenizerArray#
	 */
    @Test 
	public void test_standardtokenize03()
	{
		String string    = "/token1/token2/token3/";
		
		LightStringTokenizerCharArray lst = new LightStringTokenizerCharArray(string, '/');
		
		assertEquals("", lst.nextToken());
		assertEquals("token1", lst.nextToken());
		assertEquals("token2", lst.nextToken());
		assertEquals("token3", lst.nextToken());

		assertTrue(!lst.hasMoreTokens());
	}

	/**
	 * Test 4
	 * 
	 * @see com.xceptance.sitereports.util.LightStringTokenizerArray#
	 */
    @Test 
	public void test_standardtokenize04()
	{
		String string1    = "/token1/token2/token3/token4/token5/token6//";
		
		LightStringTokenizerCharArray lst = new LightStringTokenizerCharArray(string1, '/');
		
		assertEquals("", lst.nextToken());
		assertEquals("token1", lst.nextToken());
		assertEquals("token2", lst.nextToken());
		assertEquals("token3", lst.nextToken());
		assertEquals("token4", lst.nextToken());
		assertEquals("token5", lst.nextToken());
		assertEquals("token6", lst.nextToken());
		assertEquals("", lst.nextToken());

		assertTrue(!lst.hasMoreTokens());
	}

	/**
	 * Test 5
	 * 
	 * @see com.xceptance.sitereports.util.LightStringTokenizerArray#
	 */
    @Test 
	public void test_standardtokenize05()
	{
		String string1    = "token/token/token/test/test/foobar";
		
		LightStringTokenizerCharArray lst = new LightStringTokenizerCharArray(string1, '/');
		
		assertEquals("token", lst.nextToken());
		assertEquals("token", lst.nextToken());
		assertEquals("token", lst.nextToken());
		assertEquals("test", lst.nextToken());
		assertEquals("test", lst.nextToken());
		assertEquals("foobar", lst.nextToken());

		assertTrue(!lst.hasMoreTokens());
	}
	
	
	/**
	 * Test 7
	 * 
	 * @see com.xceptance.sitereports.util.LightStringTokenizerArray#
	 */
    @Test 
	public void test_standardtokenize07()
	{
		String string1    = "/";
		
		LightStringTokenizerCharArray lst = new LightStringTokenizerCharArray(string1, '/');
		
		assertEquals("", lst.nextToken());
		assertNull(lst.nextToken());

		assertTrue(!lst.hasMoreTokens());
	}

	/**
	 * Test 8
	 * 
	 * @see com.xceptance.sitereports.util.LightStringTokenizerArray#
	 */
    @Test 
	public void test_standardtokenize08()
	{
		String string1    = "test";
		
		LightStringTokenizerCharArray lst = new LightStringTokenizerCharArray(string1, ':');
		
		assertEquals("test", lst.nextToken());
		assertNull(lst.nextToken());

		assertTrue(!lst.hasMoreTokens());
	}

}