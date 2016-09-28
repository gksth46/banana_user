import banana_user.controller.Controllers;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();

<<<<<<< HEAD
		Controllers.getLoginController().requestLogin();
		Controllers.getLoginController().requestLoginYN();
		Controllers.getLoginController().requestLogout();
		Controllers.getLoginController().requestLoginYN();

		System.out.println("!!");
=======
		Controllers.getMusicController().requestSelectAllMusic();
		Controllers.getUserController().requestRegisterUser();
>>>>>>> refs/remotes/yuns111/master
	}

}
