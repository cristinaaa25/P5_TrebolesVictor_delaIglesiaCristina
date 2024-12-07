package greedy;

import estructura.Encreuades;
import estructura.PosicioInicial;

public class SolucióVoraç {
    private final Encreuades repte;
    private char[][] solucio;

    public SolucióVoraç(Encreuades repte) {
        this.repte = repte;
        this.solucio = this.repte.getPuzzle();
        this.solucio = this.greedy();
    }

    public char[][] getSolucio() {
        return this.solucio;
    }

    private char[][] greedy(){
        int index = 0;
        while (!esSolucio(index) && index < this.repte.getEspaisDisponibles().size()) {
            for(int i = 0; i < this.repte.getItemsSize(); i++) {
                if (acceptable(index, i)) {
                    anotarASolucio(index, i);
                    break;
                }
            }
            index++;
        }
        if(esSolucio(index)) {
            return solucio;
        } else {
            return null;
        }
    }


    private boolean esSolucio(int index) {
        return index == this.repte.getEspaisDisponibles().size();
    }

    private boolean acceptable(int indexUbicacio, int indexItem) {
        if(indexUbicacio >= this.repte.getEspaisDisponibles().size()) return false;
        char[] item = this.repte.getItem(indexItem);

        PosicioInicial posicio = this.repte.getEspaisDisponibles().get(indexUbicacio);
        if (item.length != posicio.getLength()) {
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
        for (int i = 0; i < item.length; i++) {
            if (posicio.getDireccio() == 'H') {
                solucio[posicio.getInitRow()][posicio.getInitCol() + i] = item[i];
            } else {
                solucio[posicio.getInitRow() + i][posicio.getInitCol()] = item[i];
            }
        }
    }
}
