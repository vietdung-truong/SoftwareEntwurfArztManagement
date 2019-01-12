package awk.usecase.impl;
import java.util.*;

import application.Behandlungsuche_Behandlungsdaten;
import awk.datatypes.Behandlungsart;
import awk.entity.*;
import awk.entity.internal.Behandlung;
import awk.usecase.impl.*;

public class BehandlungPflegen {

	
	public void behandlungsdatenSpeichern(int behandlungsID, String datum, String leistungen, String arzt,String patient, String behandlungsart) {
		 BehandlungManager manager = new BehandlungManager();
		 Behandlungsart bh;
		 bh = Behandlungsart.privat;
		 Behandlung behandlung = new Behandlung (behandlungsID,datum,leistungen,arzt,patient,bh);
		 manager.BehandlungAnlegen(behandlung);
		 
		 
		 // Überprüfung valider Eingabe auch möglich
		 
//		 Boolean update;
//		 Collection <BehandlungTO> tos= manager.nachBehandlungenSuchen(datum);
//		 for (BehandlungTO BehandlungTO : tos) {
//				if(BehandlungTO.getBehandlungsID() == behandlungsID)
//					update = true;
//			}
		 
		 
		 
//		 if (behandlungsart == "privat") {
//				 bh = Behandlungsart.privat;
//				 Behandlung behandlung = new Behandlung (behandlungsID,datum,leistungen,arzt,patient,bh);
//				 manager.BehandlungAnlegen(behandlung);
//		 }else if(behandlungsart == "kasse") {
//			 bh = Behandlungsart.kasse;
//			 Behandlung behandlung = new Behandlung (behandlungsID,datum,leistungen,arzt,patient,bh);
//			 manager.BehandlungAnlegen(behandlung);
//		 }else {
//			 System.out.println(Behandlungsart.privat.toString() + Behandlungsart.privat +"Hallo");
//			 System.out.println("Arbeitsverweigerung!!!!!!!!!!1");
//		 }
		
		
		 
		 
		 
	}
	
	
	public Collection<BehandlungTO> behandlungsdatenLiefern(String datum) {
		 BehandlungManager manager = new BehandlungManager();
		 
		 	Collection<BehandlungTO> behandlungen = manager.nachBehandlungenSuchen(datum);
		
			if (behandlungen == null)
				return null;
			else
				return behandlungen;
	}
}
