package sec01_05.basic_enum;

public class Client {
    public int someMethod(CalculateCommand calculateCommand) {
        CalculateType calculateType = calculateCommand.getCalculateType();
        int num1 = calculateCommand.getNum1();
        int num2 = calculateCommand.getNum2();

        int result = 0;

        if(calculateType.equals(CalculateType.ADD)) return num1 + num2;
        else if(calculateType.equals(CalculateType.MINUS)) return num1 - num2;
        else if(calculateType.equals(CalculateType.MULTIPLY)) return num1 * num2;
        else if(calculateType.equals(CalculateType.DIVIDE)) return num1 / num2;

        return result;
    }
}
