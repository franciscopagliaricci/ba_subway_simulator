import java.util.ArrayList;
import java.util.List;


public class LineACreator {

	private Line a;
	public void create() throws Exception {
		String[] names = { "San Pedrito", "San Jose de Flores",
				"Carabobo", "Puan", "Primera Junta", "Acoyte",
				"Rio de Janeiro", "Castro Barros", "Loria", "Plaza Miserere",
				"Alberti-Pasco", "Congreso", "Saenz Peña", "Lima", "Piedras",
				"Peru", "Plaza de Mayo" };
		// Numbers from 1 to 100 - 100 meaning very popular at that time
		Integer[][] popularity = {
			//    5     6    7     8     9    10   11   12   13   14   15   16   17   18   19   20   21   22
/* San Pedrito */{10,   5,    5,    1,   1,    5,  10,  10,  20,  30,  40, 200, 300, 300, 300,  50,  50,  50},
/* San Jose    */{10,   5,    5,    2,   2,    5,  10,  15,  20,  30,  40, 100, 200, 200, 200,  65,  50,  50},
/* Carabobo    */{10,   7,    7,    5,   5,   10,  15,  20,  25,  30,  40,  80, 200, 200, 200,  65,  50,  50},
/* Puan        */{10,  10,   10,    7,   7,   10,  15,  20,  25,  30,  30,  30, 200, 200, 200,  40,  40,  40},
/* Primera Jun */{10,   7,    7,    5,   5,   10,  15,  20,  25,  30,  40,  50, 200, 200, 200,  65,  50,  50},
/* Acoyte      */{20,   10,   9,    5,   5,   30,  30,  30,  30,  30,  40,  40, 100,  80,  80,  40,  40,  40},
/* Rio de Jan  */{20,   10,   9,    7,   7,   30,  30,  30,  30,  30,  40,  40,  70,  70,  70,  40,  40,  40},
/* Castro Barr */{25,   20,  10,    7,   7,   35,  30,  30,  30,  30,  30,  30,  60,  50,  50,  30,  30,  30},
/* Loria       */{30,   20,  15,   10,  10,   40,  40,  40,  40,  30,  30,  30,  30,  30,  30,  40,  40,  40},
/* Plaza Miser */{50,   50,  17,   20,  20,   40,  90,  90,  90,  90,  80,  50,  25,  20,  20,  25,  20,  20},
/* AlbertiPasc */{50,   55,  20,   20,  20,   50,  50,  50,  40,  30,  30,  20,  25,  20,  20,  25,  50,  50},
/* Congreso    */{60,   55,  25,   20,  20,   60,  50,  30,  30,  30,  30,  20,  20,  10,  10,  20,  20,  20},
/* Saenz Peña  */{60,   55,  35,   30,  30,   60,  50,  30,  30,  30,  30,  20,  20,  10,  10,  20,  20,  20},
/* Lima        */{70,   70,  50,   45,  45,   70,  70,  60,  50,  50,  50,  30,  15,   7,   7,  15,  50,  50},
/* Piedras     */{70,   80,  80,   80,  80,   80,  70,  60,  50,  40,  40,  20,  10,   5,   5,  10,  40,  40},
/* Peru        */{75,   85,  95,   95,  95,   85,  75,  60,  50,  40,  40,  20,   7,   2,   2,   7,  30,  30},
/* PlazadeMayo */{100, 200, 100,  100, 100,  150,  75,  60,  50,  40,  40,  20,   5,   1,   1,   5,  20,  20}
		};
		
		Integer[] xaxis = { 158, 206, 228, 267, 362, 440, 494, 536,
				592, 646, 668, 723, 750, 773, 816, 835, 868 };
		Integer[] yaxis = { 549, 500, 480, 440, 345, 319, 319, 319,
				319, 319, 319, 319, 319, 319, 319, 319, 319 };
		Integer[] lengths = { 90, 30, 60, 180, 100, 80, 50, 70, 60, 40,
				40, 30, 25, 40, 10, 30, 0 };
//		 0 trenes
		Integer[] frequency = { 450, 450, 265, 175, 175, 265, 265, 265,
				265, 265, 265, 295, 295, 175, 175, 420, 420, 420 };
		// 1 tren
//		Integer[] frequency = { 450, 450, 265, 153, 153, 265, 265, 265,
//				265, 265, 265, 295, 153, 153, 153, 420, 420, 420 };
		// 2 trenes
//		Integer[] frequency = { 450, 450, 265, 142, 142, 265, 265, 265,
//				265, 265, 265, 295, 142, 142, 142, 420, 420, 420 };
		// 3 trenes
//		Integer[] frequency = { 450, 450, 265, 130, 130, 265, 265, 265,
//				265, 265, 265, 295, 130, 130, 130, 420, 420, 420 };
		
		a = new Line(names, xaxis, yaxis, lengths, frequency, SubwayMap.Lines.A, popularity);
		setPersonArrivalChance();
		setPopularityLineChange();
	}

	public void setPopularityLineChange(){
		a.lineChangePopularity.put(SubwayMap.Lines.C, 10);
		a.lineChangePopularity.put(SubwayMap.Lines.H, 1);
		a.lineChangePopularity.put(SubwayMap.Lines.D, 5);
		a.lineChangePopularity.put(SubwayMap.Lines.E, 5);
	}
	
	public void setCombinations(){
		Station source = Line.allStations.get(SubwayMap.Lines.A+"Plaza Miserere");
		List<Station> target = new ArrayList<Station>();
		target.add(Line.allStations.get(SubwayMap.Lines.H+"Once"));
		Line.combinations.put(source, target);

		source = Line.allStations.get(SubwayMap.Lines.A+"Lima");
		target = new ArrayList<Station>();
		target.add(Line.allStations.get(SubwayMap.Lines.C+"Avenida de Mayo"));
		Line.combinations.put(source, target);

		source = Line.allStations.get(SubwayMap.Lines.A+"Peru");
		target = new ArrayList<Station>();
		target.add(Line.allStations.get(SubwayMap.Lines.D+"Catedral"));
		target.add(Line.allStations.get(SubwayMap.Lines.E+"Bolivar"));
		Line.combinations.put(source, target);	
	}
	
	public void setPersonArrivalChance() throws Exception{
		// 100 ronda en los 3s, 1 en los 300s
		// Cuanto mas grande el numero, mas rapido llegan a la estacion!
		Integer[] sanPedrito = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
			    65 ,  50 ,  45 , 9000, 9000, 200 ,  80 ,  40 ,  40 ,  40  , 35  , 35  , 25  , 15  , 10  , 20  , 20  , 10 };
		new PersonArrivalSimulator(sanPedrito, Line.allStations.get(SubwayMap.Lines.A+"San Pedrito")).start(0L);
		
		Integer[] sanJose = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				50 ,  35 ,  35 ,  500,  500, 100 , 80 ,  40 ,  40 ,  40  , 35  , 25  , 15  , 10  , 15  , 20  , 20  , 10 };
		new PersonArrivalSimulator(sanJose, Line.allStations.get(SubwayMap.Lines.A+"San Jose de Flores")).start(0L);

		Integer[] carabobo = {
//			    5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
			    45 ,  30 ,  30 ,  100,  500,  55 ,  50 ,  40 ,  40 ,  40  , 30  , 25  , 20  , 10  , 10  , 20  , 20  , 10 };
		new PersonArrivalSimulator(carabobo, Line.allStations.get(SubwayMap.Lines.A+"Carabobo")).start(0L);

		Integer[] puan = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				25 ,  25 ,  25 ,   70,   90,  35 ,  40 ,  40 ,  40 ,  40  , 30  , 25  , 20  , 10  , 10  , 20  , 20  , 10 };
		new PersonArrivalSimulator(puan, Line.allStations.get(SubwayMap.Lines.A+"Puan")).start(0L);

		Integer[] primeraJunta = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				20 ,  20 ,  20 ,   65,   70,  25 ,  40 ,  40 ,  40 ,  40  , 40  , 30  , 20  , 10  , 10  , 20  , 20  , 10 };
		new PersonArrivalSimulator(primeraJunta, Line.allStations.get(SubwayMap.Lines.A+"Primera Junta")).start(0L);

		Integer[] acoyte = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  20 ,  20 ,   40,   50,  20 ,  40 ,  40 ,  40 ,  40  , 30  , 20  , 20  , 20  , 20  , 20  , 10  , 10 };
		new PersonArrivalSimulator(acoyte, Line.allStations.get(SubwayMap.Lines.A+"Acoyte")).start(0L);
	
		Integer[] riodeJaneiro = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  20 ,  20 ,   30,   35,  20 ,  40 ,  40 ,  40 ,  40  , 30  , 20  , 20  , 20  , 20  , 20  , 10  , 10 };
		new PersonArrivalSimulator(riodeJaneiro, Line.allStations.get(SubwayMap.Lines.A+"Rio de Janeiro")).start(0L);

		Integer[] castroBarros = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  15 ,  25 ,   25,   32,  20 ,  40 ,  40 ,  40 ,  40  , 30  , 30  , 30  , 30  , 30  , 20  , 10  , 10 };
		new PersonArrivalSimulator(castroBarros, Line.allStations.get(SubwayMap.Lines.A+"Castro Barros")).start(0L);

		Integer[] loria = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  10 ,  23 ,   25,   30,  20 ,  40 ,  40 ,  40 ,  40  , 40  , 30  , 30  , 30  , 30  , 20  , 10  , 10 };
		new PersonArrivalSimulator(loria, Line.allStations.get(SubwayMap.Lines.A+"Loria")).start(0L);

		Integer[] plazaMiserere = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  10 ,  15 ,   20,   30,  30 ,  30 ,  30 ,  30 ,  40  , 50  , 30  , 30  , 30  , 30  , 25  , 20  , 10 };
		new PersonArrivalSimulator(plazaMiserere, Line.allStations.get(SubwayMap.Lines.A+"Plaza Miserere")).start(0L);

		Integer[] albertiPasco = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  15 ,  25 ,  25,   30,   40 ,  40 ,  30 ,  30 ,  40  , 40  , 30  , 30  , 30  , 30  , 25  , 20  , 10 };
		new PersonArrivalSimulator(albertiPasco, Line.allStations.get(SubwayMap.Lines.A+"Alberti-Pasco")).start(0L);

		Integer[] congreso = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  15 ,  25 ,  25,   30,   40 ,  40 ,  40 ,  40 ,  40  , 40  , 40  , 40 ,  40 , 40  , 30  , 20  , 10 };
		new PersonArrivalSimulator(congreso, Line.allStations.get(SubwayMap.Lines.A+"Congreso")).start(0L);

		Integer[] saenzPeña = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  15 ,  25 ,   25,   30,  30 ,  40 ,  40 ,  40 ,  40  , 50  , 40  , 45  , 40  , 40  , 30  , 20  , 10 };
		new PersonArrivalSimulator(saenzPeña, Line.allStations.get(SubwayMap.Lines.A+"Saenz Peña")).start(0L);

		Integer[] lima = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  15 ,  25 ,   30,   35,  20 ,  40 ,  40 ,  40 ,  40  , 50  , 40  , 50 ,  50 ,  50 , 30  , 20  , 10 };
		new PersonArrivalSimulator(lima, Line.allStations.get(SubwayMap.Lines.A+"Lima")).start(0L);

		Integer[] piedras = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  15 ,  25 ,   30,   35,  20 ,  40 ,  40 ,  40 ,  40  , 45  , 55  , 50,   50,   60 , 40  , 30  , 10 };
		new PersonArrivalSimulator(piedras, Line.allStations.get(SubwayMap.Lines.A+"Piedras")).start(0L);

		Integer[] peru = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  15 ,  25 ,   35,   35,  20 ,  40 ,  40 ,  40 ,  40  , 50  , 50  , 60  , 60,  60, 40  , 40  , 10 };
		new PersonArrivalSimulator(peru, Line.allStations.get(SubwayMap.Lines.A+"Peru")).start(0L);

		Integer[] plazadeMayo = {
//				5      6     7     8     9    10    11    12    13    14    15    16    17    18    19    20    21    22
				10 ,  15 ,  25 ,   35,   35,  20 ,  40 ,  40 ,  40 ,  40  , 55  , 55 ,  60,   60 ,  60 , 40 , 40  , 10 };
		new PersonArrivalSimulator(plazadeMayo, Line.allStations.get(SubwayMap.Lines.A+"Plaza de Mayo")).start(0L);
	}
}