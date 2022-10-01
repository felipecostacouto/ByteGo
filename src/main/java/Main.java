import com.gpti.bytego.controller.LoginController;

public class Main
{
    public static void main(String[] args)
    {
        LoginController loginController = new LoginController();
        loginController.register("fabriciokashino@live.com", "pass123", null, "Fabricio");
        loginController.register("joao_pe_de_feijao@yahoo.com", "asda133", null, "João");
        loginController.register("maria.florentina@hotmail.com", "f09fu21", null, "Maria");
        loginController.register("acabou_jessica@gmail.com", "dfbt234", null, "Jessica");
    }
}
