import java.util.Collections;
import java.util.Vector;

public class Main {
	static String cadena = "HolaNuevoMundo";
	static Vector<Character> valpha;

	public static void main(String[] args) {
		String alpha =	 "M-FVFLVL-LPLVSSQCVNLTTRTQLPPAYTNSFTRGVYYPDKVFRSSVLHSTQDLFLPFFSNVTWFHAISGTNGTKRFDNPVLPFNDGVYFASTEKSNIIRGWIFGTTLDSKTQSLLIVNNATNVVIKVCEFQFCNDPFLGVYHKNNKSWMESEFRVYSSANNCTFEYVSQPFLMDLEGKQGNFKNLREFVFKNIDGYFKIYSKHTPINLVRDLPQGFSALEPLVDLPIGINITRFQTLLALHRSYLTPGDSSSGWTAGAAAYYVGYLQPRTFLLKYNENGTITDAVDCALDPLSETKCTLKSFTVEKGIYQTSNFRVQPTESIVRFPNITNLCPFGEVFNATRFASVYAWNRKRISNCVADYSVLYNSASFSTFKCYGVSPTKLNDLCFTNVYADSFVIRGDEVRQIAPGQTGKIADYNYKLPDDFTGCVIAWNSNNLDSKVGGNYNYLYRLFRKSNLKPFERDISTEIYQAGSTPCNGVEGFNCYFPLQSYGFQPTYGVGYQPYRVVVLSFELLHAPATVCGPKKSTNLVKNKCVNFNFNGLTGTGVLTESNKKFLPFQQFGRDIDDTTDAVRDPQTLEILDITPCSFGGVSVITPGTNTSNQVAVLYQGVNCTEVPVAIHADQLTPTWRVYSTGSNVFQTRAGCLIGAEHVNNSYECDIPIGAGICASYQTQTNSHRRARSVASQSIIAYTMSLGAENSVAYSNNSIAIPINFTISVTTEILPVSMTKTSVDCTMYICGDSTECSNLLLQYGSFCTQLNRALTGIAVEQDKNTQEVFAQVKQIYKTPPIKDFGGFNFSQILPDPSKPSKRSFIEDLLFNKVTLADAGFIKQYGDCLGDIAARDLICAQKFNGLTVLPPLLTDEMIAQYTSALLAGTITSGWTFGAGAALQIPFAMQMAYRFNGIGVTQNVLYENQKLIANQFNSAIGKIQDSLSSTASALGKLQDVVNQNAQALNTLVKQLSSNFGAISSVLNDILARLDKVEAEVQIDRLITGRLQSLQTYVTQQLIRAAEIRASANLAATKMSECVLGQSKRVDFCGKGYHLMSFPQSAPHGVVFLHVTYVPAQEKNFTTAPAICHDGKAHFPREGVFVSNGTHWFVTQRNFYEPQIITTHNTFVSGNCDVVIGIVNNTVYDPLQPELDSFKEELDKYFKNHTSPDVDLGDISGINASVVNIQKEIDRLNEVAKNLNESLIDLQELGKYEQYIKWPWYIWLGFIAGLIAIVMVTIMLCCMTSCCSCLKGCCSCGSCCKFDEDDSEPVLKGVKLHYT--------------------";
		String omicron = "M-FVF-LVLL-PLVSSQCVNLTTRTQLPPAYTNSFTRGVYYPDKVFRSSVLHSTQDLFLPFFSNVTWFHVISGTNGTKRFDNPVLPFNDGVYFASIEKSNIIRGWIFGTTLDSKTQSLLIVNNATNVVIKVCEFQFCNDPFLDHKNNKSWMESEFRVYSSANNCTFEYVSQPFLMDLEGKQGNFKNLREFVFKNIDGYFKIYSKHTPIIVREPEDLPQGFSALEPLVDLPIGINITRFQTLLALHRSYLTPGDSSSGWTAGAAAYYVGYLQPRTFLLKYNENGTITDAVDCALDPLSETKCTLKSFTVEKGIYQTSNFRVQPTESIVRFPNITNLCPFDEVFNATRFASVYAWNRKRISNCVADYSVLYNLAPFFTFKCYGVSPTKLNDLCFTNVYADSFVIRGDEVRQIAPGQTGNIADYNYKLPDDFTGCVIAWNSNKLDSKVSGNYNYLYRLFRKSNLKPFERDISTEIYQAGNKPCNGVAGFNCYFPLRSYSFRPTYGVGHQPYRVVVLSFELLHAPATVCGPKKSTNLVKNKCVNFNFNGLKGTGVLTESNKKFLPFQQFGRDIADTTDAVRDPQTLEILDITPCSFGGVSVITPGTNTSNQVAVLYQGVNCTEVPVAIHADQLTPTWRVYSTGSNVFQTRAGCLIGAEYVNNSYECDIPIGAGICASYQTQTKSHGSASSVASQSIIAYTMSLGAENSVAYSNNSIAIPTNFTISVTTEILPVSMTKTSVDCTMYICGDSTECSNLLLQYGSFCTQLKRALTGIAVEQDKNTQEVFAQVKQIYKTPPIKYFGGFNFSQILPDPSKPSKRSFIEDLLFNKVTLADAGFIKQYGDCLGDIAARDLICAQKFKGLTVLPPLLTDEMIAQYTSALLAGTITSGWTFGAGAALQIPFAMQMAYRFNGIGVTQNVLYENQKLIANQFNSAIGKIQDSLSSTASALGKLQDVVNHNAQALNTLVKQLSSKFGAISSVLNDIFSRLDPPEAEVQIDRLITGRLQSLQTYVTQQLIRAAEIRASANLAATKMSECVLGQSKRVDFCGKGYHLMSFPQSAPHGVVFLHVTYVPAQEKNFTTAPAICHDGKAHFPREGVFVSNGTHWFVTQRNFYEPQIITTDNTFVSGNCDVVIGIVNNTVYDPLQPELDSFKEELDKYFKNHTSPDVDLGDISGINASVVNIQKEIDRLNEVAKNLNESLIDLQELGKYEQGSGYIPEAPRDGQAYVRKDGEWVLLSTFLGRSLEVLFQGPGHHHHHHHHSAWSHPQFEKGGGSGGGGSGGSAWSHPQFEK-----";
		String Beta = 	 "M-FV-FL-VLLPLVSSQCVNLTTRTQLPPAYTNSFTRGVYYPDKVFRSSVLHSTQDLFLPFFSNVTWFHAIHVSGTNGTKRFANPVLPFNDGVYFASTEKSNIIRGWIFGTTLDSKTQSLLIVNNATNVVIKVCEFQFCNDPFLGVYYHKNNKSWMESEFRVYSSANNCTFEYVSQPFLMDLEGKQGNFKNLREFVFKNIDGYFKIYSKHTPINLVRGLPQGFSALEPLVDLPIGINITRFQTLHRSYLTPGDSSSGWTAGAAAYYVGYLQPRTFLLKYNENGTITDAVDCALDPLSETKCTLKSFTVEKGIYQTSNFRVQPTESIVRFPNITNLCPFGEVFNATRFASVYAWNRKRISNCVADYSVLYNSASFSTFKCYGVSPTKLNDLCFTNVYADSFVIRGDEVRQIAPGQTGNIADYNYKLPDDFTGCVIAWNSNNLDSKVGGNYNYLYRLFRKSNLKPFERDISTEIYQAGSTPCNGVKGFNCYFPLQSYGFQPTYGVGYQPYRVVVLSFELLHAPATVCGPKKSTNLVKNKCVNFNFNGLTGTGVLTESNKKFLPFQQFGRDIADTTDAVRDPQTLEILDITPCSFGGVSVITPGTNTSNQVAVLYQGVNCTEVPVAIHADQLTPTWRVYSTGSNVFQTRAGCLIGAEHVNNSYECDIPIGAGICASYQTQTNSPRRARSVASQSIIAYTMSLGVENSVAYSNNSIAIPTNFTISVTTEILPVSMTKTSVDCTMYICGDSTECSNLLLQYGSFCTQLNRALTGIAVEQDKNTQEVFAQVKQIYKTPPIKDFGGFNFSQILPDPSKPSKRSFIEDLLFNKVTLADAGFIKQYGDCLGDIAARDLICAQKFNGLTVLPPLLTDEMIAQYTSALLAGTITSGWTFGAGAALQIPFAMQMAYRFNGIGVTQNVLYENQKLIANQFNSAIGKIQDSLSSTASALGKLQDVVNQNAQALNTLVKQLSSNFGAISSVLNDILSRLDKVEAEVQIDRLITGRLQSLQTYVTQQLIRAAEIRASANLAATKMSECVLGQSKRVDFCGKGYHLMSFPQSAPHGVVFLHVTYVPAQEKNFTTAPAICHDGKAHFPREGVFVSNGTHWFVTQRNFYEPQIITTDNTFVSGNCDVVIGIVNNTVYDPLQPELDSFKEELDKYFKNHTSPDVDLGDISGINASVVNIQKEIDRLNEVAKNLNESLIDLQELGKYEQYIKWPWYIWLGFIAGLIAIVMVTIMLCCMTSCCSCLKGCCSCGSCCKFDEDDSEPVLKGVKLHY---------------------";
		String Bat = 	 "M-FR-T-LLLAALFNACWCARPSCLKPTEYWGTHTFDGVEYVPHNTTYVSVLLNKLSCLLPDPYMAXSGQTVRQKLYMGNTSNTLVYPVTPPMFNLTYGNVTPGVYNTSFLPVFDGLLVHTYMNRFAHLDNPNRTCQEPFGVVFGTTFEQDRIAMVIIAPGEFGMWGQLTRPNTTYVHVVACSNATVCAYPMFNRWGPAGSIHADDAFVEHNSSCFLNDTFEIPMGTSRVNLAFRFQDGNLLLYHTAWLPTENYTLSGDYPLRYARSVGVGSNLPFAQFFQSVARARDSACAFLHNNLYIAPVRPKELLVKYNDQGMPVEIADCSADSTQELYCITGTFTPSVGVYQLSRYRAEAKTLVQVTQQEGSCAIPYTTILEPPSPAAWVRATISNCTFDFESLLRTLPTYNLKCYGISPARLSTMCYAGVTLDIFKLNTTHLSNMLGSVPDAVSIYNYALPSNFYGCVHAYHXNSTTPYAXAVPPGAYXIKPGGRQLFNSFVSXVLDSXSSQCTPANCMGVVVIGLTPASGSNLVCPKANDTQVIEGQCVKYNFYGYAGTGVINQSDLAIPNNKLFVTSKSGAVLAVRAGDKVYSITPCVSVPISVGYDPGHQRALVFNGLDCSARANAVSMPASEYWTAAASTTARGSEPVLDTPSGCVYNVNNCTTHTVSVCEMPIGNSLCLVSNFTCSDVATANLSPNLLSLVVYDPTDAGLKVLTPVYWVSIPTNFTLAATTEYIQTTAPKVNVDCVKYLCGDSERCIDVLSQYGAFCEDVNKALADVSAIIDSSMVTMVSELTAGVMWSETPQANVGSYNFSGLXXXLGSNCQERQYRSAISDLLYNKVKVADPGFMGAYQKCIDEQWGGSVRDLICTQTFNGISVLPPIVSPGMQALYTSLLVGAVASSGYTFGITSVGVIPFATQLQFRLNGLGVTTNVLMENQKLIANAFNNALTGIQKGFDATNTALAKMQSVINQHAQQLSTLVDQLGNSFGAISSSINEIFSRLDELEANAQVDRLINGRMVVLNTYVTQLLIRASEVKAQAALASQKISECVKAQSQRNDFCGNGTHVLSIPQMAPNGVLFLHYSYQPTAYNLVRTAAGLCFNDTGYAPLGGLFVLPNNTDRWLFTKMSFYDPVNISVSNTQVLAACGLNYSSVNYTVLEPAVDTSSFNFTEEFEKWYVNQSHIFNNTFNASAFNFSLVDVNEQLAILTDVVNQLNQSYIDLKQLGTYEYTVKWPWYVWLGMIAGLVGLVLAVVLLLCMTNCCSCARGVCSCKSCAYEEHEDVYPAVRVHGKRTA";
		valpha = new Vector();// Constructor
		for (char c : alpha.toCharArray())// Rellenar nuevo vector con un string cadena
			valpha.add(c);

		insertarguion(1, 1);
		insertarguion(1, 5);
		insertarguion(1, 8);
		System.out.println(valpha);
		// for int i i< size i++
		// System.out.println(valpha.get(i));

		int j = 0;
		for (char c : valpha) {// Rellenar nuevo vector con un string cadena
			System.out.print(c);
			if (j == valpha.capacity()/3)
				break;
			if (c != '-')
				j++;
		}
	}

	public static void insertarguion(int secuencia, int posicion) {
		switch (secuencia) {
		case 1:
			valpha.add(posicion, '-');
			break;
		}

	}
}
