import java.util.Stack;

public class ParenthesesChecker {

    public ParenthesesChecker (){}

    public boolean checkParentheses(String stringToCheck){
        if(stringToCheck.isEmpty()) return true;
        if(stringToCheck.length() == 1) return false;
        return checkParentheseHelper(stringToCheck, new Stack<Character>());
    }

    public boolean checkParentheseHelper(String stringToCheck, Stack stack){
        if(stringToCheck.isEmpty()){
            if(stack.isEmpty()) return true;
            else return false;
        }else if((stringToCheck.length() == 1 && (
                stringToCheck.charAt(0) != '(' && stringToCheck.charAt(0) != ')'
        ))){
            if(stack.isEmpty()) return true;
            else return false;
        }else if(stringToCheck.length() == 1 && (
                stringToCheck.charAt(0) == '(' || stringToCheck.charAt(0) == ')'
        )){
            return false;
        }

        int startIndex = 0;
        int lastIndex = stringToCheck.length() - 1;

        char firstDigit = stringToCheck.charAt(startIndex++);
        char lastDigit = stringToCheck.charAt(lastIndex);
        if(firstDigit == '(' || firstDigit == ')'){
            stack.push(firstDigit);
        }

        if(!stack.isEmpty() && (
                lastDigit == ')' || lastDigit == '('
        )) {
            stack.pop();
            lastIndex--;
        } else if(lastDigit != ')' && lastDigit != '('){
            lastIndex--;
        }

        if(firstDigit != '(' && firstDigit != ')'){
            stringToCheck = stringToCheck.substring(startIndex,lastIndex+1);
            return checkParentheseHelper(stringToCheck,stack);
        }

        if(startIndex > lastIndex){
            if(stack.isEmpty()) return true;
            else return false;
        }
        stringToCheck = stringToCheck.substring(startIndex, lastIndex+1);

        return checkParentheseHelper(stringToCheck,stack);
    }

}
