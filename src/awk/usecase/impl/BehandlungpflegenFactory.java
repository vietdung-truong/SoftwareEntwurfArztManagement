package awk.usecase.impl;

import awk.usecases.IBehandlungpflegenFactory;

public class BehandlungpflegenFactory implements IBehandlungpflegenFactory {
	
 @Override
 public BehandlungPflegen getBehandlungPflegen() {
	return new EintragPflegen(); 
 }

 @Override
 public BehandlungenSuchen getBehandlungenSuchen() {
	 return BehandlungenSuchen();
 }
 
 @Override
 public BehandlungSuchen getBehandlungSuchen() {
	 return BehandlungSuchen();
	 
 }
 
}
