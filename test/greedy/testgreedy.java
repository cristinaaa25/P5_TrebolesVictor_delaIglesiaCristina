package greedy;

import backtracking.SolucioBacktracking;
import estructura.Encreuades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class testgreedy {
    @Test
    void testsolucioNumeros() {
        char[][] puzzle = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '▪'},
                {' ', '▪', ' ', '▪', '▪', ' ', '▪', ' ', '▪', ' '},
                {' ', '▪', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '▪', '▪', ' ', '▪', ' ', '▪', ' ', '▪', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '▪', '▪', ' ', '▪', ' ', '▪', ' ', '▪', ' '},
                {' ', ' ', ' ', ' ', '▪', ' ', ' ', ' ', ' ', ' '}
        };
        char[][] valors = {
                {'2', '8', '8', '8', '6', '7', '4', '8', '6', '6'},
                {'3', '4', '2', '6', '4', '8', '7', '9', '8'},
                {'7', '4', '6', '4', '2', '1', '6', '0'},
                {'3', '4', '6', '4', '2', '8', '8'},
                {'8', '3', '4', '1', '7', '9', '2'},
                {'9', '6', '1', '2', '8', '4', '7'},
                {'5', '0', '7', '6', '4', '2'},
                {'2', '5', '7', '5', '2'},
                {'4', '3', '8', '7', '9'},
                {'8', '2', '4', '9'},
                {'2', '8', '7'}
        };
        Encreuades exemple = new Encreuades(puzzle,valors);

        SolucióVoraç sol = new SolucióVoraç(exemple);
        char [][] trobat = sol.getSolucio();

        char[][] solucio = {
                {	'3',	'4',	'2',	'6',	'4',	'8',	'7',	'9',	'8',	'▪'},
                {	'4',	'▪',	'8',	'▪',	'▪',	'3',	'▪',	'6',	'▪',	'5'},
                {	'6',	'▪',	'7',	'4',	'6',	'4',	'2',	'1',	'6',	'0'},
                {	'4',	'▪',	'▪',	'3',	'▪',	'1',	'▪',	'2',	'▪',	'7'},
                {	'2',	'8',	'8',	'8',	'6',	'7',	'4',	'8',	'6',	'6'},
                {	'8',	'▪',	'▪',	'7',	'▪',	'9',	'▪',	'4',	'▪',	'4'},
                {	'8',	'2',	'4',	'9',	'▪',	'2',	'5',	'7',	'5',	'2'} };

        assertArrayEquals(solucio, trobat);


    }

    @Test
    void testSolucioParaules(){
        char[][] puzzle = {
                {' ',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	'▪',	' ',	' ',	' ',	' ',	' '},
                {'▪',	'▪',	' ',	'▪',	'▪',	' ',	'▪',	' ',	'▪',	' ',	'▪',	'▪',	'▪',	' '},
                {' ',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	'▪',	'▪',	'▪',	' '},
                {' ',	'▪',	' ',	'▪',	'▪',	' ',	'▪',	' ',	'▪',	' ',	' ',	' ',	' ',	' '},
                {' ',	' ',	' ',	'▪',	'▪',	' ',	'▪',	' ',	'▪',	' ',	'▪',	' ',	'▪',	' '},
                {' ',	'▪',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	'▪',	' '},
                {' ',	'▪',	'▪',	' ',	'▪',	' ',	'▪',	'▪',	'▪',	' ',	'▪',	' ',	'▪',	' '},
                {' ',	' ',	' ',	' ',	'▪',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	' '},
                {' ',	'▪',	'▪',	' ',	'▪',	'▪',	'▪',	' ',	'▪',	' ',	'▪',	' ',	'▪',	' '},
                {' ',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	'▪',	' ',	'▪',	' ',	'▪',	'▪'},
                {' ',	'▪',	'▪',	' ',	'▪',	'▪',	'▪',	' ',	' ',	' ',	' ',	' ',	' ',	' '},
                {' ',	' ',	' ',	' ',	' ',	' ',	' ',	' ',	'▪',	'▪',	'▪',	' ',	'▪',	' '},
                {' ',	'▪',	'▪',	' ',	'▪',	'▪',	' ',	'▪',	'▪',	'▪',	'▪',	' ',	' ',	' '},
                {' ',	'▪',	'▪',	' ',	'▪',	'▪',	' ',	' ',	' ',	' ',	' ',	' ',	'▪',	' '},
                {' ',	' ',	' ',	' ',	' ',	' ',	' ',	'▪',	'▪',	'▪',	'▪',	' ',	' ',	' '}
        };
        char[][] valors = {
                "CONTEMPLAREIS".toCharArray(),
                "ORDENANCISMO".toCharArray(),
                "DESVINCULAR".toCharArray(),
                "APELOTONAD".toCharArray(),
                "COMPETIAIS".toCharArray(),
                "PANTOGRAFO".toCharArray(),
                "AUTOCTONO".toCharArray(),
                "MEZQUINEN".toCharArray(),
                "ZOLLIPAS".toCharArray(),
                "LINOLEUM".toCharArray(),
                "PATAPLUM".toCharArray(),
                "RETRANCA".toCharArray(),
                "PERECIA".toCharArray(),
                "SACONEA".toCharArray(),
                "CUORUM".toCharArray(),
                "LIMOSA".toCharArray(),
                "STABAT".toCharArray(),
                "ACLLA".toCharArray(),
                "DALLA".toCharArray(),
                "VIOLO".toCharArray(),
                "ZAMPA".toCharArray(),
                "CUCA".toCharArray(),
                "MEAN".toCharArray(),
                "NOS".toCharArray(),
                "ODA".toCharArray(),
                "SOL".toCharArray()
        };
        Encreuades exemple = new Encreuades(puzzle,valors);

        SolucióVoraç sol = new SolucióVoraç(exemple);

        char [][] trobat = sol.getSolucio();

        char[][] solucio = {
                {	'Z',	'O',	'L',	'L',	'I',	'P',	'A',	'S',	'▪',	'D',	'A',	'L',	'L',	'A',},
                {	'▪',	'▪',	'I',	'▪',	'▪',	'A',	'▪',	'T',	'▪',	'E',	'▪',	'▪',	'▪',	'U',},
                {	'C',	'O',	'M',	'P',	'E',	'T',	'I',	'A',	'I',	'S',	'▪',	'▪',	'▪',	'T',},
                {	'O',	'▪',	'O',	'▪',	'▪',	'A',	'▪',	'B',	'▪',	'V',	'I',	'O',	'L',	'O',},
                {	'N',	'O',	'S',	'▪',	'▪',	'P',	'▪',	'A',	'▪',	'I',	'▪',	'R',	'▪',	'C',},
                {	'T',	'▪',	'A',	'P',	'E',	'L',	'O',	'T',	'O',	'N',	'A',	'D',	'▪',	'T',},
                {	'E',	'▪',	'▪',	'A',	'▪',	'U',	'▪',	'▪',	'▪',	'C',	'▪',	'E',	'▪',	'O',},
                {	'M',	'E',	'A',	'N',	'▪',	'M',	'E',	'Z',	'Q',	'U',	'I',	'N',	'E',	'N',},
                {	'P',	'▪',	'▪',	'T',	'▪',	'▪',	'▪',	'A',	'▪',	'L',	'▪',	'A',	'▪',	'O',},
                {	'L',	'I',	'N',	'O',	'L',	'E',	'U',	'M',	'▪',	'A',	'▪',	'N',	'▪',	'▪',},
                {	'A',	'▪',	'▪',	'G',	'▪',	'▪',	'▪',	'P',	'E',	'R',	'E',	'C',	'I',	'A',},
                {	'R',	'E',	'T',	'R',	'A',	'N',	'C',	'A',	'▪',	'▪',	'▪',	'I',	'▪',	'C',},
                {	'E',	'▪',	'▪',	'A',	'▪',	'▪',	'U',	'▪',	'▪',	'▪',	'▪',	'S',	'O',	'L',},
                {	'I',	'▪',	'▪',	'F',	'▪',	'▪',	'C',	'U',	'O',	'R',	'U',	'M',	'▪',	'L',},
                {	'S',	'A',	'C',	'O',	'N',	'E',	'A',	'▪',	'▪',	'▪',	'▪',	'O',	'D',	'A',}
        };

        assertArrayEquals(solucio, trobat);
    }
}
