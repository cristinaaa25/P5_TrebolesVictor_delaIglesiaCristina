package backtracking;
import estructura.Encreuades;
import estructura.PosicioInicial;

public class SolucioBacktracking {

	private char[][] solucio;
	private char[][] solucioMillor;
	private final Encreuades repte;
	private boolean[] markatge;
	private int numMillorSol = -1;


	public SolucioBacktracking(Encreuades repte) {
		this.repte = repte;
	}

	public char[][] getMillorSolucio() {
		return solucioMillor;
	}

	public Runnable start(boolean optim)
	{
		markatge = new boolean[this.repte.getItemsSize()];
		for (int i = 0; i < this.repte.getItemsSize(); i++) {
			markatge[i] = false;
		}

		this.solucio = this.repte.getPuzzle();
		solucioMillor = this.repte.getPuzzle();

		if(!optim) {
			if (!this.backUnaSolucio(0))
				throw new RuntimeException("solució no trobada");
			guardarMillorSolucio();

		}else
			this.backMillorSolucio(0);
		return null;
	}

	/* esquema recursiu que troba una solució
	 * utilitzem una variable booleana (que retornem)
	 * per aturar el recorregut quan haguem trobat una solució
	 */
	private boolean backUnaSolucio(int indexUbicacio) {
		boolean trobada = false;
		// iterem sobre els possibles elements
		for(int indexItem = 0; indexItem < this.repte.getItemsSize() && !trobada; indexItem++) {
			//mirem si l'element es pot posar a la ubicació actual
			if(acceptable(indexUbicacio, indexItem)) {
				//posem l'element a la solució actual
				anotarASolucio(indexUbicacio, indexItem);

				if(esSolucio(indexUbicacio)) { // és solució si totes les ubicacions estan plenes
					return true;
				} else
					trobada = this.backUnaSolucio(indexUbicacio+1); //inserim la següent paraula
				if(!trobada)
					// esborrem la paraula actual, per després posar-la a una altra ubicació
					desanotarDeSolucio(indexUbicacio, indexItem);
			}
		}
		return trobada;
	}
	/*
	 * Esquema recursiu que busca totes les solucions
	 * no cal utilitzar una variable booleana per aturar perquè busquem totes les solucions
	 * cal guardar una COPIA de la millor solució a una variable
	 */
	private void backMillorSolucio(int indexUbicacio) {
		for (int indexItem = 0; indexItem < this.repte.getItemsSize(); indexItem++) {
			if (acceptable(indexUbicacio, indexItem)) {
				anotarASolucio(indexUbicacio, indexItem);
				if (esSolucio(indexUbicacio)) {
					guardarMillorSolucio();
				} else {
					backMillorSolucio(indexUbicacio + 1);
				}
				desanotarDeSolucio(indexUbicacio, indexItem);
			}
		}

	}

	private boolean acceptable(int indexUbicacio, int indexItem) {
		if(indexUbicacio >= this.repte.getEspaisDisponibles().size()) return false;
		char[] item = this.repte.getItem(indexItem);

		PosicioInicial posicio = this.repte.getEspaisDisponibles().get(indexUbicacio);
		if (item.length != posicio.getLength()) {
			return false;
		}
		if (markatge[indexItem]) {
			return false;
		}
		if (posicio.getDireccio() == 'H') {
			for (int i = 0; i < item.length; i++) {
				if (solucio[posicio.getInitRow()][posicio.getInitCol() + i] != ' ' && solucio[posicio.getInitRow()][posicio.getInitCol() + i] != item[i]) {
					return false;
				}
			}
		} else {
			for (int i = 0; i < item.length; i++) {
				if (solucio[posicio.getInitRow() + i][posicio.getInitCol()] != ' ' && solucio[posicio.getInitRow() + i][posicio.getInitCol()] != item[i]) {
					return false;
				}
			}
		}
		return true;
	}

	private void anotarASolucio(int indexUbicacio, int indexItem) {
		char[] item = this.repte.getItem(indexItem);
		PosicioInicial posicio = this.repte.getEspaisDisponibles().get(indexUbicacio);
		// item i posicio mateixa longitud
		for (int i = 0; i < item.length; i++) {
			if (posicio.getDireccio() == 'H') {
				solucio[posicio.getInitRow()][posicio.getInitCol() + i] = item[i];
				markatge[indexItem] = true;
			} else {
				solucio[posicio.getInitRow() + i][posicio.getInitCol()] = item[i];
				markatge[indexItem] = true;
			}
		}
	}

	private void desanotarDeSolucio(int indexUbicacio, int indexItem) {
		PosicioInicial posicio = this.repte.getEspaisDisponibles().get(indexUbicacio);

		for(int i = 0; i < posicio.getLength(); i++) {
			if(posicio.getDireccio() == 'H') {
				if (esPotEliminar(posicio.getInitRow(), posicio.getInitCol() + i, 'H')) {
					solucio[posicio.getInitRow()][posicio.getInitCol() + i] = ' ';
					markatge[indexItem] = false;
				}
			} else {
				if (esPotEliminar(posicio.getInitRow() + i, posicio.getInitCol(), 'V')) {
					solucio[posicio.getInitRow() + i][posicio.getInitCol()] = ' ';
					markatge[indexItem] = false;
				}
			}
		}
	}

	private boolean esPotEliminar(int x, int y, char direccio) {
		try {
			if (direccio == 'H') {
				return  ((x - 1 < 0 || this.solucio[x - 1][y] == '▪' || this.solucio[x - 1][y] == ' ') &&
						(x + 1 >= this.solucio.length || this.solucio[x + 1][y] == '▪' || this.solucio[x + 1][y] == ' '));
			} else {
				return ((y - 1 < 0 || this.solucio[x][y - 1] == '▪' || this.solucio[x][y - 1] == ' ') &&
						(y + 1 >= this.solucio[0].length || this.solucio[x][y + 1] == '▪' || this.solucio[x][y + 1] == ' '));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}


	private boolean esSolucio(int index) {
		return index+1 == this.repte.getEspaisDisponibles().size();
	}


	private int calcularFuncioObjectiu(char[][] matriu) {
		int valor = 0;
		for(int i = 0; i < matriu.length; i++) {
			for(int j = 0; j < matriu[i].length; j++) {
				if(matriu[i][j] != '▪' && matriu[i][j] != ' ') valor += matriu[i][j];
			}
		}
		return valor;
	}

	private void guardarMillorSolucio() {
		int puntuacioActual = calcularFuncioObjectiu(this.solucio);

		if (puntuacioActual > numMillorSol){
			for (int i = 0; i < solucio.length; i++){
				for (int j = 0; j < solucio[i].length; j++){
					solucioMillor[i][j] = solucio[i][j];
				}
			}
			numMillorSol = puntuacioActual;
		}
	}

	public String toString() {
		StringBuilder resultat = new StringBuilder();
		for (char[] chars : solucio) {
			for (char aChar : chars) {
				resultat.append(aChar).append(" ");
			}
			resultat.append("\n");
		}
		return resultat.toString();
	}

}