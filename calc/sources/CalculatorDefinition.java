// *******************************************************************
// This file has been automatically generated from the grammar in file
// Calculator.grm by hlt.language.syntax.ParserGenerator on
// Thu Mar 29 08:47:58 CEST 2018 --- !!! PLEASE DO NO EDIT !!!
// *******************************************************************

import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import hlt.language.syntax.*;
import java.util.HashMap;

public class CalculatorDefinition extends ParseNode implements Cloneable
{
  public CalculatorDefinition (ParseNode node)
    {
      super(node);
    }

  private String message;

  public String getMessage()
    {
      return message;
    }

  public void setMessage(String msg)
    {
      message = msg;
    }
}
