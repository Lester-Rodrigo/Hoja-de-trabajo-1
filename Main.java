import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRadio radio = new CarRadio();
        Scanner scanner = new Scanner(System.in);
        int pag;
        String mod;

        System.out.println("1. Prender radio: ");
        System.out.println("2. Salir: ");
        System.out.println("Ingrese alguna opción (Del 1 al 2): ");
        pag = scanner.nextInt();
        System.out.println("-------------------------------------------------------------"); 
        switch (pag) {
            case 1:
                radio.PowerOn();
                break;
        
            case 2:
                System.exit(0);
                break;
        }
        if (radio.isRadioOn() == true) {
            do {
                do {
                    if (radio.isRadioAM() == true) {
                        mod = "AM";
                    }
                    else {
                        mod = "FM";
                    }
                    System.out.println("Está escuchando: " + radio.getCurrentStation() + " " + mod);
                    System.out.println("1. Cambia de AM a FM a AM: ");
                    System.out.println("2. Avanzar en el dial de las emisoras: ");
                    System.out.println("3. Retroceder en el dial de las emisoras: ");
                    System.out.println("4. Guardar emisora: ");
                    System.out.println("5. Seleccionar emisora guardada: ");
                    System.out.println("6. Apagar el radio: ");
                    System.out.println("7. Salir: ");
                    System.out.println("Ingrese alguna opción (Del 1 al 7): ");
                    pag = scanner.nextInt();
                    System.out.println("-------------------------------------------------------------"); 
    
                } while (pag < 1 || pag > 7);
                switch (pag) {
                    case 1:
                        radio.ChangeModulation();
                        System.out.println("-------------------------------------------------------------"); 
                        break;
                
                    case 2:
                        radio.MoveStationForward();
                        System.out.println("-------------------------------------------------------------"); 
                        break;

                    case 3:
                        radio.MoveStationBackward();
                        System.out.println("-------------------------------------------------------------"); 
                        break;

                    case 4:
                        System.out.println("Ingrese el número de posición (1-12) para guardar la emisora: ");
                        int saveSlot = scanner.nextInt();
                        radio.SaveToFavorite(saveSlot);
                        System.out.println("-------------------------------------------------------------"); 
                        break;

                    case 5:
                        System.out.println("Ingrese el número de posición (1-12) para seleccionar la emisora guardada: ");
                        int favoriteSlot = scanner.nextInt();
                        radio.GoFavorite(favoriteSlot);
                        System.out.println("-------------------------------------------------------------"); 
                        break;

                    case 6:
                        radio.PowerOn();
                        System.out.println("1. Prender radio: ");
                        System.out.println("2. Salir: ");
                        System.out.println("Ingrese alguna opción (Del 1 al 2): ");
                        pag = scanner.nextInt();
                        System.out.println("-------------------------------------------------------------"); 
                        switch (pag) {
                            case 1:
                                radio.PowerOn();
                                break;
                        
                            case 2:
                                System.exit(0);
                                break;
                        }
                        break;

                    case 7:
                        System.exit(0);
                        break;
                }
            } while (pag != 7);
        }
        scanner.close();
    }
}