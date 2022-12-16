import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Witaj, proszę podaj rozmiar planszy: ");
        int wymiar = new Scanner(System.in).nextInt();
        char gamer = 'X';
        char[][] plansza =  new char[wymiar][wymiar];
                /*{{'O','X','X'},
                {' ','O','O'},
                {'O','X',' '}}; */

        boolean kontynuacja = true;
        int licnzikRuchow = 0;
        while(kontynuacja && licnzikRuchow<=wymiar*wymiar) {
            TicTacToe.drukujPlansze(plansza);
            boolean ruchPoprawny = wykonajRuch(plansza,gamer);
            if(ruchPoprawny)
            {
                licnzikRuchow++;
                boolean wygranaWiersze = sprawdzWiersze(plansza,gamer);
                boolean wygranaKolumny = sprawdzKolumny(plansza,gamer);
                boolean wygranaSkos1 = sprawdzSkos1(plansza,gamer);
//                boolean wygranaSkos2 = sprawdzSkos2(plansza,gamer);
                if(wygranaWiersze || wygranaKolumny || wygranaSkos1){
                    TicTacToe.drukujPlansze(plansza);
                    System.out.println("Gratulacje " + gamer);
                    kontynuacja = false;
                }
                gamer = gamer == 'X' ? 'O' : 'X';
            }
        }
    }

    public static boolean sprawdzWiersze(char[][] plansza, char symbol){
        int wymiar = plansza.length;
        for(int wiersz=0;wiersz<wymiar;wiersz++){
            boolean wygrana = true;
            for(int kolumna=0;kolumna<wymiar;kolumna++){
                if(plansza[wiersz][kolumna] != symbol){
                    wygrana = false;
                    break;
                }
            }
            if(wygrana){return true;}
        }
        return false;
    }

    public static boolean sprawdzKolumny(char[][] plansza, char symbol){
        int wymiar = plansza.length;
        for(int kolumna=0;kolumna<wymiar;kolumna++){
            boolean wygrana = true;
            for(int wiersz=0;wiersz<wymiar;wiersz++){
                if(plansza[wiersz][kolumna] != symbol){
                    wygrana = false;
                    break;
                }
            }
            if(wygrana){return true;}
        }
        return false;
    }

    public static boolean sprawdzSkos1(char[][] plansza, char symbol){
        int wymiar = plansza.length;
        for(int i=0;i<wymiar;i++){
            if(plansza[i][i]!=symbol){
                return false;
            }
        }
        return true;
    }


    public static boolean wykonajRuch(char[][] plansza, char symbol){
        System.out.println(symbol + " Twoj ruch");
        System.out.println("Podaj index wiersza");
        int wiersz = new Scanner(System.in).nextInt();
        System.out.println("Podaj index kolumny");
        int kolumna = new Scanner(System.in).nextInt();
        boolean ruchPoprawny = plansza[wiersz][kolumna] == 0;
        if(!ruchPoprawny){
            System.out.println("Ruch niepoprawny");
            return false;
        }
        plansza[wiersz][kolumna] = symbol;
        return true;
    }

    public static void drukujPlansze(char[][] plansza){
        int wymiar = plansza.length;

        System.out.print("\t");

        for( int i = 0; i<wymiar; i++){
            System.out.print(i+"\t");
        }
        System.out.println();

        for(int wiersz =0; wiersz<plansza.length; wiersz++){
            System.out.print(wiersz + ":\t");
            for(int kolumna=0;kolumna<plansza[wiersz].length;kolumna++){
                System.out.print(plansza[wiersz][kolumna] + "\t");
            }
            System.out.println();
        }
    }

}
