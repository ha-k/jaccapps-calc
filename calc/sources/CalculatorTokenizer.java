// FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/calc/CalculatorTokenizer.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . 4j4zn71
// STARTED ON. . Sun Nov 16 06:40:41 2008

// Last modified on Wed Jun 20 14:02:51 2012 by hak

/**
 * CalculatorTokenizer.java
 */

import java.io.*;
import java.util.Date;
import hlt.language.syntax.*;
import hlt.language.io.StreamTokenizer;

public class CalculatorTokenizer implements Tokenizer
{
  BufferedReader reader;
  StreamTokenizer input;
  String file = "stdin";

  CalculatorTokenizer () throws IOException
    {
      setReader(new InputStreamReader(System.in));
      interactive = true;
      banner();
      prompt();
    }

  CalculatorTokenizer (File file) throws IOException
    {
      setReader(new FileReader(file));
      interactive = false;
      banner();
      System.out.println("*** Parsing file: "+file);
    }

  CalculatorTokenizer (String s) throws IOException
    {
      setReader(new StringReader(s));
      interactive = false;
    }

  public final int lineNumber()
    {
      return input.getLineNumber();
    }

  public final void setReader (Reader rd)
    {
      reader = new BufferedReader(rd);
      input = new StreamTokenizer(reader);
      input.ordinaryChars("+-/");
      input.wordChars('_','_');
    }

  public final Reader getReader ()
    {
      return reader;
    }

  public static boolean interactive;
  static String promptString = ">";

  public static final void prompt()
    {
      System.out.print(promptString+" ");
    }

  static public final void setPrompt(String p)
    {
      promptString = p;
    }

  static String banner = "*** Welcome to the number calculator!\n"+
                         "*** Version of "+ (new Date());

  public static final void banner ()
    {
      System.out.println(banner);
    }

  final ParseNode locate (ParseNode node)
    {
      return ((ParseNode)node.setStart(input.tokenStart()).setEnd(input.tokenEnd()))
	.setFile(file);
    }

  public ParseNode nextToken() throws IOException
    {
      ParseNode t = null;
      int token = input.nextToken();
      switch (token)
        {
        case StreamTokenizer.TT_EOF:
          reader.close();
          t = GenericParser.E_O_I;
          break;
        case StreamTokenizer.TT_WORD:
	  if (input.sval == "exit")
	    t = GenericParser.literalToken("exit");
	  else
	    t = GenericParser.symbolToken("IDENTIFIER",input.sval);
          break;
        case StreamTokenizer.TT_NUMBER:
          t = GenericParser.numberToken("NUMBER",input.nval);
          break;
        default:
          char c = (char)token;       
          t = GenericParser.literalToken(String.valueOf(c));
          break;
        }
      return locate(t);
    }
}



