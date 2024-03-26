package Hand;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class VMHandlerTest {

	@Test
	void TestTokeninzing() {
		var vm = new VMHandler();
		assertEquals(new ArrayList<>(Arrays.asList("2", "*", "3")), vm.tokenizing("2 * 3"));
	}
	
	@Test
	void TestVerifyifSomethingIsDouble()
	{
		var vm = new VMHandler();
		assertTrue(vm.isDouble("2.3"));
	}
	
	@Test
	void TestConvertToReversePolishNotationOnlyOneSign()
	{
		var vm = new VMHandler();
		Queue<String> out = new LinkedList<String>();
		//out.add(")");
		//out.add("(");
		out.add("+");
		
		assertEquals(out, vm.CRPN(new ArrayList<>(Arrays.asList("(", ")", "+"))));
	}

	@Test
	void TestEvaluateReversePolishNotationWithOneSign()
	{
		var vm = new VMHandler();
		Queue<String> out = new LinkedList<String>();
		//out.add(")");
		//out.add("(");
		out.add("+");
		
		assertEquals(0, vm.ERPN(out));
	}
	
	@Test
	void TestOnlyOneNumberWithOneSign()
	{
		var vm = new VMHandler();
		Queue<String> out = new LinkedList<String>();
		//out.add(")");
		//out.add("(");
		out.add("+");
		out.add("1");
		
		assertEquals(0, vm.ERPN(out));
	}
	
	@Test
	void TestOnlyOneNumberButMultipleSigns()
	{
		var vm = new VMHandler();
		Queue<String> out = new LinkedList<String>();
		//out.add(")");
		//out.add("(");
		out.add("2");
		out.add("+");
		out.add("+");
		
		assertEquals(0, vm.ERPN(out));
	}
	
	@Test
	void TestEdgeNumberDividedByZero()
	{
		var vm = new VMHandler();
		Queue<String> out = new LinkedList<String>();
		out.add("2");
		out.add("/");
		out.add("0");
		
		assertEquals(0, vm.ERPN(out));
	}
	
	@Test
	void TestEdgeOnetoThePowerOfX()
	{
		var vm = new VMHandler();
		Queue<String> out = new LinkedList<String>();
		out.add("1");
		out.add("6");
		out.add("^");
		
		assertEquals(1, vm.ERPN(out));
	}
	
	@Test
	void TestEdgeZeroToThePowerOfX()
	{
		var vm = new VMHandler();
		Queue<String> out = new LinkedList<String>();
		out.add("0");
		out.add("5");
		out.add("^");
		
		assertTrue(vm.ERPN(out) == 0);
	}
	
	@Test
	void TestTokenizingMultipleZerosReturnsOnlyOneZero()
	{
		var vm = new VMHandler();
		assertEquals(new ArrayList<>(Arrays.asList("0")), vm.tokenizing("000000"));
	}
}
