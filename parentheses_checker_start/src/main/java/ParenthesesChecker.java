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
            if(stack.isEmpty()) return true;
            else return false;
        }else if((stringToCheck.length() == 1 && (
                !foreBrackets.contains(stringToCheck.charAt(0)) && !backBrackets.contains(stringToCheck.charAt(0))
        ))){
            if(stack.isEmpty()) return true;
            else return false;
        }
//        else if(stringToCheck.length() == 1 && (
//                foreBrackets.contains(stringToCheck.charAt(0)) || backBrackets.contains(stringToCheck.charAt(0))
//        )){
//            if(stack.isEmpty()) return true;
//            return false;
//        }

        int startIndex = 0;
        int lastIndex = stringToCheck.length() - 1;

        char firstDigit = stringToCheck.charAt(startIndex);
        char lastDigit = stringToCheck.charAt(lastIndex);
        if(foreBrackets.contains(firstDigit)
//                || backBrackets.contains(firstDigit)
        ){
//            startIndex++;
            stack.push(firstDigit);
        }else if(!stack.isEmpty() && backBrackets.contains(firstDigit)){
            if(foreBrackets.indexOf(stack.peek()) == backBrackets.indexOf(firstDigit)){
                stack.pop();
                if(++startIndex > lastIndex){
                    return stack.isEmpty();
                }
//                startIndex++;
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
//            char bracket = (char) stack.pop();
//            if (foreBrackets.contains(lastDigit)) {
//                if (backBrackets.indexOf(bracket) == foreBrackets.indexOf(lastDigit)) {
//                    lastIndex--;
//                } else {
//                    return false;
//                }
//            } else
//            if (backBrackets.contains(nextDigit)) {
//                if (foreBrackets.indexOf(bracket) == backBrackets.indexOf(nextDigit)) {
////                    lastIndex--;
//                    nextIndex++;
//                } else {
//                    return false;
//                }
//            }else
//                if (!backBrackets.contains(nextDigit)
//                    && !foreBrackets.contains(lastDigit))
             {
//                stack.push(bracket);
//                nextIndex++;
//                lastIndex--;
            }
        }else if(backBrackets.contains(nextDigit)){
            return false;
        }
//            if (!backBrackets.contains(nextDigit)
////                && !foreBrackets.contains(lastDigit)
//        ) {
//            nextIndex++;
////            stringToCheck = stringToCheck.substring(startIndex,lastIndex);
//            stringToCheck = stringToCheck.substring(nextIndex);
//            return checkParenthesesHelper(stringToCheck,stack);
//        }

        if(nextIndex >= stringToCheck.length()){
            if(stack.isEmpty()) return true;
            else return false;
        }

        stringToCheck = stringToCheck.substring(nextIndex);

        if(!foreBrackets.contains(nextDigit)
                && !backBrackets.contains(nextDigit)
        ){
//            stringToCheck = stringToCheck.substring(++startIndex,lastIndex+1);
//            stringToCheck = stringToCheck.substring(nextIndex);
            return checkParenthesesHelper(stringToCheck,stack);
        }
//        else {
//            stack.push(nextDigit);
////            nextIndex++;
//        }

//        stringToCheck = stringToCheck.substring(nextIndex);
        if(!stringToCheck.isEmpty()){
            return checkParenthesesHelper(stringToCheck, stack);
        }else{
            if(stack.isEmpty()) return true;
            else return false;
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
