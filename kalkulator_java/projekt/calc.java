import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class calc {

    @FXML
    private Button division;

    @FXML
    private Button eight;

    @FXML
    private Button equal;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button minus;

    @FXML
    private Button multiply;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button period;

    @FXML
    private Button delete;

    @FXML
    private Button undo;

    @FXML
    private Button plus;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private TextField textField;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button zero;

    private float wynik=0;
    private float value=0;
    private String symbol="+";

    private void policz()
    {
        if(symbol=="+")
        {
            if (symbol!="=")
            {
                if(textField.getText().equals(""))
                {
                    textField.setText("");
                }
                else if (textField.getText()!="")
                {
                    symbol="+";
                    value=Float.parseFloat(textField.getText());
                    wynik+=value;
                    textField.setText("");
                }
            }
            else
            {
                value=0;
                symbol="+";
                textField.setText("");
            }
        }
        else if(symbol=="-")
        {
            if (symbol!="=")
            {
                if(textField.getText().equals(""))
                {
                    textField.setText("");
                }
                else if (textField.getText()!="")
                {
                    symbol="-";
                    value=Float.parseFloat(textField.getText());
                    if(wynik==0)
                    {
                        wynik=value;
                        textField.setText("");
                    }
                    else
                    {
                        wynik=wynik-value;
                        textField.setText("");
                    }
                }
            }
            else
            {
                value=0;
                symbol="-";
                textField.setText("");
            }
        }
        else if(symbol=="*")
        {
            if (symbol!="=")
            {
                if(textField.getText().equals(""))
                {
                    textField.setText("");
                }
                else if (textField.getText()!="")
                {
                    symbol="*";
                    value=Float.parseFloat(textField.getText());
                    if (wynik==0)
                    {
                        wynik=1;
                    }
                    wynik=wynik*value;
                    textField.setText("");
                }
            }
            else
            {
                value=0;
                symbol="*";
                textField.setText("");
            }
        }
        else if(symbol=="/")
        {
            if (symbol!="=")
            {
                if(textField.getText().equals(""))
                {
                    textField.setText("");
                }
                else if (textField.getText()!="")
                {
                    symbol="/";
                    value=Float.parseFloat(textField.getText());
                    if (wynik==0)
                    {
                        wynik=value;
                        textField.setText("");
                    }
                    else
                    {
                        wynik=wynik/value;
                        textField.setText("");
                    } 
                }
            }
            else
            {
                value=0;
                symbol="/";
                textField.setText("");
            }
        }
        else if(symbol=="=")
        {
            textField.setText("");
        }
    }

    @FXML
    void changeText(ActionEvent event)
    {
        undo.setDisable(false);
        if (textField.getText().equals("0"))
        {
            textField.setText("");
        }
        else if (textField.getText().equals("."))
        {
            textField.setText(".");
        }

        String value=((Button)event.getSource()).getText();
        textField.setText(textField.getText()+value);
    }

    @FXML
    void dodaj(ActionEvent event)
    {
        policz();
        symbol="+";
    }

    @FXML
    void odejmij(ActionEvent event) 
    {
        policz();
        symbol="-";
    }

    @FXML
    void pomnoz(ActionEvent event) 
    {
        policz();
        symbol="*";
    }

    @FXML
    void podziel(ActionEvent event) 
    {
        policz();
        symbol="/";
    }


    @FXML
    void wynik(ActionEvent event)
    {
        undo.setDisable(true);
        if (symbol=="+")
        {
            wynik+=Float.parseFloat(textField.getText());
            textField.setText(Float.toString(wynik));
            value=0;
            symbol="=";
        }
        else if(symbol=="-")
        {
            wynik-=Float.parseFloat(textField.getText());
            textField.setText(Float.toString(wynik));
            value=0;
            symbol="=";
        }
        else if(symbol=="*")
        {
            wynik*=Float.parseFloat(textField.getText());
            textField.setText(Float.toString(wynik));
            value=0;
            symbol="=";
        }
        else if(symbol=="/")
        {   
            if(textField.getText().equals("0"))
            {
                textField.setText("Nie dziel przez 0");
            }
            else
            {
                wynik/=Float.parseFloat(textField.getText());
                textField.setText(Float.toString(wynik));
                value=0;
                symbol="=";
            }
            
        }
    }


    @FXML
    void undoText(ActionEvent event) 
    {
        if(symbol!="=")
        {
            if(textField.getText().equals(""))
            {
                textField.setText("");
            }
            else
            {
                String nowy=textField.getText().substring(0,textField.getText().length()-1);
                textField.setText(nowy);
            }
        }
    }


    @FXML 
    void deleteText(ActionEvent event)
    {
        textField.setFont(Font.font(37));
        undo.setDisable(true);
        wynik=0;
        value=0;
        textField.setText("0");
        symbol="+";
    }
}
