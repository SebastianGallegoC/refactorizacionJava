class NameValidator {
    public void validateName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Error: nombre vacío");
        }
        if(name.length() < 2) {
            throw new IllegalArgumentException("Error: nombre muy corto");
        }
    }
}

class EmailValidator {
    public void validateEmail(String email) {
        if(email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Error: email inválido");
        }
        if(!email.contains(".")) {
            throw new IllegalArgumentException("Error: email sin dominio");
        }
    }
}

class PasswordValidator {
    public void validatePassword(String password) {
        if(password == null || password.length() < 8) {
            throw new IllegalArgumentException("Error: password débil");
        }
        if(!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Error: password sin números");
        }
            
    }
}

class InputsValidator {
	private NameValidator nameValidator;
    private EmailValidator emailValidator;
    private PasswordValidator passwordValidator;
    
    public InputsValidator(NameValidator nameValidator, EmailValidator emailValidator, PasswordValidator passwordValidator) {
    	this.nameValidator = nameValidator;
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }
    
    
	public void validateInputs(String name, String email, String password) {
    	nameValidator.validateName(name);
        emailValidator.validateEmail(email);
        passwordValidator.validatePassword(password);
    }
}


class UserManager {
	private final InputsValidator inputsValidator;
    
    public UserManager(InputsValidator inputsValidator) {
        this.inputsValidator = inputsValidator;
    }
    
    public void createUser(String name, String email, String password) {
        try {
        	this.inputsValidator.validateInputs(name, email, password);
            
            System.out.println("Usuario creado " + name);
            System.out.println("Email enviado " + name);
            System.out.println("Usuario guardado en BD " + name);
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la creación del usuario: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NameValidator nameValidator = new NameValidator();
        EmailValidator emailValidator = new EmailValidator();
        PasswordValidator passwordValidator = new PasswordValidator();
        
        InputsValidator validateInputs = new InputsValidator(nameValidator, emailValidator, passwordValidator);
    
        UserManager userManager = new UserManager(validateInputs);
        
        userManager.createUser("Juan", "Gallegoj92@gmail.com", "dasd3dasdas");
    }
}