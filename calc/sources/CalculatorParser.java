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


/* ************ */
/* PARSER CLASS */
/* ************ */

public class CalculatorParser extends StaticParser
{
  /* ************************ */
  /* PARSER CLASS CONSTRUCTOR */
  /* ************************ */

  public CalculatorParser (Tokenizer t)
    {
      input = t;
      xmlroot = "Session";
    }

  /* ************************* */
  /* PARSER CLASS DECLARATIONS */
  /* ************************* */

  HashMap defs = new HashMap();


  /* ********************** */
  /* STATIC INITIALIZATIONS */
  /* ********************** */

  static
    {
      initializeTerminals();
      initializeNonTerminals();
      initializeRules();
      initializeParserActions();
      initializeParserStates();
      initializeActionTables();
      initializeGotoTables();
      initializeStateTables();
    }

  /* ********************* */
  /* PARTIAL PARSE METHODS */
  /* ********************* */

  final static ParseNode $SESSION_SWITCH$ = new ParseNode(terminals[3]);

  public final void parseSession (String s) throws IOException
    {
      parseSession(new StringReader(s));
    }

  public final void parseSession (Reader r) throws IOException
    {
      input.setReader(r);
      errorManager().recoverFromErrors(false);
      setSwitchToken($SESSION_SWITCH$);
      parse();
    }

  final static ParseNode $EXPRESSION_SWITCH$ = new ParseNode(terminals[4]);

  public final void parseExpression (String s) throws IOException
    {
      parseExpression(new StringReader(s));
    }

  public final void parseExpression (Reader r) throws IOException
    {
      input.setReader(r);
      errorManager().recoverFromErrors(false);
      setSwitchToken($EXPRESSION_SWITCH$);
      parse();
    }

  final static ParseNode $DEFINITION_SWITCH$ = new ParseNode(terminals[5]);

  public final void parseDefinition (String s) throws IOException
    {
      parseDefinition(new StringReader(s));
    }

  public final void parseDefinition (Reader r) throws IOException
    {
      input.setReader(r);
      errorManager().recoverFromErrors(false);
      setSwitchToken($DEFINITION_SWITCH$);
      parse();
    }

  /* **************** */
  /* SEMANTIC ACTIONS */
  /* **************** */

  protected ParseNode semanticAction(ParserRule $rule$) throws IOException
    {
      ParseNode $head$ = new ParseNode($rule$.head);

      switch($rule$.index())
        {
          case 2:
            {
            $head$ = $head$.copy(node($rule$,2));
            break;
            }
          case 3:
            {
            $head$ = $head$.copy(node($rule$,2));
            break;
            }
          case 4:
            {
            $head$ = $head$.copy(node($rule$,2));
            break;
            }
          case 8:
            {
            currentNode().show(); // show the current parse tree
            if (!Double.isNaN(node($rule$,0).nvalue())) System.out.println(node($rule$,0).nvalue());
            CalculatorTokenizer.prompt();
            break;
            }
          case 10:
            {
            CalculatorDefinition $node1$;
                if (node($rule$,0) instanceof CalculatorDefinition)
                   $node1$ = (CalculatorDefinition)node($rule$,0);
                 else
                 {
                     $node1$ = new CalculatorDefinition(node($rule$,0));
                     replaceStackNode($rule$,0,$node1$);
                   }

            currentNode().show(); // show the current parse tree
            System.out.println($node1$.getMessage());
            CalculatorTokenizer.prompt();
            break;
            }
          case 12:
            {
            errorManager().reportErrors(true);
            CalculatorTokenizer.prompt();
            break;
            }
          case 15:
            {
            Double value = (Double)defs.get(node($rule$,1).svalue());
            if (value == null)
              System.out.println("*** Undefined identifier: "+node($rule$,1).svalue());
            else
              $head$.setNvalue(value.doubleValue());
            break;
            }
          case 16:
            {
            $head$.setNvalue(node($rule$,1).nvalue() + node($rule$,3).nvalue());
            break;
            }
          case 17:
            {
            $head$.setNvalue(node($rule$,1).nvalue() - node($rule$,3).nvalue());
            break;
            }
          case 18:
            {
            $head$.setNvalue(node($rule$,1).nvalue() * node($rule$,3).nvalue());
            break;
            }
          case 19:
            {
            $head$.setNvalue(node($rule$,1).nvalue() / node($rule$,3).nvalue());
            break;
            }
          case 20:
            {
            $head$.setNvalue(- node($rule$,2).nvalue());
            break;
            }
          case 21:
            {
            $head$.setNvalue(node($rule$,2).nvalue());
            break;
            }
          case 22:
            {
            CalculatorDefinition $node0$ = new CalculatorDefinition($head$);
                 $head$ = (CalculatorDefinition)$node0$;

            defs.put(node($rule$,1).svalue(),new Double(node($rule$,3).nvalue()));
            $node0$.setNvalue(node($rule$,3).nvalue());
            $node0$.setSvalue(node($rule$,1).svalue());
            $node0$.setMessage("*** Defined "+$node0$.svalue()+" ("+$node0$.nvalue()+")");
            break;
            }
          case 23:
            {
            System.out.println("*** Bye bye!...");
  	    System.exit(0);
            break;
            }
          case 0: case 1: case 6: 
            break;
          default:
            $head$ = $head$.copy(node($rule$,1));
            break;
        }
      return $head$;
    }

  /* **************** */
  /* TERMINAL SYMBOLS */
  /* **************** */

  static void initializeTerminals ()
    {
      terminals = new ParserTerminal[18];

      newTerminal(0,"$EMPTY$",1,2);
      newTerminal(1,"$E_O_I$",1,2);
      newTerminal(2,"error",1,2);
      newTerminal(3,"$Session_switch$",1,2);
      newTerminal(4,"$Expression_switch$",1,2);
      newTerminal(5,"$Definition_switch$",1,2);
      newTerminal(6,"NUMBER",1,2);
      newTerminal(7,"IDENTIFIER",1,2);
      newTerminal(8,"+",11,0);
      newTerminal(9,"-",11,0);
      newTerminal(10,"*",21,0);
      newTerminal(11,"/",21,0);
      newTerminal(12,"UMINUS",31,1);
      newTerminal(13,";",1,2);
      newTerminal(14,"(",1,2);
      newTerminal(15,")",1,2);
      newTerminal(16,"=",1,2);
      newTerminal(17,"exit",1,2);
    }

  /* ******************** */
  /* NON-TERMINAL SYMBOLS */
  /* ******************** */

  static void initializeNonTerminals ()
    {
      nonterminals = new ParserNonTerminal[12];

      newNonTerminal(0,"$START$");
      newNonTerminal(1,"$ROOTS$");
      newNonTerminal(2,"Session");
      newNonTerminal(3,"Expression");
      newNonTerminal(4,"Definition");
      newNonTerminal(5,"Actions");
      newNonTerminal(6,"Exit");
      newNonTerminal(7,"Action");
      newNonTerminal(8,"$ACTION0$");
      newNonTerminal(9,"$ACTION1$");
      newNonTerminal(10,"$ACTION2$");
      newNonTerminal(11,"$ACTION3$");
    }

  /* **************** */
  /* PRODUCTION RULES */
  /* **************** */

  static void initializeRules ()
    {
      rules = new ParserRule[25];

      rules[0] = new ParserRule(0,1,0,1,2);
      rules[1] = new ParserRule(1,1,1,1,2);
      rules[2] = new ParserRule(1,2,2,1,2);
      rules[3] = new ParserRule(1,2,3,1,2);
      rules[4] = new ParserRule(1,2,4,1,2);
      rules[5] = new ParserRule(2,2,5,1,2);
      rules[6] = new ParserRule(5,0,6,1,2);
      rules[7] = new ParserRule(5,2,7,1,2);
      rules[8] = new ParserRule(8,0,8,1,2);
      rules[9] = new ParserRule(7,3,9,1,2);
      rules[10] = new ParserRule(9,0,10,1,2);
      rules[11] = new ParserRule(7,3,11,1,2);
      rules[12] = new ParserRule(10,0,12,1,2);
      rules[13] = new ParserRule(7,3,13,1,2);
      rules[14] = new ParserRule(3,1,14,1,2);
      rules[15] = new ParserRule(3,1,15,1,2);
      rules[16] = new ParserRule(3,3,16,11,0);
      rules[17] = new ParserRule(3,3,17,11,0);
      rules[18] = new ParserRule(3,3,18,21,0);
      rules[19] = new ParserRule(3,3,19,21,0);
      rules[20] = new ParserRule(3,2,20,31,1);
      rules[21] = new ParserRule(3,3,21,1,2);
      rules[22] = new ParserRule(4,3,22,1,2);
      rules[23] = new ParserRule(11,0,23,1,2);
      rules[24] = new ParserRule(6,3,24,1,2);
    }

  /* ************** */
  /* PARSER ACTIONS */
  /* ************** */

  static void initializeParserActions ()
    {
      actions = new ParserAction[194];

      newAction(0,5,0);
      newAction(1,2,0);
      newAction(2,0,3);
      newAction(3,0,4);
      newAction(4,0,5);
      newAction(5,1,6);
      newAction(6,1,6);
      newAction(7,1,6);
      newAction(8,1,6);
      newAction(9,1,6);
      newAction(10,1,6);
      newAction(11,1,1);
      newAction(12,1,6);
      newAction(13,1,6);
      newAction(14,1,6);
      newAction(15,1,6);
      newAction(16,1,6);
      newAction(17,1,6);
      newAction(18,0,10);
      newAction(19,0,22);
      newAction(20,0,13);
      newAction(21,0,14);
      newAction(22,0,40);
      newAction(23,0,9);
      newAction(24,0,10);
      newAction(25,0,11);
      newAction(26,0,13);
      newAction(27,0,14);
      newAction(28,0,16);
      newAction(29,1,5);
      newAction(30,1,7);
      newAction(31,1,7);
      newAction(32,1,7);
      newAction(33,1,7);
      newAction(34,1,7);
      newAction(35,1,7);
      newAction(36,1,23);
      newAction(37,1,14);
      newAction(38,1,14);
      newAction(39,1,14);
      newAction(40,1,14);
      newAction(41,1,14);
      newAction(42,1,14);
      newAction(43,1,14);
      newAction(44,1,15);
      newAction(45,1,15);
      newAction(46,1,15);
      newAction(47,1,15);
      newAction(48,1,15);
      newAction(49,0,35);
      newAction(50,0,23);
      newAction(51,0,24);
      newAction(52,0,25);
      newAction(53,0,26);
      newAction(54,1,8);
      newAction(55,0,10);
      newAction(56,0,22);
      newAction(57,0,13);
      newAction(58,0,14);
      newAction(59,0,10);
      newAction(60,0,22);
      newAction(61,0,13);
      newAction(62,0,14);
      newAction(63,1,10);
      newAction(64,1,12);
      newAction(65,0,18);
      newAction(66,1,13);
      newAction(67,1,13);
      newAction(68,1,13);
      newAction(69,1,13);
      newAction(70,1,13);
      newAction(71,1,13);
      newAction(72,0,20);
      newAction(73,1,11);
      newAction(74,1,11);
      newAction(75,1,11);
      newAction(76,1,11);
      newAction(77,1,11);
      newAction(78,1,11);
      newAction(79,0,23);
      newAction(80,0,24);
      newAction(81,0,25);
      newAction(82,0,26);
      newAction(83,0,27);
      newAction(84,1,15);
      newAction(85,1,15);
      newAction(86,1,15);
      newAction(87,1,15);
      newAction(88,1,15);
      newAction(89,1,15);
      newAction(90,1,15);
      newAction(91,0,10);
      newAction(92,0,22);
      newAction(93,0,13);
      newAction(94,0,14);
      newAction(95,0,10);
      newAction(96,0,22);
      newAction(97,0,13);
      newAction(98,0,14);
      newAction(99,0,10);
      newAction(100,0,22);
      newAction(101,0,13);
      newAction(102,0,14);
      newAction(103,0,10);
      newAction(104,0,22);
      newAction(105,0,13);
      newAction(106,0,14);
      newAction(107,1,21);
      newAction(108,1,21);
      newAction(109,1,21);
      newAction(110,1,21);
      newAction(111,1,21);
      newAction(112,1,21);
      newAction(113,1,21);
      newAction(114,0,23);
      newAction(115,0,24);
      newAction(116,0,25);
      newAction(117,0,26);
      newAction(118,1,19);
      newAction(119,1,19);
      newAction(120,1,19);
      newAction(121,1,19);
      newAction(122,1,19);
      newAction(123,1,19);
      newAction(124,1,19);
      newAction(125,0,23);
      newAction(126,0,24);
      newAction(127,0,25);
      newAction(128,1,18);
      newAction(129,1,18);
      newAction(130,1,18);
      newAction(131,1,18);
      newAction(132,1,18);
      newAction(133,1,18);
      newAction(134,1,18);
      newAction(135,0,23);
      newAction(136,0,24);
      newAction(137,1,17);
      newAction(138,1,17);
      newAction(139,1,17);
      newAction(140,1,17);
      newAction(141,1,17);
      newAction(142,1,17);
      newAction(143,1,17);
      newAction(144,0,25);
      newAction(145,0,26);
      newAction(146,0,23);
      newAction(147,1,16);
      newAction(148,1,16);
      newAction(149,1,16);
      newAction(150,1,16);
      newAction(151,1,16);
      newAction(152,1,16);
      newAction(153,1,16);
      newAction(154,0,25);
      newAction(155,0,26);
      newAction(156,0,23);
      newAction(157,0,24);
      newAction(158,0,25);
      newAction(159,0,26);
      newAction(160,1,20);
      newAction(161,1,20);
      newAction(162,1,20);
      newAction(163,1,20);
      newAction(164,1,20);
      newAction(165,1,20);
      newAction(166,1,20);
      newAction(167,0,34);
      newAction(168,1,9);
      newAction(169,1,9);
      newAction(170,1,9);
      newAction(171,1,9);
      newAction(172,1,9);
      newAction(173,1,9);
      newAction(174,0,10);
      newAction(175,0,22);
      newAction(176,0,13);
      newAction(177,0,14);
      newAction(178,0,23);
      newAction(179,0,24);
      newAction(180,0,25);
      newAction(181,0,26);
      newAction(182,1,22);
      newAction(183,1,22);
      newAction(184,0,38);
      newAction(185,1,24);
      newAction(186,1,4);
      newAction(187,0,35);
      newAction(188,1,3);
      newAction(189,0,23);
      newAction(190,0,24);
      newAction(191,0,25);
      newAction(192,0,26);
      newAction(193,1,2);
    }

  /* ************* */
  /* PARSER STATES */
  /* ************* */

  static void initializeParserStates ()
    {
      states = new ParserState[43];

      for (int i=0; i<43; i++) newState(i);
    }

  /* ************* */
  /* ACTION TABLES */
  /* ************* */

  static void initializeActionTables ()
    {
      newActionTables(36);

      newActionTable(0,9);
	setAction(0,17,10);
	setAction(0,2,5);
	setAction(0,3,2);
	setAction(0,4,3);
	setAction(0,5,4);
	setAction(0,6,6);
	setAction(0,7,7);
	setAction(0,9,8);
	setAction(0,14,9);

      newActionTable(1,1);
	setAction(1,1,1);

      newActionTable(2,1);
	setAction(2,1,11);

      newActionTable(3,6);
	setAction(3,17,17);
	setAction(3,2,12);
	setAction(3,6,13);
	setAction(3,7,14);
	setAction(3,9,15);
	setAction(3,14,16);

      newActionTable(4,4);
	setAction(4,6,18);
	setAction(4,7,19);
	setAction(4,9,20);
	setAction(4,14,21);

      newActionTable(5,1);
	setAction(5,7,22);

      newActionTable(6,6);
	setAction(6,17,23);
	setAction(6,2,28);
	setAction(6,6,24);
	setAction(6,7,25);
	setAction(6,9,26);
	setAction(6,14,27);

      newActionTable(7,1);
	setAction(7,1,29);

      newActionTable(8,6);
	setAction(8,17,35);
	setAction(8,2,30);
	setAction(8,6,31);
	setAction(8,7,32);
	setAction(8,9,33);
	setAction(8,14,34);

      newActionTable(9,1);
	setAction(9,13,36);

      newActionTable(10,7);
	setAction(10,1,37);
	setAction(10,8,38);
	setAction(10,9,39);
	setAction(10,10,40);
	setAction(10,11,41);
	setAction(10,13,42);
	setAction(10,15,43);

      newActionTable(11,6);
	setAction(11,16,49);
	setAction(11,8,44);
	setAction(11,9,45);
	setAction(11,10,46);
	setAction(11,11,47);
	setAction(11,13,48);

      newActionTable(12,5);
	setAction(12,8,50);
	setAction(12,9,51);
	setAction(12,10,52);
	setAction(12,11,53);
	setAction(12,13,54);

      newActionTable(13,1);
	setAction(13,13,63);

      newActionTable(14,1);
	setAction(14,13,64);

      newActionTable(15,1);
	setAction(15,13,65);

      newActionTable(16,6);
	setAction(16,17,71);
	setAction(16,2,66);
	setAction(16,6,67);
	setAction(16,7,68);
	setAction(16,9,69);
	setAction(16,14,70);

      newActionTable(17,1);
	setAction(17,13,72);

      newActionTable(18,6);
	setAction(18,17,78);
	setAction(18,2,73);
	setAction(18,6,74);
	setAction(18,7,75);
	setAction(18,9,76);
	setAction(18,14,77);

      newActionTable(19,5);
	setAction(19,8,79);
	setAction(19,9,80);
	setAction(19,10,81);
	setAction(19,11,82);
	setAction(19,15,83);

      newActionTable(20,7);
	setAction(20,1,84);
	setAction(20,8,85);
	setAction(20,9,86);
	setAction(20,10,87);
	setAction(20,11,88);
	setAction(20,13,89);
	setAction(20,15,90);

      newActionTable(21,7);
	setAction(21,1,107);
	setAction(21,8,108);
	setAction(21,9,109);
	setAction(21,10,110);
	setAction(21,11,111);
	setAction(21,13,112);
	setAction(21,15,113);

      newActionTable(22,7);
	setAction(22,1,118);
	setAction(22,8,119);
	setAction(22,9,120);
	setAction(22,10,121);
	setAction(22,11,122);
	setAction(22,13,123);
	setAction(22,15,124);

      newActionTable(23,7);
	setAction(23,1,128);
	setAction(23,8,129);
	setAction(23,9,130);
	setAction(23,10,131);
	setAction(23,11,132);
	setAction(23,13,133);
	setAction(23,15,134);

      newActionTable(24,7);
	setAction(24,1,137);
	setAction(24,8,138);
	setAction(24,9,139);
	setAction(24,10,144);
	setAction(24,11,145);
	setAction(24,13,142);
	setAction(24,15,143);

      newActionTable(25,7);
	setAction(25,1,147);
	setAction(25,8,148);
	setAction(25,9,149);
	setAction(25,10,154);
	setAction(25,11,155);
	setAction(25,13,152);
	setAction(25,15,153);

      newActionTable(26,7);
	setAction(26,1,160);
	setAction(26,8,161);
	setAction(26,9,162);
	setAction(26,10,163);
	setAction(26,11,164);
	setAction(26,13,165);
	setAction(26,15,166);

      newActionTable(27,1);
	setAction(27,13,167);

      newActionTable(28,6);
	setAction(28,17,173);
	setAction(28,2,168);
	setAction(28,6,169);
	setAction(28,7,170);
	setAction(28,9,171);
	setAction(28,14,172);

      newActionTable(29,6);
	setAction(29,1,182);
	setAction(29,8,178);
	setAction(29,9,179);
	setAction(29,10,180);
	setAction(29,11,181);
	setAction(29,13,183);

      newActionTable(30,1);
	setAction(30,13,184);

      newActionTable(31,1);
	setAction(31,1,185);

      newActionTable(32,1);
	setAction(32,1,186);

      newActionTable(33,1);
	setAction(33,16,187);

      newActionTable(34,5);
	setAction(34,1,188);
	setAction(34,8,189);
	setAction(34,9,190);
	setAction(34,10,191);
	setAction(34,11,192);

      newActionTable(35,1);
	setAction(35,1,193);

    }

  /* *********** */
  /* GOTO TABLES */
  /* *********** */

  static void initializeGotoTables ()
    {
      newGotoTables(17);

      newGotoTable(0,3);
	setGoto(0,1,1);
	setGoto(0,2,2);
	setGoto(0,5,6);

      newGotoTable(1,0);

      newGotoTable(2,2);
	setGoto(2,2,42);
	setGoto(2,5,6);

      newGotoTable(3,1);
	setGoto(3,3,41);

      newGotoTable(4,1);
	setGoto(4,4,39);

      newGotoTable(5,4);
	setGoto(5,3,12);
	setGoto(5,4,15);
	setGoto(5,6,7);
	setGoto(5,7,8);

      newGotoTable(6,1);
	setGoto(6,11,37);

      newGotoTable(7,1);
	setGoto(7,8,33);

      newGotoTable(8,1);
	setGoto(8,3,32);

      newGotoTable(9,1);
	setGoto(9,3,21);

      newGotoTable(10,1);
	setGoto(10,9,19);

      newGotoTable(11,1);
	setGoto(11,10,17);

      newGotoTable(12,1);
	setGoto(12,3,31);

      newGotoTable(13,1);
	setGoto(13,3,30);

      newGotoTable(14,1);
	setGoto(14,3,29);

      newGotoTable(15,1);
	setGoto(15,3,28);

      newGotoTable(16,1);
	setGoto(16,3,36);

    }

  /* ************ */
  /* STATE TABLES */
  /* ************ */

  static void initializeStateTables ()
    {
      setTables(0,0,0);
      setTables(1,1,1);
      setTables(2,2,1);
      setTables(3,3,2);
      setTables(4,4,3);
      setTables(5,5,4);
      setTables(6,6,5);
      setTables(7,7,1);
      setTables(8,8,1);
      setTables(9,9,6);
      setTables(10,10,1);
      setTables(11,11,1);
      setTables(12,12,7);
      setTables(13,4,8);
      setTables(14,4,9);
      setTables(15,13,10);
      setTables(16,14,11);
      setTables(17,15,1);
      setTables(18,16,1);
      setTables(19,17,1);
      setTables(20,18,1);
      setTables(21,19,1);
      setTables(22,20,1);
      setTables(23,4,12);
      setTables(24,4,13);
      setTables(25,4,14);
      setTables(26,4,15);
      setTables(27,21,1);
      setTables(28,22,1);
      setTables(29,23,1);
      setTables(30,24,1);
      setTables(31,25,1);
      setTables(32,26,1);
      setTables(33,27,1);
      setTables(34,28,1);
      setTables(35,4,16);
      setTables(36,29,1);
      setTables(37,30,1);
      setTables(38,31,1);
      setTables(39,32,1);
      setTables(40,33,1);
      setTables(41,34,1);
      setTables(42,35,1);
    }
}
