import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        checkLogoPass("aaa", "123", "123");
    }

    public static void checkLogoPass(String login, String password, String confirmPassword) {
        boolean result;
        try {
            result = checkLogin(login) && checkPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка логина и пароля выполнена");
        }
    }

    private static boolean checkLogin(String login) throws WrongLoginException {
        Pattern a = Pattern.compile("^[a-z0-9_-]{1,20}$");
        if (!a.matcher(login).matches()) {
            throw new WrongLoginException("Некорректный логин - " + login);
        }
        return true;
    }

    private static boolean checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        Pattern b = Pattern.compile("^[a-z0-9_-]{1,19}$");
        if (!b.matcher(password).matches()) {
            throw new WrongPasswordException("Некорректный пароль - " + password);
        }
        if (!password.equals(confirmPassword)) {
            System.out.println("Пароли не совпадают");
        }
        return true;

    }
}