package br.com.juhmaran.cleancode;

public class UserValidator {

    private final Cryptographer cryptographer;

    public UserValidator(Cryptographer cryptographer) {
        this.cryptographer = cryptographer;
    }

    // Pode ser renomeado para checkPasswordAndInitializeSession
    public boolean checkPassword(String userName, String password) {
        User user = UserGateway.findByName(userName);
        if (user != User.NULL) {
            String codePhrase = user.getPhraseEncodedByPassword();
            String phrase = cryptographer.decrypt(codePhrase, password);
            if ("Valid Password".equals(phrase)) {
                Session.initialize(); // Efeito Colateral
                return true;
            }
        }
        return false;
    }

    public static class User {
        public static final User NULL = null;

        public String getPhraseEncodedByPassword() {
            return "";
        }
    }

    public static class UserGateway {
        public static User findByName(String userName) {
            return null;
        }
    }

    public static class Cryptographer {
        public String decrypt(String codePhrase, String password) {
            return "Code phrase: " + codePhrase + "\n Password: " + password;
        }
    }

    public static class Session {
        public static void initialize() {
        }
    }

}