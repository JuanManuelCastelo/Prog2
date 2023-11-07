public class Main {
    public static void main(String[] args) {
        SistemaGestionVeterinaria sistema = new SistemaGestionVeterinaria("Mi Clinica Veterinaria");
        MainGUI mainGUI = new MainGUI(sistema);
        mainGUI.createAndShowGUI();
    }
}

