package banana_user.controller;

public class Controllers {

	private static ProgramController programController;
	private static UserController userController;
	private static LoginController loginController;
	private static EmotionController emotionController;
<<<<<<< HEAD
	private static MusicController musicController;
	
=======
	private static TicketController ticketController;

>>>>>>> refs/remotes/origin/pr/4
	public Controllers() {

		programController = new ProgramController();
		userController = new UserController();
		loginController = new LoginController();
		emotionController = new EmotionController();
<<<<<<< HEAD
		musicController = new MusicController();
=======
		ticketController = new TicketController();
>>>>>>> refs/remotes/origin/pr/4
	}

	public static ProgramController getProgramController() {
		return programController;
	}

	public static UserController getUserController() {
		return userController;
	}

	public static LoginController getLoginController() {
		
		return loginController;
	}

	public static EmotionController getEmotionController() {
		
		return emotionController;
	}

<<<<<<< HEAD
	public static MusicController getMusicController() {
		
		return musicController;
	}
	
	
=======
	public static TicketController getTicketController() {
		return ticketController;
	}

>>>>>>> refs/remotes/origin/pr/4
}
