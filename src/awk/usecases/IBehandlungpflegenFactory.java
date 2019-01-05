package awk.usecases;

import awk.usecase.impl.BehandlungPflegen;
import awk.usecase.impl.BehandlungenSuchen;

public interface IBehandlungpflegenFactory {
	
	public BehandlungPflegen getBehandlungPflegen();
	public BehandlungenSuchen getBehandlungenSuchen();
	

}
