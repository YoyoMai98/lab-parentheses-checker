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
//        get the index of the first digit => int startIndex
        int startIndex = 0;
//        get the index of the last digit => int lastIndex
        int lastIndex = stringToCheck.length() - 1;
//        Stack<Character> stack = new Stack<>();
//        if startIndex digit == '('
//          push '(' into stack, startIndex++,
//        if lastIndex digit == ')'
//          pop '(' out of the stack, lastIndex--
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
//            stringToCheck = stringToCheck.substring(startIndex, lastIndex);
        } else if(lastDigit != ')' && lastDigit != '('){
            lastIndex--;
        }

        if(firstDigit != '(' && firstDigit != ')'){
//            if(stack.isEmpty() && (
//                    lastDigit == '(' || lastDigit == ')')
//            ){
//                lastIndex--;
////                stringToCheck = stringToCheck.substring(startIndex,lastIndex);
//            }
                stringToCheck = stringToCheck.substring(startIndex,lastIndex+1);

            return checkParentheseHelper(stringToCheck,stack);
        }
//        get subString of stringToCheck, remove the first & last digit
        if(startIndex > lastIndex){
            if(stack.isEmpty()) return true;
            else return false;
        }
        stringToCheck = stringToCheck.substring(startIndex, lastIndex+1);
//        if stringToCheck.size() == 1 or stringToCheck.isEmpty
//          if(stack.Empty) return true
//        else checkParentheses(stringToCheck)
//        if(stringToCheck.isEmpty()){
//            if(stack.isEmpty()) return true;
//            else return false;
//        }

        return checkParentheseHelper(stringToCheck,stack);
    }

}
