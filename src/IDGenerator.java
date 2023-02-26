import java.util.Random;
public class IDGenerator {
    public static void main(String[] args) {
        String generatedCode = generateCode();
        System.out.println(codeChecker(generatedCode));
    }
    public static String generateCode(){
        Random random = new Random();
        String[] stringArray = new String[11];
        int sumOdd = 0;
        int sumEven = 0;
        int tenthDigit;
        int lastDigit;
        String resultString = "";

        for (int i=0;i<9;i++){
            stringArray[i] = Integer.toString(random.nextInt(10));
            if (i%2==0){
                sumOdd += Integer.valueOf(stringArray[i]);
            }else if (i%2 ==1){
                sumEven += Integer.valueOf(stringArray[i]);
            }
        }
        tenthDigit = (7*sumOdd - sumEven)%10;
        lastDigit = (sumOdd + sumEven + tenthDigit)%10;
        stringArray[9] = Integer.toString(tenthDigit);
        stringArray[10] = Integer.toString(lastDigit);

        for (String str:stringArray){
            resultString += str;
        }
        return resultString;
    }
    public static String codeChecker(String generatedCode){
        if (generatedCode.startsWith("0")){
            throw new IllegalArgumentException("Id number cannot start with 0");
        }return generatedCode;
    }
}