package exception;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {


	public static void main(String[] args) {
	}

	public int devide(int num1, int num2) {
		// �жϳ����Ƿ�Ϊ0
		if (num2 == 0) {
			throw new IllegalArgumentException("��������Ϊ��");
		}

		return num1 / num2;
	}
	
	 public static void readFile(String file) throws FileNotFoundException {
	        try {
	            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            System.err.println("��֪����δ�����쳣���߸������봦���������ǲ��������ֲ����ʣ����������׳��쳣������һ������");
	            //�����׳��쳣
	            throw e;
	        }
	    }

}
