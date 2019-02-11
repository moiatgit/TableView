/*
 * Implementa una demostració de l'ús de BooleanTableView
 * Mostra una taula de booleans de 4x3 durant 2 segons
 */
public class DemoBooleanTableView {
    public static void main(String[] args) {
        int maxCol = 4;
        int maxRow = 5;
        boolean[][] values = new boolean[maxCol][maxRow];

        BooleanTableView tableView = new BooleanTableView(values); // crea la vista
        tableView.wait(2000);   // espera 2 segons

        values[0][0] = true;    // canvia un dels valors
        tableView.setValues(values); // actualitza la vista
        tableView.wait(2000);

        tableView.close();      // tanca la vista (ja no es podrà tornar a fer servir!)
    }
}
