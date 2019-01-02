package awk.usecase.impl;

import awk.usecases.IBehandlungpflegenFactory;

public class BehandlungpflegenFactory implements IBehandlungpflegenFactory {
	
	 @Override
	 public BehandlungPflegen getBehandlungPflegen() {
		return new BehandlungPflegen();
	 }

	 @Override
	 public BehandlungenSuchen getBehandlungenSuchen() {
		 return new BehandlungenSuchen();
	 }
 
 
}
