import java.awt.*;
import java.util.Stack;
import javax.swing.*;

public class L02_Kalkulator extends JFrame 
{
    private JButton button_1 = new JButton("1");
    private JButton button_2 = new JButton("2");
    private JButton button_3 = new JButton("3");
    private JButton button_4 = new JButton("4");
    private JButton button_5 = new JButton("5");
    private JButton button_6 = new JButton("6");
    private JButton button_7 = new JButton("7");
    private JButton button_8 = new JButton("8");
    private JButton button_9 = new JButton("9");
    private JButton button_0 = new JButton("0");
    private JButton button_C = new JButton("C");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonDivide = new JButton("/");
    private JButton buttonMultiply = new JButton("*");
    private JButton buttonEquals = new JButton("=");
    private JButton button_BACKSPACE = new JButton("BACKSPACE");
    private JTextField textScreen;

    private StringBuilder expression = new StringBuilder();
    private boolean isResultDisplayed = false;

    public L02_Kalkulator() 
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());

        textScreen = new JTextField();
        textScreen.setEditable(false);
        mainPanel.add(textScreen, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 4));
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(button_C);
        buttonPanel.add(button_7);
        buttonPanel.add(button_8);
        buttonPanel.add(button_9);
        buttonPanel.add(buttonMinus);
        buttonPanel.add(button_4);
        buttonPanel.add(button_5);
        buttonPanel.add(button_6);
        buttonPanel.add(buttonPlus);
        buttonPanel.add(button_1);
        buttonPanel.add(button_2);
        buttonPanel.add(button_3);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(new JLabel());
        buttonPanel.add(button_0);
        buttonPanel.add(new JLabel());
        buttonPanel.add(buttonDivide);
        buttonPanel.add(button_BACKSPACE);
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(buttonEquals);
        
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        setContentPane(mainPanel);
        pack();
        setVisible(true);

        addNumberAction(button_0, "0");
        addNumberAction(button_1, "1");
        addNumberAction(button_2, "2");
        addNumberAction(button_3, "3");
        addNumberAction(button_4, "4");
        addNumberAction(button_5, "5");
        addNumberAction(button_6, "6");
        addNumberAction(button_7, "7");
        addNumberAction(button_8, "8");
        addNumberAction(button_9, "9");

        addOperatorAction(buttonPlus, "+");
        addOperatorAction(buttonMinus, "-");
        addOperatorAction(buttonMultiply, "*");
        addOperatorAction(buttonDivide, "/");

        buttonEquals.addActionListener(e -> calculate());
        button_C.addActionListener(e -> clearScreen());
        button_BACKSPACE.addActionListener(e -> backspace());
    }

    private void addNumberAction(JButton button, String number) 
    {
        button.addActionListener(e -> 
        {
            if (isResultDisplayed) 
            {
                expression.setLength(0);
                isResultDisplayed = false;
            }
            expression.append(number);
            textScreen.setText(expression.toString());
        });
    }

    private void addOperatorAction(JButton button, String operator) 
    {
        button.addActionListener(e -> 
        {
            if (isResultDisplayed) 
            {
                isResultDisplayed = false;
            }
            if (expression.length() > 0 && !Character.isDigit(expression.charAt(expression.length() - 1))) 
            {
                return;
            }
            expression.append(operator);
            textScreen.setText(expression.toString());
        });
    }

    private void calculate() 
    {
        if (expression.length() > 0) 
        {
            try 
            {
                double result = evaluateExpression(expression.toString());
                textScreen.setText(String.valueOf(result));
                expression.setLength(0);
                expression.append(result);
                isResultDisplayed = true;
            } 
            catch (Exception e) 
            {
                textScreen.setText("Error");
                expression.setLength(0);
            }
        }
    }

    private double evaluateExpression(String exp) 
    {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < exp.length(); i++) 
        {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) 
            {
                StringBuilder sbuf = new StringBuilder();
                while (i < exp.length() && (Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.'))
                {
                    sbuf.append(exp.charAt(i++));
                }
                i--;
                numbers.push(Double.parseDouble(sbuf.toString()));
            } 
            else if (c == '+' || c == '-' || c == '*' || c == '/') 
            {
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) 
                {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) 
        {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    private boolean hasPrecedence(char op1, char op2) 
    {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
        {
            return false;
        }
        return true;
    }

    private double applyOperator(char operator, double b, double a) 
    {
        switch (operator) 
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

    private void clearScreen() 
    {
        expression.setLength(0);
        textScreen.setText("");
        isResultDisplayed = false;
    }

    private void backspace() 
    {
        if (expression.length() > 0 && !isResultDisplayed) 
        {
            expression.deleteCharAt(expression.length() - 1);
            textScreen.setText(expression.toString());
        }
    }

    public static void main(String[] args) 
    {
        new L02_Kalkulator();
    }
}