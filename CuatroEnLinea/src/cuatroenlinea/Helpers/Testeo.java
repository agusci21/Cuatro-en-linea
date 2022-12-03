package cuatroenlinea.Helpers;

class Testeo {
    public static void main(String[] args) {
        veryfyDiagonals();
    }
    private static boolean veryfyDiagonals() {
        System.out.print("\033[H\033[2J");
    
        String diagonal = "";
        for(int i = 0; i < 4; i++){
          int[][] pointMatrix = {
        //x| 0,1,2,3,4,5,6 
            {0,0,0,0,0,0,0}, //0
            {0,0,0,0,0,0,0}, //1
            {0,0,0,0,0,0,0}, //2
            {0,0,0,0,0,0,0}, //3
            {0,0,0,0,0,0,0}, //4
            {0,0,0,0,0,0,0}  //5
          };
          int x = 3 + i ;
          int y = 5 - i;
          diagonal += pointMatrix[y][x] ;
          if (diagonal.contains("1111") || diagonal.contains("2222")) {
            return true;
          }
        }
        diagonal = "";
        for(int i = 0; i < 5; i++){
          int[][] pointMatrix = {
        //x| 0,1,2,3,4,5,6 
            {0,0,0,0,0,0,0}, //0
            {0,0,0,0,0,0,1}, //1
            {0,0,0,0,0,0,0}, //2
            {0,0,0,0,0,0,0}, //3
            {0,0,0,0,0,0,0}, //4
            {0,0,1,0,0,0,0}  //5
          };
          int x = 2 + i ;
          int y = 5 - i;
          diagonal += pointMatrix[y][x] ;
          if (diagonal.contains("1111") || diagonal.contains("2222")) {
            return true;
          }
        }
    
        return false;
      }
}
