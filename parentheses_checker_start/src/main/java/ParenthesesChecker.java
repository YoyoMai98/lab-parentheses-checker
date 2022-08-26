import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ParenthesesChecker {

    private List<Character> foreBrackets = Arrays.asList('(', '[', '{', '<');
    private List<Character> backBrackets = Arrays.asList(')',']','}','>');

    public ParenthesesChecker (){}

    public boolean checkParentheses(String stringToCheck){
        if(stringToCheck.isEmpty()) return true;
        if(stringToCheck.length() == 1) return false;
        return checkParenthesesHelper(stringToCheck, new Stack<Character>());
    }

    public boolean checkParenthesesHelper(String stringToCheck, Stack stack){
        if(stringToCheck.isEmpty()){
            return stack.isEmpty();
        }else if((stringToCheck.length() == 1 && (
                !foreBrackets.contains(stringToCheck.charAt(0)) && !backBrackets.contains(stringToCheck.charAt(0))
        ))){
            return stack.isEmpty();
        }

        int startIndex = 0;
        int lastIndex = stringToCheck.length() - 1;

        char firstDigit = stringToCheck.charAt(startIndex);
        if(foreBrackets.contains(firstDigit)
        ){
            stack.push(firstDigit);
        }else if(!stack.isEmpty() && backBrackets.contains(firstDigit)){
            if(foreBrackets.indexOf(stack.peek()) == backBrackets.indexOf(firstDigit)){
                stack.pop();
                if(++startIndex > lastIndex){
                    return stack.isEmpty();
                }
            }else {
                return false;
            }
        }

        int nextIndex = startIndex == lastIndex ? startIndex : startIndex+1;
        char nextDigit = stringToCheck.charAt(nextIndex);

        if(!stack.isEmpty() && backBrackets.contains(nextDigit)){
            if(foreBrackets.indexOf(stack.peek()) == backBrackets.indexOf(nextDigit)){
                stack.pop();
                nextIndex++;
            }else {
                return false;
            }
        }else if(backBrackets.contains(nextDigit)){
            return false;
        }

        if(nextIndex > lastIndex){
            return stack.isEmpty();
        }

        stringToCheck = stringToCheck.substring(nextIndex);

        if(!foreBrackets.contains(nextDigit)
                && !backBrackets.contains(nextDigit)
        ){
            return checkParenthesesHelper(stringToCheck,stack);
        }

        if(!stringToCheck.isEmpty()){
            return checkParenthesesHelper(stringToCheck, stack);
        }else{
            return stack.isEmpty();
        }


//        if(startIndex > nextIndex){
//            if(stack.isEmpty()) return true;
//            else return false;
//        }
//        stringToCheck = stringToCheck.substring(startIndex, lastIndex+1);
//
//        return checkParenthesesHelper(stringToCheck,stack);
    }

}
