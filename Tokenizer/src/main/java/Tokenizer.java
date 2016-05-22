public class Tokenizer {

    public void process(String text){
        TokenizerOserver observer = new TokenizerOserver();
        StringBuffer buffer = new StringBuffer(1);
        char[] textArray = text.toCharArray() /* removeChar(text, ' ').toCharArray()*/;
        buffer.append(textArray[0]);
        for (int i = 1, j =0; i < textArray.length; i++, j++) {
            char ch2 = textArray[i];
            char ch1 = buffer.charAt(j);

            if (isDigit(ch1) & isDigit(ch1) != isDigit(ch2)){
                observer.handleDigits(buffer.toString());
                buffer.delete(0, buffer.length());
                j = -1;
            }
            if (isLetter(ch1) & isLetter(ch1) != isLetter(ch2)){
                observer.handleLetters(buffer.toString());
                buffer.delete(0, buffer.length());
                j = -1;
            }
            if (isSign(ch1) & isSign(ch1) != isSign(ch2)){
                observer.handleSign(buffer.toString());
                buffer.delete(0, buffer.length());
                j = -1;
            }

            if (isDigit(ch1) & i+1 == textArray.length){
                buffer.append(textArray[i]);
                observer.handleDigits(buffer.toString());
                break;
            }

            if (isLetter(ch1) & i+1 == textArray.length){
                buffer.append(textArray[i]);
                observer.handleLetters(buffer.toString());
                break;
            }

            if (isSign(ch1) & i+1 == textArray.length){
                buffer.append(textArray[i]);
                observer.handleSign(buffer.toString());
                break;
            }

            buffer.append(textArray[i]);
        }
    }

    private boolean isDigit(char symbol){
        return symbol>47 & symbol<58;
    }

    private boolean isLetter(char symbol){
        return ((symbol > 64 & symbol <91)||(symbol > 96 & symbol < 123));
    }

    private boolean isSign(char symbol){
        return (symbol > 31 & symbol < 48) || (symbol > 57 & symbol < 65) || (symbol > 90 & symbol < 97) || (symbol > 122 & symbol < 127);
    }

    private String removeChar(String s, char c) {
        String r = "";
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != c) r += s.charAt(i);
        }
        return r;
    }


}
