package awk.usecases;

import awk.entity.BehandlungTO;

public interface IBehandlungPflegen {

	public void behandlungsdatenSpeichern();

	public void behandlungsdatenAnlegen();

	public BehandlungTO behandlungsdatenLiefern();
}
