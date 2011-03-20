package fr.GCAM.StudentManager.UI;

/**
 * Classe principale du projet. C'est ici que l'on va regarder les deux arguments
 * obligatoires qui doivent etre passés pour l'éxecution du programme.
 * Le programme va ensuite lancer l'UI correspodant au premier argument.
 *
 * @author Quentin
 */
public class Main {
    public static void main(String[] args) {
        if (args.length > 1
                && (args[0].equals("c") || args[0].equals("g"))
                && (args[1].equals("db") || args[1].equals("xml"))) {
            AbstractUIFactory.getUIFactory(args[0]).getUIUtilisateur(args[1]);
        } else {
            System.err.println("Arguments invalides (Format : c/g db/xml)");
        }
    }
}