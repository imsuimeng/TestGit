package exception;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {


	public static void main(String[] args) {
	}

	public int devide(int num1, int num2) {
		// 判断除数是否为0
		if (num2 == 0) {
			throw new IllegalArgumentException("除数不能为零");
		}

		return num1 / num2;
	}
	
	 public static void readFile(String file) throws FileNotFoundException {
	        try {
	            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            System.err.println("不知道如何处理该异常或者根本不想处理它，但是不做处理又不合适，这是重新抛出异常交给上一级处理");
	            //重新抛出异常
	            throw e;
	        }
	    }

}
