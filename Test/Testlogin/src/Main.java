import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void convertObjectToJsonFile(String fileName, Object obj) {
        try {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            Writer writer = Files.newBufferedWriter(Paths.get(fileName));

            gson.toJson(obj, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        users.add(new User("techmaster@gmail.com", "1234567","av"));
        users.add(new User("javacore@gmail.com", "jks0and2","haga"));
        users.add(new User("JavaSpring@gmail.com", "jaks","suzi"));
        convertObjectToJsonFile("list-user.json", users);
        while (true){
            System.out.println("\n1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Quên mật khẩu");
            System.out.println("Chọn chức năng");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    login(sc, users);
                    break;
                case 2:
                    register(sc,users);
                    break;
//                case 3:
//                    fogetpassword(Scanner);
//                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private static void changePassword(Scanner sc,List<User> users ) {
        System.out.println("Nhập mật khẩu  mới của bạn");
        String passwordNew = sc.nextLine();
        for (User user : users){
            if (user.getPassword().equals(passwordNew)&&passwordNew.length()>7&&passwordNew.length()<15){
                System.out.println("Bạn đã thay đổi thành công");
                break;
            }
            else{
                System.out.println("Thay đổi mật khẩu không thành công");
                break;
            }
        }
    }

    private static void changeEmail(Scanner sc,List<User> users) {
        System.out.println("Nhập email mới của bạn : ");
        String changeEmail = sc.nextLine();
        for (User user : users){
            if (user.getEmail().equals(changeEmail)){
                System.out.println("email của bạn đã tồn tại");
                break;
            }
            else {
                System.out.printf("Bạn đã thay đổi thành công");
                break;
            }
        }

    }

    private static void login(Scanner sc, List<User> users) {
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = sc.nextLine();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                while (true) {
                    System.out.println("\nChào mừng  bạn có thể thực hiện các công việc sau:");
                    System.out.println("1. Thay đổi username");
                    System.out.println("2. Thay đổi email");
                    System.out.println("3. Thay đổi mật khẩu");
                    System.out.println("4. Đăng xuất");
                    System.out.println("5. Thoát");
                    System.out.print("Chọn chức năng: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Nhập username mới: ");
                            String newUsername = sc.nextLine();
                            break;
                        case 2:
                            changeEmail(sc,users);
                            break;
                        case 3:
                            changePassword(sc,users);
                            break;
                        case 4:
                            users = null;
                            return;
                        case 5:
                            return;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                }
            } else {
                System.out.print("Tài khoản hoặc mật khẩu không chính xác.");
                break;
            }
        }
    }


    private static void register(Scanner scanner,List<User> users){
        System.out.println("Nhập email : ");
        String emailNew = scanner.nextLine();
        System.out.println("Nhập mật khẩu của bạn : ");
        String newPassword = scanner.nextLine();
        System.out.println("Nhập tên của bạn : ");
        String userName = scanner.nextLine();
        for (User user : users){
            if (user.getEmail().equals(emailNew)&&newPassword.length()>7&&newPassword.length()<15){
                System.out.println("email đã tồn tại");
                break;
            }
            else{
                System.out.println("Bạn đã đăng kí thành công ");
                break;
            }
        }
    }

}
