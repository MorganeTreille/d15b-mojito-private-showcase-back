package fr.formation.security;

public class SecurityUtils {

	public static boolean validatePassword (String password) {
		if (password != null && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$") ) {
			return true;
		}
		return false;
	}
}
