package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/**
 * Created by USER on 01.12.2017.
 */
public class TextFieldTest extends JFrame {
    JLabel countLabel;
    JLabel creator;
    JButton checkBar;
    JButton findLast;
    JTextField inputBar;
    public static String barcode;
    public static int counter;
    public static String result;
    public static String answer;


    public TextFieldTest() {
        super("Barcode reader");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        inputBar = new JTextField(15);

        JPanel contents = new JPanel();
        contents.setLayout(new GridBagLayout());

        countLabel = new JLabel("Введите штрих код:");
        contents.add(countLabel, new GridBagConstraints(0,0,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));

        contents.add(inputBar, new GridBagConstraints(1,0,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        checkBar = new JButton("Проверить штрих код");
        contents.add(checkBar, new GridBagConstraints(0,1,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        countLabel = new JLabel("Разработчик: Смирнов Вячеслав");
        contents.add(countLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        ActionListener actionListener = e -> {
            barcode = inputBar.getText();
            counter = Calculating.counter(barcode);
            result = Calculating.typeBarcode(Calculating.counter);
            if (result.equals("Штрих код ни относится не к EAN-8, не к EAN-13, не к UPC-10, не к UPC-12, не к UPC-14.")) {
                JOptionPane.showMessageDialog(TextFieldTest.this,
                        "Штрих код ни относится не к EAN-8, не к EAN-13, не к UPC-10, не к UPC-12, не к UPC-14.");
            } else {
                Calculating.summaEven = Calculating.checkBoxEven(barcode);
                Calculating.summaEvenx3 = Calculating.x3(Calculating.summaEven);
                Calculating.summaOdd = Calculating.checkBoxOdd(barcode);
                Calculating.summaOddEven = Calculating.checkBoxOddEven(Calculating.summaEvenx3, Calculating.summaOdd);
                Calculating.last = Calculating.last(barcode);
                Calculating.answer = Calculating.test(Calculating.summaOddEven, Calculating.last);

                if (Calculating.answer) {
                    answer = "Штрих код записон правильно!";
                } else {
                    answer = "Штрих код записон неверно!";
                }

                if (Calculating.answer) {
                    if(Calculating.counter == 8){
                        Calculating.codeProduct = Calculating.isCodeProduct8(barcode);
                        Calculating.codeProd= Calculating.isCodeProd8(barcode);
                        Calculating.codeCountry = Calculating.isCodeCountry8(barcode);
                        Calculating.discoverCountry = Calculating.isDiscoverCountry(Calculating.codeCountry);
                    }else if(Calculating.counter == 13){
                        Calculating.codeProduct = Calculating.isCodeProduct13(barcode);
                        Calculating.codeProd= Calculating.isCodeProd13(barcode);
                        Calculating.codeCountry = Calculating.isCodeCountry8(barcode);
                        Calculating.discoverCountry = Calculating.isDiscoverCountry(Calculating.codeCountry);
                    }else if(Calculating.counter == 12){
                        Calculating.codeProduct = Calculating.isCodeProduct13(barcode);
                        Calculating.codeProd= Calculating.isCodeProd12(barcode);
                        Calculating.codeCountry = Calculating.isCodeCountry8(barcode);
                        Calculating.discoverCountry = Calculating.isDiscoverCountry(Calculating.codeCountry);
                    }else if(Calculating.counter == 10){
                        Calculating.codeProduct = Calculating.isCodeProduct13(barcode);
                        Calculating.codeProd= Calculating.isCodeProd10(barcode);
                        Calculating.codeCountry = Calculating.isCodeCountry8(barcode);
                        Calculating.discoverCountry = Calculating.isDiscoverCountry(Calculating.codeCountry);
                    }else if(Calculating.counter == 14){
                        Calculating.codeProduct = Calculating.isCodeProduct13(barcode);
                        Calculating.codeProd= Calculating.isCodeProd14(barcode);
                        Calculating.codeCountry = Calculating.isCodeCountry8(barcode);
                        Calculating.discoverCountry = Calculating.isDiscoverCountry(Calculating.codeCountry);
                    }
                    JOptionPane.showMessageDialog(TextFieldTest.this,
                            "Ваш штрих код: " + inputBar.getText() + "\n" + "Число разрядов = " + Calculating.counter + "\n" + result + "\n" + "Cумма четных = " + Calculating.summaEven + "\n" +
                                    "Сумма нечетных =" + Calculating.summaOdd + "\n" + "Сумма нечетных и (сумма четных * 3) = " + Calculating.summaOddEven + "\n" + "Контрольная цифра = " + Calculating.last
                                    + "\n" +"(Конечная сумма + Контрольная цифра)%10 = 0 "+"\n"
                                    + answer+ "\n"+"Код товара = "+ Calculating.codeProduct+ "\n"+"Код производителя = "+ Calculating.codeProd+ "\n"+"Код страны = "+ Calculating.codeCountry+ "\n"+"Страна = "+ Calculating.discoverCountry);
                    //JOptionPane.showMessageDialog(TextFieldTest.this,
                    //        answer);
                }else{
                    JOptionPane.showMessageDialog(TextFieldTest.this,  "\n" + "Число разрядов = " + Calculating.counter + "\n" + result + "\n" + "Cумма четных = " + Calculating.summaEven + "\n" +
                            "Сумма нечетных =" + Calculating.summaOdd + "\n" + "Сумма нечетных и (сумма четных * 3) = " + Calculating.summaOddEven + "\n" + "Контрольная цифра = " + Calculating.last
                            + "\n" +"(Конечная сумма + Контрольная цифра)%10 != 0 "+"\n"+answer);
                    //JOptionPane.showMessageDialog(TextFieldTest.this,
                    //        answer);

                }
            }
            Calculating.counter = 0;
        };

        checkBar.addActionListener(actionListener);
        findLast = new JButton("Найти контрольный разряд");
        contents.add(findLast, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        ActionListener actionListener1 = e -> {
            barcode = inputBar.getText();
            counter = Calculating.counter(barcode);
            if (Calculating.counter == 7 || Calculating.counter == 12 || Calculating.counter == 11 || Calculating.counter == 13 || Calculating.counter == 9) {
                Calculating.getLast = Calculating.isGetLast(barcode);
                JOptionPane.showMessageDialog(TextFieldTest.this,
                        "Контрольная цифра = "+ Calculating.getLast);
            } else {
                JOptionPane.showMessageDialog(TextFieldTest.this,
                        "Неправильный формат штрих код");
            }

            Calculating.counter = 0;
        };
        findLast.addActionListener(actionListener1);
        setContentPane(contents);
        pack();
        setVisible(true);
    }
}
