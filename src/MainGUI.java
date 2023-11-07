import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private SistemaGestionVeterinaria sistema;

    public MainGUI(SistemaGestionVeterinaria sistema) {
        this.sistema = sistema;
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Mi Clinica Veterinaria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        panel.setLayout(null);

        // Botón para agregar veterinario
        JButton agregarVeterinarioButton = new JButton("Agregar Veterinario");
        agregarVeterinarioButton.setBounds(10, 10, 300, 30);
        panel.add(agregarVeterinarioButton);

        // Botón para agregar mascota a un veterinario
        JButton agregarMascotaButton = new JButton("Agregar Mascota a Veterinario");
        agregarMascotaButton.setBounds(10, 50, 300, 30);
        panel.add(agregarMascotaButton);

        // Botón para mostrar datos del veterinario
        JButton mostrarDatosVeterinarioButton = new JButton("Mostrar Datos del Veterinario");
        mostrarDatosVeterinarioButton.setBounds(10, 90, 300, 30);
        panel.add(mostrarDatosVeterinarioButton);

        // Botón para mostrar mascotas de un veterinario
        JButton mostrarMascotasButton = new JButton("Mostrar Mascotas de un Veterinario");
        mostrarMascotasButton.setBounds(10, 130, 300, 30);
        JButton mostrarMascotasButton1 = mostrarMascotasButton;
        panel.add(mostrarMascotasButton1);

        // Botón para calcular la cantidad total de mascotas atendidas
        JButton calcularTotalMascotasButton = new JButton("Calcular Cantidad Total de Mascotas Atendidas");
        calcularTotalMascotasButton.setBounds(10, 170, 300, 30);
        panel.add(calcularTotalMascotasButton);

        // Botón de salida
        JButton salirButton = new JButton("Salir");
        salirButton.setBounds(10, 210, 300, 30);
        panel.add(salirButton);

        // Implementación de los ActionListeners para cada botón
        agregarVeterinarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Nombre del Veterinario:");
                String numIdentificacion = JOptionPane.showInputDialog("Número de Identificación del Veterinario:");
                String especialidad = JOptionPane.showInputDialog("Especialidad del Veterinario");

                if (nombre != null && numIdentificacion != null && especialidad != null) {
                    sistema.agregarVeterinario(nombre, numIdentificacion, especialidad);
                    JOptionPane.showMessageDialog(null, "Veterinario agregado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son requeridos.");
                }
            }
        });

        agregarMascotaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numIdVeterinario = JOptionPane.showInputDialog("Número de Identificación del Veterinario:");
                Veterinario veterinario = sistema.buscarVeterinario(numIdVeterinario);

                if (veterinario != null) {
                    String nombreMascota = JOptionPane.showInputDialog("Nombre de la Mascota:");
                    String tipoMascota = JOptionPane.showInputDialog("Tipo de la Mascota:");
                    String idMascota = JOptionPane.showInputDialog("ID de la Mascota:");

                    if (idMascota != null) {
                        try {
                            int idMascotaInt = Integer.parseInt(idMascota);
                            Mascota mascota = new Mascota(idMascotaInt, nombreMascota, tipoMascota);
                            sistema.agregarMascotaAVeterinario(numIdVeterinario, mascota);
                            JOptionPane.showMessageDialog(null, "Mascota agregada al veterinario con éxito.");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "El ID de la mascota debe ser un número válido.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El ID de la mascota es requerido.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El veterinario con identificación " + numIdVeterinario + " no existe.");
                }
            }
        });


        mostrarDatosVeterinarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numIdVeterinario = JOptionPane.showInputDialog("Número de Identificación del Veterinario:");
                Veterinario veterinario = sistema.buscarVeterinario(numIdVeterinario);
                if (veterinario != null) {
                    JOptionPane.showMessageDialog(null, "Datos del Veterinario:\n" +
                            "Nombre: " + veterinario.getNombre() + "\n" +
                            "Número de Identificación: " + veterinario.getNumIdentificacion() + "\n" +
                            "Especialidad: " + veterinario.getEspecialidad());
                } else {
                    JOptionPane.showMessageDialog(null, "El veterinario con identificación " + numIdVeterinario + " no existe.");
                }
            }
        });

        mostrarMascotasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numIdVeterinario = JOptionPane.showInputDialog("Número de Identificación del Veterinario:");
                Veterinario veterinario = sistema.buscarVeterinario(numIdVeterinario);
                if (veterinario != null) {
                    StringBuilder mascotas = new StringBuilder("Mascotas atendidas por " + veterinario.getNombre() + ":\n");
                    for (Mascota mascota : veterinario.getMascotasAtendidas()) {
                        mascotas.append("ID: ").append(mascota.getId()).append(", Nombre: ").append(mascota.getNombre()).append(", Tipo: ").append(mascota.getTipo()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, mascotas.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "El veterinario con identificación " + numIdVeterinario + " no existe.");
                }
            }
        });

        calcularTotalMascotasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalMascotas = sistema.cantidadTotalMascotasAtendidas();
                JOptionPane.showMessageDialog(null, "Total de mascotas atendidas en la clínica: " + totalMascotas);
            }
        });

        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra la aplicación
            }
        });

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
