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

    public double add(double a, double b) {
        return a+b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mult(double a, double )

}