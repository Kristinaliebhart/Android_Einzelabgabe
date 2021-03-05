package com.example.einzelabgabge_se2;

public class ASCII {
    public static void main(String[] args) {

    }
    public String getAscii(String number){
        String ergebnis= "";
        char newChar;

        for(int i = 0; i < number.length(); i++){
            if (i%2 == 0){
                ergebnis+= number.charAt(i);
            }

            else {
                switch (number.charAt(i)){
                    case '1':
                        newChar = 'a';
                        break;
                    case '2':
                        newChar = 'b';
                        break;
                    case '3':
                        newChar = 'c';
                        break;
                    case '4':
                        newChar = 'd';
                        break;
                    case '5':
                        newChar = 'e';
                        break;
                    case '6':
                        newChar = 'f';
                        break;
                    case '7':
                        newChar = 'g';
                        break;
                    case '8':
                        newChar = 'h';
                        break;
                    case '9':
                        newChar = 'i';
                        break;
                    case '0':
                        newChar = 'j';

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + i);
                }
                ergebnis+= newChar;

            }
        }

        return ergebnis;
    }
}
