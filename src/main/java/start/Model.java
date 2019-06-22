package start;

public class Model {
	private int columnas= 10;
	private int filas =10;
	private String [][] mapajuego = new String[columnas][filas];
	
	public Model() {
		for(int i=0; i<columnas; i++) {
			for(int j = 0; j< filas; j++) {
				if(i==2 && j==2) {
					mapajuego[i][j]="A";
				}
				else
				mapajuego[i][j]="X";
			}
		}
	}
	
	public String convertirmapa() {
		String mapita="";
		for(int i=0; i<columnas; i++) {
			String temp="";
			for(int j = 0; j< filas; j++) {
				if(j==9){
					temp+= mapajuego[i][j];
				}
				else
					temp+= mapajuego[i][j] + " ";
			}
			if(i!=9)
				mapita+= temp + "\n";
		}
		System.out.println(mapita);
		return mapita;
	}
	
	public String moverse() {
		boolean a=false;
		for(int i=0; i<columnas; i++) {
			for(int j = 0; j< filas; j++) {
				if(a) {
					mapajuego[i][j]="A";
					return convertirmapa();
				}
				if(mapajuego[i][j].equals("A")) {
					mapajuego[i][j]="0";
					a=true;
				}
			}
		}
		return convertirmapa();
		
	}

}
