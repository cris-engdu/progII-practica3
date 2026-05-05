/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

import java.util.List;
import java.util.Scanner;
import prog2.adaptador.Adaptador;

/**
 *
 * @author dortiz
 */
public class BiblioUB {
    
    // Declarem les constants del menu principal
    static private enum OpcionsMenuPrincipal {
        MENU_PRINCIPAL_EXEMPLARS,
        MENU_PRINCIPAL_USUARIS,
        MENU_PRINCIPAL_PRESTECS,
        MENU_PRINCIPAL_SAVE,
        MENU_PRINCIPAL_LOAD,
        MENU_PRINCIPAL_EXIT};
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuPrincipal={"Gestió Exemplars",
                                               "Gestió Usuaris",
                                               "Gestió Prestecs",
                                               "Guardar Dades",
                                               "Recuperar Dades",
                                               "Sortir"};

    static private enum OpcionsMenuGestioExemplars {
        MENU_GESTIO_EXEMPLARS_ADD,
        MENU_GESTIO_EXEMPLARS_VIEW,
        MENU_GESTIO_EXEMPLARS_EXIT
    };
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuGestioExemplars ={"Afegir Exemplar",
                                                      "Visualitzar Exemplars",
                                                      "Sortir"};

    static private enum OpcionsMenuGestioClients {
        MENU_GESTIO_USUARIS_ADD,
        MENU_GESTIO_USUARIS_VIEW,
        MENU_GESTIO_USUARIS_EXIT
    };
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuGestioUsuaris ={"Afegir Usuari",
                                                    "Visualitzar Usuaris",
                                                    "Sortir"};

    static private enum OpcionsMenuGestioPrestecs {
        MENU_GESTIO_PRESTECS_ADD,
        MENU_GESTIO_PRESTECS_REMOVE,
        MENU_GESTIO_PRESTECS_VIEW,
        MENU_GESTIO_PRESTECS_VIEW_URG,
        MENU_GESTIO_PRESTECS_EXIT
    };
    
    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] descMenuGestioPrestecs ={"Afegir Prestec",
                                                     "Retornar Prestec",
                                                     "Visualitzar Prestecs",
                                                     "Visualitzar Prestecs no Retornats",
                                                     "Sortir"};

    
    /** Adaptador de l'aplicació */
    private Adaptador adaptador;
    
    /* Constructor*/
    public BiblioUB() {
        adaptador = new Adaptador();
    }
     
    public void gestioBiblioUB() {
        // Creem un objecte per llegir des del teclat
        Scanner sc = new Scanner(System.in);
        
        // Creem l'objecte per al menú. Li passem com a primer paràmetre el nom del menú
        Menu<OpcionsMenuPrincipal> menu = new Menu<>("Menu principal", OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);
        
        OpcionsMenuPrincipal opcio;
        do {
            // Mostrem les opcions del menú i demanem una opció
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            // Fem les accions necessàries per a la opció triada
            switch(opcio) {
                case MENU_PRINCIPAL_EXEMPLARS:
                    // Mostra el menú per a la gestió d'exemplars
                    menuGestioExemplars(sc);
                    break;

                case MENU_PRINCIPAL_USUARIS:
                    // Mostra el menú per a la gestió d'usuaris
                    menuGestioUsuaris(sc);
                    break;

                case MENU_PRINCIPAL_PRESTECS:
                    // Mostra el menú per a la gestió de prestecs
                    menuGestioPrestecs(sc);
                    break;

                case MENU_PRINCIPAL_SAVE:
                    // Guardar dades
                    String dstFile = getFilePath(sc,false); // Obtenir el fitxer de sortida
                    if(dstFile != null) {
                        // Guardar les dades al fitxer triat
                        try {
                             this.adaptador.guardaDades(dstFile);
                             System.err.println("Dades guardades");
                        } catch (BiblioException ex) {
                            System.out.println("Error guardant les dades: " + ex.getMessage());
                        }
                    }                   
                    break;
                case MENU_PRINCIPAL_LOAD:
                    // Carregar dades                   
                    String srcFile = getFilePath(sc,false); // Obtenir el fitxer d'entrada
                    if(srcFile != null) {
                        // Carregar les dades del fitxer triat
                        try {
                             this.adaptador.carregaDades(srcFile);
                             System.err.println("Dades carregades");
                        } catch(BiblioException ex) {
                            System.out.println("Error carregant les dades." + ex.getMessage());
                        }
                    }     
                    break;
                case MENU_PRINCIPAL_EXIT:
                    // Sortir      1
                    System.err.println("Sortint de l'aplicació...");
                    break;
            }
        } while(opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_EXIT);
    }
    
    private void menuGestioExemplars(Scanner sc) {
        Menu<OpcionsMenuGestioExemplars> menuExemplars = new Menu<>("Menu Gestió Exemplars", OpcionsMenuGestioExemplars.values());

        menuExemplars.setDescripcions(descMenuGestioExemplars);
        OpcionsMenuGestioExemplars opcio;
        do {
            menuExemplars.mostrarMenu();
            opcio = menuExemplars.getOpcio(sc);

            switch(opcio) {
                case MENU_GESTIO_EXEMPLARS_ADD:
                    afegirExemplar(sc);
                    break;
                case MENU_GESTIO_EXEMPLARS_VIEW:
                    showList("EXEMPLARS", adaptador.llistarExemplars());
                    break;
                case MENU_GESTIO_EXEMPLARS_EXIT:
                    break;

            }
        }
        while (opcio != OpcionsMenuGestioExemplars.MENU_GESTIO_EXEMPLARS_EXIT);
    }
    
    /**
     * Afegir un nou article
     * @param sc
     */
    
    private void afegirExemplar(Scanner sc) {
        System.out.println("Introdueix l'id de l'exemplar: ");
        String id = sc.nextLine();

        System.out.println("Introdueix el titol de l'exemplar: ");
        String titol = sc.nextLine();

        System.out.println("Introdueix l'autor de l'exemplar: ");
        String autor = sc.nextLine();
        String prestec;
        boolean admetPrestec = false;
        do {
            System.out.println("L'exemplar admet prèstec llarg: (y/n)");
            prestec = sc.nextLine();
            if (prestec.equals("y")) {
                admetPrestec = true;
            } else if (prestec.equals("n")) {
                admetPrestec = false;
            } else {
                System.out.println("Format incorrecte");
            }
        } while (!prestec.equals("y") && !prestec.equals("n"));

        try {
            adaptador.afegirExemplar(id, titol, autor, admetPrestec);
        } catch (BiblioException e) {
            System.err.println(e.getMessage());
        }
    }

    private void menuGestioUsuaris(Scanner sc) {
        Menu<OpcionsMenuGestioClients> menuClients = new Menu<>("Menu Gestió Clients",  OpcionsMenuGestioClients.values());
        menuClients.setDescripcions(descMenuGestioUsuaris);

        OpcionsMenuGestioClients opcio;
        do {
            menuClients.mostrarMenu();
            opcio = menuClients.getOpcio(sc);
            switch(opcio) {
                case MENU_GESTIO_USUARIS_ADD:
                    afegirUsuari(sc);
                    break;
                case MENU_GESTIO_USUARIS_VIEW:
                    showList("USUARIS", adaptador.llistarUsuaris());
                    break;
                case MENU_GESTIO_USUARIS_EXIT:
                    break;
            }
        }
        while (opcio != OpcionsMenuGestioClients.MENU_GESTIO_USUARIS_EXIT);
    }
    
    /**
     * Afegir un nou usuari
     * @param sc
     */
    
    private void afegirUsuari(Scanner sc){
        System.out.println("Introdueix l'email de l'usuari: ");
        String email = sc.nextLine();

        System.out.println("Introdueix el nom de l'usuari: ");
        String nom = sc.nextLine();

        System.out.println("Introdueix l'adreça de l'usuari: ");
        String adreca = sc.nextLine();

        String estudiant;
        boolean esEstudiant = false;
        do {
            System.out.println("L'usuari es estudiant (y/n): ");
            estudiant = sc.nextLine();
            if (estudiant.equals("y")) {
                esEstudiant = true;
            } else if (estudiant.equals("n")) {
                esEstudiant = false;
            } else {
                System.out.println("Format incorrecte");
            }
        } while (!estudiant.equals("y") && !estudiant.equals("n"));

        try {
            adaptador.afegirUsuari(email, nom, adreca, esEstudiant);
        } catch (BiblioException e) {
            System.err.println(e.getMessage());
        }
    }

    private void menuGestioPrestecs(Scanner sc) {
        Menu<OpcionsMenuGestioPrestecs> menuPrestecs = new Menu<>("Menu Gestió Prestecs",  OpcionsMenuGestioPrestecs.values());
        menuPrestecs.setDescripcions(descMenuGestioPrestecs);
        OpcionsMenuGestioPrestecs opcio;
        do {
            menuPrestecs.mostrarMenu();
            opcio = menuPrestecs.getOpcio(sc);

            switch (opcio) {
                case MENU_GESTIO_PRESTECS_ADD:
                    afegirPrestec(sc);
                    break;
                case MENU_GESTIO_PRESTECS_REMOVE:
                    cancelarPrestec(sc);
                    break;
                case MENU_GESTIO_PRESTECS_VIEW:
                    showList("PRÉSTECS", adaptador.llistarPrestec(false));
                    break;
                case MENU_GESTIO_PRESTECS_VIEW_URG:
                    showList("PRÉSTECS NO RETORNATS", adaptador.llistarPrestec(true));
                    break;
                case MENU_GESTIO_PRESTECS_EXIT:
                    break;
            }

        } while (opcio != OpcionsMenuGestioPrestecs.MENU_GESTIO_PRESTECS_EXIT);
    }
    
    /**
     * Afegir un nou prestec
     * @param sc
     */
    
    private void afegirPrestec(Scanner sc){
        System.out.println("Introdueix la posició de l'usuari en la llista: ");
        int posUsuari = sc.nextInt();
        sc.nextLine();

        System.out.println("Introdueix la posició de l'exemplar en la llista: ");
        int posExemplar = sc.nextInt();
        sc.nextLine();

        boolean esLlarg = false;
        String llarg = "";
        do {
            System.out.println("És un préstec llarg? (y/n): ");
            llarg = sc.next();
            if (llarg.equals("y")) {
                esLlarg = true;
            } else  if (llarg.equals("n")) {
                esLlarg = false;
            } else  {
                System.out.println("Format incorrecte");
            }
        }
        while (!llarg.equals("y") && !llarg.equals("n"));

        try {
            adaptador.afegirPrestec(posExemplar, posUsuari, esLlarg);
        } catch (BiblioException e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelarPrestec(Scanner sc){
        System.out.println("Introdueix la posició del préstec a retornar en la llista: ");
        int posPrestec = sc.nextInt();
        try {
            adaptador.retornarPrestec(posPrestec);
        } catch (BiblioException e) {
            System.out.println(e.getMessage());
        }
    }

     /**
     * Mostra una llista d'objectes
     * @param title Títol a posar com a capçalera
     * @param lines Llista d'objectes per mostrar
     */
    private void showList(String title, List<String> lines) {
        System.out.println("============================================");
        System.out.println(title);
        System.out.println("============================================");
        int i = 0;
        for(String l : lines) {
            System.out.println("\t[" + (i++) + "] " + l);
        }
        System.out.println("============================================");
    }


    /**
     * Demana el camí d'un fitxer
     * @param sc Objecte per a la lectura de dades de teclat
     * @param mustExist Exigeix que el fitxer existeixi (True) o no (False)
     * @return Ruta al fitxer entrada per l'usuari o null si s'ha cancelat
     */
    private String getFilePath(Scanner sc, boolean mustExist) {
        String filePath = null;

        // Mostrar el missatge demanant la entrada
        System.out.println("Entra ruta completa fitxer (o ENTER per ometre):");

            // Llegim la ruta del fitxer
            filePath = sc.nextLine();

            // Si la ruta està buida retornem un null
            if(filePath.isEmpty()) {
                return null;
            }

        return filePath;
    }

}
