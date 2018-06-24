package com.company;

/**
 * Created by USER on 02.12.2017.
 */
public  class Calculating {
    public static String barcode;
    public static int counter;
    public static long summaEvenx3;
    public static long summaEven;
    public static long summaOdd;
    public static long summaOddEven;
    public static long last;
    public static boolean answer;
    public static long getLast;
    public static long codeCountry;
    public static String codeProd;
    public static String codeProduct;
    public static String discoverCountry;

    Calculating(String barcode, int counter) {
        this.barcode = barcode;
        this.counter = counter;
    }


    public static String typeBarcode(int counter) {
        if (counter == 8) {
            return "Штрих код относится к группе EAN-8 ";
        } else if (counter == 13) {
            return "Штрих код относится к группе EAN-13 ";
        } else if (counter == 10) {
            return "Штрих код относится к группе UPC-10 ";
        } else if (counter == 12) {
            return "Штрих код относится к группе UPC-12 ";
        } else if (counter == 14) {
            return "Штрих код относится к группе UPC-14 ";
        }
        return "Штрих код ни относится не к EAN-8, не к EAN-13, не к UPC-10, не к UPC-12, не к UPC-14.";
    }

    public static int counter(String barcode) {
        counter = barcode.length();
        return counter;
    }

    public static long checkBoxEven(String barcode) {
        long barcodeF = Long.parseLong(barcode);
        long summa = 0;
        long rest;
        barcodeF = barcodeF / 10;
        while (barcodeF > 0) {
            rest = barcodeF % 10;
            summa = summa + (rest);
            barcodeF = barcodeF / 10;
            barcodeF = barcodeF / 10;
        }
        return summa;
    }

    public static long x3(long summa) {
        long summax3 = summa * 3;
        return summax3;
    }

    public static long checkBoxOdd(String barcode) {
        long barcodeF = Long.parseLong(barcode);
        long summa = 0;
        long rest;
        barcodeF = barcodeF / 100;
        while (barcodeF > 0) {
            rest = barcodeF % 10;
            summa = summa + (rest);
            barcodeF = barcodeF / 10;
            barcodeF = barcodeF / 10;
        }
        return summa;
    }

    public static long checkBoxOddEven(long summaEvenx3, long summaOdd) {
        long summa = 0;
        summa = summaEvenx3 + summaOdd;
        return summa;
    }

    public static long last(String barcode) {
        long last;
        long barcodeF = Long.parseLong(barcode);
        last = barcodeF % 10;
        return last;
    }

    public static boolean test(long summaOddEven, long last) {

        if ((summaOddEven + last) % 10 == 0) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }

    public static long isGetLast(String barcode) {
        long barcodeF = Long.parseLong(barcode);
        barcodeF = barcodeF * 10;
        String barcodeF10 = String.valueOf(barcodeF);
        summaEven = checkBoxEven(barcodeF10);
        summaEvenx3 = x3(summaEven);
        summaOdd = checkBoxOdd(barcodeF10);
        summaOddEven = checkBoxOddEven(summaEvenx3, summaOdd);
        for (int i = 0; i < 10; i++) {
            if ((summaOddEven + i) % 10 == 0) {
                return i;
            }
        }
        return 0;
    }


    public static String isCodeProduct13(String barcode) {
        long barcodeF = Long.parseLong(barcode);
        long rest1;
        long rest2;
        long rest3;
        barcodeF = barcodeF / 10;
        codeProduct = "";
        rest1 = barcodeF % 10;
        barcodeF = barcodeF / 10;
        rest2 = barcodeF % 10;
        barcodeF = barcodeF / 10;
        rest3 = barcodeF % 10;
        codeProduct = codeProduct + rest3 + rest2 + rest1;
        return codeProduct;
    }

    public static String isCodeProduct8(String barcode) {

        String codeProductForReturn = "";
        char[] barCodeChar = barcode.toCharArray();
        for (int i = 5; i < 7; i++) {
            codeProductForReturn = codeProductForReturn + barCodeChar[i];
        }

        return codeProductForReturn;
    }

    public static String isCodeProd13(String barcode) {

        String codeProductForReturn = "";
        char[] barCodeChar = barcode.toCharArray();
        for (int i = 3; i < 9; i++) {
            codeProductForReturn = codeProductForReturn + barCodeChar[i];
        }

        return codeProductForReturn;
    }

    public static String isCodeProd8(String barcode) {

        String codeProductForReturn = "";
        char[] barCodeChar = barcode.toCharArray();
        for (int i = 3; i < 5; i++) {
            codeProductForReturn = codeProductForReturn + barCodeChar[i];
        }

        return codeProductForReturn;
    }

    public static String isCodeProd10(String barcode) {
        /*long barcodeF = Long.parseLong(barcode);
        long rest1 = 0;
        long rest2 = 0;
        long rest3 = 0;
        barcodeF = barcodeF / 10000;
        codeProd = "";
        rest1 = barcodeF % 10;
        barcodeF = barcodeF / 10;
        rest2 = barcodeF % 10;
        barcodeF = barcodeF / 10;
        rest3 = barcodeF % 10;
        codeProd = codeProd + rest3 + rest2+rest1;*/

        String codeProdForReturn = "";
        char[] barCodeChar = barcode.toCharArray();
        for (int i = 3; i < 6; i++) {
            codeProdForReturn = codeProdForReturn + barCodeChar[i];
        }

        return codeProdForReturn;
    }


    public static String isCodeProd12(String barcode) {


        String codeProductForReturn = "";
        char[] barCodeChar = barcode.toCharArray();
        for (int i = 3; i < 8; i++) {
            codeProductForReturn = codeProductForReturn + barCodeChar[i];
        }

        return codeProductForReturn;
    }
    public static String isCodeProd14(String barcode) {


        String codeProdForReturn = "";
        char[] barCodeChar = barcode.toCharArray();
        for (int i = 3; i < 10; i++) {
            codeProdForReturn = codeProdForReturn + barCodeChar[i];
        }

        return codeProdForReturn;
    }


    public static long isCodeCountry13(String  barcode) {
        String codeCountryForReturn = "";
        char[]barCodeChar = barcode.toCharArray();
        for (int i = 0; i < 3; i++) {
            codeCountryForReturn = codeCountryForReturn + barCodeChar[i];
        }

        Long codeCountryForReturnLong = Long.parseLong(codeCountryForReturn);

        return codeCountryForReturnLong;
    }

    public static long isCodeCountry8(String barcode) {

       String codeCountryForReturn = "";
        char[]barCodeChar = barcode.toCharArray();
        for (int i = 0; i < 3; i++) {
            codeCountryForReturn = codeCountryForReturn + barCodeChar[i];
        }

        Long codeCountryForReturnLong = Long.parseLong(codeCountryForReturn);

        return codeCountryForReturnLong;
    }



    public static String isDiscoverCountry(long codeCountry) {
        int i;
        for (i = 0; i < 140; i++) {
            if (codeCountry ==
                    i) {
                discoverCountry = "США";
                break;
            }

        }

        for (i = 300; i < 380; i++) {
            if (codeCountry == i) {
                discoverCountry = "Франция";
                break;
            }

        }

        for (i = 400; i < 441; i++) {
            if (codeCountry == i) {
                discoverCountry = "Германия";
                break;
            }

        }


        for (i = 460; i < 469; i++) {
            if (codeCountry == i) {
                discoverCountry = "Россия";
                break;
            }

        }
        for (i = 500; i < 510; i++) {
            if (codeCountry == i) {
                discoverCountry = "Великобритания";
                break;
            }

        }

        for (i = 540; i < 550; i++) {
            if (codeCountry == i) {
                discoverCountry = "Люксембург или Бельгия";
                break;
            }

        }
        for (i = 570; i < 580; i++) {
            if (codeCountry == i) {
                discoverCountry = "Дания";
                break;
            }

        }
        for (i = 640; i < 650; i++) {
            if (codeCountry == i) {
                discoverCountry = "Финляндия";
                break;
            }

        }
        for (i = 700; i < 710; i++) {
            if (codeCountry == i) {
                discoverCountry = "Норвегия";
                break;
            }

        }
        for (i = 730; i < 740; i++) {
            if (codeCountry == i) {
                discoverCountry = "Швеция";
                break;
            }
        }

        for (i = 800; i < 840; i++) {
            if (codeCountry == i) {
                discoverCountry = "Италия";
                break;
            }
        }
        for (i = 840; i < 850; i++) {
            if (codeCountry == i) {
                discoverCountry = "Испания";
                break;
            }

        }
        for (i = 870; i < 880; i++) {
            if (codeCountry == i) {
                discoverCountry = "Нидерланды";
                break;
            }

        }
        for (i = 900; i < 920; i++) {
            if (codeCountry == i) {
                discoverCountry = "Австрия";
                break;
            }
        }
        for (i = 490; i < 500; i++) {
            if (codeCountry == i) {
                discoverCountry = "Япония";
                break;
            }

        }

        for (i = 690; i < 696; i++) {
            if (codeCountry == i) {
                discoverCountry = "Китай";
                break;
            }
        }
        for (i = 754; i < 756; i++) {
            if (codeCountry == i) {
                discoverCountry = "Канада";
                break;
            }
        }
        for (i = 789; i < 791; i++) {
            if (codeCountry == i) {
                discoverCountry = "Бразилия";
                break;
            }
        }
        for (i = 600; i < 602; i++) {
            if (codeCountry == i) {
                discoverCountry = "ЮАР";
                break;
            }
        }
        for (i = 930; i < 940; i++) {
            if (codeCountry == i) {
                discoverCountry = "Австралия";
                break;
            }
        }
        for (i = 940; i < 950; i++) {
            if (codeCountry == i) {
                discoverCountry = "Новая Зеландия";
                break;
            }
        }

        switch ((int)codeCountry){
            case 380: discoverCountry = "Болгария";
            case 383: discoverCountry = "Словения";
            case 385: discoverCountry = "Хорватия";
            case 387: discoverCountry = "Босния и Герцеговина";
            case 474: discoverCountry = "Эстония";
            case 475: discoverCountry = "Латвия";
            case 477: discoverCountry = "Литва";
            case 481: discoverCountry = "Беларусь";
            case 482: discoverCountry = "Укранина";
            case 484: discoverCountry = "Молдавия";
            case 520: discoverCountry = "Греция";
            case 530: discoverCountry = "Албания";
            case 531: discoverCountry = "Македония";
            case 535: discoverCountry = "Мальта";
            case 539: discoverCountry = "Ирландия";
            case 560: discoverCountry = "Люксембург";
            case 569: discoverCountry = "Португалия";
            case 590: discoverCountry = "Исландия";
            case 594: discoverCountry = "Румыния";
            case 599: discoverCountry = "Венгрия";
            case 470: discoverCountry = "Киргизия";
            case 476: discoverCountry = "Азербайджан";
            case 478: discoverCountry = "Узбекистан";
            case 479: discoverCountry = "Шри-Ланка";
            case 480: discoverCountry = "Филиппины";
            case 485: discoverCountry = "Армения";
            case 486: discoverCountry = "Грузия";
            case 487: discoverCountry = "Казахстан";
            case 488: discoverCountry = "Таджикистан";
            case 528: discoverCountry = "Ливан";
            case 529: discoverCountry = "Кипр";
            case 608: discoverCountry = "Бахрейн";
            case 621: discoverCountry = "Сирия";
            case 625: discoverCountry = "Иордания";
            case 626: discoverCountry = "Иран";
            case 627: discoverCountry = "Кувейт";
            case 628: discoverCountry = "Саудовская Аравия";
            case 629: discoverCountry = "ОАЭ";
            case 729: discoverCountry = "Израиль";
            case 865: discoverCountry = "Монголия";
            case 867: discoverCountry = "КНДР";
            case 869: discoverCountry = "Турция";
            case 880: discoverCountry = "Республика Корея";
            case 884: discoverCountry = "Камбоджа";
            case 885: discoverCountry = "Таиланд";
            case 888: discoverCountry = "Сингапур";
            case 858: discoverCountry = "Словакия";
            case 859: discoverCountry = "Чехия";
            case 860: discoverCountry = "Сербия";
            case 890: discoverCountry = "Индия";
            case 893: discoverCountry = "Вьетнам";
            case 899: discoverCountry = "Индонезия";
            case 955: discoverCountry = "Малайзия";
            case 740: discoverCountry = "Гватемала";
            case 741: discoverCountry = "Сальвадор";
            case 742: discoverCountry = "Гондурас";
            case 743: discoverCountry = "Никарагуа";
            case 744: discoverCountry = "Коста-Рика";
            case 745: discoverCountry = "Панама";
            case 746: discoverCountry = "Доминиканская Республика";
            case 750: discoverCountry = "Мексика";
            case 850: discoverCountry = "Куба";
            case 759: discoverCountry = "Венесуэла";
            case 770: discoverCountry = "Колумбия";
            case 773: discoverCountry = "Уругвай";
            case 775: discoverCountry = "Перу";
            case 777: discoverCountry = "Боливия";
            case 779: discoverCountry = "Аргентина";
            case 780: discoverCountry = "Чили";
            case 784: discoverCountry = "Парагвай";
            case 786: discoverCountry = "Эквадор";
            case 603: discoverCountry = "Гана";
            case 609: discoverCountry = "Маврикий";
            case 611: discoverCountry = "Марокко";
            case 613: discoverCountry = "Алжир";
            case 616: discoverCountry = "Кения";
            case 618: discoverCountry = "Кот-д'Ивуар";
            case 619: discoverCountry = "Тунис";
            case 622: discoverCountry = "Египет";
            case 489: discoverCountry = "Гонгонг";
            case 958: discoverCountry = "Макао";
            case 471: discoverCountry = "Тайвань";

        }


        return discoverCountry;
    }
}
