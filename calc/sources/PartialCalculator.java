// FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/calc/sources/PartialCalculator.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . Hp-Dv7
// STARTED ON. . Sun Oct 14 20:56:42 2012

/**
 * This illustrates how the parser generated from the <a
 * href="Calculator.html">Calculator.grm</a> grammar allows parsing of
 * partial subgrammars (in this case definitions and expressions) as
 * specified by the declarations:
 * <pre>
 * %root  Expression
 * %root  Definition</pre>
 * instead of the full grammar rooted in the initial non-terminal symbol
 * <tt>Session</tt>, which stands for an interactive session where
 * several expressions or definitions may be successively parsed and
 * interpreted.
 *
 * <p>
 *
 * This is a stand-alone application calling the generated partial
 * parser methods <tt>parseDefinition</tt> and <tt>parseExpresion</tt>
 * on given strings and printing the result of the parse for each
 * string. Here is the <a
 * href="../../test/PartialCalculatorRun.html">generated output</a>.
 *
 * <p>
 *
 * @version     Last modified on Tue Jan 29 11:24:34 2013 by hak
 * @author      <a href="mahlto:hak@acm.org">Hassan A&iuml;t-Kaci</a>
 * @copyright   &copy; <a href="http://www.hassan-ait-kaci.net/">by the author</a>
 */


import hlt.language.syntax.GenericParser;

public class PartialCalculator
{
  public static void main (String args[])
    {
      try
        {
          CalculatorTokenizer t;

          t = new CalculatorTokenizer("");

          try
            {
              CalculatorParser p = new CalculatorParser(t);

              String input;

              p.parseTreeType = p.COMPACT_TREE;
//            p.toggleTrace();
              
              System.out.println("\n---------------------------------------------");

              p.parseExpression(input="1+2");
              System.out.println("\nvalue() of "+input+" is "+p.currentNode().nvalue());
              System.out.println("\nPARSE TREE:\n");
              p.currentNode().show();

              System.out.println("\n---------------------------------------------");

              p.parseDefinition("pi = 22/7");
              System.out.println("\nDefining pi as "+p.currentNode().nvalue());
              System.out.println("\nPARSE TREE:\n");
              p.currentNode().show();

              System.out.println("\n---------------------------------------------");
              
              p.parseExpression("2 * pi");
              System.out.println("\nTwice this pi is "+p.currentNode().nvalue());
              System.out.println("\nPARSE TREE:\n");
              p.currentNode().show();

              System.out.println("\n---------------------------------------------");
            }
          catch (Exception e)
            {
              System.out.println("*** Parsing error: "+e);
            }
        }
      catch (Exception e)
        {
          System.out.println("*** Tokenizing error: "+e);
        }
    }
}
