package MyCurrentPackage;

public class BIN {
	public StringBuilder binaryValue = new StringBuilder();
	public int decimalValue;
	public BIN(String bin) {
		this.binaryValue.append(bin);
		this.decimalValue = this.binToDec();
	}
	public BIN(int bin) {
		this.binaryValue = this.binAtDec(bin);
		this.decimalValue = bin;
	}
	public int binToDec() {
		int decrement = (int) Math.pow(2, this.binaryValue.length()-1);
		int sum = 0;
		for (int i = 0; i < this.binaryValue.length(); i++) {
			if (this.binaryValue.charAt(i) == '1') {
				sum+=decrement;
			}
			decrement/=2;
		}
		return sum;
	}
	
	public String toString() {
		return this.binaryValue.toString();
	}
//	public String binAtDec(int dec) {
//		StringBuilder sb = new StringBuilder("00000000");
//		double result = Math.log(dec) / Math.log(2);
//		if (result != Math.floor(result)) {
//			result=Math.floor(result)+1;
//		} else {
//			result+=1;
//		}
//		for (int i = sb.length() - (int) result; i < sb.length() ; i++) {
//			Math.pow(2, (int) result - 1);
//		}
// 		return "1";
//	}
	public StringBuilder binAtDec(int dec) {
		double decrement = 0;
		StringBuilder sb = new StringBuilder("00000000");
		if (dec <= 0) {
			return sb;
		}
		double result = Math.log(dec) / Math.log(2);
		if (result != Math.floor(result)) {
			result=Math.floor(result)+1;
		} else {
			result+=1;
		}
		decrement = Math.pow(2, (int) (result - 1));
		for (int i = sb.length() - (int) result; i < sb.length() ; i++) {
			if (decrement<=dec) {
				dec-=decrement;
				sb.setCharAt(i, '1');
			}
			decrement/=2;
		};
		return sb;
	}
	public void increment() {
		this.binaryValue.delete(0, this.binaryValue.length());
		this.binaryValue.append(this.binAtDec(decimalValue+1));
		this.decimalValue = decimalValue+1;
	}
	public void increment(int by) {
		this.binaryValue.delete(0, this.binaryValue.length());
		this.binaryValue.append(this.binAtDec(decimalValue+by));
		this.decimalValue = decimalValue+by;
	}
	public void decrement() {
		this.binaryValue.delete(0, this.binaryValue.length());
		this.binaryValue.append(this.binAtDec(decimalValue-1));
		this.decimalValue = decimalValue - 1;
	}
	public void decrement(int by) {
		this.binaryValue.delete(0, this.binaryValue.length());
		this.binaryValue.append(this.binAtDec(decimalValue-by));
		this.decimalValue = decimalValue - by;
	}
	public void setValue(int dec) {
		this.binaryValue.delete(0, binaryValue.length());
		this.binaryValue.append(this.binAtDec(dec));
		this.decimalValue = dec;
	}
	public void setValue(String bin) { // we only change the part entered
		int len = this.binaryValue.length();
		this.binaryValue.delete(len-bin.length(), len);
		this.binaryValue.append(bin);
		this.decimalValue = this.binToDec();
	}
	public String add(BIN bin2) {
		int val1 = this.decimalValue + bin2.decimalValue;
		return binAtDec(val1).toString();
	}
}

