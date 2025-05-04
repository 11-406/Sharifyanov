public class Stack {
    char[] arr;
    int top;
    public int size;

    public Stack(int size) {
        arr = new char[size];
        this.size = size;
        top = -1;
    }

    public boolean add(char elem) {
        if(!isFull()) {
            arr[top+1] = elem;
            top++;
            return true;
        } else {
            return false;
        }
    }

    public char remove() {
        if(!isPust()){
		return arr[top--];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isFull() {
        return top == size-1;
    }

    public boolean isPust() {
        return top == -1;
    }
	
	public boolean isWork(String str) {
		Stack stack = new Stack(str.length());
        for(int i = 0; i < str.length(); i++) {

            char temp = str.charAt(i);
            if(temp == '(' || temp == '[') {
                if(!stack.add(temp)) {
                    return false;
                }
            }
            if(temp == ')') {
                if(stack.remove() != '(') {
                    return false;
                }

            }
            if(temp == ']') {
                if(stack.remove() != '[') {
                    return false;
                }
            }
        }

        return stack.isPust();
	}

    public double Calculator(String str) {
        int  index = 0;
        String  a = "";
        String b = "";
        double result = 0;
        if(isWork(str)) {
            for(int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if(temp >= 48 && temp <=57) {
                    a += temp;
                    index = i;
                    break;
                }
            }
            for(int j = index; j < str.length(); j++) {
                char second = str.charAt(j);
                if(second >= 48 && second <= 57) {
                    b += second;
                }

            }

//            for(int k = 0; k < str.length(); k++) {
//                char da = str.charAt(k);
//                if(da == '+') {
//                    result = add(a-'0' ,b -'0');
//                } else if(da == '-') {
//                    result = sub(a - '0', b - '0');
//                } else if(da == '*') {
//                    result = mult(a - '0', b - '0');
//                } else if(da == '/') {
//                    result = divide(a - '0', b - '0');
//                } else if(da == ' ' || da == '(' || da == ')' || (da >= 48 && da <= 57)) {
//                    continue;
//                } else {
//                    throw new IndexOutOfBoundsException();
//                }
//            }
            return result;
        } else {
            return 0;
        }
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public double add(double a, double b) {
        return a+b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mult(double a, double b) {
        return a*b;
    }

    public double divide(double a, double b) {
        return a/b;
    }

}