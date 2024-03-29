import java.util.Random;
import java.util.Scanner;

/**
 * ClassName: Builder
 * Description:
 *
 * @Author Agility6
 * @Create 2023-06-20
 * @Version 1.0
 */
public class Generator {

    PasswordData passwordData;

    public final Scanner keyborad = new Scanner(System.in);
    public Generator() {
    }

    public Generator(boolean NumberType, boolean capitalLetter, boolean smallLetter) {
        passwordData = new PasswordData(NumberType, capitalLetter, smallLetter);
    }

    public void begin() {
        printf();
        passwordType();
    }

    private void printf() {
        System.out.println("--> Select password type(Y or N) <--");
        System.out.println();
    }

    private void passwordType() {

        String value;
        boolean numberType;
        boolean capitalLetter;
        boolean smallLetter;
        int passWordLength;
        boolean TypeError;

        do {

            numberType = isState(SelectType("NumberType"));
            capitalLetter = isState(SelectType("CapitalLetterType"));
            smallLetter = isState(SelectType("SmallLetterType"));
            System.out.println(" Enter password length :) ");
            // TODO 长度判断是否合法
            passWordLength = keyborad.nextInt();

            TypeError = !numberType && !capitalLetter && !smallLetter && passWordLength > 0;

        } while (TypeError);

        final Generator generator = new Generator(numberType, capitalLetter, smallLetter);

        // 生成密码
        generator.compoundPassWord(passWordLength);

        end();
    }


    private void compoundPassWord(int length) {

        String initPassWord = passwordData.getPassWord();

        int initPassWordMaxLength = initPassWord.length();

        System.out.println();
        System.out.println("Your PassWord:  ");
        System.out.print("  ");
        while (length != 0) {
            int randomNumber = new Random().nextInt(initPassWordMaxLength - 1);
            System.out.print(initPassWord.charAt(randomNumber));
            length--;
        }
        System.out.println();
        System.out.println(":) Done");
    }

    private String SelectType(String Type) {
        String inputValue;

        do {
            System.out.println(Type);
            inputValue = keyborad.next();
        } while (!(inputValue.equalsIgnoreCase("y") || inputValue.equalsIgnoreCase("n")));

        return inputValue;
    }

    private boolean isState(String value) {
        return value.equalsIgnoreCase("y");
    }

    private void end() {
        keyborad.close();
    }
}
