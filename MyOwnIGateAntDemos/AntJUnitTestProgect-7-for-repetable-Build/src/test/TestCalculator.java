package test;
import math.MyMath;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestCalculator
{
  @Test
  public void testMulti() 
  {
    MyMath math = new MyMath();
    assertEquals(150, math.multi(5, 10));
  }
} 