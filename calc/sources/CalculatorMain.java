// FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/calc/sources/CalculatorMain.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . Hp-Dv7
// STARTED ON. . Sun Oct 14 20:56:42 2012

// Last modified on Sun Oct 14 20:56:57 2012 by hak

/**
 * CalculatorMain.java
 */

import java.io.File;

public class CalculatorMain
{
  public static void main (String args[])
    {
      try
        {
          CalculatorTokenizer t;
          
          if(args.length>0)
            t = new CalculatorTokenizer(new File(args[0]));
          else
            t = new CalculatorTokenizer();

          try
            { // arg to parse is to enable building the parse tree
              // - COMPACT_TREE for the trimmed version
              CalculatorParser p = new CalculatorParser(t);
              p.parse(p.COMPACT_TREE);
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



